package presupuesto;

import java.io.Serializable;

/**
 * Created by Arnau on 18/10/16.
 */
public class Presupuesto implements Serializable {
    private int id;
    private String concepto;
    private double precio;
    private String estado;

    public Presupuesto(int id, String concepto, double precio, String estado) {
        this.id = id;
        this.concepto = concepto;
        this.precio = precio;
        this.estado = estado;
    }

    public Presupuesto(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
