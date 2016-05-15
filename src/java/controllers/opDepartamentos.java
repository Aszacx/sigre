/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entidades.Departamento;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.departamentoModel;

/**
 *
 * @author Lenovo
 */
public class opDepartamentos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        String msj;
        boolean estatus = false;
        String accion = request.getParameter("accion");
        departamentoModel cp = new departamentoModel();
        
        switch (accion) {
            case "agregar":
                cp.agregarDepartamento(new Departamento(request.getParameter("departamento")));
                response.sendRedirect(request.getContextPath()+"/departamentos");
                break;
            case "eliminar":{
                    Integer id = Integer.parseInt(request.getParameter("id"));
                    cp.eliminarDepartamento(id);
                    if(estatus == true){
                        msj = "Departamento eliminado correctamente.";
                    } else {
                        msj = "Error al eliminar departamento.";
                    }
                    request.setAttribute("msj", msj);
                    response.sendRedirect(request.getContextPath()+"/departamentos");
                    break;
                }
            case "edicion":{
                Integer id = Integer.valueOf(request.getParameter("id"));    
                Departamento departamento = cp.getDepartamentoById(id);
                request.setAttribute("departamento", departamento);
                request.getRequestDispatcher("backend/sa/editarDepartamento.jsp").forward(request, response);
                break;
            }
            case "editar":{
                cp.editarDepartamento(new Departamento(Integer.parseInt(request.getParameter("idDepartamento")),
                                                       request.getParameter("departamento")));
                response.sendRedirect(request.getContextPath()+"/departamentos");
                break;
            }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(opDepartamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(opDepartamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
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
