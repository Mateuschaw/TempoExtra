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
import android.widget.Toast;

import com.example.tempoextra.roomdatabase.CoordenaDao;
import com.example.tempoextra.roomdatabase.CoordenaDatabase;
import com.example.tempoextra.roomdatabase.CoordenaEntity;
import com.example.tempoextra.roomdatabase.PedidoDao;
import com.example.tempoextra.roomdatabase.PedidoDatabase;
import com.example.tempoextra.roomdatabase.PedidoEntity;

public class TelaAlunoPedido extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String nome, email, curso; // Visualizar na tela
    String tipo; // Spinner

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

        PedidoEntity pedidoEntity = new PedidoEntity();
        PedidoDatabase pedidoDatabase = PedidoDatabase.getPedidoDatabase(getApplicationContext());
        PedidoDao pedidoDao = pedidoDatabase.pedidoDao();

        btn_solicitar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                pedidoEntity.setStatus(new String("Enviado"));
                pedidoEntity.setAlunoNome(nome);
                pedidoEntity.setAlunoId(email);
                pedidoEntity.setCurso(curso);
                pedidoEntity.setCordenaId(coordenadortext.getText().toString());
                pedidoEntity.setTexto(mensagemtext.getText().toString());
                pedidoEntity.setTipo(tipo);

                if (validateInput(pedidoEntity)) {

                    new Thread(new Runnable() {

                        @Override
                        public void run() {

                            pedidoDao.registerPedido(pedidoEntity);

                            runOnUiThread(new Runnable() {

                                @Override
                                public void run() {

                                    Toast.makeText(getApplicationContext(), "Pedido Cadastrado", Toast.LENGTH_SHORT).show();

                                    Intent tela = new Intent(TelaAlunoPedido.this, TelaHomeScreen.class);
                                    startActivity(tela);
                                    finish();

                                }

                            });

                        }

                    });

                } else {

                    Toast.makeText(getApplicationContext(), "Preencha Todos Os Campos", Toast.LENGTH_SHORT).show();

                }

            }
        });

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaHome();
                //mensagemtext.setText(texto);
            }
        });

    }

    private Boolean validateInput(PedidoEntity pedidoEntity) {

        if (pedidoEntity.getTexto().isEmpty() ||
                pedidoEntity.getAlunoId().isEmpty() ||
                pedidoEntity.getCordenaId().isEmpty() ||
                pedidoEntity.getAlunoNome().isEmpty() ||
                pedidoEntity.getCurso().isEmpty() ||
                pedidoEntity.getTipo().isEmpty() ||
                pedidoEntity.getStatus().isEmpty()) {

            return false;

        }

        return true;

    }

    public void telaHome() {
        Intent tela = new Intent(TelaAlunoPedido.this, TelaHomeScreen.class)
                .putExtra("nome", nome).putExtra("email", email).putExtra("curso", curso);
        startActivity(tela);
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        tipo = adapterView.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}