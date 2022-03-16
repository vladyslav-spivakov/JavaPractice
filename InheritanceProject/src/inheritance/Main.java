package inheritance;

import inheritance.classes.*;

import java.util.ArrayList;

public class Main {
    public static void main(String... args) {
        var vehicles = new ArrayList<Vehicle>();
        vehicles.add(new Car("Jaguar"));
        vehicles.add(new Plane("Lviv"));
        vehicles.add(new Plane("Berlin"));

        for( var veh : vehicles) {
            if( veh instanceof Plane) {
                ((Plane) veh).fly();
            } else if( veh instanceof Car) {
                System.out.println("Car was driven: " + ((Car) veh).model + " (" + ((Car) veh).hashCode() + ")");
            }
            System.out.println(veh);
        }


    }
}
