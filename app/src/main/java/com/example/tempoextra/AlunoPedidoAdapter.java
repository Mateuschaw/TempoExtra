package com.example.tempoextra;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tempoextra.roomdatabase.PedidoEntity;

import java.util.ArrayList;
import java.util.List;

public class AlunoPedidoAdapter extends RecyclerView.Adapter<AlunoPedidoViewHolder> {

    private String nome; // Visualizar na tela
    private String email;
    private String curso;

    private Context context;
    private List<PedidoEntity> pedido;

    public AlunoPedidoAdapter(String nome, String email, String curso) {
        this.nome = nome;
        this.email = email;
        this.curso = curso;
    }

//    public AlunoPedidoAdapter(String nome, String email, String curso, Context context, List<PedidoEntity> itens) {
//        this.nome = nome;
//        this.email = email;
//        this.curso = curso;
//        this.context = context;
//        this.itens = itens;
//    }


    public AlunoPedidoAdapter(List<PedidoEntity> pedido, Context context) {
        this.pedido = pedido;
        this.context = context;
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
//        PedidoEntity pedidoPedido = itens.get(position);
//        alunoPedidoViewHolder.titulo.setText(itens.get(position).getTipo());
//        alunoPedidoViewHolder.coordenador.setText(itens.get(position).getCoordenaId());
//        alunoPedidoViewHolder.mensagem.setText(itens.get(position).getTexto());

        PedidoEntity pedidoPedido = pedido.get(position);
        alunoPedidoViewHolder.titulo.setText(pedido.get(position).getTipo());
        alunoPedidoViewHolder.coordenador.setText(pedido.get(position).getCoordenaId());
        alunoPedidoViewHolder.mensagem.setText(pedido.get(position).getTexto());

        //Contrutor que fez a boa!
        AlunoPedidoAdapter funfo = new AlunoPedidoAdapter(nome,email,curso);
        nome = funfo.getNome();
        email = funfo.getEmail();
        curso = funfo.getCurso();

        //FUNÇÕES DE CLICK
        alunoPedidoViewHolder.titulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //adicionar um check pra achar a posição do botão
                
                Toast.makeText(context, "ENTROU", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(alunoPedidoViewHolder.itemView.getContext(), TelaAlunoAnalisa.class)
                        .putExtra("nome", nome).putExtra("curso", curso);

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
