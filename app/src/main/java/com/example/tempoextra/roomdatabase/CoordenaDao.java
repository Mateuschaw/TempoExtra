package com.example.tempoextra.roomdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface CoordenaDao {

    @Insert
    void registerCoordena(CoordenaEntity coordenaEntity);

    @Query("SELECT * from coordena where coordenaID=(:coordenaID) and senha=(:senha)")
    CoordenaEntity login(String coordenaID, String senha);

    //checa pra ver se ja existe o email no banco de dados
    @Query("SELECT * from coordena where coordenaID=(:coordenaID)")
    CoordenaEntity checkemail(String coordenaID);

    //temporariamente o codigo de tirar os alunos que pediram hora
    @Query("SELECT * from coordena where coordenaID=(:coordenaID)")
    List<CoordenaEntity> getRequest(String coordenaID);

}
