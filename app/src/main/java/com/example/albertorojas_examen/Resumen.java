package com.example.albertorojas_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Resumen extends AppCompatActivity {
    private TextView recUsuario, nombreEstudiante;
    private TextView recResp1, recResp2, recResp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
        Bundle extras = getIntent().getExtras();
        recUsuario = (TextView) findViewById(R.id.idUsuario);
        nombreEstudiante = (TextView) findViewById(R.id.idEstudiante);
        recUsuario.setText(extras.getString("usuario"));
        nombreEstudiante.setText(extras.getString("estudiante"));
        recResp1 = (TextView) findViewById(R.id.recRsp1);
        recResp2 = (TextView) findViewById(R.id.recRsp2);
        recResp3 = (TextView) findViewById(R.id.recRsp3);
        recResp1.setText(extras.getString("pregunta1").replace("?", ":") + " " + extras.getString("resp1"));
        recResp2.setText(extras.getString("pregunta2").replace("?", ":") + " " + extras.getString("resp2"));
        recResp3.setText(extras.getString("pregunta3").replace("?", ":") + " " + extras.getString("resp3"));
    }

}
