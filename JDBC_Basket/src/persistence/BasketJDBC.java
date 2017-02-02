/*
 * Clase que se encarga de la persistencia en la BBDD
 */
package persistence;

import model.EstadisticaDTO;
import model.Player;
import model.Team;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BasketJDBC {

    private Connection conexion;

    public BasketJDBC()  {

    }

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
    public Player selectPlayerByName(String name) throws SQLException{
        PreparedStatement selectTable = conexion.prepareStatement("SELECT * FROM player WHERE name = ?");
        selectTable.setString(1,name);
        ResultSet result = selectTable.executeQuery();
        Player player = new Player();
        if (result.next()){
            player.setNombre(result.getString("name"));
            player.setBornDate(result.getDate("birth").toLocalDate());
            player.setNumberAssists(result.getInt("nassists"));
            player.setNumberBaskets(result.getInt("nbaskets"));
            player.setNumberReboots(result.getInt("nrebounds"));
            player.setPosicion(result.getString("position"));
            player.setTeam(selectTeamByName(result.getString("team")));
        }
        result.close();
        selectTable.close();
        return player;

    }
    public List<Player> selectPlayerByNameLike(String like) throws SQLException{
        PreparedStatement selectTable = conexion.prepareStatement("select * from player WHERE name LIKE '%"+like+"%'");
        ResultSet result = selectTable.executeQuery();
        Player player = new Player();
        ArrayList players = new ArrayList();
        while (result.next()){
            player.setNombre(result.getString("name"));
            player.setBornDate(result.getDate("birth").toLocalDate());
            player.setNumberAssists(result.getInt("nassists"));
            player.setNumberBaskets(result.getInt("nbaskets"));
            player.setNumberReboots(result.getInt("nrebounds"));
            player.setPosicion(result.getString("position"));
            player.setTeam(selectTeamByName(result.getString("team")));
            players.add(player);
        }
        result.close();
        selectTable.close();
        return players;

    }
    public Team selectTeamByName(String name) throws SQLException{
        PreparedStatement selectTable = conexion.prepareStatement("SELECT * FROM team WHERE name = ?");
        selectTable.setString(1,name);
        ResultSet result = selectTable.executeQuery();
        Team team = new Team();
        if (result.next()){
            team.setName(result.getString("name"));
            team.setLocation(result.getString("city"));
            team.setCreationDate(result.getDate("creation").toLocalDate());
        }
        result.close();
        selectTable.close();
        return team;

    }
    public List<Team> selectAllTeams() throws SQLException {
        String query = "select * from team";
        Statement statement = conexion.createStatement();
        ResultSet resultset = statement.executeQuery(query);
        List<Team> teams = new ArrayList<>();
        while (resultset.next()) {
            Team team = new Team();
            team.setName(resultset.getString("name"));
            team.setLocation(resultset.getString("city"));
            team.setCreationDate(resultset.getDate("creation").toLocalDate());
            teams.add(team);
        }
        resultset.close();
        statement.close();
        return teams;
    }
    public List<Player> selectPlayerByBaskets(Integer min, Integer max) throws SQLException {
        String query = "select * from player where nbaskets >= " + min +" && nbaskets <= " + max +"";
        PreparedStatement preparedStatement = conexion.prepareStatement(query);
        ResultSet resultset = preparedStatement.executeQuery(query);
        List<Player> players = new ArrayList<>();
        while (resultset.next()) {
            Player player = new Player();
            player.setNombre(resultset.getString("name"));
            player.setBornDate(resultset.getDate("birth").toLocalDate());
            player.setNumberBaskets(resultset.getInt("nbaskets"));
            player.setNumberAssists(resultset.getInt("nassists"));
            player.setNumberReboots(resultset.getInt("nrebounds"));
            player.setPosicion(resultset.getString("position"));
            player.setTeam(selectTeamByName(resultset.getString("team")));
            players.add(player);
        }
        resultset.close();
        preparedStatement.close();
        return players;
    }
    public List<Player> selectPlayerByAssists(Integer min, Integer max) throws SQLException {
        String query = "select * from player where nassists >= " + min +" && nassists <= " + max +"";
        PreparedStatement preparedStatement = conexion.prepareStatement(query);
        ResultSet resultset = preparedStatement.executeQuery(query);
        List<Player> players = new ArrayList<>();
        while (resultset.next()) {
            Player player = new Player();
            player.setNombre(resultset.getString("name"));
            player.setBornDate(resultset.getDate("birth").toLocalDate());
            player.setNumberBaskets(resultset.getInt("nbaskets"));
            player.setNumberAssists(resultset.getInt("nassists"));
            player.setNumberReboots(resultset.getInt("nrebounds"));
            player.setPosicion(resultset.getString("position"));
            player.setTeam(selectTeamByName(resultset.getString("team")));
            players.add(player);
        }
        resultset.close();
        preparedStatement.close();
        return players;
    }
    public List<Player> selectPlayerByPosition(String posicion) throws SQLException {
        String query = "select * from player where position = '"+ posicion + "'";
        PreparedStatement preparedStatement = conexion.prepareStatement(query);
        ResultSet resultset = preparedStatement.executeQuery(query);
        List<Player> players = new ArrayList<>();
        while (resultset.next()) {
            Player player = new Player();
            player.setNombre(resultset.getString("name"));
            player.setBornDate(resultset.getDate("birth").toLocalDate());
            player.setNumberBaskets(resultset.getInt("nbaskets"));
            player.setNumberAssists(resultset.getInt("nassists"));
            player.setNumberReboots(resultset.getInt("nrebounds"));
            player.setPosicion(resultset.getString("position"));
            player.setTeam(selectTeamByName(resultset.getString("team")));
            players.add(player);
        }
        resultset.close();
        preparedStatement.close();
        return players;
    }
    public List<Player> selectPlayerByBirth(Date date) throws SQLException {
        String query = "select * from player where birth <= '"+ date.toLocalDate() + "'";
        PreparedStatement preparedStatement = conexion.prepareStatement(query);
        ResultSet resultset = preparedStatement.executeQuery(query);
        List<Player> players = new ArrayList<>();
        while (resultset.next()) {
            Player player = new Player();
            player.setNombre(resultset.getString("name"));
            player.setBornDate(resultset.getDate("birth").toLocalDate());
            player.setNumberBaskets(resultset.getInt("nbaskets"));
            player.setNumberAssists(resultset.getInt("nassists"));
            player.setNumberReboots(resultset.getInt("nrebounds"));
            player.setPosicion(resultset.getString("position"));
            player.setTeam(selectTeamByName(resultset.getString("team")));
            players.add(player);
        }
        resultset.close();
        preparedStatement.close();
        return players;
    }

    public List<EstadisticaDTO> selectAllPlayersAvgAndMaxMin() throws SQLException {
        String query = "select position, avg(nbaskets) as avgbaskets, avg(nassists) as avgassists, avg(nrebounds) as avgrebounds, max(nbaskets) as maxbaskets, max(nassists) as maxassists, max(nrebounds) as maxrebounds, min(nbaskets) as minbaskets, min(nassists) as minassists, min(nrebounds) as minrebounds from player group by position";
        PreparedStatement preparedStatement = conexion.prepareStatement(query);
        ResultSet resultset = preparedStatement.executeQuery(query);
        List<EstadisticaDTO> estadisticaDTOList = new ArrayList<>();
        while (resultset.next()){
            EstadisticaDTO estadisticaDTO = new EstadisticaDTO(resultset.getDouble("avgbaskets"),resultset.getDouble("avgassists"),resultset.getDouble("avgrebounds"),resultset.getInt("maxbaskets"),resultset.getInt("maxassists"),resultset.getInt("maxrebounds"),resultset.getInt("minbaskets"),resultset.getInt("minassists"), resultset.getInt("minrebounds"),resultset.getString("position"));
            estadisticaDTOList.add(estadisticaDTO);
        }
        resultset.close();
        preparedStatement.close();
        return estadisticaDTOList;
    }

    public List<EstadisticaDTO> rankingPlayersByBaskets() throws SQLException{
        String query = "select name, nbaskets from player order by nbaskets DESC";
        PreparedStatement preparedStatement = conexion.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery(query);
        List<EstadisticaDTO> estadisticaDTOList = new ArrayList<>();
        while (resultSet.next()){
            EstadisticaDTO estadisticaDTO = new EstadisticaDTO(resultSet.getString("name"),resultSet.getInt("nbaskets"));
            estadisticaDTOList.add(estadisticaDTO);
        }
        resultSet.close();
        preparedStatement.close();
        return estadisticaDTOList;
    }

    public List<Player> getPlayersByPosition(String position) throws SQLException{
        String query = "SELECT * FROM player WHERE position = '" + position + "'";
        PreparedStatement preparedStatement = conexion.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery(query);
        List<Player> playerList = new ArrayList<>();
        while (resultSet.next()){
            Player player = new Player();
            player.setNombre(resultSet.getString("name"));
            player.setBornDate(resultSet.getDate("birth").toLocalDate());
            player.setNumberBaskets(resultSet.getInt("nbaskets"));
            player.setNumberAssists(resultSet.getInt("nassists"));
            player.setNumberReboots(resultSet.getInt("nrebounds"));
            player.setPosicion(resultSet.getString("position"));
            player.setTeam(selectTeamByName(resultSet.getString("team")));
            playerList.add(player);
        }
        resultSet.close();
        preparedStatement.close();
        return playerList;

    }

    public List<Player> getPlayersFromTeamName(String name) throws SQLException{
        String query = "select * from player where team = '" + name + "'";
        PreparedStatement preparedStatement = conexion.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery(query);
        List<Player> playerList = new ArrayList<>();
        while (resultSet.next()){
            Player player = new Player();
            player.setNombre(resultSet.getString("name"));
            player.setBornDate(resultSet.getDate("birth").toLocalDate());
            player.setNumberBaskets(resultSet.getInt("nbaskets"));
            player.setNumberAssists(resultSet.getInt("nassists"));
            player.setNumberReboots(resultSet.getInt("nrebounds"));
            player.setPosicion(resultSet.getString("position"));
            player.setTeam(selectTeamByName(resultSet.getString("team")));
            playerList.add(player);
        }
        resultSet.close();
        preparedStatement.close();
        return playerList;

    }
    public List<Player> getPlayersFromTeamNameAndPosition(String name, String position) throws SQLException{
        String query = "select * from player where team = '" + name + "' && position = '" + position + "'";
        PreparedStatement preparedStatement = conexion.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery(query);
        List<Player> playerList = new ArrayList<>();
        while (resultSet.next()){
            Player player = new Player();
            player.setNombre(resultSet.getString("name"));
            player.setBornDate(resultSet.getDate("birth").toLocalDate());
            player.setNumberBaskets(resultSet.getInt("nbaskets"));
            player.setNumberAssists(resultSet.getInt("nassists"));
            player.setNumberReboots(resultSet.getInt("nrebounds"));
            player.setPosicion(resultSet.getString("position"));
            player.setTeam(selectTeamByName(resultSet.getString("team")));
            playerList.add(player);
        }
        resultSet.close();
        preparedStatement.close();
        return playerList;

    }

    public List<Player> getPlayersBasketsFromTeamName(String name) throws SQLException{
        String query = "select * from player where team = '" + name + "' ORDER BY nbaskets DESC LIMIT 1";
        PreparedStatement preparedStatement = conexion.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery(query);
        List<Player> playerList = new ArrayList<>();
        while (resultSet.next()){
            Player player = new Player();
            player.setNombre(resultSet.getString("name"));
            player.setBornDate(resultSet.getDate("birth").toLocalDate());
            player.setNumberBaskets(resultSet.getInt("nbaskets"));
            player.setNumberAssists(resultSet.getInt("nassists"));
            player.setNumberReboots(resultSet.getInt("nrebounds"));
            player.setPosicion(resultSet.getString("position"));
            player.setTeam(selectTeamByName(resultSet.getString("team")));
            playerList.add(player);
        }
        resultSet.close();
        preparedStatement.close();
        return playerList;
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