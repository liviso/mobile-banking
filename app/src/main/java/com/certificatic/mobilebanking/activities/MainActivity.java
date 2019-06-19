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


                        Toast.makeText(MainActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(MainActivity.this, ClientActivity.class);
                        startActivity(intent);
                        finish();

        }


    }
}
