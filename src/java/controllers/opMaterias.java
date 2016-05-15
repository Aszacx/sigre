/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entidades.Academia;
import entidades.Materia;
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
import models.materiaModel;

/**
 *
 * @author Lenovo
 */
public class opMaterias extends HttpServlet {

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
        materiaModel cp = new materiaModel();
        academiaModel cb =new academiaModel();
        
        switch (accion) {
            case "agregar":
                cp.agregarMateria(new Materia(request.getParameter("materia"),
                        Integer.parseInt(request.getParameter("nivel")),
                        Integer.parseInt(request.getParameter("academia"))
                )
                );
                response.sendRedirect(request.getContextPath()+"/materias");
                break;
            case "eliminar":{
                Integer id = Integer.valueOf(request.getParameter("id"));
                cp.eliminarMateria(id);
                response.sendRedirect(request.getContextPath() + "/materias");
                break;
                }
            case "edicion":{
                Integer id = Integer.parseInt(request.getParameter("id"));    
                Materia materia = cp.getMateriaById(id);
                ArrayList<Academia> academias = cb.obtenerAcademias();
                request.setAttribute("materia", materia);
                request.setAttribute("academias", academias);
                request.getRequestDispatcher("backend/sa/editarMateria.jsp").forward(request, response);
                break;
            }
            case "editar":{
                cp.editarMateria(new Materia(Integer.parseInt(request.getParameter("idMateria")),
                                             request.getParameter("materia"),
                                             Integer.parseInt(request.getParameter("nivel")),
                                             Integer.parseInt(request.getParameter("academia"))));
                response.sendRedirect(request.getContextPath()+"/materias");
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
            Logger.getLogger(opMaterias.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(opMaterias.class.getName()).log(Level.SEVERE, null, ex);
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
