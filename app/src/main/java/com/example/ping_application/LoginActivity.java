package com.example.ping_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText pas, usr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button newAccount = (Button) findViewById(R.id.createAccountButton);
        newAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewAccount();
            }
        });

        Button login = (Button) findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //This is where we check the username and password
                openMain();
            }
        });

        usr = (EditText) findViewById( R.id.username); //Get text from UI into code
        pas = (EditText) findViewById( R.id.password);
    }

    public void openNewAccount() {
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }

    public void openMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void loginBtn(View view)
    {
        String user = usr.getText().toString(); // Turn UI values into Strings for Java
        String pass = pas.getText().toString();

        background bg = new background(this);
        bg.execute(user,pass);
    }
}