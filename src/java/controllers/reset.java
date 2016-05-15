/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entidades.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.usuarioModel;

/**
 *
 * @author Lenovo
 */
public class reset extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws javax.mail.MessagingException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, MessagingException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion = request.getParameter("accion");
        usuarioModel cp = new usuarioModel();
        email em = new email();
        
        if(accion.equals("recuperar")){
            try {
                String email = request.getParameter("email");
                Usuario usuario = cp.getUsuarioByEmail(email);
                String cuerpo = "<h4>Has restablecido tu contraseña de acceso al sistema SIGRE.</h4>";
                cuerpo += "<p>Estimado "+usuario.getNombre()+" "+usuario.getApellidoP()+":</p>";
                cuerpo += "<p>Hemos restablecido tu contraseña perteneciente al usuario: <b>"+usuario.getEmail()+"</b></p>";
                cuerpo += "<p>Tu nueva contraseña es: <b>"+usuario.getPass()+"</b></p>";
                cuerpo += "<p>Un cordial saludo.</p>";
                cuerpo += "<p>Atentamente <b>SIGRE</b></p>";            
                em.enviar(usuario.getEmail(), "Restablecer contraseña.", cuerpo);
                response.sendRedirect(request.getContextPath()+"/recuperar_contrasena");
            } catch (SQLException | MessagingException | IOException e) {
                System.out.println(e);
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
        } catch (SQLException | MessagingException ex) {
            Logger.getLogger(reset.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException | MessagingException ex) {
            Logger.getLogger(reset.class.getName()).log(Level.SEVERE, null, ex);
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
