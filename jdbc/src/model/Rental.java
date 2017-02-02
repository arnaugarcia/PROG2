package model;

/**
 * Created by Arnau on 02/02/17.
 */
public class Rental {
    private int idrental;
    private String customer;
    private String car;
    private String city;

    public Rental() {

    }

    public Rental(int idrental, String customer, String car, String city) {
        this.idrental = idrental;
        this.customer = customer;
        this.car = car;
        this.city = city;
    }

    public int getIdrental() {
        return idrental;
    }

    public void setIdrental(int idrental) {
        this.idrental = idrental;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "idrental=" + idrental +
                ", customer='" + customer + '\'' +
                ", car='" + car + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
