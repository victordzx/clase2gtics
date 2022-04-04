package com.example.clase2gtics.entity;

public class Carro {
    private String placa;
    private String color;
    private String marca;
    private Integer anioFabricacion;

    public Carro(String placa, String color, String marca, Integer anioFabricacion) {
        this.placa = placa;
        this.color = color;
        this.marca = marca;
        this.anioFabricacion = anioFabricacion;
    }

    public Carro(String marca, String placa, String color) {
        this.marca = marca;
        this.color = color;
        this.placa = placa;
    }

    public Carro(String marca, String color) {
        this.marca = marca;
        this.color = color;
    }

    public Carro(String marca) {
        this.marca = marca;
    }

    public Carro() {

    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(Integer anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }
}
