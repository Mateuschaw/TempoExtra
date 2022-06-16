package com.example.tempoextra;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaHomeScreen extends AppCompatActivity {

    private String nome, email, curso; // Visualizar na tela

    TextView tnome;
    TextView tcurso;

    Button btn_voltar, btn_pedido, btn_verpedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_TempoExtra);
        setContentView(R.layout.activity_tela_home_screen);
        getSupportActionBar().hide();


        //TELAS NÃO ESTÃO SALVANDO NOMES

        tnome = findViewById(R.id.nome);
        nome = getIntent().getStringExtra("nome");
        tnome.setText(nome);

        email = getIntent().getStringExtra("email");

        tcurso = findViewById(R.id.curso);
        curso = getIntent().getStringExtra("curso");
        tcurso.setText(curso);

        btn_voltar = findViewById(R.id.btn_voltar3);
        btn_pedido = findViewById(R.id.btn_pedido);
        btn_verpedido = findViewById(R.id.btn_verpedido);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaMain();
            }
        });

        btn_pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaPedido();
            }
        });

        btn_verpedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaVisualizarPedidos();
            }
        });

    }

    public void telaPedido() {
        Intent tela = new Intent(TelaHomeScreen.this, TelaAlunoPedido.class)
                .putExtra("nome", nome).putExtra("email", email).putExtra("curso", curso);

        startActivity(tela);
        finish();
    }

    public void telaVisualizarPedidos() {
        Intent tela = new Intent(TelaHomeScreen.this, TelaAlunoVisualizar.class)
                .putExtra("nome", nome).putExtra("email", email).putExtra("curso", curso);
        startActivity(tela);
        finish();
    }

    public void telaMain() {
        Intent tela = new Intent(TelaHomeScreen.this, MainActivity.class);
        startActivity(tela);
        finish();
    }

}