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
    int emailCheck1;
    int emailCheck22;
    int val2 = 0;

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

        btn_voltar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                TelaMain();

            }

        });

        emailCheck1 = 1;
        emailCheck22 = 1;

        btn_cadastrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                CoordenaDatabase coordenaDatabase = CoordenaDatabase.getCoordenaDatabase(getApplicationContext());
                CoordenaDao coordenaDao = coordenaDatabase.coordenaDao();

                UserEntity userEntity = new UserEntity();
                CoordenaEntity coordenaEntity = new CoordenaEntity();

                //FUNÇÕES DE CADASTRAR
                //Criando a Coordenador Entity

                //checa o banco de dados pra ver se ja existe o email digitado,
                //caso ja tenha ele gospe "Email Já Cadastrado" e não decha cadastrar
                if (validateEmail(coordenaEntity)) {

                    Toast.makeText(getApplicationContext(), "" + emailCheck1, Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "" + emailCheck22, Toast.LENGTH_SHORT).show();

                    coordenaEntity.setNome(nometext.getText().toString());
                    coordenaEntity.setCoordenaId(emailtext.getText().toString());
                    coordenaEntity.setSenha(senhatext.getText().toString());
                    coordenaEntity.setCurso(cursotext.getText().toString());

                    //valida se todos os campos estão vazios
                    if (validateInput(coordenaEntity)) {

                        //checa pra ver se as senhas são iguais
                        if (new String(senhatext.getText().toString()).equals(new String(confsenhatext.getText().toString()))) {

                            Toast.makeText(getApplicationContext(), "" + emailCheck1, Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(), "" + emailCheck22, Toast.LENGTH_SHORT).show();

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

                }

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


    private Boolean validateEmail(CoordenaEntity coordenaEntity) {

        UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
        UserDao userDao = userDatabase.userDao();

        CoordenaDatabase coordenaDatabase = CoordenaDatabase.getCoordenaDatabase(getApplicationContext());
        CoordenaDao coordenaDao = coordenaDatabase.coordenaDao();

        new Thread(new Runnable() {

            @Override
            public void run() {

                emailCheck1 = userDao.isExistsEmail(emailtext.getText().toString());
                emailCheck22 = coordenaDao.isExistsEmail(emailtext.getText().toString());

            }

        }).start();

        val2 = 0;

        if (emailCheck1 == 0) {

            Toast.makeText(getApplicationContext(), "user == 0", Toast.LENGTH_SHORT).show();

            val2 = val2 + 1;

            if (emailCheck22 == 0) {

                Toast.makeText(getApplicationContext(), "coordena == 0", Toast.LENGTH_SHORT).show();

                val2 = val2 + 1;

            }

        }

        Toast.makeText(getApplicationContext(), "val: " + val2, Toast.LENGTH_SHORT).show();

        if(val2 == 2){

            return true;

        }else{

            return false;

        }

    }

    public void TelaMain() {

        Intent tela = new Intent(TelaAdm.this, MainActivity.class);
        startActivity(tela);
        finish();

    }
}