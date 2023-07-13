package com.yogeshandroid.machinetest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yogeshandroid.machinetest.MainActivity;
import com.yogeshandroid.machinetest.Model.Country;
import com.yogeshandroid.machinetest.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    Context context;
    List<Country.Countries> countriesList;

    public CountryAdapter(Context context, List<Country.Countries> countriesList) {
        this.context = context;
        this.countriesList = countriesList;
    }

    public void updateList(List<Country.Countries> updated) {
        countriesList = updated;
    }

    @NonNull
    @Override
    public CountryAdapter.CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_countries, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.CountryViewHolder holder, int position) {

        Country.Countries singleUnit = countriesList.get(position);

        holder.name.setText("country name- " + singleUnit.getCountryName());
        holder.code.setText("country code- " + singleUnit.getCountryISD());

        Glide.with(context).load("https://hardcore-mclean.54-159-161-200.plesk.page/" + singleUnit.getFile()).placeholder(R.drawable.img_placeholder).into(holder.flag);
    }

    @Override
    public int getItemCount() {
        if (countriesList == null || countriesList.size() < 1) {
            return 0;
        } else {
            return countriesList.size();
        }
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder {

        CircleImageView flag;
        TextView name, code;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            flag = itemView.findViewById(R.id.countryFlag);
            name = itemView.findViewById(R.id.countryName);
            code = itemView.findViewById(R.id.countryCode);
        }
    }
}
