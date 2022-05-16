package com.example.tempoextra.roomdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


@Dao
public interface UserDao {

    @Insert
    void registerUser(UserEntity userEntity);

    @Query("SELECT * from pessoal where userID=(:userID) and senha=(:senha)")
    UserEntity login(String userID, String senha);

}
