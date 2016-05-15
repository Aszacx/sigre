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
public class Academia {
    private int idAcademia;
    private String academia;
    private int Departamento_idDepartamento;
    private String departamento;

    public Academia() {
    }

    public Academia(String academia, int Departamento_idDepartamento) {
        this.academia = academia;
        this.Departamento_idDepartamento = Departamento_idDepartamento;
    }

    public Academia(int idAcademia, String academia, int Departamento_idDepartamento) {
        this.idAcademia = idAcademia;
        this.academia = academia;
        this.Departamento_idDepartamento = Departamento_idDepartamento;
    }
    
    public Academia(int idAcademia, String academia, int Departamento_idDepartamento, String departamento) {
        this.idAcademia = idAcademia;
        this.academia = academia;
        this.Departamento_idDepartamento = Departamento_idDepartamento;
        this.departamento = departamento;
    }
    
    public Academia(int idAcademia, String academia, String departamento) {
        this.idAcademia = idAcademia;
        this.academia = academia;
        this.departamento = departamento;
    }

    public int getIdAcademia() {
        return idAcademia;
    }

    public void setIdAcademia(int idAcademia) {
        this.idAcademia = idAcademia;
    }

    public String getAcademia() {
        return academia;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
    }

    public int getDepartamento_idDepartamento() {
        return Departamento_idDepartamento;
    }

    public void setDepartamento_idDepartamento(int Departamento_idDepartamento) {
        this.Departamento_idDepartamento = Departamento_idDepartamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
