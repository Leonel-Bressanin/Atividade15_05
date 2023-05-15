package com.example.avaliacao2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity {
    //DECLARAR AS VARIÁVEIS
    EditText user, cpf, nascimento, pwd, pwd2, numero;
    Button send, list;

    TextView txtResultado;

    //DECLARAR O ARQUIVO DE PREFERÊNCIA
    public static final String MyPREFERENCES = "arquivo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        user=(EditText)  findViewById(R.id.editTextTextNome);
        cpf=(EditText)  findViewById(R.id.editTextTextCPF);
        nascimento=(EditText)  findViewById(R.id.editTextTextNascimento);
        numero=(EditText)  findViewById(R.id.editTextTextNumero);
        pwd=(EditText)  findViewById(R.id.editTextTextSenha);
        pwd2=(EditText)  findViewById(R.id.editTextTextSenha2);
        send=(Button) findViewById(R.id.button2);
        list=(Button) findViewById(R.id.button3);

        txtResultado=(TextView) findViewById(R.id.textView);

        //CLASSE SHAREDPREFERENCES
        SharedPreferences sharedPreferences = getSharedPreferences(MyPREFERENCES,0);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DECLARAÇÃO DE VARIÁVEIS LOCAIS
                String usuarioLocal = user.getText().toString();
                String cpfLocal = cpf.getText().toString();
                String nascimentoLocal = nascimento.getText().toString();
                String numeroLocal = numero.getText().toString();
                String senhaLocal = pwd.getText().toString();
                String senhaLocal2 = pwd.getText().toString();

                //DECLARAÇÃO DO EDITOR - SHAREDPREFERENCES NO MODO DE EDIÇÃO
                SharedPreferences.Editor editor = sharedPreferences.edit();

                //FAZER A PERSISTÊNCIA DOS DADOS
                editor.putString("usuario", usuarioLocal);
                editor.putString("cpf", cpfLocal);
                editor.putString("nascimento", nascimentoLocal);
                editor.putString("numero", numeroLocal);
                editor.putString("senha", senhaLocal);
                editor.putString("senha2", senhaLocal2);

                //CONFIRMAR A PERSISTÊNCIA
                editor.commit();

                //NOTIFICAÇÃO NO APP
                Toast.makeText(Cadastro.this, "Dados Cadastrados no arquivo .xml com sucesso!", Toast.LENGTH_LONG).show();

                //LIMPAR O FORMULÁRIO (GLOBAL) PARA O PRÓXIMO CADASTRO
                user.getText().clear();
                cpf.getText().clear();
                nascimento.getText().clear();
                numero.getText().clear();
                pwd.getText().clear();
                pwd2.getText().clear();
                user.requestFocus();
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        });
    }
}

