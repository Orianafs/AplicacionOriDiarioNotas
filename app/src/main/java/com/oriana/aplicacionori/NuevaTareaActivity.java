package com.oriana.aplicacionori;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NuevaTareaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_tarea);


    }
    public void irTareasDiarias(View view){
        Intent i = new Intent(NuevaTareaActivity.this, TareaActivity.class);
        startActivity(i);

    }
}