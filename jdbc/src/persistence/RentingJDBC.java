/*
 * Clase que se encarga de la persistencia en la BBDD
 */
package persistence;

import model.Car;
import model.City;
import model.Driver;
import model.Rental;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arnau on 02/02/17.
 */
public class RentingJDBC {

    private Connection conexion;

    public RentingJDBC()  {
    }

    public void insertRental(Rental rental) throws  SQLException{
        String insertRental = "insert into rental values(?, ?, ?, ?)";
        PreparedStatement preparedStatement = conexion.prepareStatement(insertRental);
        preparedStatement.setInt(1,rental.getIdrental());
        preparedStatement.setString(2,rental.getCustomer());
        preparedStatement.setString(3,rental.getCar());
        preparedStatement.setString(4,rental.getCity());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void setSalaryDriver(Driver driver, double salary) throws SQLException{
        String updateQuery = "UPDATE driver SET salary= ? WHERE dni= ?";
        PreparedStatement preparedStatement = conexion.prepareStatement(updateQuery);
        preparedStatement.setDouble(1,salary);
        preparedStatement.setString(2,driver.getDni());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public List<Car> getCarsFromDriver(Driver driver) throws SQLException{
        String selectQuery = "SELECT * FROM car WHERE driver = '" + driver.getDni() + "'";
        PreparedStatement preparedStatement = conexion.prepareStatement(selectQuery);
        ResultSet resultSet = preparedStatement.executeQuery(selectQuery);
        ArrayList<Car> carArrayList = new ArrayList<>();

        while (resultSet.next()){
            Car car = new Car();
            car.setIdcar(resultSet.getString("idcar"));
            car.setModel(resultSet.getString("model"));
            car.setCapacity(resultSet.getInt("capacity"));
            car.setDriver(resultSet.getString("driver"));
            carArrayList.add(car);
        }
        resultSet.close();
        preparedStatement.close();
        return carArrayList;
    }

    public List<Rental> getRentalsFromCity(City city) throws SQLException{
        String selectQuery = "SELECT * FROM rental WHERE city = '" + city.getPostalcode() + "'";
        PreparedStatement preparedStatement = conexion.prepareStatement(selectQuery);
        ResultSet resultSet = preparedStatement.executeQuery(selectQuery);
        ArrayList<Rental> rentalArrayList = new ArrayList<>();

        while (resultSet.next()){
            Rental rental = new Rental();
            rental.setIdrental(resultSet.getInt("idrental"));
            rental.setCustomer(resultSet.getString("customer"));
            rental.setCar(resultSet.getString("car"));
            rental.setCity(resultSet.getString("city"));
            rentalArrayList.add(rental);
        }

        resultSet.close();
        preparedStatement.close();
        return rentalArrayList;

    }

    public List<String> getNumberOfCity() throws SQLException{
        String query = "select count(city.postalcode) AS countrent, city.name from city inner join rental where rental.city = city.postalcode GROUP BY city.postalcode";
        PreparedStatement preparedStatement = conexion.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery(query);
        ArrayList<String> arrayList = new ArrayList<>();

        while(resultSet.next()){
            String add = resultSet.getInt("countrent") + " " + resultSet.getString("name");
            arrayList.add(add);
        }

        return arrayList;

    }

    public void conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/renting";
        String usr = "root";
        String pass = "root";
        conexion = DriverManager.getConnection(url,usr,pass);
    }

    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }

}