/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.dao;

import br.com.curso.model.Pessoa;
import br.com.curso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public int inserir (Object objeto) {
      Pessoa oPessoa = (Pessoa) objeto;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer IdPessoa = null;
        String sql = "insert into pessoa (cpfcnpj,nome,datanascimento,idcidade,login,senha,foto) values (?,?,?,?,?,?,?) returning IdPessoa;" ;
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oPessoa.getCpfCnpj());
            stmt.setString(2, oPessoa.getNome());
            stmt.setDate(3, new java.sql.Date(oPessoa.getDataNascimento().getTime()));
            stmt.setInt(4, oPessoa.getCidade().getIdCidade());
            stmt.setString(5, oPessoa.getLogin());
            stmt.setString(6, oPessoa.getSenha());
            stmt.setString(7, oPessoa.getFoto());
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                IdPessoa = rs.getInt(IdPessoa);
            }
        } catch(SQLException e){
            try{
                System.out.println("Problemas ao cadastrar pessoas. Erro: "+e.getMessage());
                e.printStackTrace();
                conexao.rollback();
            } catch(SQLException ex) {
                System.out.println("Problemas ao executar o hollback"+ex.getMessage());
                ex.printStackTrace();
            }
        }
        return IdPessoa;
    }
    
    public int alterar(Object objeto){
        Pessoa oPessoa = (Pessoa) objeto;
        PreparedStatement stmt = null;
        Integer idPessoa = oPessoa.getIdPessoa();
        String sql = "";
        try{
            stmt = conexao.prepareStatement(sql);
        } catch (SQLException e){
            try{
                System.out.println("Problemas ao alterar Pessoa. Erro"+ e.getLocalizedMessage());
                e.printStackTrace();
                conexao.rollback();
            } catch(SQLException ex){
                System.out.println("Problemas ao realizar o rollback. erro:"+ ex.getMessage());
                ex.printStackTrace();
            }
        }
        return idPessoa;
    }
}
