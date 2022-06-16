package com.example.tempoextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaAlunoAnalisa extends AppCompatActivity {

    String nome,email, curso; // Visualizar na tela

    int position;
    String titulo;
    String mensagem;

    TextView titulo_analisa, curso_analisa, mensagem_analisa, horas_analisa, nome_analisa;
    Button btn_voltar, btn_excluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_TempoExtra);
        setContentView(R.layout.activity_tela_aluno_analisa);
        getSupportActionBar().hide();

        titulo_analisa = findViewById(R.id.titulo_analisa);
        nome_analisa = findViewById(R.id.nome_analisa);
        mensagem_analisa = findViewById(R.id.mensagem_analisa);
        curso_analisa = findViewById(R.id.curso_analisa);
        horas_analisa = findViewById(R.id.horas_analisa);//AQUI

        nome = getIntent().getStringExtra("nome");
        email = getIntent().getStringExtra("email");
        curso = getIntent().getStringExtra("curso");

        position = getIntent().getIntExtra("pos", position);//CASO PRECISE DO NUMERO DA POSIÇÃO

        titulo = getIntent().getStringExtra("titulo");
        mensagem = getIntent().getStringExtra("mensagem");

        //TEXTO NA TELA
        titulo_analisa.setText(titulo); //O INT PRECISA TER TEXTINHO SE NÃO ELE BUGA
        mensagem_analisa.setText(mensagem);
        nome_analisa.setText(nome);
        curso_analisa.setText(curso);
        //FALTA AS HORAS

        btn_excluir = findViewById(R.id.btn_excluir);
        btn_voltar = findViewById(R.id.btn_voltar8);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaHomeScreen();
            }
        });
    }

    public void telaHomeScreen(){
        Intent tela = new Intent(TelaAlunoAnalisa.this, TelaAlunoVisualizar.class)
                .putExtra("nome", nome).putExtra("email", email).putExtra("curso", curso);
        startActivity(tela);
        finish();
    }

}