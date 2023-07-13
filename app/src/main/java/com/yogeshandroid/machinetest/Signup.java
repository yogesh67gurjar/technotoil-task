package com.yogeshandroid.machinetest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.yogeshandroid.machinetest.Api.ApiService;
import com.yogeshandroid.machinetest.Model.SignUp;
import com.yogeshandroid.machinetest.Retrofits.RetrofitServices;
import com.yogeshandroid.machinetest.databinding.ActivitySignupBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Signup extends AppCompatActivity {
    ActivitySignupBinding binding;
    String lastName = "", email = "";
    ApiService apiService;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        apiService = RetrofitServices.getRetrofit().create(ApiService.class);


        progressDialog = new ProgressDialog(Signup.this);
        progressDialog.setMessage("creating your account");
        progressDialog.setCancelable(false);

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Signup.this, Login.class));
                finish();

            }
        });

        binding.mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Signup.this, MainActivity.class));
            }
        });

        binding.signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!binding.lastName.getText().toString().isEmpty()) {
                    lastName = binding.lastName.getText().toString();
                }

                if (!binding.email.getText().toString().isEmpty()) {
                    email = binding.email.getText().toString();
                }


                if (binding.firstName.getText().toString().isEmpty()) {
                    binding.firstName.setError("enter name please");
                    binding.firstName.requestFocus();
                } else if (binding.mobile.getText().toString().isEmpty()) {
                    binding.mobile.setError("enter mobile number please");
                    binding.mobile.requestFocus();
                } else if (!binding.agree.isChecked()) {
                    Toast.makeText(Signup.this, "please check the checkbox", Toast.LENGTH_SHORT).show();
                } else {
                    Call<com.yogeshandroid.machinetest.Model.SignUp> call = apiService.signUpFunc(binding.firstName.getText().toString(), lastName, email, binding.mobile.getText().toString(), "+91", "123456");

                    progressDialog.show();
                    call.enqueue(new Callback<SignUp>() {
                        @Override
                        public void onResponse(Call<SignUp> call, Response<SignUp> response) {
                            progressDialog.dismiss();
                            if (response.isSuccessful()) {
                                Toast.makeText(Signup.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Signup.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<SignUp> call, Throwable t) {
                            Toast.makeText(Signup.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    });
                }


            }
        });


        final TextWatcher mTextEditorWatcher = new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //This sets a textview to the current length
                binding.counter.setText(String.valueOf(s.length()) + "/10");
            }

            public void afterTextChanged(Editable s) {
            }
        };

        binding.mobile.addTextChangedListener(mTextEditorWatcher);

    }
}