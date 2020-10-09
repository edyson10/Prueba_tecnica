package com.example.prueba_tecnica.Clases;

public class Employees {

    private String nombre;
    private String documento;
    private String cargo;
    private int foto;

    public Employees() { }

    public Employees(String nombre, String documento, String cargo, int foto) {
        this.nombre = nombre;
        this.documento = documento;
        this.cargo = cargo;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
