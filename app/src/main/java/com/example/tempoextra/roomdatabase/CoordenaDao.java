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

//    @Query("SELECT EXISTS(SELECT * from coordena where coordenaID=(:coordenaID))")
//    boolean isExistsEmail(String coordenaID);

    @Query("SELECT COUNT() FROM coordena WHERE coordenaID=(:userID)")
    int isExistsEmail(String userID);

//    @Query("SELECT COUNT() FROM coordena WHERE coordenaID=(:coordenaID)")
//    int isExistsEmail(String coordenaID);



}
