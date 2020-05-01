package com.sample.worldcountries.networking;

import com.sample.worldcountries.model.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountriesService {

    private final String BASE_URL = "https://restcountries.eu/rest/v2/";
    CountriesApi countriesApi;

    public CountriesService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(CountriesApi.class);
    }

    public Call<List<Country>> fetchCountries() {
        return countriesApi.fetchCountries();
    }

}
