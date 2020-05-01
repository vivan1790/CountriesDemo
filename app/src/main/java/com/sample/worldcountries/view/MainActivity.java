package com.sample.worldcountries.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sample.worldcountries.R;
import com.sample.worldcountries.viewmodel.CountriesViewModel;

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
    }
}
