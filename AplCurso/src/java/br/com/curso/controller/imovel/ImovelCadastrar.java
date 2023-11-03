/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.curso.controller.imovel;

import br.com.curso.dao.GenericDAO;
import br.com.curso.dao.ImovelDAO;
import br.com.curso.model.Imovel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author muril
 */
@WebServlet(name = "ImovelCadastrar", urlPatterns = {"/ImovelCadastrar"})
public class ImovelCadastrar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=iso-8859-1");
            int idImovel = Integer.parseInt(request.getParameter("idimovel"));
            double valorAluguel = Double.parseDouble(request.getParameter("valorAluguel")) ;
            String descricao = request.getParameter("descricao");
            String endereco = request.getParameter("endereco");
            String mensagem = null;
            
            Imovel oImovel = new Imovel();
            oImovel.setIdImovel(idImovel);
            oImovel.setDescricao(descricao);
            oImovel.setEndereco(endereco);
            oImovel.setValorAluguel(valorAluguel);
            
            try{
                GenericDAO dao = new ImovelDAO();
                if(dao.cadastrar(oImovel)){
                    mensagem = "Imovel cadastrado com sucesso";
                }else{
                    mensagem = "Problemas ao cadastrar Imovel. Verifique os dados informados e tente novamente";
                }
                request.setAttribute("mensagem", mensagem);
                response.sendRedirect("ImovelListar");
        }catch (Exception ex) {
                System.out.println("Problemas no servlet ao cadastrar Imovel! Erro: " + ex.getMessage());     
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
