package com.example.manuelperez.carrosmaterial;

/**
 * Created by manuelperez on 10/21/17.
 */

public class Carro {
    private String id;
    private String placa;
    private int marca;
    private int modelo;
    private int color;
    private  int precio, foto;

    public Carro(){

    }

    public Carro(String id, String placa, int marca, int modelo, int color, int precio, int foto) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.foto = foto;
    }

    public Carro(String placa, int marca, int modelo, int color, int precio, int foto) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.foto = foto;
    }

    public Carro(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void guardar(){
        Datos.guardarCarro(this);
    }

    public void editar(){
        Datos.editarCarro(this);
    }

    public void eliminar(){
        Datos.eliminarCarro(this);
    }
}
