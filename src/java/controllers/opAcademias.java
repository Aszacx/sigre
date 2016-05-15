/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entidades.Academia;
import entidades.Departamento;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.academiaModel;
import models.departamentoModel;

/**
 *
 * @author Lenovo
 */
public class opAcademias extends HttpServlet {

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
        
        String accion = request.getParameter("accion");
        academiaModel cp = new academiaModel();
        departamentoModel cb = new departamentoModel();
        
        switch (accion) {
            case "agregar":
                boolean estatus = cp.agregarAcademia(new Academia(request.getParameter("academia"),
                                               Integer.parseInt(request.getParameter("departamento"))
                                               )
                );
                if(estatus){
                    System.out.println("Registro Completo");
                }
                else {
                    System.out.println("Registro Incompleto");
                }
                response.sendRedirect(request.getContextPath()+"/academias");
                break;
            case "eliminar":{
                    Integer id = Integer.valueOf(request.getParameter("id"));
                    cp.eliminarAcademia(id);
                    response.sendRedirect(request.getContextPath()+"/academias");
                    break;
                }
            case "edicion":{
                Integer id = Integer.valueOf(request.getParameter("id"));    
                Academia academia = cp.getAcademiaById(id);
                ArrayList<Departamento> departamentos = cb.obtenerDepartamentos();
                request.setAttribute("academia", academia);
                request.setAttribute("departamentos", departamentos);
                request.getRequestDispatcher("backend/sa/editarAcademia.jsp").forward(request, response);
                break;
            }
            case "editar":{
                cp.editarAcademia(new Academia(Integer.parseInt(request.getParameter("idAcademia")),
                                               request.getParameter("academia"),
                                               Integer.parseInt(request.getParameter("departamento"))));
                response.sendRedirect(request.getContextPath()+"/academias");
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
            Logger.getLogger(opAcademias.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(opAcademias.class.getName()).log(Level.SEVERE, null, ex);
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
