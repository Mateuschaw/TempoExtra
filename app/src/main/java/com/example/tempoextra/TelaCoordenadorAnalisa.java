package com.example.tempoextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tempoextra.roomdatabase.PedidoDao;
import com.example.tempoextra.roomdatabase.PedidoDatabase;
import com.example.tempoextra.roomdatabase.PedidoEntity;
import com.example.tempoextra.roomdatabase.UserDao;
import com.example.tempoextra.roomdatabase.UserDatabase;
import com.example.tempoextra.roomdatabase.UserEntity;

import io.github.muddz.styleabletoast.StyleableToast;

public class TelaCoordenadorAnalisa extends AppCompatActivity {

    String emailc, titulo, nome, curso, email, mensagem;
    int horas;

    Button btn_voltar, btn_deferir, btn_indeferir;
    EditText text_horas;

    TextView text_aluno_curso, text_aluno_nome, text_titulo_pedido, text_aluno_email, text_aluno_mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(R.style.Theme_TempoExtra);
        setContentView(R.layout.activity_tela_coordenador_analisa);
        getSupportActionBar().hide();

        //Botões
        btn_deferir = findViewById(R.id.btn_deferir);
        btn_indeferir = findViewById(R.id.btn_indeferir);
        btn_voltar = findViewById(R.id.btn_voltar7);

        //TEXTOS
        text_titulo_pedido = findViewById(R.id.text_titulo_pedido);
        text_aluno_nome = findViewById(R.id.text_aluno_nome);
        text_aluno_curso = findViewById(R.id.text_aluno_curso);
        text_aluno_email = findViewById(R.id.text_aluno_email);
        text_aluno_mensagem = findViewById(R.id.text_aluno_mensagem);

        //EDIT text
        text_horas = findViewById(R.id.text_horas);

        emailc = getIntent().getStringExtra("email");//EMAIL DO COORDENADOR IMPORTANTE

        //Intent dos valores do aluno
        titulo = getIntent().getStringExtra("titulo");
        nome = getIntent().getStringExtra("nome");
        curso = getIntent().getStringExtra("curso");
        email = getIntent().getStringExtra("email_aluno");
        mensagem = getIntent().getStringExtra("mensagem");

        //BOTA OS VALORES NA TELA
        text_titulo_pedido.setText(titulo);
        text_aluno_nome.setText(nome);
        text_aluno_curso.setText(curso);
        text_aluno_email.setText(email);
        text_aluno_mensagem.setText(mensagem);


        //BOTÃO DEFERIR, SERVE PARA ADICIONAR AS HORAS COMPLEMENTARES AO ALUNO
        btn_deferir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String horast = text_horas.getText().toString();
                if (horast.isEmpty()) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            toastErradoCampos();
                        }
                    });
                } else {

                    //VARIAVEL HORAS É A VARIAVEL INT QUE CONTEM AS HORAS QUE O COORDENADOR BOTOU
                    horas = Integer.parseInt(text_horas.getText().toString());

                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();
                    UserEntity userEntity = new UserEntity();

                    try {
                        userEntity = userDao.loginEmail(email);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    int horasaluno = userEntity.getHoras();
                    int horasfinal = horas + horasaluno;

                    try {
                        int retorno = userDao.updateUserQ(horasfinal, email);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    PedidoDatabase pedidoDatabase = PedidoDatabase.getPedidoDatabase(getApplicationContext());
                    PedidoDao pedidoDao = pedidoDatabase.pedidoDao();
                    PedidoEntity pedidoEntity = new PedidoEntity();

                    pedidoDao.deletePedidoQ(email, mensagem);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            toastDeferido();
                        }
                    });
                    //volta pra tela inicial
                    telaHomeCoordenador();
                }
            }
        });//BOTÃO DEFERIR TERMINA AQUI

        //BOTÃO DE INDEFERIR PEDIDO SERVE PARA NEGAR O PEDIDO DO ALUNO
        btn_indeferir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //EXCLUIR PEDIDO AQUI DENTRO

                PedidoDatabase pedidoDatabase = PedidoDatabase.getPedidoDatabase(getApplicationContext());
                PedidoDao pedidoDao = pedidoDatabase.pedidoDao();
                PedidoEntity pedidoEntity = new PedidoEntity();

                pedidoDao.deletePedidoQ(email, mensagem);

                toastIndeferido();
                //volta pra tela inicial
                telaHomeCoordenador();

            }
        });//BOTÃO INDEFERIR TERMINA AQUI

        //volta pra tela inicial
        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaHomeCoordenador();
            }
        });
    }

    public void telaHomeCoordenador() {
        Intent tela = new Intent(TelaCoordenadorAnalisa.this, TelaHomeCoordenador.class)
                .putExtra("email", emailc);
        startActivity(tela);
        finish();
    }

    public void toastErradoCampos() {
        StyleableToast.makeText(this, "Preencha o Campo Horas!", R.style.toast_negado).show();
    }

    public void toastDeferido() {
        StyleableToast.makeText(this, "Pedido Deferido Com Sucesso!", R.style.toast_verificado).show();
    }

    public void toastIndeferido() {
        StyleableToast.makeText(this, "Pedido Indeferido Com Sucesso!", R.style.toast_verificado).show();
    }
}