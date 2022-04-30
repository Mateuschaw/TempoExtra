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
    Button btn_acesso, btn_cadastro;

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

        btn_acesso = findViewById(R.id.btn_acesso);
        btn_cadastro = findViewById(R.id.btn_cadastro);

        btn_acesso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailtext.getText().toString();
                String senha = senhatext.getText().toString();

                if(email.equals("admin") && (senha.equals("123"))){
                    telaAdm();
                }
                else if(email.equals("") && (senha.equals(""))){
                    telaCadastro();
                }
                else{
                    textView.setText("Erro nos dados:  "+ email + senha);
                }
            }
        });

        btn_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TipoCadastro();
            }
        });


    }

    public void telaCadastro(){
        Intent tela = new Intent(MainActivity.this, TelaCadastro.class);
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