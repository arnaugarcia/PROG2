/*
 * Fichero de Test de nuestra clase JDBC
 */
package restaurantbbdd;

import model.Cocinero;
import persistence.RestaurantJDBC;

import java.sql.SQLException;

/**
 *
 * @author mfontana
 */
public class RestaurantBBDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Instanciamos nuestro gestor
        RestaurantJDBC gestor = new RestaurantJDBC();
        try {
            // Conectamos con la bbdd
            gestor.conectar();
            System.out.println("Estableciendo la conexión con el servidor...");
            Cocinero c = new Cocinero("Karlos Arguiñano", "123456789", "hombre", 63, 44, "Platos principales");
            System.out.println("Insertando cocinero....");
            gestor.insertarCocinero(c);
            System.out.println("Cocinero dado de alta.");
        } catch (SQLException ex) {
            System.out.println("Error con la BBDD: " + ex.getMessage());
        } finally {
            try {
                gestor.desconectar();
                System.out.println("Conexión cerrada.");
            } catch (SQLException ex) {
                System.out.println("Error al desconectar "+ex.getMessage());
            }
        }
    }

}