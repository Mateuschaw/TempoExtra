package com.example.tempoextra.roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "pedido")
public class PedidoEntity {

    @PrimaryKey(autoGenerate = true)
    Integer id;

    @ColumnInfo(name = "alunoID")
    String AlunoId;

    @ColumnInfo(name = "cordenaID")
    String CordenaId;

    @ColumnInfo(name = "alunoNome")
    String AlunoNome;

    @ColumnInfo(name = "cordenaNome")
    String CordenaNome;

    @ColumnInfo(name = "alunoCurso")
    String Curso;

    @ColumnInfo(name = "texto")
    int Texto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlunoId() {
        return AlunoId;
    }

    public void setAlunoId(String alunoId) {
        AlunoId = alunoId;
    }

    public String getCordenaId() {
        return CordenaId;
    }

    public void setCordenaId(String cordenaId) {
        CordenaId = cordenaId;
    }

    public String getAlunoNome() {
        return AlunoNome;
    }

    public void setAlunoNome(String alunoNome) {
        AlunoNome = alunoNome;
    }

    public String getCordenaNome() {
        return CordenaNome;
    }

    public void setCordenaNome(String cordenaNome) {
        CordenaNome = cordenaNome;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String curso) {
        Curso = curso;
    }

    public int getTexto() {
        return Texto;
    }

    public void setTexto(int texto) {
        Texto = texto;
    }
}



