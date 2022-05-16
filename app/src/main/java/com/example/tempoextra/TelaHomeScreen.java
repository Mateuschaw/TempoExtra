package com.example.tempoextra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TelaHomeScreen extends AppCompatActivity {

    TextView tnome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_home_screen);

        tnome = findViewById(R.id.nome);
        String usuario = getIntent().getStringExtra("nome");
        tnome.setText(usuario);

    }
}