package com.example.albertorojas_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private static final String usuario = "estudiante2019";
    private static final String password = "uisrael2019";

    private EditText idUser, idPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        idUser = (EditText) findViewById(R.id.etUser);
        idPass = (EditText) findViewById(R.id.etPassword);
    }

    public void ingresar(View v) {
        if (idUser.getText().toString().equals(usuario) &&
                idPass.getText().toString().equals(password)) {
            Intent i = new Intent(getApplicationContext(), Registro.class);
            i.putExtra("usuario","Conectado: " + usuario);
            startActivity(i);
        }
        else {
            Toast.makeText(getApplicationContext(), "Login Incorrecto", Toast.LENGTH_LONG).show();
        }
    }
}
