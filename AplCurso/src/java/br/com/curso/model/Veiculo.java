
package br.com.curso.model;

public class Veiculo {
       private int idVeiculo;
       private Marca marca;
       private Modelo modelo;

    public Veiculo() {
        this.idVeiculo = 0;
        this.marca = new Marca();
        this.modelo = new Modelo();
    }

    public Veiculo(int idVeiculo, Marca marca, Modelo modelo) {
        this.idVeiculo = idVeiculo;
        this.marca = marca;
        this.modelo = modelo;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    
    
       
       
       
}
