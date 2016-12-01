package cartas;

import stucom.tools.Colors;
import stucom.tools.InputData;
import stucom.tools.Show;

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
        if (player != null){
            showAllCards();
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
        ArrayList<Card> cardsPlayer1 = new ArrayList<>(3);
        ArrayList<Card> cardsPlayer2 = new ArrayList<>(3);
        int elixirPlayer1 = 0;
        int elixirPlayer2 = 0;
        //TODO : Añadir un metodo para insertar carta al jugador (addCardToPlayer) de este estilo
        if (player1 != null && player2 != null){
            String playerStart = InputData.pedirCadena("Introduce el jugador que empieza" + "(" + player1.getUsername() + " o " + player2.getUsername() + ")");
            showCardsPlayer(player1);
            System.out.println("Seleciona 3 de tu inventario " + player1.getUsername());
            do {
                String nombreCarta = InputData.pedirCadena("Introduce el nombre de una carta para utilizar la en la batalla "+ player1.getUsername() + Colors.ANSI_RESET);
                boolean exists = false;
                for (Card c : cards) {
                    if (c.getName().equalsIgnoreCase(nombreCarta) && !cardsPlayer1.contains(c)){
                        cardsPlayer1.add(c);
                        exists = true;
                        elixirPlayer1 = elixirPlayer1 + c.getElixir();
                        System.out.println(Colors.ANSI_GREEN + "La carta " + c.getName() + " se ha añadido al inventario" + Colors.ANSI_RESET);
                    }
                }
                if (!exists){
                    System.out.println(Colors.ANSI_RED + "La carta no se encuentra o ya la tienes en tu inventario" + Colors.ANSI_RESET);
                }
            } while(cardsPlayer1.size() != 3);
            showCardsPlayer(player2);
            do {
                String nombreCarta = InputData.pedirCadena("Introduce el nombre de una carta para utilizar la en la batalla" + player2.getUsername()  + Colors.ANSI_RESET);
                boolean exists = false;
                for (Card c : cards) {
                    if (c.getName().equalsIgnoreCase(nombreCarta) && !cardsPlayer2.contains(c)){
                        cardsPlayer2.add(c);
                        exists = true;
                        elixirPlayer2 = elixirPlayer2 + c.getElixir();
                        System.out.println(Colors.ANSI_GREEN + "La carta " + c.getName() + " se ha añadido al inventario" + Colors.ANSI_RESET);
                    }
                }
                if (!exists){
                    System.out.println(Colors.ANSI_RED + "La carta no se encuentra o ya la tienes en tu inventario" + Colors.ANSI_RESET);
                }
            } while(cardsPlayer2.size() != 3);

            if (!(elixirPlayer1 > 10) && !(elixirPlayer2 > 10)){
                battle(player1, cardsPlayer1, player2, cardsPlayer2);
            }else{
                System.out.println(Colors.ANSI_RED + "La suma de los elixires es superior a 10" + Colors.ANSI_RESET);
            }

        }
    }
    public static Player loggin(String username, String password){
        for (Player p : players) {
            if (p.getUsername().equalsIgnoreCase(username) && p.getPassword().equalsIgnoreCase(password)){
                Show.success("Te has logeado correctamente " + p.getUsername());
                return p;
            }
        }
        Show.error("Loggin fallido");
        return null;
    }
    public static void showInfoCardTrope(CardTrope cardTrope){
        System.out.println("La carta: " + cardTrope.getName() + " tiene " + cardTrope.getHealth() + " puntos de vida, " + cardTrope.getElixir() + " elixires y " + cardTrope.getAttack() + " puntos de ataque ");
    }
    public static void showInfoCardSpell(CardSpell cardSpell){
        System.out.println("La carta: " + cardSpell.getName() + " tiene " + cardSpell.getHealth() + " puntos de vida, " + cardSpell.getElixir() + " elixires, esta en modo " + cardSpell.getMode() +  " y tiene un alcance de " + cardSpell.getRange());
    }
    public static void showInfoCardStructure(CardStructure cardStructure){
        System.out.println("La carta: " + cardStructure.getName() + " tiene " + cardStructure.getHealth() + " puntos de vida, " + cardStructure.getElixir() + " elixires y " + cardStructure.getDefend() + " puntos de defensa ");
    }
    public static void showAllCards(){
        for (Card card : cards){
            showCard(card);
        }
    }
    public static void showCard(Card card){
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
    public static void showCardsPlayer(Player player){
        ArrayList<Card> cards = player.getCard();
        if (cards != null){
            for (Card card : cards){
                showCard(card);
            }
        }else{
            System.out.println(Colors.ANSI_RED + "El jugador " + player.getUsername() + " no tine cartas asignadas" + Colors.ANSI_RESET);
        }
    }
    public static void battle(Player player1, ArrayList<Card> cardsPlayer1, Player player2, ArrayList<Card> cardsPlayer2){
        int healthPlayer1, healthPlayer2 = 0;
        for (int i = 0; i < 5; i++){
            Card cardPlayer1 = cardsPlayer1.get(i);
            Card cardPlayer2 = cardsPlayer2.get(i);
            if (cardPlayer1 instanceof CardTrope){
                /**

             */
                cardPlayer2.setHealth(cardPlayer2.getHealth() - ((CardTrope) cardPlayer1).getAttack());
                healthPlayer2 += cardPlayer2.getHealth();
            }
        }
    }
}
