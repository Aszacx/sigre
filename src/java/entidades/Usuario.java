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
public class Usuario {
   private int idUsuario;
   private int tipo;
   private String nombre;
   private String apellidoP;
   private String apellidoM;
   private String cel;
   private String email;
   private String pass;
   private int Departamento_idDepartamento;
   private String departamento;
   private String boleta;
   private int Materia_idMateria;
   private String materia;
   private String motivos;
   private String fecha;
   private String[] materias;

    public Usuario() {
    }
    
    //Login
    public Usuario(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }
    
    //Agregar usuarios sa/jd 
    public Usuario(int tipo, String nombre, String apellidoP, String apellidoM, String cel, String email, String pass, int Departamento_idDepartamento) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.cel = cel;
        this.email = email;
        this.pass = pass;
        this.Departamento_idDepartamento = Departamento_idDepartamento;
    }
    
    //Agregar usuario profesor
    public Usuario(int tipo, String nombre, String apellidoP, String apellidoM, String cel, String email, String[] materias) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.cel = cel;
        this.email = email;
        this.materias = materias;
    }
    
    //Editar Usuarios
    public Usuario(int idUsuario, int tipo, String nombre, String apellidoP, String apellidoM, String cel, String email, String pass, int Departamento_idDepartamento) {
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.cel = cel;
        this.email = email;
        this.pass = pass;
        this.Departamento_idDepartamento = Departamento_idDepartamento;
    }   
    
    //Obtener Usuarios
    public Usuario(int idUsuario, int tipo, String nombre, String apellidoP, String apellidoM, String cel, String email, String pass, String departamento) {
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.cel = cel;
        this.email = email;
        this.pass = pass;
        this.departamento = departamento;
    }
    
    //Insertar Cita/Alumno
    public Usuario(int tipo, String nombre, String apellidoP, String apellidoM, 
            String cel, String email, String boleta, int Materia_idMateria, String motivos) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.cel = cel;
        this.email = email;
        this.boleta = boleta;
        this.Materia_idMateria = Materia_idMateria;
        this.motivos = motivos;        
    }
    
    //Obtener citas
    public Usuario(int Materia_idMateria, String fecha, String nombre, String apellidoP, String apellidoM, 
                    String boleta, String cel, String email) {
        this.Materia_idMateria = Materia_idMateria;    
        this.fecha = fecha;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.boleta = boleta;
        this.cel = cel;
        this.email = email;
    }
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public String getBoleta() {
        return boleta;
    }

    public void setBoleta(String boleta) {
        this.boleta = boleta;
    }

    public int getMateria_idMateria() {
        return Materia_idMateria;
    }

    public void setMateria_idMateria(int Materia_idMateria) {
        this.Materia_idMateria = Materia_idMateria;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getMotivos() {
        return motivos;
    }

    public void setMotivos(String motivos) {
        this.motivos = motivos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String[] getMaterias() {
        return materias;
    }

    public void setMaterias(String[] materias) {
        this.materias = materias;
    }

    

}
