/*
 * Clase para tener las consultas del enunciado de Alfredo.
 */
package jugadores;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mfontana
 */
public class Consultas {

    public static List<Jugador> buscarJugadoresPorNombre(List<Equipo> todosEquipos, String nombre) {
        List<Jugador> jugadores = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            for (Jugador j : e.getJugadores()) {
                // Problema de Mayúsculas y minúsculas
                String nombreCompleto = j.getNombre().toLowerCase();
                String nombreMinusculas = nombre.toLowerCase();
                // Miramos si contiene una parte del nombre
                if (nombreCompleto.contains(nombreMinusculas)) {
                    jugadores.add(j);
                }
            }
        }
        return jugadores;
    }

    public static List<Jugador> buscarJugadoresPorCanastas(List<Equipo> todosEquipos, int canastas) {
        List<Jugador> jugadores = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            for (Jugador j : e.getJugadores()) {
                if (j.getCanastas() >= canastas){
                    jugadores.add(j);
                }
            }
        }
        return jugadores;
    }

    public static List<Jugador> buscarJugadoresEntreAsistencias(List <Equipo> todosEquipos, int asistenciasMin, int asistenciasMax){
        List<Jugador> jugadoresAsistencias = new ArrayList<>();
        for (Equipo e : todosEquipos){
            for (Jugador j : e.getJugadores()){
                if(j.getAsistencias()>= asistenciasMin && j.getAsistencias() <= asistenciasMax ){
                    jugadoresAsistencias.add(j);
                }
            }
        }
        return jugadoresAsistencias;
    }


}