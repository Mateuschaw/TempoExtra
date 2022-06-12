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
    Button btn_voltar, btn_excluir;

    TextView titulo_analisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_TempoExtra);
        setContentView(R.layout.activity_tela_aluno_analisa);
        getSupportActionBar().hide();

        titulo_analisa = findViewById(R.id.titulo_analisa);

        nome = getIntent().getStringExtra("nome");
        email = getIntent().getStringExtra("email");
        curso = getIntent().getStringExtra("curso");
        position = getIntent().getIntExtra("pos", position);

        titulo_analisa.setText(""+position); //ELE PRECISA TER ESSE TEXTINHO SE NÃO ELE BUGA

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