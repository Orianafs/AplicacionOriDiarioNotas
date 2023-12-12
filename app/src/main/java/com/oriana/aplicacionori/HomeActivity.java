package com.oriana.aplicacionori;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Iniciar el servicio
        Intent serviceIntent = new Intent(this, ProximityService.class);
        startService(serviceIntent);
    }

    public void irLogin(View view) {
        Intent i = new Intent(HomeActivity.this, LoginActivity.class);
        startActivity(i);
    }

    public void irSignUp(View view) {
        Intent i = new Intent(HomeActivity.this, SingUpActivity.class);
        startActivity(i);
    }

    public void irMapa(View view) {
        Intent i = new Intent(HomeActivity.this, MapaActivity.class);
        startActivity(i);
    }

    public void irMqtt(View view) {
        Intent i = new Intent(HomeActivity.this, MqttActivity.class);
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
