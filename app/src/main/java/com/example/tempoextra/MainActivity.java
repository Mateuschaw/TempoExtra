package com.example.tempoextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText emailtext, senhatext;
    Button btn_acessar, btn_cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setTheme(R.style.Theme_TempoExtra);//SPASH SCREEN

        setContentView(R.layout.activity_main);//ATIVIDADE
        getSupportActionBar().hide();

        textView = findViewById(R.id.textView3);

        emailtext = findViewById(R.id.emailText);
        senhatext = findViewById(R.id.senhaText);

        btn_acessar = findViewById(R.id.btn_acesso);
        btn_cadastro = findViewById(R.id.btn_acessar);

        btn_acessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //FUNÇÃO DE LOGIN





                //FUNÇÃO DE ADMINISTRADOR
                String email = emailtext.getText().toString();
                String senha = senhatext.getText().toString();

                if(email.equals("admin") && (senha.equals("123"))){
                    telaAdm();
                }
                else if(email.equals("") && (senha.equals(""))){
                    telaCadastro();
                }
                else{
                    textView.setText("Erro nos dados:  "+ email + senha);//TEXT VIEW MAIN
                }
            }
        });

        btn_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TipoCadastro();//TELA TIPO CADASTRO
            }
        });


    }

    public void telaCadastro(){
        Intent tela = new Intent(MainActivity.this, TelaCadastroAluno.class);
        startActivity(tela);
        finish();
    }

    public void telaAdm(){
        Intent tela = new Intent(MainActivity.this, TelaAdm.class);
        startActivity(tela);
        finish();
    }
    public void TipoCadastro(){
        Intent tela = new Intent(MainActivity.this, TipoCadastro.class);
        startActivity(tela);
        finish();
    }
}