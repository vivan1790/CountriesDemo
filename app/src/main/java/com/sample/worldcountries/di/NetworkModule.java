package com.sample.worldcountries.di;

import com.sample.worldcountries.networking.CountriesApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    private final String BASE_URL = "https://restcountries.eu/rest/v2/";

    @Provides
    public CountriesApi getCountriesApi() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CountriesApi.class);
    }
}
