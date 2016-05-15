/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entidades.Departamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class departamentoModel extends conexion{
    
    public ArrayList<Departamento> obtenerDepartamentos() throws SQLException {
        ArrayList<Departamento> departamentos = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM departamento";
            pst = getConnection().prepareCall(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                departamentos.add(new Departamento(rs.getInt("idDepartamento"),
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

        return departamentos;
    }
    
    public Departamento getDepartamentoById(int id) throws SQLException {
        Departamento departamento = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM departamento WHERE idDepartamento = ?";
            pst = getConnection().prepareCall(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                departamento = new Departamento(rs.getInt("idDepartamento"),
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

        return departamento;
    }

    public boolean agregarDepartamento(Departamento departamento) {
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            String sql = "INSERT INTO departamento (departamento) VALUES (?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, departamento.getDepartamento());

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

    public boolean eliminarDepartamento(int id) {
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            String sql = "DELETE FROM departamento WHERE idDepartamento = ?";
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

    public boolean editarDepartamento(Departamento departamento) {
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            String sql = "UPDATE departamento SET departamento = ? WHERE idDepartamento = ?";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, departamento.getDepartamento());
            pst.setInt(2, departamento.getIdDepartamento());

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
