
package br.com.curso.dao;

import br.com.curso.model.Marca;
import br.com.curso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MarcaDAO implements GenericDAO {
    
    private Connection conexao;
    
    public MarcaDAO() throws Exception{
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
       Marca oMarca = (Marca) objeto;
       Boolean retorno = false;
       if(oMarca.getIdMarca()==0){
           retorno = this.inserir(oMarca);
       }else{
           retorno = this.alterar(oMarca);
       }
       return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Marca oMarca = (Marca) objeto;
        PreparedStatement stmt = null;
        String sql = "Insert into marca (descricao) values (?)";
        
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oMarca.getDescricao());
            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception ex){
            try{
                System.out.println("Probleamas ao cadastrar Marca! Erro: " +  ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            }catch(Exception e){
                System.out.println("Erro: " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean alterar(Object objeto) {
       Marca oMarca = (Marca) objeto;
       PreparedStatement stmt = null;
       String sql = "update marca set descricao = ? where idmarca = ?";
       
       try{
           stmt = conexao.prepareStatement(sql);
           stmt.setString(1, oMarca.getDescricao());
           stmt.setInt(2, oMarca.getIdMarca());
           stmt.execute();
           conexao.commit();
           return true;
       }catch(Exception ex){
           try{
               System.out.println("Problemas ao alterar Marca! Erro: " + ex.getMessage());
               ex.printStackTrace();
               conexao.rollback();
           }catch(Exception e){
               System.out.println("Erro: "  + e.getMessage());
               e.printStackTrace();
           }
           return false;
       }
    }

    @Override
    public Boolean excluir(int numero) {
       int idMarca = numero;
       PreparedStatement stmt = null;
       String sql = "delete from marca where idmarca = ?";
       
       try{
           stmt = conexao.prepareStatement(sql);
           stmt.setInt(1, idMarca);
           stmt.execute();
           conexao.commit();
           return true;
       }catch(Exception ex){
           System.out.println("Problemas ao excluir Marca! Erro: " + ex.getMessage());
           try{
               conexao.rollback();
           }catch(Exception e){
               System.out.println("Erro rollback: " + e.getMessage());
               e.printStackTrace();
           }
           return false;
       }
    }

    @Override
    public Object carregar(int numero) {
       int idMarca = numero;
       PreparedStatement stmt = null;
       ResultSet rs = null;
       Marca oMarca = null;
       String sql = "Select * from marca where idmarca = ?";
       
       try{
           stmt = conexao.prepareStatement(sql);
           stmt.setInt(1, idMarca);
           rs = stmt.executeQuery();
           while(rs.next()){
               oMarca = new Marca();
               oMarca.setIdMarca(rs.getInt("idmarca"));
               oMarca.setDescricao(rs.getString("descricao"));
           }
           return oMarca;
       }catch(Exception ex){
           System.out.println("Problemas ao carregar Marca! Erro: " + ex.getMessage());
           return false;
       }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "Select  * from marca order by idmarca";
        
        try{
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Marca oMarca = new Marca();
                oMarca.setIdMarca(rs.getInt("idmarca"));
                oMarca.setDescricao(rs.getString("descricao"));
                resultado.add(oMarca);
            }
        }catch(Exception ex){
            System.out.println("Problemas ao listar Marca! Erro: " + ex.getMessage());
            
        }
        return resultado;
    }
    
}
