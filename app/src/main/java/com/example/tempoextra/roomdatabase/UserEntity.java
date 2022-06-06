package com.example.tempoextra.roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;


@Entity(tableName = "Aluno")
public class UserEntity {

    @PrimaryKey(autoGenerate = true)
    Integer id;

    @ColumnInfo(name = "userID")
    String UserId;

    @ColumnInfo(name = "senha")
    String Senha;

    @ColumnInfo(name = "nome")
    String Nome;

    @ColumnInfo(name = "horas")
    int Horas;

    @ColumnInfo(name = "curso")
    String Curso;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {

        UserId = userId;

    }

    public String getSenha() {

        return Senha;

    }

    public void setSenha(String senha) {

        Senha = senha;

    }

    public String getNome() {

        return Nome;

    }

    public void setNome(String nome) {

        Nome = nome;

    }

    public int getHoras() {

        return Horas;

    }

    public void setHoras(int horas) {

        Horas = horas;

    }

    public String getCurso() {

        return Curso;

    }

    public void setCurso(String curso) {

        Curso = curso;

    }

}



