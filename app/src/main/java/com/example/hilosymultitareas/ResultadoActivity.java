package com.example.hilosymultitareas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvResultado = (TextView)findViewById(R.id.tvResultado);

        tvResultado = (TextView)findViewById(R.id.tvResultado);
        String nombreUsuario = getIntent().getStringExtra("usuario");
        tvResultado.setText("Bienvenido: " + nombreUsuario);
    }
}