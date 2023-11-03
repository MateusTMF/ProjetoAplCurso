
package br.com.curso.model;

public class Modelo {
    private int idModelo;
    private String descricao;

    public Modelo() {
        this.idModelo = 0;
        this.descricao = "";
    }

    public Modelo(int idModelo, String descricao) {
        this.idModelo = idModelo;
        this.descricao = descricao;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    
}
