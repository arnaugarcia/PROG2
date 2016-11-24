package cartas;

/**
 * Created by Arnau on 17/11/16.
 */
public class CardTrope extends Card {
    private int attack;

    public CardTrope(String name, int elixir, int health, int attack) {
        super(name, elixir, health);
        this.attack = attack;
    }

    public int getAttack() {
        return attack / 2;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
