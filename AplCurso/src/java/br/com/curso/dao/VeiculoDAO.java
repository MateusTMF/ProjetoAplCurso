
package br.com.curso.dao;

import br.com.curso.model.Marca;
import br.com.curso.model.Modelo;
import br.com.curso.model.Veiculo;
import br.com.curso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO implements GenericDAO{
    
    private Connection conexao;
    
    public VeiculoDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
       Veiculo oVeiculo = (Veiculo) objeto;
        Boolean retorno = false;
        if(oVeiculo.getIdVeiculo()== 0){
            retorno = this.inserir(oVeiculo);
        }else{
            retorno = this.alterar(oVeiculo);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Veiculo oVeiculo = (Veiculo) objeto;
        PreparedStatement stmt = null;
        String sql = "Insert into veiculo (idmarca, idmodelo) values (?,?)";
        try{
           stmt = conexao.prepareStatement(sql);
           stmt.setInt(1, oVeiculo.getMarca().getIdMarca());
           stmt.setInt(2, oVeiculo.getModelo().getIdModelo());
           stmt.execute();
           conexao.commit();
           return true;
        }catch (Exception ex){
            try{
                System.out.println("Problemas ao cadastrar a Veiculo! Erro: " + ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            }catch (SQLException e){
                System.out.println("Erro:" + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean alterar(Object objeto) {
        Veiculo oVeiculo = (Veiculo) objeto;
        PreparedStatement stmt = null;
        String sql = "update veiculo set idmarca = ?, idmodelo = ? where idveiculo = ?";
        
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, oVeiculo.getMarca().getIdMarca());
            stmt.setInt(2, oVeiculo.getModelo().getIdModelo());
            stmt.setInt(3, oVeiculo.getIdVeiculo());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try{
                System.out.println("Problemas ao alterar o Veiculo! Erro: " + ex.getMessage());
                ex.getStackTrace();
                conexao.rollback();
            } catch (SQLException e){
                System.out.println("Erro: " + e.getMessage());
                e.printStackTrace();
        }
      return false;
    }
    }

    @Override
    public Boolean excluir(int numero) {
        int idVeiculo = numero;
        PreparedStatement stmt = null;
        String sql = "delete from veiculo where idveiculo = ?";
        
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idVeiculo);
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex){
            System.out.println("Problemas ao excluir a Veiculo! Erro: " + ex.getMessage());
            try{
                conexao.rollback();
            } catch (SQLException e){
                System.out.println("Erro rollback " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Object carregar(int numero) {
        int idVeiculo = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Veiculo oVeiculo = null;
        String sql ="select * from veiculo where idveiculo = ?";
        
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idVeiculo);
            rs = stmt.executeQuery();
            while (rs.next()){
                oVeiculo = new Veiculo();
                oVeiculo.setIdVeiculo(rs.getInt("idveiculo"));
               
                MarcaDAO oMarcaDAO = new MarcaDAO();
                oVeiculo.setMarca((Marca) oMarcaDAO.carregar(rs.getInt("idmarca")));
                
                ModeloDAO oModeloDAO = new ModeloDAO();
                oVeiculo.setModelo((Modelo) oModeloDAO.carregar(rs.getInt("idmodelo")));
            }
            return oVeiculo;
        } catch(Exception ex) {
            System.out.println("Problemas ao carregar Veiculo! Erro: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Object> listar() {
         List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "Select *  from veiculo order by idVeiculo";
        try {
            stmt = conexao.prepareStatement(sql);
            rs=stmt.executeQuery();
            while (rs.next()) {
                Veiculo oVeiculo = new Veiculo();
                oVeiculo.setIdVeiculo(rs.getInt("idVeiculo"));
                
               MarcaDAO oMarcaDAO = null;
               try{
                   oMarcaDAO = new MarcaDAO();
               }catch(Exception ex){
                   System.out.println("Erro ao buscar Marca " + ex.getMessage());
                   ex.printStackTrace();
               }
                oVeiculo.setMarca((Marca) oMarcaDAO.carregar(rs.getInt("idmarca")));
                
                ModeloDAO oModeloDAO = null;
                try{
                    oModeloDAO = new ModeloDAO();
                }catch(Exception ex){
                    System.out.println("Erro ao buscar Modelo " + ex.getMessage());
                    ex.printStackTrace();
                }
                oVeiculo.setModelo((Modelo) oModeloDAO.carregar(rs.getInt("idmodelo")));
                resultado.add(oVeiculo);
            } 
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Veiculo! Erro:" + ex.getMessage());
        }
        return resultado;
    }
    
}
