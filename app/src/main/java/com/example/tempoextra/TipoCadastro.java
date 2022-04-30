package com.example.tempoextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class TipoCadastro extends AppCompatActivity {

    Button btn_acessar;
    ImageButton btn_aluno, btn_professor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_TempoExtra);//teste
        setContentView(R.layout.activity_tipo_cadastro);
        getSupportActionBar().hide();

        btn_acessar = findViewById(R.id.btn_cadastro);
        btn_aluno = findViewById(R.id.btn_aluno);
        btn_professor = findViewById(R.id.btn_professor);

        btn_acessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TelaMain();
            }
        });

        btn_aluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //CADASTRO ALUNO
            }
        });
        btn_professor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //CADASTRO PROFESSOR
            }
        });
    }

    public void TelaMain(){
        Intent tela = new Intent(TipoCadastro.this, MainActivity.class);
        startActivity(tela);
        finish();
    }
}