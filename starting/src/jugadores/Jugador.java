/*
 * Entidad jugador
 */
package jugadores;

import java.time.LocalDate;

/**
 *
 * @author mfontana
 */
public class Jugador implements Cloneable {

    // Variable estática para dar valor al identificador de cada Jugador
    // Contará cuantas entidades de Jugador tenemos instanciadas
    private static int contador = 0;

    private int identificador;
    private String nombre;
    private LocalDate nacimiento;
    private int canastas;
    private int asistencias;
    private int rebotes;
    private String posicion;

    public Jugador(String nombre, LocalDate nacimiento, int canastas, int asistencias, int rebotes, String posicion) {
        contador++;
        this.identificador = contador;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.canastas = canastas;
        this.asistencias = asistencias;
        this.rebotes = rebotes;
        this.posicion = posicion;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getRebotes() {
        return rebotes;
    }

    public void setRebotes(int rebotes) {
        this.rebotes = rebotes;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public int getCanastas() {
        return canastas;
    }

    public void setCanastas(int canastas) {
        this.canastas = canastas;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        return "Jugador: " + "identificador " + identificador + ", nombre " + nombre + ", nacimiento " + nacimiento + ", canastas " + canastas + ", asistencias " + asistencias + ", rebotes " + rebotes + ", posicion " + posicion;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.identificador;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jugador other = (Jugador) obj;
        return this.identificador == other.identificador;
    }



}