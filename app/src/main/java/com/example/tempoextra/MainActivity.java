package com.example.tempoextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tempoextra.roomdatabase.CoordenaDao;
import com.example.tempoextra.roomdatabase.CoordenaDatabase;
import com.example.tempoextra.roomdatabase.CoordenaEntity;
import com.example.tempoextra.roomdatabase.UserDao;
import com.example.tempoextra.roomdatabase.UserDatabase;
import com.example.tempoextra.roomdatabase.UserEntity;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    EditText emailtext, senhatext;
    Button btn_acessar, btn_cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

//        try {
//            Thread.sleep(1000);
//
//        } catch (InterruptedException e) {
//
//            e.printStackTrace();
//
//        }
        setTheme(R.style.Theme_TempoExtra);//SPASH SCREEN

        setContentView(R.layout.activity_main);//ATIVIDADE
        getSupportActionBar().hide();


        emailtext = findViewById(R.id.emailText);
        senhatext = findViewById(R.id.senhaText);

        btn_acessar = findViewById(R.id.btn_acesso);
        btn_cadastro = findViewById(R.id.btn_acessar);

        btn_acessar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //Função de Login
                //Validação de Input

                final String email = emailtext.getText().toString();
                final String senha = senhatext.getText().toString();

                if (email.isEmpty() || senha.isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Preencha Todos os Campos!", Toast.LENGTH_SHORT).show();

                } else {

                    //Login de administrador
                    if (email.equals("admin") && (senha.equals("1234"))) {

                        telaAdm();
                        Toast.makeText(getApplicationContext(), "Bem vindo Administrador!", Toast.LENGTH_SHORT).show();

                    } else {
                        //Realizar o query

                        UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                        CoordenaDatabase coordenaDatabase = CoordenaDatabase.getCoordenaDatabase(getApplicationContext());

                        final UserDao userDao = userDatabase.userDao();
                        final CoordenaDao coordenaDao = coordenaDatabase.coordenaDao();

                        new Thread(new Runnable() {

                            @Override
                            public void run() {

                                UserEntity userEntity = userDao.login(email, senha);
                                CoordenaEntity coordenaEntity = coordenaDao.login(email, senha);

                                // adicionar uma logica a onde ser for userEntity == null ele entrana na tela de coordenador e ser for coordenaEntity == null ele
                                // entra na tela de usuario caso ambos sejão null ele dira o erro "Login ou Senha Incorretos!"

                                if (userEntity == null && coordenaEntity == null) {

                                    //LÓGICA DE ERRO DE PROCURA DE CADASTRO

                                    runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {

                                            Toast.makeText(getApplicationContext(), "Login ou Senha Incorretos!", Toast.LENGTH_SHORT).show();

                                        }
                                    });

                                } else if (userEntity == null) {

                                    //LÓGICA PARA ENTRAR NA DE COORDENADOR
                                    String nome = coordenaEntity.getNome();
                                    String curso = coordenaEntity.getCurso();


                                    startActivity(new Intent(MainActivity.this, TelaHomeCoordenador.class)
                                            .putExtra("nome", nome).putExtra("curso", curso));


                                } else if (coordenaEntity == null) {

                                    //LÓGICA PARA ENTRAR NA DE ALUNO(USER)
                                    String nome = userEntity.getNome();
                                    String curso = userEntity.getCurso();


                                    startActivity(new Intent(MainActivity.this, TelaHomeScreen.class)
                                            .putExtra("nome", nome).putExtra("curso", curso));


                                } else {

                                    //LÓGICA DE ERRO ASTRONOMICO

                                    runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {

                                            Toast.makeText(getApplicationContext(), "RATINHO JUNIOR PARABENS VC N DEVIA ESTAR LENDO ISSO", Toast.LENGTH_SHORT).show();

                                        }

                                    });

                                }

                            }

                        }).start();

                    }


                }

            }
        });

        btn_cadastro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                telaCadastro();//TELA TIPO CADASTRO

            }
        });


    }

    public void telaCadastro() {

        Intent tela = new Intent(MainActivity.this, TelaCadastroAluno.class);
        startActivity(tela);
        finish();

    }

    public void telaAdm() {

        Intent tela = new Intent(MainActivity.this, TelaAdm.class);
        startActivity(tela);
        finish();

    }

}