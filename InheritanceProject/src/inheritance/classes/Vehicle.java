package inheritance.classes;

import java.util.Vector;

public abstract class Vehicle {
    private static int numOfVehicles = 0;
    private int numOfSeats;

    protected Vehicle(int aNumOfSeats) {
        this.numOfSeats = aNumOfSeats;
        Vehicle.numOfVehicles++;
    }
    @Override
    protected final void finalize() {
        System.out.println("Vehicle was deleted!");
        numOfVehicles--;
    }

    public final int getNumOfVehicles() {

        return numOfVehicles;
    }

}
