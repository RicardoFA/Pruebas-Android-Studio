package com.example.desarrollo.claseherencia;

/**
 * Created by Desarrollo on 04/02/2016.
 */
public class Vehiculo {
    //Orientacion objeti
    //Atributos privados - solamente puede acceder de sus métodos de ENCAPSULAMIENTO
    //metodos publicos

    private int cantidad;
    private String numeroPlaca;
    private String color;
    private String marca;
    private String modelo;
    private String capacidad;

    public Vehiculo(){
        numeroPlaca = "";
        color = "";
        marca = "";
        modelo = "";
        capacidad = "";
        cantidad = 0;
    }

    public Vehiculo (String xplaca, String xmodelo){
        numeroPlaca = xplaca;
        modelo = xmodelo;
    }

    public int getCantidad() {

        return cantidad;
    }

    public void setCantidad(int cantidad) {

        this.cantidad = cantidad;
    }

    public String getNumeroPlaca() {

        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {

        this.numeroPlaca = numeroPlaca;
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

    public String getModelo() {

        return modelo;
    }

    public void setModelo(String modelo) {

        this.modelo = modelo;
    }

    public String getCapacidad() {

        return capacidad;
    }

    public void setCapacidad(String capacidad) {

        this.capacidad = capacidad;
    }
}
