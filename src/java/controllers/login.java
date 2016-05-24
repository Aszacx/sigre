/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.usuarioModel;

/**
 *
 * @author Lenovo
 */
public class login extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        usuarioModel cp = new usuarioModel();
        
        HttpSession sesion = request.getSession();
        String accion = request.getParameter("accion");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        int tipo = cp.login(email, pass);
        
        if(accion.equals("entrar")){
            switch(tipo){
                case 1:
                    sesion.setAttribute("email", email);
                    sesion.setAttribute("tipo", tipo);
                    response.sendRedirect(request.getContextPath()+"/jefeDepartamento"); 
                    break;
                case 3:
                    sesion.setAttribute("email", email);
                    sesion.setAttribute("tipo", tipo);
                    response.sendRedirect(request.getContextPath()+"/subAcademica");
                    break;
                default:
                    out.println("Usuario o Contraseña Inválida");
                    response.sendRedirect(request.getContextPath());
                    break;
            }
        }
        
        else if(accion.equals("cerrar")) {
            sesion = request.getSession();
            sesion.removeAttribute("email");
            sesion.removeAttribute("tipo");
            sesion.invalidate();
            response.sendRedirect(request.getContextPath());
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
