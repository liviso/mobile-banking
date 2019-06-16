package com.certificatic.mobilebanking.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.certificatic.mobilebanking.R;
import com.certificatic.mobilebanking.retrofit.LoginClient;
import com.certificatic.mobilebanking.retrofit.LoginService;
import com.certificatic.mobilebanking.retrofit.request.RequestLogin;
import com.certificatic.mobilebanking.retrofit.response.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText idUserEt;
    private EditText passwordEt;
    private LoginService loginService;
    private LoginClient loginClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofitInit();
        findViews();
    }

    public void retrofitInit() {
        loginClient = LoginClient.getInstance();
        loginService = loginClient.getLoginService();
    }

    public void findViews() {
        idUserEt = (EditText) findViewById(R.id.idUser);
        passwordEt = (EditText) findViewById(R.id.password);
    }

    public void validateLogin(View view) {
        String user= idUserEt.getText().toString();
        String password= passwordEt.getText().toString();
        if (user.isEmpty()) {
            idUserEt.setError(getString(R.string.enter_user));

        } else if (password.isEmpty()) {
            passwordEt.setError(getString(R.string.enter_password));

        } else {
            RequestLogin requestLogin= new RequestLogin(password, user);
            Call<UserResponse> call= loginService.doLogin(requestLogin);
            call.enqueue(new Callback<UserResponse>() {
                @Override
                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                    if(response.isSuccessful()){

                        Toast.makeText(MainActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(MainActivity.this, ClientActivity.class);
                        startActivity(intent);
                        finish();

                    }else{
                        Toast.makeText(MainActivity.this, "Error. Intente más tarde", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<UserResponse> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Error en la conexión. Intente más tarde", Toast.LENGTH_SHORT).show();
                }
            });
        }


    }
}
