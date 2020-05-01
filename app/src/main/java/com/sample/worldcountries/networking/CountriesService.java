package com.sample.worldcountries.networking;

import com.sample.worldcountries.model.Country;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

public class CountriesService {

    @Inject
    CountriesApi countriesApi;

    @Inject
    public CountriesService() {
        // CountriesService will be instantiated through Dagger Dependency Injection
    }

    public Call<List<Country>> fetchCountries() {
        return countriesApi.fetchCountries();
    }

}
