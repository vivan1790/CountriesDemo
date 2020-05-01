package com.sample.worldcountries.networking;

import com.sample.worldcountries.model.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountriesApi {

    @GET("all")
    Call<List<Country>> fetchCountries();
}
