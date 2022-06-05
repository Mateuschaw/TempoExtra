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

public class TelaCadastroAluno extends AppCompatActivity {

    Button btn_voltar, btn_cadastrar;
    EditText nometext, emailtext, senhatext, confsenhatext, cursotext;
    int emailCheck;
    int emailCheck2;
    int val = 0;

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


        btn_voltar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                telaMain();

            }

        });

        emailCheck = 1;
        emailCheck2 = 1;

        btn_cadastrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                UserDao userDao = userDatabase.userDao();

                CoordenaEntity coordenaEntity = new CoordenaEntity();
                UserEntity userEntity = new UserEntity();

                //FUNÇÕES DE CADASTRAR
                //Criando a User Entity

                if (validateEmail(userEntity)) {

                    Toast.makeText(getApplicationContext(), "" + emailCheck, Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "" + emailCheck2, Toast.LENGTH_SHORT).show();

                    userEntity.setNome(nometext.getText().toString());
                    userEntity.setUserId(emailtext.getText().toString());
                    userEntity.setSenha(senhatext.getText().toString());
                    userEntity.setCurso(cursotext.getText().toString());

                    if (validateImput(userEntity)) {

                        //Checar se as senhas são iguais
                        if (new String(senhatext.getText().toString()).equals(new String(confsenhatext.getText().toString()))) {

                            //checa o banco de dados pra ver se ja existe o email digitado,
                            //caso ja tenha ele gospe "Email Já Cadastrado" e não decha cadastrar


                            //Fazer o Insert

                            new Thread(new Runnable() {

                                @Override
                                public void run() {

                                    //Registra Usuario
                                    userDao.registerUser(userEntity);

                                    runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {

                                            Toast.makeText(getApplicationContext(), "Usuario Cadastrado", Toast.LENGTH_SHORT).show();

//                                            Intent tela = new Intent(TelaCadastroAluno.this, MainActivity.class);
//                                            startActivity(tela);
//                                            finish();

                                        }

                                    });

                                }

                            }).start();


                        } else {

                            Toast.makeText(getApplicationContext(), "As Senhas Não São Iguais", Toast.LENGTH_SHORT).show();

                        }


                    } else {

                        Toast.makeText(getApplicationContext(), "Preencha Todos Os Campos", Toast.LENGTH_SHORT).show();

                    }
                } else {

                    Toast.makeText(getApplicationContext(), "Email Já Cadastrado", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());

                }

            }

        });

    }

    private Boolean validateImput(UserEntity userEntity) {

        if (userEntity.getNome().isEmpty() ||
                userEntity.getUserId().isEmpty() ||
                userEntity.getSenha().isEmpty() ||
                userEntity.getCurso().isEmpty()) {
            return false;

        }

        return true;

    }

    private Boolean validateEmail(UserEntity userEntity) {

        UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
        UserDao userDao = userDatabase.userDao();

        CoordenaDatabase coordenaDatabase = CoordenaDatabase.getCoordenaDatabase(getApplicationContext());
        CoordenaDao coordenaDao = coordenaDatabase.coordenaDao();

        new Thread(new Runnable() {

            @Override
            public void run() {

                emailCheck = userDao.isExistsEmail(emailtext.getText().toString());
                emailCheck2 = coordenaDao.isExistsEmail(emailtext.getText().toString());

            }

        }).start();


        val = 0;

        if (emailCheck == 0) {

            Toast.makeText(getApplicationContext(), "user == 0", Toast.LENGTH_SHORT).show();

            val = val + 1;

            if (emailCheck2 == 0) {

                Toast.makeText(getApplicationContext(), "coordena == 0", Toast.LENGTH_SHORT).show();

                val = val + 1;

            }

        }

        Toast.makeText(getApplicationContext(), "val: " + val, Toast.LENGTH_SHORT).show();

        if(val == 2){

            return true;

        }else{

            return false;

        }

    }

    public void telaMain() {

        Intent tela = new Intent(TelaCadastroAluno.this, MainActivity.class);
        startActivity(tela);
        finish();

    }

}