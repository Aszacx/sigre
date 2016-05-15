/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controllers.email;
import entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class usuarioModel extends conexion {
    
    public ArrayList<Usuario> obtenerUsuarios() throws SQLException{
        ArrayList<Usuario> usuarios = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM usuario AS u LEFT JOIN profesor AS p ON p.Usuario_idUsuario = u.idUsuario";
            pst = getConnection().prepareCall(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                usuarios.add(new Usuario(rs.getInt("idUsuario"), 
                                         rs.getInt("tipo"), 
                                         rs.getString("nombre"), 
                                         rs.getString("apellidoP"),
                                         rs.getString("apellidoM"), 
                                         rs.getString("cel"), 
                                         rs.getString("email"),
                                         rs.getString("pass")));
            }
        } catch (Exception e) {
        } finally {
            try {
                if(getConnection() != null) getConnection().close();
                if(pst != null) getConnection().close();
            } catch (Exception e) {
            }
        }  
        return usuarios;
    }
    
    public Usuario getUsuarioById(int id) throws SQLException {
        Usuario usuario = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM usuario AS u LEFT JOIN profesor AS p ON p.Usuario_idUsuario = u.idUsuario WHERE idUsuario = ?";
            pst = getConnection().prepareCall(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                usuario = new Usuario(rs.getInt("idUsuario"), 
                                      rs.getInt("tipo"), 
                                      rs.getString("nombre"), 
                                      rs.getString("apellidoP"),
                                      rs.getString("apellidoM"), 
                                      rs.getString("cel"), 
                                      rs.getString("email"),
                                      rs.getString("pass"));
            }
        } catch (Exception e) {
        } finally {
            try {
                if (getConnection() != null) {
                    getConnection().close();
                }
                if (pst != null) {
                    getConnection().close();
                }
            } catch (Exception e) {
            }
        }

        return usuario;
    }
    
    public Usuario getUsuarioByEmail(String email) throws SQLException {
        email e = new email();
        String pass = e.generarPassword(10);
        Usuario usuario = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "UPDATE usuario AS u LEFT JOIN profesor AS p ON p.Usuario_idUsuario = u.idUsuario "
                    + "SET p.pass = ? WHERE u.email = ?";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, pass);
            pst.setString(2, email);

            if (pst.executeUpdate() == 1) {
                String sql2 = "SELECT * FROM usuario AS u LEFT JOIN profesor AS p ON p.Usuario_idUsuario = u.idUsuario WHERE email = ?";
                pst = getConnection().prepareCall(sql2);
                pst.setString(1, email);
                rs = pst.executeQuery();

                while (rs.next()) {
                    usuario = new Usuario(rs.getInt("idUsuario"), 
                                          rs.getInt("tipo"), 
                                          rs.getString("nombre"), 
                                          rs.getString("apellidoP"),
                                          rs.getString("apellidoM"), 
                                          rs.getString("cel"), 
                                          rs.getString("email"),
                                          rs.getString("pass"));
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                if (getConnection() != null) {
                    getConnection().close();
                }
                if (pst != null) {
                    getConnection().close();
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        return usuario;
    }
    
    public boolean agregarUsuario(Usuario user) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean flag = false;
        int id = 0;
        try {            
            String sql = "INSERT INTO usuario (tipo,nombre,apellidoP,apellidoM,cel,email) VALUES (?,?,?,?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setInt(1, user.getTipo());
            pst.setString(2, user.getNombre());
            pst.setString(3, user.getApellidoP());
            pst.setString(4, user.getApellidoM());
            pst.setString(5, user.getCel());
            pst.setString(6, user.getEmail());
            
            if(pst.executeUpdate() == 1){
                flag = true;
                
                String key = "SELECT LAST_INSERT_ID()";
                pst = getConnection().prepareCall(key);
                rs = pst.executeQuery();
                if(rs.next()){
                    id = Integer.parseInt(rs.getString(1));
                }
                
                String sql2 = "INSERT INTO profesor (pass, Usuario_idUsuario) VALUES (?,?)";
                pst = getConnection().prepareStatement(sql2);
                pst.setString(1, user.getPass());
                pst.setInt(2, id);
                
                if(pst.executeUpdate() == 1){
                    flag = true;
                }
            }
        } catch (Exception e) {
        }finally {
            try {
                if(getConnection() != null) getConnection().close();
                if(pst != null) getConnection().close();
            } catch (Exception e) {
            }
        }
        return flag;
    }
    
    public boolean eliminarUsuario(int id) {
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            String sql = "DELETE FROM profesor WHERE Usuario_idUsuario = ?";
            pst = getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            
            if(pst.executeUpdate() == 1){
                String sql2 = "DELETE FROM usuario WHERE idUsuario = ?";
                pst = getConnection().prepareStatement(sql2);
                pst.setInt(1, id);
                
                if(pst.executeUpdate() == 1){
                    flag = true;
                }
            }
        } catch (Exception e) {
        }finally {
            try {
                if(getConnection() != null) getConnection().close();
                if(pst != null) getConnection().close();
            } catch (Exception e) {
            }
        }
        return flag;
    }
    
    public boolean editarUsuario(Usuario user) {
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            String sql = "UPDATE usuario AS u LEFT JOIN profesor AS p ON p.Usuario_idUsuario = u.idUsuario "
                    + "SET u.tipo = ?, u.nombre = ?, u.apellidoP = ?, u.apellidoM = ?, u.cel = ?, u.email = ?, p.pass = ? "
                    + "WHERE u.idUsuario = ?";
            pst = getConnection().prepareStatement(sql);
            pst.setInt(1, user.getTipo());
            pst.setString(2, user.getNombre());
            pst.setString(3, user.getApellidoP());
            pst.setString(4, user.getApellidoM());
            pst.setString(5, user.getCel());
            pst.setString(6, user.getEmail());
            pst.setString(7, user.getPass());
            pst.setInt(8, user.getIdUsuario());

            if (pst.executeUpdate() == 1) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (getConnection() != null) {
                    getConnection().close();
                }
                if (pst != null) {
                    getConnection().close();
                }
            } catch (Exception e) {
            }
        }
        return flag;
    }
    
    public int login(String email, String pass) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        int tipo = 0;
        try {
            String sql = "SELECT u.tipo FROM usuario AS u LEFT JOIN profesor AS p ON p.Usuario_idUsuario = u.idUsuario "
                    + "WHERE u.email = ? AND p.pass = ?";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, pass);
            rs = pst.executeQuery();
            
            if(rs.next()){
                tipo = Integer.parseInt(rs.getString("tipo"));
                return tipo;
            }
        } catch (SQLException | NumberFormatException e) {
        } finally {
            try {
                if(getConnection() != null) getConnection().close();
                if(pst != null) getConnection().close();
                if(rs != null) rs.close();
            } catch (Exception e) {
            }
        }
            
        return tipo;
    }
    
