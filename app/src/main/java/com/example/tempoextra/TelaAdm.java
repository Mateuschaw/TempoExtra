package com.example.tempoextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tempoextra.roomdatabase.CoordenaDao;
import com.example.tempoextra.roomdatabase.CoordenaDatabase;
import com.example.tempoextra.roomdatabase.CoordenaEntity;
import com.example.tempoextra.roomdatabase.UserDao;
import com.example.tempoextra.roomdatabase.UserDatabase;
import com.example.tempoextra.roomdatabase.UserEntity;

public class TelaAdm extends AppCompatActivity {

    Button btn_voltar, btn_cadastrar;
    EditText nometext, emailtext, senhatext, confsenhatext, cursotext;

    int val = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_TempoExtra);
        setContentView(R.layout.activity_tela_adm);
        getSupportActionBar().hide();

        nometext = findViewById(R.id.nomeText);
        String nome;
        emailtext = findViewById(R.id.emailText);
        String email;
        senhatext = findViewById(R.id.senhaText);
        String senha;
        confsenhatext = findViewById(R.id.confsenhaText);
        cursotext = findViewById(R.id.cursoText);

        btn_voltar = findViewById(R.id.btn_voltar);
        btn_cadastrar = findViewById(R.id.btn_cadastrar_coordenador);

        btn_cadastrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (new String(senhatext.getText().toString()).equals(new String(confsenhatext.getText().toString()))) {

                    CoordenaDatabase coordenaDatabase = CoordenaDatabase.getCoordenaDatabase(getApplicationContext());
                    CoordenaDao coordenaDao = coordenaDatabase.coordenaDao();

                    CoordenaEntity coordenaEntity = new CoordenaEntity();
                    coordenaEntity.setNome(nometext.getText().toString());
                    coordenaEntity.setCoordenaId(emailtext.getText().toString());
                    coordenaEntity.setSenha(senhatext.getText().toString());
                    coordenaEntity.setCurso(cursotext.getText().toString());
                    
                    if (validateInput(coordenaEntity)) {

                        //FUNÇÕES DE CADASTRAR
                        //Criando a coordena Entity

                        //Fazer o Insert

                        new Thread(new Runnable() {

                            @Override
                            public void run() {

                                //Registra Coordena
                                coordenaDao.registerCoordena(coordenaEntity);

                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {

                                        Toast.makeText(getApplicationContext(), "Coordenador Cadastrado", Toast.LENGTH_SHORT).show();

                                        val = 0;

                                    }
                                });
                            }
                        }).start();


                    } else {

                        Toast.makeText(getApplicationContext(), "Preencha Todos Os Campos", Toast.LENGTH_SHORT).show();

                    }


                } else {

                    Toast.makeText(getApplicationContext(), "As Senhas Não São Iguais", Toast.LENGTH_SHORT).show();

                }


            }
        });


        btn_voltar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                TelaMain();
            }

        });

    }


    private Boolean validateInput(CoordenaEntity coordenaEntity) {


        if (coordenaEntity.getNome().isEmpty() ||
                coordenaEntity.getCoordenaId().isEmpty() ||
                coordenaEntity.getSenha().isEmpty() ||
                coordenaEntity.getCurso().isEmpty()) {
            return false;

        }

        return true;

    }


    public void TelaMain() {
        Intent tela = new Intent(TelaAdm.this, MainActivity.class);
        startActivity(tela);
        finish();
    }
}
