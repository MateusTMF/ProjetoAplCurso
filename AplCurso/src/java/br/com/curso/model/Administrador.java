/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.model;

import br.com.curso.utils.Conversao;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author matef
 */
public class Administrador extends Pessoa {

    private int idadministrador;
    private String situacao;
    private String permitelogin;

    public Administrador(int idadministrador, String situacao, String permitelogin, int idPessoa,
            String nome, String cpfCnpj, Date dataNascimento, int idcidade, String login,
            String senha, String foto) {
        super(idPessoa, nome, cpfCnpj, dataNascimento, idcidade, login, senha, foto);
        this.idadministrador = idadministrador;
        this.situacao = situacao;
        this.permitelogin = permitelogin;
    }

    public static Administrador administradorVazio() throws ParseException {
        Cidade oCidade = new Cidade();
        Date dataNascimento = Conversao.dataAtual();
        Administrador oAdministrador = new Administrador(0, "S", "A", 0, "", "", dataNascimento, oCidade, "", "", null);
        return oAdministrador;
    }

    public int getIdadministrador() {
        return idadministrador;
    }

    public void setIdadministrador(int idadministrador) {
        this.idadministrador = idadministrador;
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
