package com.example.tempoextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tempoextra.roomdatabase.UserDao;
import com.example.tempoextra.roomdatabase.UserDatabase;
import com.example.tempoextra.roomdatabase.UserEntity;

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


        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaMain();
            }
        });

        btn_cadastrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //Checar se as senhas são iguais
                if (new String(senhatext.getText().toString()).equals(new String(confsenhatext.getText().toString()))) {

                    //FUNÇÕES DE CADASTRAR
                    //Criando a User Entity
                    UserEntity userEntity = new UserEntity();
                    userEntity.setNome(nometext.getText().toString());
                    userEntity.setUserId(emailtext.getText().toString());
                    userEntity.setSenha(senhatext.getText().toString());
                    userEntity.setCurso(cursotext.getText().toString());

                    if (validateImput(userEntity)) {

                        //Fazer o Insert
                        UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                        UserDao userDao = userDatabase.userDao();
                        new Thread(new Runnable() {

                            @Override
                            public void run() {

                                //Registra Usuario
                                userDao.registerUser(userEntity);

                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {

                                        Toast.makeText(getApplicationContext(), "Usuario Cadastrado", Toast.LENGTH_SHORT).show();

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

    public void telaMain() {

        Intent tela = new Intent(TelaCadastroAluno.this, MainActivity.class);
        startActivity(tela);
        finish();

    }
}