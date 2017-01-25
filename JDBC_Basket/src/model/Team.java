package model;

import java.time.LocalDate;

/**
 * Created by Arnau on 11/01/17.
 */

public class Team {

    private String name;
    private String location;
    private LocalDate creationDate;

    public Team(String name, String location, LocalDate creationDate) {
        this.name = name;
        this.location = location;
        this.creationDate = creationDate;
    }

    public Team() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
