package com.example.tempoextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelaAlunoPedido extends AppCompatActivity {

    String usuario;

    Button btn_voltar, btn_solicitar;
    EditText titulotext, coordenadortext, mensagemtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_TempoExtra);
        setContentView(R.layout.activity_tela_aluno_pedido);
        getSupportActionBar().hide();

        TelaHomeScreen telaHomeScreen = new TelaHomeScreen();

        usuario = getIntent().getStringExtra("nome");


        //GUARDAR VALORES DE UM PEDIDO AQUI
        titulotext = findViewById(R.id.titulotext);
        coordenadortext = findViewById(R.id.coordenadortext);
        mensagemtext = findViewById(R.id.mensagemtext);

        btn_voltar = findViewById(R.id.btn_voltar4);
        btn_solicitar = findViewById(R.id.btn_solicitar);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaHome();
            }
        });

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void telaHome(){
        Intent tela = new Intent(TelaAlunoPedido.this, TelaHomeScreen.class);
        startActivity(tela);
        finish();
    }
}