package com.example.avaliacao2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Entrar extends AppCompatActivity {
    //DECLARAR AS VARIÁVEIS
    EditText pwd;
    Button send;

    TextView txtResultado;

    //DECLARAR O ARQUIVO DE PREFERÊNCIA
    public static final String MyPREFERENCES = "arquivo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar);
        pwd=(EditText)  findViewById(R.id.editTextTextPassword);
        send=(Button) findViewById(R.id.button2);
        txtResultado=(TextView) findViewById(R.id.textView);

        //RECUPERAR OS DADOS SALVOS
        SharedPreferences preferencia = getSharedPreferences(MyPREFERENCES, 0);

        if (preferencia.contains("usuario")){
            // RECUPERAR OS DADOS
            String usuario = preferencia.getString("usuario", "Olá! Usuário não definido");
            txtResultado.setText("Olá " + usuario);

        }else {
            txtResultado.setText("Olá! Usuário não definido");
        }

    }
}

