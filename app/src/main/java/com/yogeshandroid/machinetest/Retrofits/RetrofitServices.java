package com.yogeshandroid.machinetest.Retrofits;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServices {


    public static Retrofit retrofit = null;
    public static final String BASE_URL = "https://hardcore-mclean.54-159-161-200.plesk.page/";

    public static Retrofit getRetrofit() {


        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}

