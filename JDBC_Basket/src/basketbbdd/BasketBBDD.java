/*
 * Fichero de Test de nuestra clase JDBC
 */
package basketbbdd;

import model.EstadisticaDTO;
import model.Player;
import model.Team;
import persistence.BasketJDBC;
import stucom.tools.Show;

import java.sql.Date;
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
            Player player1 = new Player("Mill Milf", LocalDate.now(),200,200,200,"Base", team);
            Player player2 = new Player("Will es Milf", LocalDate.now(),300,300,300,"Alero", team);
            System.out.println("Insertando jugador....");
            conexion.insertPlayer(player);
            conexion.insertPlayer(player1);
            conexion.insertPlayer(player2);
            Show.success("Jugador dado de alta.");

            //Ejercicio 3
            System.out.println("Modifcar jugador " + player.getNombre());
            conexion.updatePlayer(player,300,300,300);
            Show.success(player.getNombre() + " modificado con éxito");

            //Ejercicio 4
            Show.success("Modificando Equipo " + team.getName() + " perteneciente al jugador " + player.getNombre());


            //Ejercicio 6
            System.out.println("Oteniendo jugador " + player.getNombre());
           Show.success(conexion.selectPlayerByName("Michael Jordan").toString());

            //Ejercicio 7
            System.out.println("Obteniendo todos los jugadores por la letra 'M'");
            for (Player players : conexion.selectPlayerByNameLike("M")){
                Show.success(players.toString());
            }

            //Ejercicio 8
            System.out.println("Listado de jugadores que hayan conseguido un número mayor o igual a un número de canastas especificado como parámetro.");
            for (Player players : conexion.selectPlayerByBaskets(0,1000)){
                Show.success(players.toString());
            }

            //Ejercicio 9
            System.out.println("Listado de jugadores que hayan efectuado un número de asistencias dentro de un rango especificado como parámetro.");
            for (Player players : conexion.selectPlayerByAssists(0,1000)){
                Show.success(players.toString());
            }

            //Ejercicio 10
            System.out.println("Listado de jugadores que pertenezcan a una posición específica, por ejemplo: base.");
            for (Player players : conexion.selectPlayerByPosition("base")){
                Show.success(players.toString());
            }

            //Ejercicio 11
            System.out.println("Listado de jugadores que hayan nacido en una fecha anterior a una fecha especificada como parámetro.");
            for (Player players : conexion.selectPlayerByBirth(Date.valueOf(LocalDate.now()))){
                Show.success(player.toString());
            }

            //Ejercicio 12
            System.out.println("Agrupar los jugadores por la posición del campo y devolver para cada grupo la siguiente información: la media, el máximo y el mínimo de canastas, asistencias y rebotes.");
            for (EstadisticaDTO estadisticaDTO : conexion.selectAllPlayersAvgAndMaxMin()){
                Show.success(estadisticaDTO.toString());
            }

            //Ejercicio 13
            System.out.println("Ranking de jugadores por número de canastas");
            for (int i = 0, x = 0; i<conexion.rankingPlayersByBaskets().size(); i++, x++){
                Show.success(x+1 + " " +  conexion.rankingPlayersByBaskets().get(i).getName() + " " + conexion.rankingPlayersByBaskets().get(i).getBaskets());
            }

            //Ejercicio 14
            System.out.println("Obtener la posición dentro del ranking para un jugador determinado (2)");
            Show.success("Posición 2 " + conexion.rankingPlayersByBaskets().get(2).getName() + " " + conexion.rankingPlayersByBaskets().get(2).getBaskets());

            //Ejercicio 15
            System.out.println("Listado de equipos existentes en una localidad determinada");
            for (Player players : conexion.getPlayersByPosition("Alero")){
                Show.success(players.toString());
            }
            //Ejercicio 16
            System.out.println("Listado de equipos existentes de un equipo por nombre ('Stucom')");
            for (Player players : conexion.getPlayersFromTeamName("Stucom")){
                Show.success(players.toString());
            }

            //Ejercicio 17
            System.out.println("Listado de todos los jugadores de un equipo ('Stucom'), que además jueguen en la misma posición (parámetro adicional de la consulta), por ejemplo, alero.");
            for (Player players : conexion.getPlayersFromTeamNameAndPosition("Stucom","Alero")){
                Show.success(players.toString());
            }

            //Ejercicio 18
            System.out.println("Devuelve el jugador que más canastas ha realizado de un equipo determinado como parámetro ('Stucom').");
            for (Player players : conexion.getPlayersBasketsFromTeamName("Stucom")){
                Show.success(players.toString());
            }
        } catch (SQLException ex) {
            Show.error("Error con la BBDD: " + ex.getMessage());
        } finally {
            try {
                conexion.desconectar();
                Show.error("Conexión cerrada.");
            } catch (SQLException ex) {
                Show.error("Error al desconectar "+ex.getMessage());
            }
        }
    }

}