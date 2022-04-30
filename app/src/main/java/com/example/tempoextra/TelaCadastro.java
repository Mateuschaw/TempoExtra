package com.example.tempoextra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TelaCadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_TempoExtra);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().hide();




    }
}