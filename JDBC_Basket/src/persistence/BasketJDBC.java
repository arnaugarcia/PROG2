/*
 * Clase que se encarga de la persistencia en la BBDD
 */
package persistence;

import model.Player;
import model.Team;

import java.sql.*;

public class BasketJDBC {

    private Connection conexion;

    public BasketJDBC()  {

    }

    // Método que recibe un cocinero y lo inserta en la BBDD
    public void insertPlayer(Player player) throws SQLException {
        String insert = "insert into player values (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = conexion.prepareStatement(insert);
        preparedStatement.setString(1, player.getNombre());
        preparedStatement.setDate(2, Date.valueOf(player.getBornDate()));
        preparedStatement.setInt(3,player.getNumberBaskets());
        preparedStatement.setInt(4,player.getNumberAssists());
        preparedStatement.setInt(5,player.getNumberReboots());
        preparedStatement.setString(6,player.getPosicion());
        preparedStatement.setString(7,player.getTeam().getName());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void insertTeam(Team team) throws SQLException {
        String insert = "insert into team values(?,?,?)";
        PreparedStatement preparedStatement = conexion.prepareStatement(insert);
        preparedStatement.setString(1,team.getName());
        preparedStatement.setString(2,team.getLocation());
        preparedStatement.setDate(3, Date.valueOf(team.getCreationDate()));
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void updatePlayer(Player player, int canastas, int asistencias, int rebotes) throws SQLException{

        PreparedStatement updateQuery = conexion.prepareStatement("UPDATE player set nbaskets = ?, nassists = ?, nrebounds = ? WHERE name = ?");
        updateQuery.setInt(1,canastas);
        updateQuery.setInt(2,asistencias);
        updateQuery.setInt(3,rebotes);
        updateQuery.setString(4,player.getNombre());
        updateQuery.executeUpdate();
        updateQuery.close();
    }

    public void updateTeam(Player player, String location) throws SQLException {
        PreparedStatement updateTeam = conexion.prepareStatement("UPDATE team set location = ?");
        updateTeam.setString(1,location);
        updateTeam.executeUpdate();
        updateTeam.close();
    }
    public Object select(String table, String id) throws SQLException{
        PreparedStatement selectTable = conexion.prepareStatement("SELECT * FROM " + table + " WHERE name = ?");
        selectTable.setString(1,id);
        ResultSet result = selectTable.executeQuery();
        Player player = new Player( // AQUI!);
        if (result.next()){
            player.setNombre(result.getString("name"));
            //TODO : acabar de devolver el equipo
        }
        result.close();
        selectTable.close();
        return player;


    }
    public void reset() throws SQLException{
        PreparedStatement resetTeam = conexion.prepareStatement("DELETE FROM team");
        PreparedStatement resetPlayer = conexion.prepareStatement("DELETE FROM player");
        resetPlayer.execute();
        resetTeam.execute();
        resetPlayer.close();
    }
    public void connect() throws SQLException {
        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/basket", "root", "root");
    }

    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }

}