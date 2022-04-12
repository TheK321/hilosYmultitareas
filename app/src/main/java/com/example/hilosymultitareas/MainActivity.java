package com.example.hilosymultitareas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText nombre, apellido, semestre, nc;
    private ProgressBar progressBar;
    private TextView loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loading = findViewById(R.id.tvLoading);
        button = (Button)findViewById(R.id.button);
        nombre = (EditText)findViewById(R.id.nombre);
        apellido = (EditText) findViewById(R.id.apellido);
        semestre = (EditText)findViewById(R.id.semestre);
        nc = (EditText) findViewById(R.id.nc);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task1().execute(nombre.getText().toString());
            }
        });
    }

    public void textoCustom(String string){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                loading.setText(string);
            }
        });
    }

    class Task1 extends AsyncTask<String, Void, String>{

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            button.setEnabled(false);
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected String doInBackground(String... strings) {
            try{

                textoCustom("Obteniendo datos...");
                Thread.sleep(2000);
                textoCustom("Verificando datos...");
                Thread.sleep(5000);
                textoCustom("Procesando...");
                Thread.sleep(1500);
                textoCustom("Generando interfaz...");
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return strings[0];
        }

        @Override
        protected void onPostExecute(String s) {
            progressBar.setVisibility(View.INVISIBLE);
            button.setEnabled(true);

            Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
            intent.putExtra("Nombre",nombre.getText().toString());
            intent.putExtra("Apellido",apellido.getText().toString());
            intent.putExtra("Semestre",semestre.getText().toString());
            intent.putExtra("NC",nc.getText().toString());
            startActivity(intent);
        }
    }
}


