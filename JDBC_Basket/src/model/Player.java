package model;

import java.time.LocalDate;

/**
 * Created by Arnau on 11/01/17.
 */

public class Player {
    private String nombre;
    private LocalDate bornDate;
    private int numberBaskets;
    private int numberAssists;
    private int numberReboots;
    private String posicion;
    private Team team;

    public Player(String nombre, LocalDate bornDate, int numberBaskets, int numberAssists, int numberReboots, String posicion, Team team) {
        this.nombre = nombre;
        this.bornDate = bornDate;
        this.numberBaskets = numberBaskets;
        this.numberAssists = numberAssists;
        this.numberReboots = numberReboots;
        this.posicion = posicion;
        this.team = team;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }

    public int getNumberBaskets() {
        return numberBaskets;
    }

    public void setNumberBaskets(int numberBaskets) {
        this.numberBaskets = numberBaskets;
    }

    public int getNumberAssists() {
        return numberAssists;
    }

    public void setNumberAssists(int numberAssists) {
        this.numberAssists = numberAssists;
    }

    public int getNumberReboots() {
        return numberReboots;
    }

    public void setNumberReboots(int numberReboots) {
        this.numberReboots = numberReboots;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
