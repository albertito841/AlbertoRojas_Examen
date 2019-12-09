package com.example.albertorojas_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Encuesta extends AppCompatActivity {
    private TextView recUsuario, nombreEstudiante, txtPregunta1, txtPregunta2, txtPregunta3;
    private CheckBox chkPrS1, chkPrS2, chkPrS3;
    private RadioButton rbPrA, rbPrB;
    private EditText txtRespuesta1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);
        recUsuario = (TextView) findViewById(R.id.idUsuario);
        nombreEstudiante = (TextView) findViewById(R.id.idEstudiante);
        txtPregunta1 = (TextView) findViewById(R.id.pregunta1);
        txtPregunta2 = (TextView) findViewById(R.id.pregunta2);
        txtPregunta3 = (TextView) findViewById(R.id.pregunta3);
        chkPrS1 = (CheckBox) findViewById(R.id.chkOpcion1);
        chkPrS2 = (CheckBox) findViewById(R.id.chkOpcion2);
        chkPrS3 = (CheckBox) findViewById(R.id.chkOpcion3);
        rbPrA = (RadioButton) findViewById(R.id.rdBtnA);
        rbPrB = (RadioButton) findViewById(R.id.rdBtnB);
        txtRespuesta1 = (EditText) findViewById(R.id.txtRespuesta1);
        recibirDatos();
    }

    private void recibirDatos() {
        Bundle extras = getIntent().getExtras();
        recUsuario.setText(extras.getString("usuario"));
        nombreEstudiante.setText(extras.getString("estudiante"));
    }

    public void pasarDatos(View v) {
        Intent i = new Intent(getApplicationContext(), Resumen.class);

        String valorPr1 = txtRespuesta1.getText().toString();
        String valorChkPr2 = (chkPrS1.isChecked() ? chkPrS1.getText().toString() : (chkPrS2.isChecked() ? chkPrS2.getText().toString() : (chkPrS3.isChecked() ? chkPrS3.getText().toString() : "")));
        String valorRbPr3 = (rbPrA.isChecked() ? rbPrA.getText().toString() : (rbPrB.isChecked() ? rbPrB.getText().toString() :  ""));

        i.putExtra("estudiante","Estudiante: " + nombreEstudiante.getText().toString());
        i.putExtra("usuario",recUsuario.getText().toString());

        i.putExtra("pregunta1",txtPregunta1.getText().toString());
        i.putExtra("pregunta2",txtPregunta2.getText().toString());
        i.putExtra("pregunta3",txtPregunta3.getText().toString());

        i.putExtra("resp1",valorPr1);
        i.putExtra("resp2",valorChkPr2);
        i.putExtra("resp3",valorRbPr3);
        startActivity(i);
    }
}
