package com.sample.worldcountries.di;

import com.sample.worldcountries.viewmodel.CountriesViewModel;

import dagger.Component;

@Component(modules = {NetworkModule.class})
public interface NetworkComponent {

    void inject(CountriesViewModel countriesListViewModel);
}
