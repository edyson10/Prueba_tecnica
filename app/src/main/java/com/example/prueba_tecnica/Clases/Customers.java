package com.example.prueba_tecnica.Clases;

public class Customers {

    private int foto;
    private String nombre;
    private String documento;

    public Customers(){ }

    public Customers(String nombre, String documento, int foto ) {
        this.foto = foto;
        this.nombre = nombre;
        this.documento = documento;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
