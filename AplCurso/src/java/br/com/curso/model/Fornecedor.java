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
public class Fornecedor extends Pessoa {

    private int idfornecedor;
    private String enderecoweb;
    private String situacao;
    private String permitelogin;

    public Fornecedor(int idfornecedor, String enderecoweb, String situacao, String permitelogin, int idPessoa, String nome, String cpfCnpj, Date dataNascimento, int idcidade, String login, String senha, String foto) {
        super(idPessoa, nome, cpfCnpj, dataNascimento, idcidade, login, senha, foto);
        this.idfornecedor = idfornecedor;
        this.enderecoweb = enderecoweb;
        this.situacao = situacao;
        this.permitelogin = permitelogin;
    }

    public int getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(int idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    public String getEnderecoweb() {
        return enderecoweb;
    }

    public void setEnderecoweb(String enderecoweb) {
        this.enderecoweb = enderecoweb;
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
