package inheritance.classes;

import java.util.Objects;

final public class Car extends Vehicle{
    public String model;

    public Car(String aModel){
        super(2);
        this.model = aModel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(model,super.getNumOfVehicles());
    }

    public String toString() {
        return "Car " + model;
    }
}
