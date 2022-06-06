package com.example.tempoextra.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface PedidoDao {

    @Insert
    void registerPedido(PedidoEntity pedidoEntity);

    @Query("SElECT * FROM pedido where alunoID=(:alunoId)")
    List<PedidoEntity> getAllPedidosAluno(String alunoId);

    @Query("SElECT * FROM pedido where cordenaID=(:coordenaId)")
    List<PedidoEntity> getAllPedidosCoordena(String coordenaId);

    @Delete
    void delete(PedidoEntity pedidoEntity);

}
