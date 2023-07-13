package com.yogeshandroid.machinetest.Api;

import com.yogeshandroid.machinetest.Model.Country;
import com.yogeshandroid.machinetest.Model.Login;
import com.yogeshandroid.machinetest.Model.SignUp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiService {
    @GET("user/country/list")
    Call<Country> getCountries();


    @FormUrlEncoded
    @POST("user/signup")
    Call<SignUp> signUpFunc(

            @Field("first_name") String firstName,
            @Field("last_name") String lastName,
            @Field("email") String email,
            @Field("mobile_number") String mobile,
            @Field("country_code") String countryCode,
            @Field("device_token") String token
    );


    @FormUrlEncoded
    @POST("user/mobile-login")
    Call<Login> logInFunc(

            @Field("mobile_number") String mobile,
            @Field("country_code") String countryCode,
            @Field("Pin") String pin
    );

}
