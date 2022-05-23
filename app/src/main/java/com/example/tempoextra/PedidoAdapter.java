package com.example.tempoextra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PedidoAdapter extends RecyclerView.Adapter<PedidoViewHolder> {

    private Context context;
    private ArrayList<Pedido> itens;

    public PedidoAdapter(Context context, ArrayList<Pedido> itens) {
        this.context = context;
        this.itens = itens;
    }

    @NonNull
    @Override
    public PedidoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(context).inflate(R.layout.produtos_linha, parent, false);
        PedidoViewHolder viewHolder = new PedidoViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PedidoViewHolder pedidoViewHolder, int position) {
        Pedido pedido = itens.get(position);
        pedidoViewHolder.titulo.setText(pedido.getTitulo());
        pedidoViewHolder.coordenador.setText(pedido.getCoordenador());
        pedidoViewHolder.mensagem.setText(pedido.getMensagem());

        //FUNÇÕES DE CLICK
        pedidoViewHolder.titulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "CLICOU", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }
}
