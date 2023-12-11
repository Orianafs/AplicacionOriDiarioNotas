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

        // Iniciar el servicio
        Intent serviceIntent = new Intent(this, ProximityService.class);
        startService(serviceIntent);
    }

    public void irLogin(View view) {
        Intent i = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);
    }

    public void irSignUp(View view) {
        Intent i = new Intent(MainActivity.this, SingUpActivity.class);
        startActivity(i);
    }

    public void irMapa(View view) {
        Intent i = new Intent(MainActivity.this, MapaActivity.class);
        startActivity(i);
    }

    public void irMqtt(View view) {
        Intent i = new Intent(MainActivity.this, MqttActivity.class);
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Detener el servicio
        Intent serviceIntent = new Intent(this, ProximityService.class);
        stopService(serviceIntent);
    }
}
