package model;

import java.time.LocalDate;

/**
 * Created by Arnau on 25/01/17.
 */
public class EstadisticaDTO {

    private String name;
    private LocalDate bornDate;
    private int baskets;
    private int assists;
    private int reboots;
    private Team team;
    private double avgbaskets;
    private double avgassists;
    private double avgrebounds;
    private int maxbaskets;
    private int maxassists;
    private int maxrebounds;
    private int minbaskets;
    private int minassists;
    private int minrebounds;
    private String position;

    public EstadisticaDTO(double avgbaskets, double avgassists, double avgrebounds, int maxbaskets, int maxassists, int maxrebounds, int minbaskets, int minassists, int minrebounds, String position) {
        this.avgbaskets = avgbaskets;
        this.avgassists = avgassists;
        this.avgrebounds = avgrebounds;
        this.maxbaskets = maxbaskets;
        this.maxassists = maxassists;
        this.maxrebounds = maxrebounds;
        this.minbaskets = minbaskets;
        this.minassists = minassists;
        this.minrebounds = minrebounds;
        this.position = position;
    }

    public EstadisticaDTO(String name, int baskets, int assists, int reboots) {
        this.name = name;
        this.baskets = baskets;
        this.assists = assists;
        this.reboots = reboots;
    }

    public EstadisticaDTO(String name, int baskets) {
        this.name = name;
        this.baskets = baskets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }

    public int getBaskets() {
        return baskets;
    }

    public void setBaskets(int baskets) {
        this.baskets = baskets;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getReboots() {
        return reboots;
    }

    public void setReboots(int reboots) {
        this.reboots = reboots;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public double getAvgbaskets() {
        return avgbaskets;
    }

    public void setAvgbaskets(double avgbaskets) {
        this.avgbaskets = avgbaskets;
    }

    public double getAvgassists() {
        return avgassists;
    }

    public void setAvgassists(double avgassists) {
        this.avgassists = avgassists;
    }

    public double getAvgrebounds() {
        return avgrebounds;
    }

    public void setAvgrebounds(double avgrebounds) {
        this.avgrebounds = avgrebounds;
    }

    public int getMaxbaskets() {
        return maxbaskets;
    }

    public void setMaxbaskets(int maxbaskets) {
        this.maxbaskets = maxbaskets;
    }

    public int getMaxassists() {
        return maxassists;
    }

    public void setMaxassists(int maxassists) {
        this.maxassists = maxassists;
    }

    public int getMaxrebounds() {
        return maxrebounds;
    }

    public void setMaxrebounds(int maxrebounds) {
        this.maxrebounds = maxrebounds;
    }

    public int getMinbaskets() {
        return minbaskets;
    }

    public void setMinbaskets(int minbaskets) {
        this.minbaskets = minbaskets;
    }

    public int getMinassists() {
        return minassists;
    }

    public void setMinassists(int minassists) {
        this.minassists = minassists;
    }

    public int getMinrebounds() {
        return minrebounds;
    }

    public void setMinrebounds(int minrebounds) {
        this.minrebounds = minrebounds;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "EstadisticaDTO: (" +
                "Media baskets: " + avgbaskets +
                ", Media assistencias: " + avgassists +
                ", Media rebotes: " + avgrebounds +
                ", Canastas máximas: " + maxbaskets +
                ", Asistencias máximas: " + maxassists +
                ", Rebotes máximos: " + maxrebounds +
                ", Canastas mínimas: " + minbaskets +
                ", Aistencias mínimas: " + minassists +
                ", Rebotes mínimo: " + minrebounds +
                ", Posición: '" + position + '\'' +
                ')';
    }
}
