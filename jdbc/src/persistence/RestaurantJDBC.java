/*
 * Clase que se encarga de la persistencia en la BBDD
 */
package persistence;

import model.Cocinero;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author mfontana
 */
public class RestaurantJDBC {

    private Connection conexion;

    public RestaurantJDBC()  {
    }

    // Método que recibe un cocinero y lo inserta en la BBDD
    public void insertarCocinero(Cocinero c) throws SQLException {
        String insert = "insert into cocinero values (?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, c.getNombre());
        ps.setString(2, c.getTelefono());
        ps.setString(3, c.getSexo());
        ps.setInt(4, c.getEdad());
        ps.setInt(5, c.getExperiencia());
        ps.setString(6, c.getEspecialidad());
        ps.executeUpdate();
        ps.close();
    }

    public void conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/restaurant";
        String usr = "root";
        String pass = "5933059330";
        conexion = DriverManager.getConnection(url, usr, pass);
    }

    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }

}