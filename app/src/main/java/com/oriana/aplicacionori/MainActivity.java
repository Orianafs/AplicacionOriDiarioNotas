package com.oriana.aplicacionori;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irLogin(View view){
        Intent i = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);

    }

    public void irSignUp(View view){
        Intent i = new Intent(MainActivity.this, SingUpActivity.class);
        startActivity(i);

    }
}

