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

public class TelaCadastroAluno extends AppCompatActivity {

    Button btn_voltar, btn_cadastrar;
    EditText nometext, emailtext, senhatext, confsenhatext, cursotext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(R.style.Theme_TempoExtra);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().hide();

        nometext = findViewById(R.id.nomeText);
        emailtext = findViewById(R.id.emailText);
        senhatext = findViewById(R.id.senhaText);
        confsenhatext = findViewById(R.id.confsenhaText);
        cursotext = findViewById(R.id.cursoText);

        btn_voltar = findViewById(R.id.btn_voltar);
        btn_cadastrar = findViewById(R.id.btn_cadastrar);

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

                telaMain();

            }

        });

        //FUNÇÕES DE CADASTRAR
        btn_cadastrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String nome = nometext.getText().toString();
                final String email = emailtext.getText().toString();
                final String senha = senhatext.getText().toString();
                final String curso = cursotext.getText().toString();

                //checa pra ver se todos os campos estão preenchidos
                if (nome.isEmpty() ||
                        email.isEmpty() ||
                        senha.isEmpty() ||
                        curso.isEmpty()) {

                    toastErradoCampos(); // TOAST DE CAMPOS PRREENCHIDOS

                } else {

                    //checa se os dois campos de senha estão iguais
                    if (new String(senhatext.getText().toString()).equals(new String(confsenhatext.getText().toString()))) {

                        new Thread(new Runnable() {

                            @Override
                            public void run() {

                                UserEntity userEntity = userDao.loginEmail(emailtext.getText().toString());
                                CoordenaEntity coordenaEntity = coordenaDao.loginEmail(emailtext.getText().toString());

                                //checa pra ver se ambas as Entitys estão vasias, com ambas vazias o email não esta cadastro no sistema
                                if (userEntity == null && coordenaEntity == null) {

//                                  coloca as informações digitadas na UserEntity
//                                  e cadastra o usuario
                                    putOnUser();

                                    runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {

                                            toastCorretoCadastro();// TOAST DE CADASTRO CORRETO

                                            Intent tela = new Intent(TelaCadastroAluno.this, MainActivity.class);
                                            startActivity(tela);
                                            finish();

                                        }

                                    });

                                } else {

                                    runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {

                                            toastErradoEmail(); // TOAST DE VERIFICAR EMAIL

                                            finish();
                                            startActivity(getIntent());

                                        }

                                    });

                                }

                            }

                        }).start();

                    } else {

                        toastErradoSenha(); //TOAST DE SENHA ERRADA

                    }

                }

            }

        });

    }

    public void putOnUser() {

        UserEntity userEntity = new UserEntity();

        //coloca as informações dentro da Entity
        userEntity.setNome(nometext.getText().toString());
        userEntity.setUserId(emailtext.getText().toString());
        userEntity.setSenha(senhatext.getText().toString());
        userEntity.setCurso(cursotext.getText().toString());

        UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
        UserDao userDao = userDatabase.userDao();

        //Fazer o Insert
        //Registra Usuario
        userDao.registerUser(userEntity);

    }

    public void telaMain() {

        Intent tela = new Intent(TelaCadastroAluno.this, MainActivity.class);
        startActivity(tela);
        finish();

    }

    public void toastCorretoCadastro(){
        StyleableToast.makeText(this, "Aluno Cadastrado!", R.style.toast_verificado).show();
    }

    public void toastErradoCampos(){
        StyleableToast.makeText(this, "Preencha Todos os Campos!", R.style.toast_negado).show();
    }

    public void toastErradoEmail(){
        StyleableToast.makeText(this, "Email já Cadastrado!", R.style.toast_negado).show();
    }

    public void toastErradoSenha(){
        StyleableToast.makeText(this, "As Senhas Não São Iguais", R.style.toast_negado).show();
    }

}