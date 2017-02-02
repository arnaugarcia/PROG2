/*
 * Fichero de Test de nuestra clase JDBC
 */
package rentingbbdd;

import model.Car;
import model.City;
import model.Driver;
import model.Rental;
import persistence.RentingJDBC;

import java.sql.SQLException;

/**
 * Created by Arnau on 02/02/17.
 */
public class RentingBBDD {

    public static void main(String[] args) {
        RentingJDBC rentingJDBC = new RentingJDBC();
        try {

            rentingJDBC.conectar();
            System.out.println("Estableciendo la conexión con el servidor...");
            Driver driver = new Driver("48102291E","Arnau","692464645",600.0);
            City city = new City("08629","Torrelles de LLobregat");

            //Ejercicio 4
            System.out.println("Implementa un método que permita insertar un alquiler");
            Rental rental = new Rental(2,"Arnau","1","08629");
           // rentingJDBC.insertRental(rental);

            //Ejercicio 5
            System.out.println("Implementa un método que permita modificar el sueldo de un chofer");
            rentingJDBC.setSalaryDriver(driver,7000);

            //Ejercicio 6
            System.out.println("Implementa un método que devuelva la lista de coches que conduce un conductor dado (48102291E)");
            for (Car car : rentingJDBC.getCarsFromDriver(driver)){
                System.out.println(car.toString());
            }

            //Ejercicio 7
            System.out.println("Implementa un método que devuelva los alquileres que se han hecho en una ciudad determinada (08629)");
            for (Rental rental1 : rentingJDBC.getRentalsFromCity(city)){
                System.out.println(rental1.toString());
            }

            //Ejercicio 8
            System.out.println("Implementa un método que devuleva el nombre de la ciudad y el numero de alquileres ordenado de mayor a menor");
            int lenght = rentingJDBC.getNumberOfCity().size();
            for (int i = 0; i<lenght; i++){
                System.out.println(rentingJDBC.getNumberOfCity());
            }
        } catch (SQLException ex) {
            System.out.println("Error con la BBDD: " + ex.getMessage());
        } finally {
            try {
                rentingJDBC.desconectar();
                System.out.println("Conexión cerrada.");
            } catch (SQLException ex) {
                System.out.println("Error al desconectar "+ex.getMessage());
            }
        }
    }

}