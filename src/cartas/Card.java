package cartas;

/**
 * Created by Arnau on 17/11/16.
 */
public class Card {
    private String name;
    private int elixir;
    private int health;

    public Card(String name, int elixir, int health) {
        this.name = name;
        this.elixir = elixir;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getElixir() {
        return elixir;
    }

    public void setElixir(int elixir) {
        this.elixir = elixir;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
