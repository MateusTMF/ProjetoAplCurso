/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.model;

import java.util.Date;

/**
 *
 * @author matef
 */
public class Cliente extends Pessoa {

    private int idcliente;
    private String observacao;
    private String situacao;
    private String permitelogin;

    public Cliente(int idcliente, String observacao, String situacao, String permitelogin, int idPessoa, String nome, String cpfCnpj, Date dataNascimento, int idcidade, String login, String senha, String foto) {
        super(idPessoa, nome, cpfCnpj, dataNascimento, idcidade, login, senha, foto);
        this.idcliente = idcliente;
        this.observacao = observacao;
        this.situacao = situacao;
        this.permitelogin = permitelogin;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getPermitelogin() {
        return permitelogin;
    }

    public void setPermitelogin(String permitelogin) {
        this.permitelogin = permitelogin;
    }

}
