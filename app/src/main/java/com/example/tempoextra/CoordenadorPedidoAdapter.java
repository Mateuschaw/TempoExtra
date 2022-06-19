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

public class CoordenadorPedidoAdapter extends RecyclerView.Adapter<CoordenadorPedidoViewHolder> {

    String email;

    private Context context;
    private List<PedidoEntity> pedido;

    public CoordenadorPedidoAdapter(String email) {
        this.email = email;
    }

    public CoordenadorPedidoAdapter(Context context, List<PedidoEntity> pedido, String email) {
        this.context = context;
        this.pedido = pedido;
        this.email = email;
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
        CoordenadorPedidoAdapter coordenador = new CoordenadorPedidoAdapter(email);
        email = coordenador.getEmail();

        PedidoEntity pedidoEntity = pedido.get(position);
        coordenadorPedidoViewHolder.titulo.setText(pedido.get(position).getTipo());
        coordenadorPedidoViewHolder.aluno.setText(pedido.get(position).getAlunoId());
        coordenadorPedidoViewHolder.mensagem.setText(pedido.get(position).getTexto());
        //FUNÇÕES DE CLICK
        coordenadorPedidoViewHolder.titulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(coordenadorPedidoViewHolder.itemView.getContext(), TelaCoordenadorAnalisa.class)
                        .putExtra("email", email)
                        .putExtra("email_aluno", pedidoEntity.getAlunoId())
                        .putExtra("titulo", pedidoEntity.getTipo())
                        .putExtra("curso", pedidoEntity.getCurso())
                        .putExtra("nome", pedidoEntity.getAlunoNome())
                        .putExtra("mensagem", pedidoEntity.getTexto());
                //COLOCAR PARAMETROS PARA PASAR DA TELA AQUI TIPO .putExtra
                coordenadorPedidoViewHolder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return pedido.size();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

