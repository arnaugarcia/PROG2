package cartas;

import stucom.tools.InputData;

/**
 * Created by Arnau on 18/10/16.
 */
public class Main {
    public static void main(String[] args){
        createCardsAndPlayers();
        int option = 0;
        do{
            System.out.println("**** STUCOM ROYAL ****");
            showMenu();
            option = InputData.pedirEntero("Introduce una opción");
            switch (option){
                case 1:
                    System.out.println(1);
                    break;
            }
        }while(option != 4);
    }
    public static void createCardsAndPlayers(){
        //Cards
        CardTrope barbarian = new CardTrope("Barbarian",5,80,20);
        CardTrope archer = new CardTrope("Archer",3,80,30);
        CardTrope giant = new CardTrope("Giant",5,100,40);

        CardStructure turret = new CardStructure("Turret",4,100,40);
        CardStructure canon = new CardStructure("Canon",5,100,10);
        CardStructure ballista = new CardStructure("Ballista", 5,80,20);

        CardSpell download = new CardSpell("Download", 2,30,40,"attack");
        CardSpell poison = new CardSpell("Poison", 4, 20, 10,"attack");
        CardSpell shield = new CardSpell("Shield",2,100,30,"defend");

        //Players
        Player arnau = new Player("NeF3r","123456789", 0);
        Player albert = new Player("Treblast5","123456789", 0);
        Player marti = new Player("Mulusaso","123456789", 0);
    }
    public static void showMenu(){
        System.out.println("1. Loggeate y consigue tus cartas");
        System.out.println("2. Batalla");
        System.out.println("3. Ranking");
        System.out.println("4. Salir");
    }
    public static boolean loggin(String username, String password){
        return false;
    }
}
