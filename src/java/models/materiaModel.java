/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entidades.Materia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class materiaModel extends conexion{
    
    public ArrayList<Materia> obtenerMaterias() throws SQLException {
        ArrayList<Materia> materias = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT m.idMateria, m.materia, m.nivel, a.academia FROM materia AS m LEFT JOIN academia AS a ON m.Academia_idAcademia = a.idAcademia";
            pst = getConnection().prepareCall(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                materias.add(new Materia(rs.getInt("idMateria"),
                        rs.getString("materia"),
                        rs.getInt("nivel"),
                        rs.getString("academia")));
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
        return materias;
    }
    
    public Materia getMateriaById(int id) throws SQLException {
        Materia materia = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM materia AS m LEFT JOIN academia AS a "
                    + "ON m.Academia_idAcademia = a.idAcademia WHERE idMateria = ?";
            pst = getConnection().prepareCall(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                materia = new Materia(rs.getInt("idMateria"),
                                      rs.getString("materia"),
                                      rs.getInt("nivel"),
                                      rs.getInt("Academia_idAcademia"),
                                      rs.getString("academia"));
                                       
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

        return materia;
    }

    public boolean agregarMateria(Materia materia) {
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            String sql = "INSERT INTO materia (materia, nivel, Academia_idAcademia) VALUES (?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, materia.getMateria());
            pst.setInt(2, materia.getNivel());
            pst.setInt(3, materia.getAcademia_idAcademia());

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

    public boolean eliminarMateria(int id) {
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            String sql = "DELETE FROM materia WHERE idMateria = ?";
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

    public boolean editarMateria(Materia materia) {
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            String sql = "UPDATE materia SET materia = ?, nivel = ?, Academia_idAcademia = ? WHERE idMateria = ?";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, materia.getMateria());
            pst.setInt(2, materia.getNivel());
            pst.setInt(3, materia.getAcademia_idAcademia());
            pst.setInt(4, materia.getIdMateria());

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

