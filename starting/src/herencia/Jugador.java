package herencia;

/**
 * Created by Arnau on 10/11/16.
 */
public class Jugador {

    private String nick;
    private int ataque;
    private int defensa;

    public Jugador(String nick, int ataque, int defensa) {
        this.nick = nick;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
}
