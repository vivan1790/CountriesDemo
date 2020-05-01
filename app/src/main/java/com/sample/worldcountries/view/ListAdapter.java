package com.sample.worldcountries.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sample.worldcountries.R;
import com.sample.worldcountries.model.Country;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.CountryItemViewHolder> {

    static class CountryItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.flag) ImageView countryFlag;
        @BindView(R.id.name) TextView countryName;
        @BindView(R.id.capital) TextView countryCapital;

        CountryItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private List<Country> countries = new ArrayList<>();

    public void updateList(List<Country> list) {
        countries.clear();
        countries.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CountryItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_country_item, parent, false);
        return new CountryItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryItemViewHolder holder, int position) {
        Country countryItem = countries.get(position);
        holder.countryName.setText(countryItem.getCountryName());
        holder.countryCapital.setText(countryItem.getCountryCapital());
        String iso = countryItem.getCountryIsoCode().toLowerCase();
        Picasso.get()
                .load("https://flagpedia.net/data/flags/w580/" + iso + ".png")
                .into(holder.countryFlag);
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

}
