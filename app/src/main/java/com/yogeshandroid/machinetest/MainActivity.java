package com.yogeshandroid.machinetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.yogeshandroid.machinetest.Adapter.CountryAdapter;
import com.yogeshandroid.machinetest.Api.ApiService;
import com.yogeshandroid.machinetest.Model.Country;
import com.yogeshandroid.machinetest.Retrofits.RetrofitServices;
import com.yogeshandroid.machinetest.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private static final String TAG = "MainActivity";
    ApiService apiService;
    List<Country.Countries> countriesList;

    CountryAdapter adapter;
    Call<Country> countryCall;


    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("loading");
        progressDialog.setCancelable(false);

        apiService = RetrofitServices.getRetrofit().create(ApiService.class);
        countriesList = new ArrayList<>();


        binding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        countryCall = apiService.getCountries();

        binding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Signup.class));
                finish();
            }
        });

        progressDialog.show();
        countryCall.enqueue(new Callback<Country>() {
            @Override
            public void onResponse(Call<Country> call, Response<Country> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()) {

                    Country resp = response.body();
                    countriesList = resp.getCountries();
                    adapter = new CountryAdapter(MainActivity.this, countriesList);
                    binding.recyclerView.setAdapter(adapter);

//                    adapter.updateList(countriesList);
                } else {

                    Log.d(TAG, "api response failed " + response.message() + "   " + response.code() + "   " + response.body());
                    Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Country> call, Throwable t) {
                progressDialog.dismiss();
                Log.d(TAG, "failure " + t.getMessage() + t.getCause().toString());
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}