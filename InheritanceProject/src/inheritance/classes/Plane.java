package inheritance.classes;

import java.util.Objects;

final public class Plane extends Vehicle {
    private String city;

    public Plane(String aCity) {
        super(20);
        this.city = aCity;
    }

    public void fly() {
        System.out.println("Plane is flying to " + city + " (" + this.hashCode() + ")");
    }

    @Override
    public int hashCode() {
        return Objects.hash(city,super.getNumOfVehicles());
    }

    public String toString() {
        return "Plane from " + city;
    }

}
