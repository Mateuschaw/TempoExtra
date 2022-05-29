package com.example.tempoextra;

public class AlunoPedido {

    private String titulo;
    private String coordenador;
    private String mensagem;

    public AlunoPedido(String titulo, String coordenador, String mensagem) {
        this.titulo = titulo;
        this.coordenador = coordenador;
        this.mensagem = mensagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
