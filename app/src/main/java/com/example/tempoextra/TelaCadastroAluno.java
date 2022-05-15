package com.example.tempoextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaCadastroAluno extends AppCompatActivity {

    Button btn_acessar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_TempoExtra);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().hide();

        btn_acessar2 = findViewById(R.id.btn_acessar2);


        btn_acessar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaMain();
            }
        });


    }

    public void telaMain(){
        Intent tela = new Intent(TelaCadastroAluno.this, MainActivity.class);
        startActivity(tela);
        finish();
    }
}