package com.example.tempoextra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tempoextra.roomdatabase.CoordenaDao;
import com.example.tempoextra.roomdatabase.CoordenaDatabase;
import com.example.tempoextra.roomdatabase.CoordenaEntity;
import com.example.tempoextra.roomdatabase.PedidoDao;
import com.example.tempoextra.roomdatabase.PedidoDatabase;
import com.example.tempoextra.roomdatabase.PedidoEntity;

import java.util.ArrayList;
import java.util.List;

public class TelaHomeCoordenador extends AppCompatActivity {

    private RecyclerView recycler;
    private CoordenadorPedidoAdapter adapter;
    private ArrayList<CoordenadorPedido> itens;

    String email;

    TextView tnome;
    Button btn_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_TempoExtra);//SPASH SCREEN
        setContentView(R.layout.activity_tela_home_coordenador);
        getSupportActionBar().hide();

        tnome = findViewById(R.id.text_coordenador);
        String usuario = getIntent().getStringExtra("nome");
        String email = getIntent().getStringExtra("email");
        String curso = getIntent().getStringExtra("curso");


        recycler = findViewById(R.id.recycler_coordenador);

        PedidoEntity pedidoEntity = new PedidoEntity();
        PedidoDatabase pedidoDatabase = PedidoDatabase.getPedidoDatabase(getApplicationContext());
        PedidoDao pedidoDao = pedidoDatabase.pedidoDao();

        List<PedidoEntity> pedido = pedidoDao.getAllPedidosCoordena(email);//Coordenador

        adapter = new CoordenadorPedidoAdapter(TelaHomeCoordenador.this, pedido, email);
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
        Intent tela = new Intent(TelaHomeCoordenador.this, MainActivity.class)
                .putExtra("email", email);
        startActivity(tela);
        finish();
    }
}