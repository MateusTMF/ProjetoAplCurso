
package br.com.curso.model;

public class Imovel {
    
    private int idImovel;
    private String descricao;
    private String endereco;
    private double valorAluguel;

    public Imovel() {
        this.idImovel = 0;
        this.descricao = "";
        this.endereco = "";
        this.valorAluguel = 0;
    }

    public Imovel(int idImovel, String descricao, String endereco, double valorAluguel) {
        this.idImovel = idImovel;
        this.descricao = descricao;
        this.endereco = endereco;
        this.valorAluguel = valorAluguel;
    }

    public int getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }
      
}
