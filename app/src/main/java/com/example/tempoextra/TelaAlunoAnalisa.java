package com.example.tempoextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaAlunoAnalisa extends AppCompatActivity {

    Button btn_voltar, btn_excluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_TempoExtra);
        setContentView(R.layout.activity_tela_aluno_analisa);
        getSupportActionBar().hide();

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
        Intent tela = new Intent(TelaAlunoAnalisa.this, TelaAlunoVisualizar.class);
        startActivity(tela);
        finish();
    }

}