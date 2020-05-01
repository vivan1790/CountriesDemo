package com.sample.worldcountries.model;

import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("name")
    String countryName;

    @SerializedName("capital")
    String countryCapital;

    @SerializedName("alpha2Code")
    String countryIsoCode;

    public String getCountryName() {
        return countryName;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }
}
