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

    @ColumnInfo(name = "alunoCurso")
    String Curso;

    @ColumnInfo(name = "horas")
    int Horas;

    @ColumnInfo(name = "tipo")
    String Tipo;

    @ColumnInfo(name = "texto")
    String Texto;

    @ColumnInfo(name = "status")
    String Status;

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

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String curso) {
        Curso = curso;
    }

    public int getHoras() {
        return Horas;
    }

    public void setHoras(int horas) {
        Horas = horas;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String texto) {
        Texto = texto;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}