//    public boolean agregarCita(Usuario user) {
//        PreparedStatement pst = null;
//        ResultSet rs = null;
//        boolean flag = false;
//        int id = 0;
//        try {            
//            String sql = "INSERT INTO usuario (tipo,nombre,apellidoP,apellidoM,cel,email) VALUES (?,?,?,?,?,?)";
//            pst = getConnection().prepareStatement(sql);
//            pst.setInt(1, user.getTipo());
//            pst.setString(2, user.getNombre());
//            pst.setString(3, user.getApellidoP());
//            pst.setString(4, user.getApellidoM());
//            pst.setString(5, user.getCel());
//            pst.setString(6, user.getEmail());
//            
//            if(pst.executeUpdate() == 1){
//                flag = true;
//                
//                String key = "SELECT LAST_INSERT_ID()";
//                pst = getConnection().prepareCall(key);
//                rs = pst.executeQuery();
//                if(rs.next()){
//                    id = Integer.parseInt(rs.getString(1));
//                }
//                
//                String sql2 = "INSERT INTO alumno (boleta, Usuario_idUsuario) VALUES (?,?)";
//                pst = getConnection().prepareStatement(sql2);
//                pst.setString(1, user.getPass());
//                pst.setInt(2, id);
//                
//                if(pst.executeUpdate() == 1){
//                    flag = true;
//                }
//            }
//        } catch (Exception e) {
//        }finally {
//            try {
//                if(getConnection() != null) getConnection().close();
//                if(pst != null) getConnection().close();
//            } catch (Exception e) {
//            }
//        }
//        return flag;
//    }
}
