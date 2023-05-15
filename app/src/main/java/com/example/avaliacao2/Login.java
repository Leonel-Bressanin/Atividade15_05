package com.example.avaliacao2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    //DECLARAR AS VARIÁVEIS
    EditText email;
    Button send;

    TextView txtResultado;

    //DECLARAR O ARQUIVO DE PREFERÊNCIA
    public static final String MyPREFERENCES = "arquivo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=(EditText)  findViewById(R.id.editTextTextEmail);
        send=(Button) findViewById(R.id.button2);
        txtResultado=(TextView) findViewById(R.id.textView);

        //CLASSE SHAREDPREFERENCES
        SharedPreferences sharedPreferences = getSharedPreferences(MyPREFERENCES,0);
        //SharedPreferences sharedPreferences = getSharedPreferences("arquivo", 0);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DECLARAÇÃO DE VARIÁVEIS LOCAIS
                String emailLocal = email.getText().toString();

                //DECLARAÇÃO DO EDITOR - SHAREDPREFERENCES NO MODO DE EDIÇÃO
                SharedPreferences.Editor editor = sharedPreferences.edit();

                //FAZER A PERSISTÊNCIA DOS DADOS
                editor.putString("email", emailLocal);

                //CONFIRMAR A PERSISTÊNCIA
                editor.commit();

                //NOTIFICAÇÃO NO APP
                Toast.makeText(Login.this, "Dados Cadastrados no arquivo .xml com sucesso!", Toast.LENGTH_LONG).show();

                //LIMPAR O FORMULÁRIO (GLOBAL) PARA O PRÓXIMO CADASTRO
                email.getText().clear();
            }
        });

    }
}

