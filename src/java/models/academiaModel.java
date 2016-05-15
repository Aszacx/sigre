/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entidades.Academia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class academiaModel extends conexion{
    
    public ArrayList<Academia> obtenerAcademias() throws SQLException {
        ArrayList<Academia> academias = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT a.idAcademia, a.academia, d.departamento FROM academia AS a LEFT JOIN departamento AS d ON a.Departamento_idDepartamento = d.idDepartamento";
            pst = getConnection().prepareCall(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                academias.add(new Academia(rs.getInt("idAcademia"),
                        rs.getString("academia"),
                        rs.getString("departamento")));
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
        return academias;
    }
    
    public Academia getAcademiaById(int id) throws SQLException {
        Academia academia = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM academia AS a LEFT JOIN departamento AS d "
                    + "ON a.Departamento_idDepartamento = d.idDepartamento WHERE idAcademia = ?";
            pst = getConnection().prepareCall(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                academia = new Academia(rs.getInt("idAcademia"),
                                        rs.getString("academia"),
                                        rs.getInt("Departamento_idDepartamento"),
                                        rs.getString("departamento"));
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

        return academia;
    }

    public boolean agregarAcademia(Academia academia) {
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            String sql = "INSERT INTO academia (academia, Departamento_idDepartamento) VALUES (?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, academia.getAcademia());
            pst.setInt(2, academia.getDepartamento_idDepartamento());

            if (pst.executeUpdate() == 1) {
                flag = true;
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
        return flag;
    }

    public boolean eliminarAcademia(int id) {
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            String sql = "DELETE FROM academia WHERE idAcademia = ?";
            pst = getConnection().prepareStatement(sql);
            pst.setInt(1, id);

            if (pst.executeUpdate() == 1) {
                flag = true;
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
        return flag;
    }

    public boolean editarAcademia(Academia academia) {
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            String sql = "UPDATE academia SET academia = ?, Departamento_idDepartamento = ? WHERE idAcademia = ?";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, academia.getAcademia());
            pst.setInt(2, academia.getDepartamento_idDepartamento());
            pst.setInt(3, academia.getIdAcademia());

            if (pst.executeUpdate() == 1) {
                flag = true;
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
        return flag;
    }
}
