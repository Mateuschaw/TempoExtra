package com.example.tempoextra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TelaAdm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_TempoExtra);
        setContentView(R.layout.activity_tela_adm);
        getSupportActionBar().hide();
    }
}