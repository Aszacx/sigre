/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entidades.Departamento;
import entidades.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.departamentoModel;
import models.usuarioModel;

/**
 *
 * @author Lenovo
 */
public class opUsuarios extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");
        String mensaje = "";
        boolean estatus = false;
        usuarioModel cp = new usuarioModel();
        departamentoModel cb = new departamentoModel();

        switch (accion) {
            case "agregar_jd":
                    estatus = cp.agregarUsuario(new Usuario(Integer.parseInt(request.getParameter("tipo")),
                            request.getParameter("nombre"),
                            request.getParameter("apellidoP"),
                            request.getParameter("apellidoM"),
                            request.getParameter("cel"),
                            request.getParameter("email"),
                            request.getParameter("pass"),
                            Integer.parseInt(request.getParameter("departamento"))));

                if (estatus) {
                    System.out.println(estatus);
                } else {
                    System.out.println(estatus);
                }
                response.sendRedirect(request.getContextPath() + "/usuarios");
            break;
            case "agregar_profesor":
                estatus = cp.agregarUsuario(new Usuario(Integer.parseInt(request.getParameter("tipo")),
                        request.getParameter("nombre"),
                        request.getParameter("apellidoP"),
                        request.getParameter("apellidoM"),
                        request.getParameter("cel"),
                        request.getParameter("email"),
                        request.getParameterValues("materias")));

                if (estatus) {
                    System.out.println(estatus);
                } else {
                    System.out.println(estatus);
                }
                response.sendRedirect(request.getContextPath() + "/usuarios");
            break;
            case "cita":
                estatus = cp.agregarCita(new Usuario(Integer.parseInt(request.getParameter("tipo")),
                        request.getParameter("nombre"),
                        request.getParameter("apellidoP"),
                        request.getParameter("apellidoM"),
                        request.getParameter("cel"),
                        request.getParameter("email"),
                        request.getParameter("boleta"),
                        Integer.parseInt(request.getParameter("materia")),
                        request.getParameter("motivos"))
                );
                if (estatus) {
                    System.out.println(estatus);
                } else {
                    System.out.println(estatus);
                }
                response.sendRedirect(request.getContextPath());
                break;
            case "eliminar": {
                Integer id = Integer.parseInt(request.getParameter("id"));
                estatus = cp.eliminarUsuario(id);
                response.sendRedirect(request.getContextPath() + "/usuarios");
                if (estatus == true) {
                    mensaje = "Usuario eliminado correctamente.";
                } else {
                    mensaje = "Error al eliminar Usuario.";
                }
                request.setAttribute("mensaje", mensaje);
                break;
            }
            case "edicion": {
                Integer id = Integer.parseInt(request.getParameter("id"));
                Usuario usuario = cp.getUsuarioById(id);
                ArrayList<Departamento> departamentos = cb.obtenerDepartamentos();
                request.setAttribute("usuario", usuario);
                request.setAttribute("departamentos", departamentos);
                request.getRequestDispatcher("backend/sa/editarProfesor.jsp").forward(request, response);
                break;
            }
            case "editar":
                estatus = cp.editarUsuario(new Usuario(Integer.parseInt(request.getParameter("idUsuario")),
                        Integer.parseInt(request.getParameter("tipo")),
                        request.getParameter("nombre"),
                        request.getParameter("apellidoP"),
                        request.getParameter("apellidoM"),
                        request.getParameter("cel"),
                        request.getParameter("email"),
                        request.getParameter("pass"),
                        Integer.parseInt(request.getParameter("departamento"))));
                if (estatus) {
                    System.out.println(estatus);
                } else {
                    System.out.println(estatus);
                }
                response.sendRedirect(request.getContextPath() + "/usuarios");
            break;
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
            Logger.getLogger(opUsuarios.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(opUsuarios.class.getName()).log(Level.SEVERE, null, ex);
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
