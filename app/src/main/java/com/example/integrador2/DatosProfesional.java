package com.example.integrador2;

public class DatosProfesional {

    private String nombre;
    private String apellido;
    private String profesion;
    private String tipo;

    public DatosProfesional(String nombre, String apellido,String profesion , String tipo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profesion;
        this.tipo = tipo;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
