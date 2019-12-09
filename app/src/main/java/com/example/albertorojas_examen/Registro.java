package com.example.albertorojas_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Registro extends AppCompatActivity {
    private TextView recUsuario, nombreEstudiante, cuotasMensuales;
    private EditText pagoInicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        recUsuario = (TextView) findViewById(R.id.idTextUsuario);
        nombreEstudiante = (TextView) findViewById(R.id.etEstudiante);
        pagoInicial = (EditText) findViewById(R.id.etMontoInicial);
        cuotasMensuales = (TextView) findViewById(R.id.etPagosMensuales);
        recibirDatos();
    }

    private void recibirDatos() {
        Bundle extras = getIntent().getExtras();
        recUsuario.setText(extras.getString("usuario"));
    }

    public void calcula(View v){
        int montoI = Integer.valueOf(pagoInicial.getText().toString());
        double cuotas = (3000 - montoI) / 5;
        cuotasMensuales.setText(String.valueOf(cuotas));
    }

    public void guardar(View v) {
        Intent i = new Intent(getApplicationContext(), Encuesta.class);
        i.putExtra("estudiante","Estudiante: " + nombreEstudiante.getText().toString());
        i.putExtra("usuario",recUsuario.getText().toString());
        startActivity(i);
    }
}
