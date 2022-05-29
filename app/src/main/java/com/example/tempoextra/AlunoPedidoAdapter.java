package com.example.tempoextra;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AlunoPedidoAdapter extends RecyclerView.Adapter<AlunoPedidoViewHolder> {

    private Context context;
    private ArrayList<AlunoPedido> itens;

    public AlunoPedidoAdapter(Context context, ArrayList<AlunoPedido> itens) {
        this.context = context;
        this.itens = itens;
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
        AlunoPedido alunoPedido = itens.get(position);
        alunoPedidoViewHolder.titulo.setText(alunoPedido.getTitulo());
        alunoPedidoViewHolder.coordenador.setText(alunoPedido.getCoordenador());
        alunoPedidoViewHolder.mensagem.setText(alunoPedido.getMensagem());
        //FUNÇÕES DE CLICK
        alunoPedidoViewHolder.titulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "ENTROU", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(alunoPedidoViewHolder.itemView.getContext(), TelaAlunoAnalisa.class);
                //COLOCAR PARAMETROS PARA PASAR DA TELA AQUI TIPO .putExtra
                alunoPedidoViewHolder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }
}
