/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.dao;

import br.com.curso.model.Pessoa;
import br.com.curso.utils.SingleConnection;
import java.sql.Connection;
import java.text.ParseException;

/**
 *
 * @author matef
 */
public class PessoaDAO {

    private Connection conexao;

    public PessoaDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }

    public int cadastrar(Object objeto) throws ParseException {
        Pessoa oPessoa = (Pessoa) objeto;
        int retorno = 0;
        if (oPessoa.getIdPessoa() == 0) {
            Pessoa objPessoa = this.carregarCpf(oPessoa.getCpfCnpj());
            if (oPessoa.getIdPessoa() == 0) {
                retorno = this.inserir(oPessoa);
            } else {
                retorno = objPessoa.getIdPessoa();
            }
        } else {
            retorno = this.alterar(oPessoa);
        }
        return retorno;
    }
}
