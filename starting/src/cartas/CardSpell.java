package cartas;

/**
 * Created by Arnau on 23/11/16.
 */
public class CardSpell extends Card{

    private int range;
    private String mode;

    public CardSpell(String name, int elixir, int health, int range, String mode) {
        super(name, elixir, health);
        this.range = range;
        this.mode = mode;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
