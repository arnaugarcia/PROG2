/*
 * Entity Plato
 */
package model;

/**
 *
 * @author arnaugarcia
 */

public class Plato {

    private String nombre;
    private String tipo;
    private double precio;
    private Cocinero cocinero;

    public Plato() {
        
    }

    public Plato(String nombre, String tipo, double precio, Cocinero cocinero) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.cocinero = cocinero;
    }

    public Cocinero getCocinero() {
        return cocinero;
    }

    public void setCocinero(Cocinero cocinero) {
        this.cocinero = cocinero;
    }



    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}