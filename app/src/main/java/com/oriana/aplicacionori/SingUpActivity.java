package com.oriana.aplicacionori;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class SingUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        Spinner spinnerCountry = findViewById(R.id.spinnerCountry);

        // Crea un ArrayAdapter utilizando el array de países
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.countries, android.R.layout.simple_spinner_item);

        // Especifica el diseño a utilizar cuando se despliega el Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Establece el adaptador en el Spinner
        spinnerCountry.setAdapter(adapter);

        // Agrega un listener para manejar la selección del usuario
        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Obtiene el país seleccionado por el usuario
                String selectedCountry = parentView.getItemAtPosition(position).toString();

                // Si el usuario selecciona "Seleccionar País", no hagas nada
                if (!selectedCountry.equals("Seleccionar País")) {
                    // Realiza acciones basadas en el país seleccionado
                    Toast.makeText(getApplicationContext(), "País seleccionado: " + selectedCountry, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Este método se llama cuando no se selecciona nada, puedes dejarlo vacío
            }
        });

        TextView username =(TextView) findViewById(R.id.signup_email);
        TextView passwordC =(TextView) findViewById(R.id.signup_password);
        TextView password =(TextView) findViewById(R.id.signup_passwordC);

        TextView passwordConfirmed =(TextView) findViewById(R.id.signup_passwordC);

        Button registrarbtn = (Button) findViewById(R.id.signup_button);

        registrarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("oriana") && password.getText().toString().equals("123") && passwordConfirmed.getText().toString().equals("123")){
                    //correct
                    Intent myIntent = new Intent(SingUpActivity.this, LoginActivity.class);
                    startActivity(myIntent);


                }else
                    //incorrect
                    Toast.makeText(SingUpActivity.this,"Registro Fallido intentelo de nuevo!!!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}