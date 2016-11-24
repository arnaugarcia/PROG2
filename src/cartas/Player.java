package cartas;

import java.util.ArrayList;

/**
 * Created by Arnau on 17/11/16.
 */
public class Player {
    private String username;
    private String password;
    private int trophies;
    private ArrayList Card;

    public Player(String username, String password, int trophies) {
        this.username = username;
        this.password = password;
        this.trophies = trophies;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTrophies() {
        return trophies;
    }

    public void setTrophies(int trophies) {
        this.trophies = trophies;
    }

    public ArrayList getCard() {
        return Card;
    }

    public void setCard(ArrayList card) {
        Card = card;
    }
}
