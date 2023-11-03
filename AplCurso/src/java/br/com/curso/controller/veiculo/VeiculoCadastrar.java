/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.curso.controller.veiculo;


import br.com.curso.dao.GenericDAO;
import br.com.curso.dao.VeiculoDAO;
import br.com.curso.model.Marca;
import br.com.curso.model.Modelo;
import br.com.curso.model.Veiculo;
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
@WebServlet(name = "VeiculoCadastrar", urlPatterns = {"/VeiculoCadastrar"})
public class VeiculoCadastrar extends HttpServlet {

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
            int idVeiculo = Integer.parseInt(request.getParameter("idveiculo"));
            int idMarca = Integer.parseInt(request.getParameter("idmarca"));
            int idModelo = Integer.parseInt(request.getParameter("idmodelo"));
            String mensagem = null;

            try{
                Veiculo oVeiculo = new Veiculo();
                oVeiculo.setIdVeiculo(idVeiculo);
                oVeiculo.setMarca(new Marca(idMarca, ""));
                oVeiculo.setModelo(new Modelo(idModelo, ""));
                
                GenericDAO dao = new VeiculoDAO();
                if (dao.cadastrar(oVeiculo)){
                    mensagem = "Veiculo cadastrado com sucesso!";
                } else{
                    mensagem = "Problemas ao cadastrar Veiculo. Verifique os dados informados e tente novamente";
                }
                request.setAttribute("mensagem", mensagem);
                response.sendRedirect("VeiculoListar");
            } catch (Exception ex) {
                System.out.println("Problemas no servlet ao cadastrar Veiculo! Erro: " + ex.getMessage());
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
