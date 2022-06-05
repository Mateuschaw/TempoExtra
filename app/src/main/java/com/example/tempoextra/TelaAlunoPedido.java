package com.example.tempoextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class TelaAlunoPedido extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String nome, email, curso; // Visualizar na tela
    String texto; // Spinner

    Button btn_voltar, btn_solicitar;
    EditText coordenadortext, mensagemtext;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_TempoExtra);
        setContentView(R.layout.activity_tela_aluno_pedido);
        getSupportActionBar().hide();


        nome = getIntent().getStringExtra("nome");
        email = getIntent().getStringExtra("email");
        curso = getIntent().getStringExtra("curso");


        //GUARDAR VALORES DE UM PEDIDO AQUI
        coordenadortext = findViewById(R.id.coordenadortext);
        spinner = findViewById(R.id.spinner);
        mensagemtext = findViewById(R.id.mensagemtext);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tipo, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        btn_voltar = findViewById(R.id.btn_voltar4);
        btn_solicitar = findViewById(R.id.btn_solicitar);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaHome();
                //mensagemtext.setText(texto);
            }
        });

    }

    public void telaHome(){
        Intent tela = new Intent(TelaAlunoPedido.this, TelaHomeScreen.class)
                .putExtra("nome", nome).putExtra("email", email).putExtra("curso", curso);
        startActivity(tela);
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        texto = adapterView.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}