package com.example.tempoextra.roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "coordena")
public class CoordenaEntity {

    @PrimaryKey(autoGenerate = true)
    Integer id;

    @ColumnInfo(name = "coordenaID")
    String CoordenaId;

    @ColumnInfo(name = "senha")
    String Senha;

    @ColumnInfo(name = "nome")
    String Nome;

    @ColumnInfo(name = "curso")
    String Curso;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoordenaId() {
        return CoordenaId;
    }

    public void setCoordenaId(String coordenaId) {
        CoordenaId = coordenaId;
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

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String curso) {
        Curso = curso;
    }
}



