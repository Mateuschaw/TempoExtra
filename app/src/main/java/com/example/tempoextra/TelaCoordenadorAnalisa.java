package com.example.tempoextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaCoordenadorAnalisa extends AppCompatActivity {

    Button btn_voltar, btn_deferir, btn_indeferir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(R.style.Theme_TempoExtra);
        setContentView(R.layout.activity_tela_coordenador_analisa);
        getSupportActionBar().hide();

        btn_deferir = findViewById(R.id.btn_deferir);
        btn_indeferir = findViewById(R.id.btn_indeferir);
        btn_voltar = findViewById(R.id.btn_voltar7);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaHomeCoordenador();
            }
        });

    }

    public void telaHomeCoordenador(){
        Intent tela = new Intent(TelaCoordenadorAnalisa.this, TelaHomeCoordenador.class);
        startActivity(tela);
        finish();
    }
}