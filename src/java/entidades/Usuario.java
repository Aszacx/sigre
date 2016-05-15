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

    public Usuario() {
    }
    
    public Usuario(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }
    
    public Usuario(int tipo, String nombre, String apellidoP, String apellidoM, String cel, String email, String pass) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.cel = cel;
        this.email = email;
        this.pass = pass;
    }
    
    public Usuario(int idUsuario, int tipo, String nombre, String apellidoP, String apellidoM, String cel, String email, String pass) {
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.cel = cel;
        this.email = email;
        this.pass = pass;
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

    

}
