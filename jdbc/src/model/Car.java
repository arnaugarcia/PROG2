package model;

/**
 * Created by Arnau on 02/02/17.
 */
public class Car {

    private String idcar;
    private String model;
    private int capacity;
    private String driver;

    public Car() {

    }

    public Car(String idcar, String model, int capacity, String driver) {
        this.idcar = idcar;
        this.model = model;
        this.capacity = capacity;
        this.driver = driver;
    }

    public String getIdcar() {
        return idcar;
    }

    public void setIdcar(String idcar) {
        this.idcar = idcar;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Car{" +
                "idcar='" + idcar + '\'' +
                ", model='" + model + '\'' +
                ", capacity=" + capacity +
                ", driver='" + driver + '\'' +
                '}';
    }
}
