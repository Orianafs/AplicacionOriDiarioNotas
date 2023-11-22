package com.oriana.aplicacionori;

// Importar las clases necesarias
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.oriana.aplicacionori.Utils.DataBaseUsuarios;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private TextView username;
    private TextView password;
    private void UnSegundo(){
        try{
            Thread.sleep(800);
        }catch (InterruptedException e){}
    }
    void Hilos(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1; i<=10; i++){
                    UnSegundo();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getBaseContext(), "Hilo funcionando", Toast.LENGTH_LONG).show();
                    }
                });

            }
        }).start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView username = findViewById(R.id.login_email);
        TextView password = findViewById(R.id.login_password);
        DataBaseUsuarios dbHelper = new DataBaseUsuarios(this);
        dbHelper.insertarUsuarioPorDefecto();

        // ...


        Button loginbtn = findViewById(R.id.login_button);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hilos();
                // Verificar el inicio de sesión en la base de datos
                if (verificarCredenciales(username.getText().toString(), password.getText().toString())) {
                    // Inicio de sesión correcto
                    Intent myIntent = new Intent(LoginActivity.this, Splash2Activity.class);
                    startActivity(myIntent);
                    Toast.makeText(LoginActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                } else {
                    // Inicio de sesión incorrecto
                    Toast.makeText(LoginActivity.this, "Inicio Fallido, Intentelo de nuevo!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Método para verificar las credenciales en la base de datos
    private boolean verificarCredenciales(String username, String password) {
        DataBaseUsuarios dbHelper = new DataBaseUsuarios(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Consultar la base de datos para verificar las credenciales
        Cursor cursor = db.rawQuery("SELECT * FROM usuarios WHERE username=? AND password=?", new String[]{username, password});

        // Verificar si se encontraron resultados
        boolean result = cursor.moveToFirst();

        // Cerrar el cursor y la base de datos
        cursor.close();
        db.close();

        return result;
    }
}
