package com.example.tempoextra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class TelaAlunoVisualizar extends AppCompatActivity {

    String nome, curso; // Visualizar na tela

    private RecyclerView recycler;
    private AlunoPedidoAdapter adapter;
    private ArrayList<AlunoPedido> itens;
    Button btn_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_TempoExtra);
        setContentView(R.layout.activity_tela_aluno_visualizar);
        getSupportActionBar().hide();

        nome = getIntent().getStringExtra("nome");
        curso = getIntent().getStringExtra("curso");

        //LISTAR TODOS OS PEDIDOS QUE O USUÁRIO TEM NA CONTA
        recycler = findViewById(R.id.recycler_pedidos);

        itens = new ArrayList<AlunoPedido>();
        itens.add(new AlunoPedido("Horas", "Gouveia", "Quero 10 Horas"));
        itens.add(new AlunoPedido("Horas", "Gouveia", "Quero 10 Horas"));
        itens.add(new AlunoPedido("Horas", "Gouveia", "Quero 10 Horas"));


        adapter = new AlunoPedidoAdapter(TelaAlunoVisualizar.this, itens);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TelaAlunoVisualizar.this,
                LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);

        btn_voltar = findViewById(R.id.btn_voltar5);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaHome();
            }
        });

    }

    public void telaHome(){
        Intent tela = new Intent(TelaAlunoVisualizar.this, TelaHomeScreen.class)
                .putExtra("nome", nome).putExtra("curso", curso);
        startActivity(tela);
        finish();
    }


}