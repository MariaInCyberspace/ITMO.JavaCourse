package maria.incyberspace.Lesson08.ParkingLotTask;

import java.util.ArrayList;
import java.util.List;

public class Question {
    public static void main(String[] args) {
        // Instantiate and initialize a new Parking Lot object
        // Its constructor also creates all 7 sections of the lot pertaining to different vehicle types and having specified number of parking spaces
        // So when a 'findParkingSpace' method is called, only a particular section of the parking lot will be checked
        ParkingLot parkingLot = new ParkingLot();
        // Instantiate a new list of vehicles to be filled with some vehicles in the for-loop just below
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < AssortedMethods.randomIntInRange(15, 30); i++) {
            if (i < 5) {
                vehicles.add(new Motorcycle());
            } else if (i > 5 && i < 10) {
                vehicles.add(new SaloonCar());
            } else if (i > 10 && i < 20) {
                vehicles.add(new Van());
            }

        }
        // Find parking spaces for the vehicles
        for (Vehicle vehicle : vehicles) {
            parkingLot.findParkingSpaceFor(vehicle);
        }
        // Some parked vehicles want to leave the lot
        for (int i = 0; i < vehicles.size() / 2; i++) {
            parkingLot.leaveTheParkingLot(vehicles.get(i));
        }
    }
}
