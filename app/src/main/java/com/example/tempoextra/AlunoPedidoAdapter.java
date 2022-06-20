package com.example.tempoextra;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tempoextra.roomdatabase.PedidoEntity;

import java.util.ArrayList;
import java.util.List;

import io.github.muddz.styleabletoast.StyleableToast;

public class AlunoPedidoAdapter extends RecyclerView.Adapter<AlunoPedidoViewHolder> {

    private String nome, email, curso; // Visualizar na tela
    private int horas;
    int pos;

    private Context context;
    private List<PedidoEntity> pedido;

    public AlunoPedidoAdapter(String nome, String email, String curso, int horas) {
        this.nome = nome;
        this.email = email;
        this.curso = curso;
        this.horas = horas;
    }

    public AlunoPedidoAdapter(List<PedidoEntity> pedido, Context context, String nome, String email, String curso, int horas) {
        this.pedido = pedido;
        this.context = context;
        this.nome = nome;
        this.email = email;
        this.curso = curso;
        this.horas = horas;
    }

    @NonNull
    @Override
    public AlunoPedidoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pedido_linha, parent, false);
        AlunoPedidoViewHolder viewHolder = new AlunoPedidoViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AlunoPedidoViewHolder alunoPedidoViewHolder, int position) {
        //Contrutor que fez a boa!
        AlunoPedidoAdapter aluno = new AlunoPedidoAdapter(nome, email, curso, horas);
        nome = aluno.getNome();
        email = aluno.getEmail();
        curso = aluno.getCurso();
        horas = aluno.getHoras();

        PedidoEntity pedidoEntity = pedido.get(position);
        alunoPedidoViewHolder.titulo.setText(pedido.get(position).getTipo());
        alunoPedidoViewHolder.coordenador.setText(pedido.get(position).getCoordenaId());
        alunoPedidoViewHolder.mensagem.setText(pedido.get(position).getTexto());

        //FUNÇÕES DE CLICK
        alunoPedidoViewHolder.titulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos = alunoPedidoViewHolder.getAdapterPosition();//CONTA A POSITION

                //adicionar um check pra achar a posição do botão
                Intent intent = new Intent(alunoPedidoViewHolder.itemView.getContext(), TelaAlunoAnalisa.class)
                        .putExtra("nome", nome)
                        .putExtra("email", email)
                        .putExtra("curso", curso)
                        .putExtra("titulo", pedidoEntity.getTipo())
                        .putExtra("mensagem", pedidoEntity.getTexto())
                        .putExtra("emailc", pedidoEntity.getCoordenaId())
                        .putExtra("horas", horas);
                //COLOCAR PARAMETROS PARA PASAR DA TELA AQUI TIPO .putExtra
                alunoPedidoViewHolder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pedido.size();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
}

