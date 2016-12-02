package cartas;

import stucom.tools.Colors;
import stucom.tools.InputData;
import stucom.tools.Show;

import java.util.ArrayList;
import java.util.Comparator;

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
                case 3:
                    option3();
                    break;
            }
        }while(option != 4);
    }
    private static void createCardsAndPlayers(){

        //CardsTrope
        CardTrope barbarian = new CardTrope("Barbarian",2,80,20);
        cards.add(barbarian);

        CardTrope archer = new CardTrope("Archer",1,80,30);
        cards.add(archer);

        CardTrope giant = new CardTrope("Giant",2,100,40);
        cards.add(giant);


        //CardsStrucure
        CardStructure turret = new CardStructure("Turret",4,100,40);
        cards.add(turret);

        CardStructure canon = new CardStructure("Canon",3,100,10);
        cards.add(canon);

        CardStructure ballista = new CardStructure("Ballista", 2,80,20);
        cards.add(ballista);


        //CardsSpell
        CardSpell download = new CardSpell("Download", 1,30,40,"attack");
        cards.add(download);

        CardSpell poison = new CardSpell("Poison", 3, 20, 10,"attack");
        cards.add(poison);

        CardSpell shield = new CardSpell("Shield",1,100,30,"defend");
        cards.add(shield);

        //Players
        Player arnau = new Player("NeF3r","123456789", 0);
        players.add(arnau);

        Player albert = new Player("Treblast5","123456789", 0);
        players.add(albert);

        Player marti = new Player("Mulusaso","123456789", 0);
        players.add(marti);
        arnau.setTrophies(30);
        albert.setTrophies(10);

    }
    private static void showMenu(){
        System.out.println("1. Loggeate y consigue tus cartas");
        System.out.println("2. Batalla");
        System.out.println("3. Ranking");
        System.out.println("4. Salir");
    }
    private static void option1(){
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
                        Show.success("La carta se ha añadido al inventario");

                    }
                }
                if (!exists){
                    Show.error("La carta no se encuentra o ya la tienes en tu inventario");
                }
            } while(cardsToAdd.size() != 5);
            player.setCard(cardsToAdd);
            Show.success("Las Cartas se añadieron al inventario del jugador " + player.getUsername());
        }
    }
    private static void option2(){
        Player player1 = loggin(InputData.pedirCadena("Introduce nombre de usuario"),InputData.pedirCadena("Introduce contraseña"));
        Player player2 = loggin(InputData.pedirCadena("Introduce nombre de usuario"),InputData.pedirCadena("Introduce contraseña"));
        ArrayList<Card> cardsPlayer1 = new ArrayList<>(2);
        ArrayList<Card> cardsPlayer2 = new ArrayList<>(2);
        int elixirPlayer1 = 0;
        int elixirPlayer2 = 0;
        //TODO : Añadir un metodo para insertar carta al jugador (addCardToPlayer) de este estilo
        if ((player1 != null && player1.getCard() != null) && (player2 != null && player2.getCard() != null)){
            System.out.println("Seleciona 3 de tu inventario " + player1.getUsername());
            do {
                String nombreCarta = InputData.pedirCadena("Introduce el nombre de una carta para utilizar la en la batalla "+ player1.getUsername() + Colors.ANSI_RESET);
                boolean exists = false;
                for (Card c : cards) {
                    if (c.getName().equalsIgnoreCase(nombreCarta) && !cardsPlayer1.contains(c)){
                        cardsPlayer1.add(c);
                        exists = true;
                        elixirPlayer1 = elixirPlayer1 + c.getElixir();
                        Show.success("La carta " + c.getName() + " se ha añadido al inventario");
                    }
                }
                if (!exists){
                    Show.error("La carta no se encuentra o ya la tienes en tu inventario");
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
                cardsPlayer1.clear();
                cardsPlayer2.clear();
                System.out.println(Colors.ANSI_RED + "La suma de los elixires es superior a 10" + Colors.ANSI_RESET);
            }

        }else{
            Show.error("Uno o más jugadores no han elegido cartas previamente");
        }
    }
    private static Player loggin(String username, String password){
        for (Player p : players) {
            if (p.getUsername().equalsIgnoreCase(username) && p.getPassword().equalsIgnoreCase(password)){
                Show.success("Te has logeado correctamente " + p.getUsername());
                return p;
            }
        }
        Show.error("Loggin fallido");
        return null;
    }
    private static void showInfoCardTrope(CardTrope cardTrope){
        System.out.println("La carta: " + cardTrope.getName() + " tiene " + cardTrope.getHealth() + " puntos de vida, " + cardTrope.getElixir() + " elixires y " + cardTrope.getAttack() + " puntos de ataque ");
    }
    private static void showInfoCardSpell(CardSpell cardSpell){
        System.out.println("La carta: " + cardSpell.getName() + " tiene " + cardSpell.getHealth() + " puntos de vida, " + cardSpell.getElixir() + " elixires, esta en modo " + cardSpell.getMode() +  " y tiene un alcance de " + cardSpell.getRange());
    }
    private static void showInfoCardStructure(CardStructure cardStructure){
        System.out.println("La carta: " + cardStructure.getName() + " tiene " + cardStructure.getHealth() + " puntos de vida, " + cardStructure.getElixir() + " elixires y " + cardStructure.getDefend() + " puntos de defensa ");
    }
    private static void showAllCards(){
        for (Card card : cards){
            showCard(card);
        }
    }
    private static void showCard(Card card){
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
    private static void showCardsPlayer(Player player){
        ArrayList<Card> cards = player.getCard();
        if (cards != null){
            for (Card card : cards){
                showCard(card);
            }
        }else{
            Show.error("El jugador " + player.getUsername() + " no tine cartas asignadas");
        }
    }
    private static void battle(Player player1, ArrayList<Card> cardsPlayer1, Player player2, ArrayList<Card> cardsPlayer2){
        int healthPlayer1 = 0;
        int healthPlayer2 = 0;
        for (int i = 0; i <= 2; i++){
            Card cardPlayer1 = cardsPlayer1.get(i);
            Card cardPlayer2 = cardsPlayer2.get(i);
            //Guarrada máxima
            healthPlayer2 = getFinalHealthPlayer(cardsPlayer1, cardsPlayer2, healthPlayer2, cardPlayer1, cardPlayer2);
            healthPlayer1 = getFinalHealthPlayer(cardsPlayer2, cardsPlayer1, healthPlayer1, cardPlayer2, cardPlayer1);
        }
        Show.success("Health player 1 " + healthPlayer1);
        Show.success("Health player 2 " + healthPlayer2);
        if (healthPlayer2 > healthPlayer1){
            player2.setTrophies(player2.getTrophies()+5);
            Show.success("Gana el jugador 2");
        }else{
            player1.setTrophies(player1.getTrophies()+5);
            Show.success("Gana el jugador 1");
        }
    }
    //Guarrada máxima
    private static int getFinalHealthPlayer(ArrayList<Card> cardsPlayer1, ArrayList<Card> cardsPlayer2, int healthPlayer2, Card cardPlayer1, Card cardPlayer2) {
        if (cardPlayer1 instanceof CardTrope){
            cardPlayer2.setHealth(cardPlayer2.getHealth() - (((CardTrope) cardPlayer1).getAttack() / 2));
            healthPlayer2 = cardPlayer2.getHealth() + cardPlayer2.getHealth();
        }
        if (cardPlayer1 instanceof CardStructure){
            cardsPlayer1.get(0).setHealth(cardPlayer1.getHealth() + 8);
            cardsPlayer1.get(1).setHealth(cardPlayer1.getHealth() + 8);
            cardsPlayer1.get(2).setHealth(cardPlayer1.getHealth() + 8);
            healthPlayer2 = cardPlayer2.getHealth() + cardPlayer2.getHealth();
        }
        if (cardPlayer1 instanceof CardSpell){
            if (((CardSpell) cardPlayer1).getMode().equalsIgnoreCase("attack")){
                cardsPlayer2.get(0).setHealth(cardPlayer2.getHealth() - (((CardSpell) cardPlayer1).getRange() * 2 /3));
                cardsPlayer2.get(1).setHealth(cardPlayer2.getHealth() - (((CardSpell) cardPlayer1).getRange() * 2 /3));
                cardsPlayer2.get(2).setHealth(cardPlayer2.getHealth() - (((CardSpell) cardPlayer1).getRange() * 2 /3));
                healthPlayer2 = cardPlayer2.getHealth() + cardPlayer2.getHealth();
            }else{
                cardsPlayer1.get(0).setHealth(cardPlayer2.getHealth() + (((CardSpell) cardPlayer1).getRange() * 2 /3));
                cardsPlayer1.get(1).setHealth(cardPlayer2.getHealth() + (((CardSpell) cardPlayer1).getRange() * 2 /3));
                cardsPlayer1.get(2).setHealth(cardPlayer2.getHealth() + (((CardSpell) cardPlayer1).getRange() * 2 /3));
                healthPlayer2 = cardPlayer2.getHealth() + cardPlayer2.getHealth();
            }
        }
        return healthPlayer2;
    }
    private static void option3(){
        System.out.println("Ranking de Jugadores:");
        players.sort(Comparator.comparing(Player::getTrophies).reversed());
        for (int i=0; i != players.size(); i++){
            System.out.println(i + 1 + ". El Jugador " + players.get(i).getUsername() + " tiene " + players.get(i).getTrophies());
        }

    }
}
