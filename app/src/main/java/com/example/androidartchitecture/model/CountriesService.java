package com.example.androidartchitecture.model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountriesService {
    public static final String BASE_URL = "https://restcountries.eu/rest/v2/";


    private CountriesApi api;

    // this is a constructor
    public CountriesService() {

        // call the endpoints
        //RetrofitはAPIから取得するデーターをオブジェクトにしてアクセスできるようにするまで面倒見てくれるHTTP clientのこと
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        api = retrofit.create(CountriesApi.class);

    }

    public Single<List<Country>> getCountries() {
        return api.getCountries();
    }
}
