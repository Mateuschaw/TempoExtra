package com.example.tempoextra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TelaHomeCoordenador extends AppCompatActivity {

    private RecyclerView recycler;
    private CoordenadorPedidoAdapter adapter;
    private ArrayList<CoordenadorPedido> itens;

    TextView tnome;
    Button btn_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_TempoExtra);//SPASH SCREEN
        setContentView(R.layout.activity_tela_home_coordenador);
        getSupportActionBar().hide();

        tnome = findViewById(R.id.nome);
        String usuario = getIntent().getStringExtra("nome");
        tnome.setText(usuario);

        recycler = findViewById(R.id.recycler_coordenador);
        itens = new ArrayList<CoordenadorPedido>();
        itens.add(new CoordenadorPedido("Horas", "Gouveia", "funcionales"));
        itens.add(new CoordenadorPedido("Horas", "Gouveia", "Quero 10 Horas"));
        itens.add(new CoordenadorPedido("Horas", "Gouveia", "Quero 10 Horas"));
        itens.add(new CoordenadorPedido("Horas", "Kerneski", "funcionales"));
        itens.add(new CoordenadorPedido("Jabuticaba", "Gouveia", "funcionales"));


        adapter = new CoordenadorPedidoAdapter(TelaHomeCoordenador.this, itens);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TelaHomeCoordenador.this,
                LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);

        btn_voltar = findViewById(R.id.btn_voltar6);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TelaMain();
            }
        });


    }

    public void TelaMain(){
        Intent tela = new Intent(TelaHomeCoordenador.this, MainActivity.class);
        startActivity(tela);
        finish();
    }
}