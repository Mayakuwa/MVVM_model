package com.example.androidartchitecture.mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidartchitecture.model.CountriesService;
import com.example.androidartchitecture.model.Country;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CountriesViewModel extends ViewModel {


    //this is observable, and call the countries
    private final MutableLiveData<List<String>> countries = new MutableLiveData<>();
    private final MutableLiveData<Boolean> countryError = new MutableLiveData<>();



    private CountriesService service;

    public CountriesViewModel() {
        service = new CountriesService();
        fetchCountries();
    }

    public LiveData<List<String>> getCountries() {
        return countries;

    }

    public LiveData<Boolean> getCountryError() {
        return countryError;
    }

    private void fetchCountries() {
        service.getCountries()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Country>>() {
                    @Override
                    public void onSuccess(List<Country> value) {
                        List<String> countryNames = new ArrayList<>();
                        for(Country country: value) {
                            countryNames.add(country.countyName);
                        }
                        //everytime something happen update data
                        countries.setValue(countryNames);
                        countryError.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        countryError.setValue(true);
                    }
                });
    }

    public void onRefresh() {
        fetchCountries();
    }
}
