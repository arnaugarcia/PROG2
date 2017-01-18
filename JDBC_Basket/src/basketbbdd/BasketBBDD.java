/*
 * Fichero de Test de nuestra clase JDBC
 */
package basketbbdd;

import model.Player;
import model.Team;
import persistence.BasketJDBC;
import stucom.tools.Show;

import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author mfontana
 */
public class BasketBBDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Instanciamos nuestro gestor
        BasketJDBC conexion = new BasketJDBC();
        try {   
            // Conectamos con la bbdd
            conexion.connect();
            conexion.reset();
            System.out.println("Estableciendo la conexión con el servidor...");
            Team team = new Team("Stucom","Barcelona",LocalDate.now());
            //Ejercicio 1
            System.out.println("Insertando equipo...");
            conexion.insertTeam(team);
            Show.success("Equipo insertado con éxito");

            //Ejercicio 2
            Player player = new Player("Michael Jordan", LocalDate.now(),100,100,100,"Alero", team);
            System.out.println("Insertando jugador....");
            conexion.insertPlayer(player);
            Show.success("Jugador dado de alta.");

            //Ejercicio 3
            System.out.println("Modifcar jugador " + player.getNombre());
            conexion.updatePlayer(player,300,300,300);
            Show.success(player.getNombre() + " modificado con éxito");

            //Ejercicio 4
            System.out.println("Modificando Equipo " + team.getName() + " perteneciente al jugador " + player.getNombre());
            conexion.select("team","Stucom");

        } catch (SQLException ex) {
            System.out.println("Error con la BBDD: " + ex.getMessage());
        } finally {
            try {
                conexion.desconectar();
                System.out.println("Conexión cerrada.");
            } catch (SQLException ex) {
                System.out.println("Error al desconectar "+ex.getMessage());
            }
        }
    }

}