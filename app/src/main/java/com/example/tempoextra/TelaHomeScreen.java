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
import com.example.tempoextra.databinding.ActivityTelaHomeScreenBinding;

public class TelaHomeScreen extends AppCompatActivity {

    TextView tnome;
    TextView tcurso;

    Button btn_voltar, btn_pedido, btn_verpedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_TempoExtra);
        setContentView(R.layout.activity_tela_home_screen);
        getSupportActionBar().hide();

        tnome = findViewById(R.id.nome);
        String usuario = getIntent().getStringExtra("nome");
        tnome.setText(usuario);

        tcurso = findViewById(R.id.curso); //Não está funcionando
        String curso = getIntent().getStringExtra("curso");
        tcurso.setText(curso);

        btn_voltar = findViewById(R.id.btn_voltar3);
        btn_pedido = findViewById(R.id.btn_pedido);

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


    }
    public void telaPedido(){
        Intent tela = new Intent(TelaHomeScreen.this, TelaAlunoPedido.class);
        startActivity(tela);
        finish();
    }

    public void telaVisualizarPedidos(){

    }

    public void telaMain() {
        Intent tela = new Intent(TelaHomeScreen.this, MainActivity.class);
        startActivity(tela);
        finish();
    }
}