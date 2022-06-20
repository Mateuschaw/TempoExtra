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

import io.github.muddz.styleabletoast.StyleableToast;

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
        emailtext = findViewById(R.id.emailText);
        senhatext = findViewById(R.id.senhaText);
        confsenhatext = findViewById(R.id.confsenhaText);
        cursotext = findViewById(R.id.cursoText);

        btn_voltar = findViewById(R.id.btn_voltar);
        btn_cadastrar = findViewById(R.id.btn_cadastrar_coordenador);

        UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
        UserDao userDao = userDatabase.userDao();

        CoordenaDatabase coordenaDatabase = CoordenaDatabase.getCoordenaDatabase(getApplicationContext());
        CoordenaDao coordenaDao = coordenaDatabase.coordenaDao();

        CoordenaEntity coordenaEntity = new CoordenaEntity();
        UserEntity userEntity = new UserEntity();

        coordenaEntity = null;
        userEntity = null;

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TelaMain();
            }
        });

        //FUNÇÕES DE CADASTRAR
        btn_cadastrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                val = 0;

                final String nome = nometext.getText().toString();
                final String email = emailtext.getText().toString();
                final String senha = senhatext.getText().toString();
                final String curso = cursotext.getText().toString();

                //checa pra ver se todos os campos estão preenchidos
                if (nome.isEmpty() ||
                        email.isEmpty() ||
                        senha.isEmpty() ||
                        curso.isEmpty()) {
                    toastErradoCampos(); //TOAST DE CAMPOS INCOMPLETOS
                } else {

                    //checa pra ver se as senhas são iguais
                    if (new String(senhatext.getText().toString()).equals(new String(confsenhatext.getText().toString()))) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                UserEntity userEntity = userDao.loginEmail(emailtext.getText().toString());
                                CoordenaEntity coordenaEntity = coordenaDao.loginEmail(emailtext.getText().toString());

                                //checa pra ver se ambas as Entitys estão vasias, com ambas vazias o email não esta cadastro no sistema
                                if (userEntity == null && coordenaEntity == null) {

                                    //coloca as informações digitadas na UserEntity
                                    //e cadastra o coordenador
                                    putOnCoordena();
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            toastCorretoCadastro();// TOAST DE CADASTRAR COORDENADOR
                                        }
                                    });
                                } else {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            toastErradoEmail();// TOAST EMAIL JÁ EXISTE
                                            finish();
                                            startActivity(getIntent());
                                        }
                                    });
                                }
                            }
                        }).start();
                    } else {
                        toastErradoSenha();// TOAST DE SENHA ERRADA
                    }
                }
            }
        });
    }

    public void putOnCoordena() {
        CoordenaEntity coordenaEntity = new CoordenaEntity();

        //coloca as informações dentro da Entity
        coordenaEntity.setNome(nometext.getText().toString());
        coordenaEntity.setCoordenaId(emailtext.getText().toString());
        coordenaEntity.setSenha(senhatext.getText().toString());
        coordenaEntity.setCurso(cursotext.getText().toString());

        CoordenaDatabase coordenaDatabase = CoordenaDatabase.getCoordenaDatabase(getApplicationContext());
        CoordenaDao coordenaDao = coordenaDatabase.coordenaDao();

        //Fazer o Insert
        //Registra Usuario
        coordenaDao.registerCoordena(coordenaEntity);
    }


    public void TelaMain() {
        Intent tela = new Intent(TelaAdm.this, MainActivity.class);
        startActivity(tela);
        finish();
    }

    public void toastCorretoCadastro() {
        StyleableToast.makeText(this, "Coordenador Cadastrado!", R.style.toast_verificado).show();
    }

    public void toastErradoCampos() {
        StyleableToast.makeText(this, "Preencha Todos os Campos!", R.style.toast_negado).show();
    }

    public void toastErradoEmail() {
        StyleableToast.makeText(this, "Email já Cadastrado!", R.style.toast_negado).show();
    }

    public void toastErradoSenha() {
        StyleableToast.makeText(this, "As Senhas Não São Iguais", R.style.toast_negado).show();
    }
}