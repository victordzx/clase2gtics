package com.example.clase2gtics.entity;

public class Alumno {
    private String nombre;
    private int codigo;
    private Carro carro;


    public Alumno() {
    }

    public Alumno(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public Alumno(String nombre, int codigo, Carro carro) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.carro = carro;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
