package com.oriana.aplicacionori;

// Importar las clases necesarias
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.oriana.aplicacionori.Utils.DataBaseUsuarios;

import androidx.appcompat.app.AppCompatActivity;

public class SingUpActivity extends AppCompatActivity {

    private TextView username;
    private TextView password;
    private TextView passwordConfirmed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        TextView username = findViewById(R.id.signup_email);
        TextView password = findViewById(R.id.signup_password);
        TextView passwordConfirmed = findViewById(R.id.signup_passwordC);


        // ...

        Button registrarbtn = findViewById(R.id.signup_button);
        registrarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar si las contraseñas coinciden
                if (password.getText().toString().equals(passwordConfirmed.getText().toString())) {

                    // Registrar el usuario en la base de datos
                    registrarUsuario(username.getText().toString(), password.getText().toString());

                    // Redirigir a la pantalla de inicio de sesión
                    Intent myIntent = new Intent(SingUpActivity.this, LoginActivity.class);
                    startActivity(myIntent);
                } else {
                    // Contraseñas no coinciden
                    Toast.makeText(SingUpActivity.this, "Registro Fallido, las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Método para registrar un usuario en la base de datos
    private void registrarUsuario(String username, String password) {
        DataBaseUsuarios dbHelper = new DataBaseUsuarios(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Crear un nuevo registro de usuario
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", password);

        // Insertar el nuevo usuario en la base de datos
        db.insert("usuarios", null, values);

        // Cerrar la base de datos
        db.close();
    }
}
