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

    private String nome; // Visualizar na tela
    private String email;
    private String curso;
    int pos;

    private Context context;
    private List<PedidoEntity> pedido;

    public AlunoPedidoAdapter(String nome, String email, String curso) {
        this.nome = nome;
        this.email = email;
        this.curso = curso;
    }

    public AlunoPedidoAdapter(List<PedidoEntity> pedido, Context context, String nome, String email, String curso) {
        this.pedido = pedido;
        this.context = context;
        this.nome = nome;
        this.email = email;
        this.curso = curso;
    }

    @NonNull
    @Override
    public AlunoPedidoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(context).inflate(R.layout.pedido_linha, parent, false);
        AlunoPedidoViewHolder viewHolder = new AlunoPedidoViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AlunoPedidoViewHolder alunoPedidoViewHolder, int position) {
       //Contrutor que fez a boa!
        AlunoPedidoAdapter funfo = new AlunoPedidoAdapter(nome,email,curso);
        nome = funfo.getNome();
        email = funfo.getEmail();
        curso = funfo.getCurso();


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
                        .putExtra("nome", nome).putExtra("email", email).putExtra("curso", curso)
                        .putExtra("pos", pos)
                        .putExtra("titulo", pedido.get(pos).getTipo())
                        .putExtra("mensagem", pedidoEntity.getTexto());//DA PRA FAZER ASSIM

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

}

