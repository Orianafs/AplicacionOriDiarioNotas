package com.oriana.aplicacionori;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TareaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea);
    }

    public void irNuevaTarea(View view){
        Intent i = new Intent(TareaActivity.this, NuevaTareaActivity.class);
        startActivity(i);

    }
}