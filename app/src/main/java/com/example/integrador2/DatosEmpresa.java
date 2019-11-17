package com.example.integrador2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DatosEmpresa {

    private String nombre;
    private String rubro;
    private String ruc;
    private String tipo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public DatosEmpresa(String nombre, String rubro, String ruc , String tipo){
        this.nombre = nombre;
        this.rubro = rubro;
        this.ruc = ruc;
        this.tipo = tipo;



    }


}
