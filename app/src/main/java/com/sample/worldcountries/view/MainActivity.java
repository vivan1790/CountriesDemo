package com.sample.worldcountries.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sample.worldcountries.R;
import com.sample.worldcountries.model.Country;
import com.sample.worldcountries.viewmodel.CountriesViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.countriesList) RecyclerView countriesList;
    @BindView(R.id.errorMessage) TextView errorMessage;
    @BindView(R.id.progressBar) ProgressBar progressBar;

    private CountriesViewModel listViewModel;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        countriesList.setLayoutManager(new LinearLayoutManager(this));
        listAdapter = new ListAdapter();
        countriesList.setAdapter(listAdapter);
        listViewModel = new ViewModelProvider(this).get(CountriesViewModel.class);
        subscribeToViewModel();
    }

    private void subscribeToViewModel() {
        listViewModel.getCountriesLiveData().observe(this, new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countries) {
                listAdapter.updateList(countries);
                progressBar.setVisibility(View.GONE);
                countriesList.setVisibility(View.VISIBLE);
                errorMessage.setVisibility(View.GONE);
            }
        });
        listViewModel.getLoadingErrorLiveData().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean error) {
                if (error) {
                    progressBar.setVisibility(View.GONE);
                    countriesList.setVisibility(View.GONE);
                    errorMessage.setVisibility(View.VISIBLE);
                }
            }
        });
        progressBar.setVisibility(View.VISIBLE);
        countriesList.setVisibility(View.GONE);
        errorMessage.setVisibility(View.GONE);
        listViewModel.refreshList();
    }
}
