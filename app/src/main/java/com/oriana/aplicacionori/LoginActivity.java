package com.oriana.aplicacionori;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {
 //hola
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView username =(TextView) findViewById(R.id.login_email);
        TextView password =(TextView) findViewById(R.id.login_password);

        Button loginbtn = (Button)  findViewById(R.id.login_button);
        //admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {

            private void UnSegundo(){
                try{
                    Thread.sleep(1000);
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
                                Toast.makeText(getBaseContext(), "Iniciando Aplicación", Toast.LENGTH_LONG).show();
                            }
                        });

                    }
                }).start();
            }


            @Override
            public void onClick(View v) {

                Hilos();
                if(username.getText().toString().equals("oriana") && password.getText().toString().equals("123")){
                    //correct
                    Intent myIntent = new Intent(LoginActivity.this, Splash2Activity.class);
                    startActivity(myIntent);


                }else
                    //incorrect
                    Toast.makeText(LoginActivity.this,"Inicio Fallido, Intentelo de nuevo!!!",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
