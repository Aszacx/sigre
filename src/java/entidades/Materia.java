/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Lenovo
 */
public class Materia {
    private int idMateria;
    private String materia;
    private int nivel;
    private int Academia_idAcademia;
    private String academia;

    public Materia() {
    }
    
    public Materia(String materia, int nivel, int Academia_idAcademia) {
        this.materia = materia;
        this.nivel = nivel;
        this.Academia_idAcademia = Academia_idAcademia;
    }

    public Materia(int idMateria, String materia, int nivel, int Academia_idAcademia) {
        this.idMateria = idMateria;
        this.materia = materia;
        this.nivel = nivel;
        this.Academia_idAcademia = Academia_idAcademia;
    }
    
    public Materia(int idMateria, String materia, int nivel, int Academia_idAcademia, String academia) {
        this.idMateria = idMateria;
        this.materia = materia;
        this.nivel = nivel;
        this.Academia_idAcademia = Academia_idAcademia;
        this.academia = academia;
    }
    
    public Materia(int idMateria, String materia, int nivel, String academia) {
        this.idMateria = idMateria;
        this.materia = materia;
        this.nivel = nivel;
        this.academia = academia;
    }
    
    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getAcademia_idAcademia() {
        return Academia_idAcademia;
    }

    public void setAcademia_idAcademia(int Academia_idAcademia) {
        this.Academia_idAcademia = Academia_idAcademia;
    }

    public String getAcademia() {
        return academia;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
    }
}
