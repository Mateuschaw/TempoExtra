package com.example.tempoextra.roomdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface UserDao {

    @Insert
    void registerUser(UserEntity userEntity);

    @Query("SELECT * from Aluno where userID=(:userID) and senha=(:senha)")
    UserEntity login(String userID, String senha);

    @Query("SELECT * from Aluno where userID=(:userID)")
    UserEntity loginEmail(String userID);

    @Query("SELECT COUNT() FROM Aluno WHERE userID=(:userID)")
    int isExistsEmail(String userID);

    //temporariamente o codigo de tirar os alunos que pediram hora
    @Query("SELECT * from Aluno where userID=(:userID)")
    List<UserEntity> getRequest(String userID);

}
