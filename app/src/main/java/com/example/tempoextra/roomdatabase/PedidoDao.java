package com.example.tempoextra.roomdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface PedidoDao {

    @Insert
    void registerPedido(PedidoEntity pedidoEntity);

//    @Query("SELECT * from pessoal where userID=(:userID) and senha=(:senha)")
//    PedidoEntity login(String userID, String senha);
//
//    //temporariamente o codigo de tirar os alunos que pediram hora
//    @Query("SELECT * from pessoal where userID=(:userID)")
//    List<PedidoEntity> getRequest(String userID);

}
