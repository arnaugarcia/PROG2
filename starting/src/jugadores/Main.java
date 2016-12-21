/*
 * Ejemplo de Alfredo, sin persistencia y con relación de muchos a uno.
 */
package jugadores;

import stucom.tools.Fichero;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 *
 * @author mfontana
 */
public class Main {

    private static Fichero miFichero;
    private static List liga;

    public static void main(String[] args) {
        miFichero = new Fichero("basketball.xml");
        liga = (List) miFichero.leer();
        if (liga == null){
            // Datos de prueba para probar las consultas, etc.
            Equipo e1 = new Equipo("Stucom", "Barcelona", LocalDate.of(2012, Month.SEPTEMBER, 10));
            Jugador j1 = new Jugador("Super Mario", LocalDate.of(1995, Month.MARCH, 23), 10, 10, 0, "Alero");
            Jugador j2 = new Jugador("Luigi", LocalDate.of(1994, Month.JANUARY, 8), 15, 20, 0, "Pivot");
            e1.getJugadores().add(j1);
            e1.getJugadores().add(j2);

            Equipo e2 = new Equipo("Linkia", "Madrid", LocalDate.of(2013, Month.JUNE, 23));
            Jugador j3 = new Jugador("Kako Gazapo", LocalDate.of(1996, Month.FEBRUARY, 16), 8, 2, 0, "Base");
            Jugador j4 = new Jugador("Toad", LocalDate.of(1993, Month.MAY, 15), 3, 300, 0, "Alero");
            e2.getJugadores().add(j3);
            e2.getJugadores().add(j4);

            liga.add(e1);
            liga.add(e2);
            miFichero.grabar(liga);
        }

        // Consultamos jugadores que contengan u
        List<Jugador> resultado = Consultas.buscarJugadoresPorNombre(liga, "u");
        System.out.println("Listado de jugadores con u en el nombre");
        for (Jugador j : resultado) {
            System.out.println(j);
        }

        // Jugadores que tengan más de 5 canastas
        resultado = Consultas.buscarJugadoresPorCanastas(liga, 5);
        System.out.println("Listado de jugadores con más de 5 canastas");
        for (Jugador j : resultado) {
            System.out.println(j);
        }

        resultado = Consultas.buscarJugadoresEntreAsistencias(liga, 5, 300);
        System.out.println("Listado de jugadores por asistencias");
        for (Jugador j : resultado){
            System.out.println(j);
        }
    }

}