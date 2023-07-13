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
import com.yogeshandroid.machinetest.Retrofits.RetrofitServices;
import com.yogeshandroid.machinetest.databinding.ActivityLoginBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    ActivityLoginBinding binding;
    ApiService apiService;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        apiService = RetrofitServices.getRetrofit().create(ApiService.class);
        progressDialog = new ProgressDialog(Login.this);
        progressDialog.setMessage("please wait...");
        progressDialog.setCancelable(false);

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Signup.class));
                finish();
            }
        });

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.mobile.getText().toString().isEmpty()) {
                    binding.mobile.setError("enter mobile please");
                    binding.mobile.requestFocus();
                } else if (binding.pinOne.getText().toString().isEmpty() || binding.pinTwo.getText().toString().isEmpty() || binding.pinThree.getText().toString().isEmpty() || binding.pinFour.getText().toString().isEmpty() || binding.pinFive.getText().toString().isEmpty() || binding.pinSix.getText().toString().isEmpty()) {
                    Toast.makeText(Login.this, "enter pin properly", Toast.LENGTH_SHORT).show();
                } else {
                    String pin = binding.pinOne.getText().toString() + binding.pinTwo.getText().toString() + binding.pinThree.getText().toString() + binding.pinFour.getText().toString() + binding.pinFive.getText().toString() + binding.pinSix.getText().toString();
                    Call<com.yogeshandroid.machinetest.Model.Login> call = apiService.logInFunc(binding.mobile.getText().toString(), "+91", pin);
                    progressDialog.show();
                    call.enqueue(new Callback<com.yogeshandroid.machinetest.Model.Login>() {
                        @Override
                        public void onResponse(Call<com.yogeshandroid.machinetest.Model.Login> call, Response<com.yogeshandroid.machinetest.Model.Login> response) {
                            progressDialog.dismiss();
                            if (response.isSuccessful()) {
                                Toast.makeText(Login.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Login.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<com.yogeshandroid.machinetest.Model.Login> call, Throwable t) {
                            Toast.makeText(Login.this, t.getMessage(), Toast.LENGTH_SHORT).show();
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
                binding.count.setText(String.valueOf(s.length()) + "/10");
            }

            public void afterTextChanged(Editable s) {
            }
        };

        binding.mobile.addTextChangedListener(mTextEditorWatcher);


        binding.pinOne.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    binding.pinTwo.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not needed for this case, but must be implemented
            }
        });

        binding.pinTwo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not needed for this case, but must be implemented
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    binding.pinThree.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not needed for this case, but must be implemented
            }
        });

        binding.pinThree.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not needed for this case, but must be implemented
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    binding.pinFour.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not needed for this case, but must be implemented
            }
        });

        binding.pinFour.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not needed for this case, but must be implemented
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    binding.pinFive.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not needed for this case, but must be implemented
            }
        });

        binding.pinFive.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not needed for this case, but must be implemented
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    binding.pinSix.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not needed for this case, but must be implemented
            }
        });

    }
}