package cartas;

import stucom.tools.Colors;
import stucom.tools.InputData;

import java.util.ArrayList;

/**
 * Created by Arnau on 18/10/16.
 */
public class Main {

    private static ArrayList<Card> cards = new ArrayList<>();
    private static ArrayList<Player> players = new ArrayList<>();

    public static void main(String[] args){
        createCardsAndPlayers();
        int option = 0;
        do{
            System.out.println(Colors.ANSI_BLUE + "**** " + Colors.ANSI_YELLOW + " STUCOM ROYAL " + Colors.ANSI_BLUE + " ****" + Colors.ANSI_RESET);
            showMenu();
            option = InputData.pedirEntero("Introduce una opción");
            switch (option){
                case 1:
                    option1();
                    break;
                case 2:
                    option2();
                    break;
            }
        }while(option != 4);
    }
    public static void createCardsAndPlayers(){

        //CardsTrope
        CardTrope barbarian = new CardTrope("Barbarian",5,80,20);
        cards.add(barbarian);

        CardTrope archer = new CardTrope("Archer",3,80,30);
        cards.add(archer);

        CardTrope giant = new CardTrope("Giant",5,100,40);
        cards.add(giant);


        //CardsStrucure
        CardStructure turret = new CardStructure("Turret",4,100,40);
        cards.add(turret);

        CardStructure canon = new CardStructure("Canon",5,100,10);
        cards.add(canon);

        CardStructure ballista = new CardStructure("Ballista", 5,80,20);
        cards.add(ballista);


        //CardsSpell
        CardSpell download = new CardSpell("Download", 2,30,40,"attack");
        cards.add(download);

        CardSpell poison = new CardSpell("Poison", 4, 20, 10,"attack");
        cards.add(poison);

        CardSpell shield = new CardSpell("Shield",2,100,30,"defend");
        cards.add(shield);

        //Players
        Player arnau = new Player("NeF3r","123456789", 0);
        players.add(arnau);

        Player albert = new Player("Treblast5","123456789", 0);
        players.add(albert);

        Player marti = new Player("Mulusaso","123456789", 0);
        players.add(marti);

    }
    public static void showMenu(){
        System.out.println("1. Loggeate y consigue tus cartas");
        System.out.println("2. Batalla");
        System.out.println("3. Ranking");
        System.out.println("4. Salir");
    }
    public static void option1(){
        ArrayList<Card> cardsToAdd = new ArrayList<>();
        Player player = loggin(InputData.pedirCadena("Introduce nombre de usuario"),InputData.pedirCadena("Introduce contraseña"));
        showAllCards();
        if (player != null){
            do {
                String nombreCarta = InputData.pedirCadena("Introduce el nombre de una carta para añadirla al inventario" + Colors.ANSI_RESET);
                boolean exists = false;
                for (Card c : cards) {
                    if (c.getName().equalsIgnoreCase(nombreCarta) && !cardsToAdd.contains(c)){
                        cardsToAdd.add(c);
                        exists = true;
                        System.out.println(Colors.ANSI_GREEN + "La carta se ha añadido al inventario" + Colors.ANSI_RESET);
                    }
                }
                if (!exists){
                    System.out.println(Colors.ANSI_RED + "La carta no se encuentra o ya la tienes en tu inventario" + Colors.ANSI_RESET);
                }
            } while(cardsToAdd.size() != 5);
            player.setCard(cardsToAdd);
            System.out.println(Colors.ANSI_GREEN + "Las Cartas se añadieron al inventario del jugador " + player.getUsername() + Colors.ANSI_RESET);
        }
    }
    public static void option2(){
        Player player1 = loggin(InputData.pedirCadena("Introduce nombre de usuario"),InputData.pedirCadena("Introduce contraseña"));
        Player player2 = loggin(InputData.pedirCadena("Introduce nombre de usuario"),InputData.pedirCadena("Introduce contraseña"));
        if (player1 != null && player2 != null){

        }
    }
    public static Player loggin(String username, String password){
        for (Player p : players) {
            if (p.getUsername().equalsIgnoreCase(username) && p.getPassword().equalsIgnoreCase(password)){
                System.out.println(Colors.ANSI_GREEN + "Te has logeado correctamente " + p.getUsername() + Colors.ANSI_RESET);
                return p;
            }
        }
        System.out.println(Colors.ANSI_RED + "Loggin fallido" + Colors.ANSI_RESET);
        return null;
    }
    public static void showInfoCardTrope(CardTrope cardTrope){
        System.out.println("La carta: " + cardTrope.getName() + " tiene " + cardTrope.getHealth() + " puntos de vida, " + cardTrope.getElixir() + " elixires y " + cardTrope.getAttack() + " puntos de ataque ");
    }
    public static void showInfoCardSpell(CardSpell cardSpell){
        System.out.println("La carta: " + cardSpell.getName() + " tiene " + cardSpell.getHealth() + " puntos de vida, " + cardSpell.getElixir() + " elixires, esta en modo " + cardSpell.getMode() +  "y tiene un alcance de " + cardSpell.getRange());
    }
    public static void showInfoCardStructure(CardStructure cardStructure){
        System.out.println("La carta: " + cardStructure.getName() + " tiene " + cardStructure.getHealth() + " puntos de vida, " + cardStructure.getElixir() + " elixires y " + cardStructure.getDefend() + " puntos de defensa ");
    }
    public static void showAllCards(){
        for (Card card : cards){
            if (card instanceof CardTrope) {
                CardTrope tropeCard = (CardTrope) card;
                showInfoCardTrope(tropeCard);
            } else if (card instanceof CardStructure){
                CardStructure structureCard  = (CardStructure) card;
                showInfoCardStructure(structureCard);
            } else if (card instanceof CardSpell){
                CardSpell cardSpell = (CardSpell) card;
                showInfoCardSpell(cardSpell);
            }
        }
    }
}
