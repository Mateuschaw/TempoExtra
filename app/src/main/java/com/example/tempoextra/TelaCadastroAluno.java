package com.example.tempoextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaCadastroAluno extends AppCompatActivity {

    Button btn_voltar, btn_cadastrar;
    EditText nometext,emailtext,senhatext,confsenhatext,cursotext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_TempoExtra);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().hide();

        nometext = findViewById(R.id.nomeText);
        emailtext = findViewById(R.id.emailText);
        senhatext = findViewById(R.id.senhaText);
        confsenhatext = findViewById(R.id.confsenhaText);
        cursotext = findViewById(R.id.cursoText);

        btn_voltar = findViewById(R.id.btn_voltar);
        btn_cadastrar = findViewById(R.id.btn_cadastrar);



        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaMain();
            }
        });

        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //FUNÇÕES DE CADASTRAR
                String nome = nometext.getText().toString();//formatação de texto

            }
        });


    }

    public void telaMain(){
        Intent tela = new Intent(TelaCadastroAluno.this, MainActivity.class);
        startActivity(tela);
        finish();
    }
}