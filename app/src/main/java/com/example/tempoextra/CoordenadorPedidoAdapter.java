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

public class CoordenadorPedidoAdapter extends RecyclerView.Adapter<CoordenadorPedidoViewHolder> {

    private Context context;
    private ArrayList<CoordenadorPedido> itens;

    public CoordenadorPedidoAdapter(Context context, ArrayList<CoordenadorPedido> itens) {
        this.context = context;
        this.itens = itens;
    }

    @NonNull
    @Override
    public CoordenadorPedidoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(context).inflate(R.layout.pedidocoordenador_linha, parent, false);
        CoordenadorPedidoViewHolder viewHolder = new CoordenadorPedidoViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CoordenadorPedidoViewHolder coordenadorPedidoViewHolder, int position) {
        CoordenadorPedido coordenadorPedido = itens.get(position);
        coordenadorPedidoViewHolder.titulo.setText(coordenadorPedido.getTitulo());
        coordenadorPedidoViewHolder.coordenador.setText(coordenadorPedido.getCoordenador());
        coordenadorPedidoViewHolder.mensagem.setText(coordenadorPedido.getMensagem());
        //FUNÇÕES DE CLICK
        coordenadorPedidoViewHolder.titulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "ENTROU", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(coordenadorPedidoViewHolder.itemView.getContext(), TelaCoordenadorAnalisa.class);
                //COLOCAR PARAMETROS PARA PASAR DA TELA AQUI TIPO .putExtra
                coordenadorPedidoViewHolder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }

}

