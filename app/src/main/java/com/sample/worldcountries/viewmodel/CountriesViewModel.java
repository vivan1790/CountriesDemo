package com.sample.worldcountries.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sample.worldcountries.model.Country;
import com.sample.worldcountries.networking.CountriesService;

import java.util.List;


import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountriesViewModel extends ViewModel {

    private MutableLiveData<List<Country>> countriesLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> loadingErrorLiveData = new MutableLiveData<>();

    @Inject
    CountriesService countriesService;

    public void refreshList() {
        countriesService.fetchCountries().enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                countriesLiveData.postValue(response.body());
                loadingErrorLiveData.postValue(false);
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                loadingErrorLiveData.postValue(true);
            }
        });
    }

    public MutableLiveData<List<Country>> getCountriesLiveData() {
        return countriesLiveData;
    }

    public MutableLiveData<Boolean> getLoadingErrorLiveData() {
        return loadingErrorLiveData;
    }
}
