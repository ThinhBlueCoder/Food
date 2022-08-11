package com.example.asm;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


import com.example.asm.ApiResponse;
import com.example.asm.R;
import com.example.asm.ApiClient;
import com.example.asm.ApiInterface;

import com.example.asm.databinding.ActivityRegisterBinding;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding registerBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_register);
        registerBinding= DataBindingUtil.setContentView(this, R.layout.activity_register);
        setSupportActionBar(registerBinding.myToolbar);
        getSupportActionBar().setTitle("New User SignUp");

        registerBinding.bnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performSignUp();
                registerBinding.showProgess.setVisibility(View.VISIBLE);
            }
        });
    }
    private void performSignUp(){
        String userName=registerBinding.txtUserName.getText().toString();
        String password=registerBinding.txtUserPassword.getText().toString();
        String name=registerBinding.txtName.getText().toString();

        Call<ApiResponse> call= ApiClient.getApiClient().create(ApiInterface.class).performUserSignIn(userName,
                password,name);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.code()==200){
                    if (response.body().getStatus().equals("ok")){
                        if (response.body().getResultCode()==1){
                            Toast.makeText(RegisterActivity.this,"Đăng Ký Thành Công, Đang Chuyển Hướng...",
                                    Toast.LENGTH_LONG).show();
                            onBackPressed();
                            finish();
                        }else {

                        }
                    }else{
                        displayUserInfo("User already exists...");
                        registerBinding.txtUserPassword.setText("");
                    }
                }else {
                    displayUserInfo("Something went wrong...");
                    registerBinding.txtUserPassword.setText("");
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {

            }
        });
    }
    private void displayUserInfo(String message){
        Snackbar.make(registerBinding.myToolbar,message, Snackbar.LENGTH_SHORT).show();
        registerBinding.txtUserPassword.setText("");
        registerBinding.showProgess.setVisibility(View.INVISIBLE);
    }
}
