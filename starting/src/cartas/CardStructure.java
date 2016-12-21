package cartas;

/**
 * Created by Arnau on 17/11/16.
 */
public class CardStructure extends Card{

    private int defend;

    public CardStructure(String name, int elixir, int health, int defend) {
        super(name, elixir, health);
        this.defend = defend;
    }

    public int getDefend() {
        return defend + 8;
    }

    public void setDefend(int defend) {
        this.defend = defend;
    }
}

