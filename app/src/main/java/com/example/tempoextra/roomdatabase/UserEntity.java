package com.example.tempoextra.roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "pessoal")
public class UserEntity {

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int Id;

    @ColumnInfo(name = "email")
    private String Email;

    @ColumnInfo(name = "senha")
    private String Senha;

    @ColumnInfo(name = "nome")
    private String Nome;

    @ColumnInfo(name = "horas")
    private int Horas;

    @ColumnInfo(name = "curso")
    private String Curso;

    @ColumnInfo(name = "professor")
    private int Professor;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
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

    public int getProfessor() {
        return Professor;
    }

    public void setProfessor(int professor) {
        Professor = professor;
    }
}



