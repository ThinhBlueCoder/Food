package com.example.asm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.asm.AppConfig;
import com.example.asm.ApiResponse;
import com.example.asm.R;
import com.example.asm.ApiClient;
import com.example.asm.ApiInterface;

import com.example.asm.databinding.ActivityLoginBinding;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding mainBinding;
    private boolean isRememberUserLogin=false;
    private AppConfig appConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        mainBinding= DataBindingUtil.setContentView(this, R.layout.activity_login);
        setSupportActionBar(mainBinding.myToolbar);
        getSupportActionBar().setTitle("Login Page");
        appConfig=new AppConfig(this);
        if (appConfig.isUserLogin()){
            String name=appConfig.getNameofUser();
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            intent.putExtra("name",name);
            startActivity(intent);
            finish();
        }
        mainBinding.bnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
        mainBinding.bnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performLogin();
                mainBinding.showProgess.setVisibility(View.VISIBLE);
            }
        });
    }
    private void performLogin(){
        String  userName=mainBinding.txtUserName.getText().toString();
        String password=mainBinding.txtUserPassword.getText().toString();

        Call<ApiResponse> call= ApiClient.getApiClient().create(ApiInterface.class).performUserLogin(userName,password);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.code()==200){
                    if (response.body().getStatus().equals("ok")){
                        if (response.body().getResultCode()==1){
                            String name=response.body().getName();
                            if (isRememberUserLogin){
                                appConfig.updateUserLoginStatus(true);
                                appConfig.saveNameofUser(name);
                            }
                            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                            intent.putExtra("name",name);
                            startActivity(intent);
                            finish();
                        }else {
                            displayUserInformation("Tài Khoản Hoặc Mật Khẩu Không Chính Xác");
                            mainBinding.txtUserPassword.setText("");
                        }
                    }else {
                        displayUserInformation("Something went wrong...");
                        mainBinding.txtUserPassword.setText("");
                    }
                }else {
                    displayUserInformation("Something went wrong...");
                    mainBinding.txtUserPassword.setText("");
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {

            }
        });
    }
    private void displayUserInformation(String message){
        Snackbar.make(mainBinding.myToolbar,message,Snackbar.LENGTH_SHORT).show();
        mainBinding.showProgess.setVisibility(View.INVISIBLE);
    }
    public void checkBoxClicked(View view){
        isRememberUserLogin=((CheckBox)view).isChecked();
    }
}