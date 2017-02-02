package model;

/**
 * Created by Arnau on 02/02/17.
 */
public class City {

    private String postalcode;
    private String name;

    public City() {

    }

    public City(String postalcode, String name) {
        this.postalcode = postalcode;
        this.name = name;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "postalcode='" + postalcode + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
