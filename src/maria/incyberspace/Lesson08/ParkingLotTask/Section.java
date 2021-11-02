package maria.incyberspace.Lesson08.ParkingLotTask;

import java.util.Map;

public class Section {
    private VehicleType vehicleType;
    private ParkingSpaceCount parkingSpaceCount;
    private int parkSpaceCount;

    // Counter variable that's going to be used while looking for parking spaces and also while leaving the parking lot
    int parkedVehicles = 0;

    // Private constructor that instantiates a Section of a certain type
    private Section(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
        if (vehicleType.equals(VehicleType.SEGWAY)) {
            this.parkingSpaceCount = ParkingSpaceCount.SEGWAY;
            parkSpaceCount = parkingSpaceCount.value;
        } else if (vehicleType.equals(VehicleType.SCOOTER)) {
            this.parkingSpaceCount = ParkingSpaceCount.SCOOTER;
            parkSpaceCount = parkingSpaceCount.value;
        } else if (vehicleType.equals(VehicleType.BICYCLE)) {
            this.parkingSpaceCount = ParkingSpaceCount.BICYCLE;
            parkSpaceCount = parkingSpaceCount.value;
        } else if (vehicleType.equals(VehicleType.MOTORCYCLE)) {
            this.parkingSpaceCount = ParkingSpaceCount.MOTORCYCLE;
            parkSpaceCount = parkingSpaceCount.value;
        } else if (vehicleType.equals(VehicleType.SALOONCAR)) {
            this.parkingSpaceCount = ParkingSpaceCount.SALOONCAR;
            parkSpaceCount = parkingSpaceCount.value;
        } else if (vehicleType.equals(VehicleType.VAN)) {
            this.parkingSpaceCount = ParkingSpaceCount.VAN;
            parkSpaceCount = parkingSpaceCount.value;
        } else {
            this.parkingSpaceCount = ParkingSpaceCount.TRUCK;
            parkSpaceCount = parkingSpaceCount.value;
        }
    }

    // A method that creates all 7 sections of this parking lot and adds them into a map structure
    // Kind of similar to a singleton pattern, only there are 7 sections to be returned within a map
    public static Map<String, Section> createSections() {

        Section segwaySection = new Section(VehicleType.SEGWAY);
        Section scooterSection = new Section(VehicleType.SCOOTER);
        Section bicycleSection = new Section(VehicleType.BICYCLE);
        Section motorcycleSection = new Section(VehicleType.MOTORCYCLE);
        Section saloonCarSection = new Section(VehicleType.SALOONCAR);
        Section vanSection = new Section(VehicleType.VAN);
        Section truckSection = new Section(VehicleType.TRUCK);
        return Map.of(
                "Segway" , segwaySection,
                "Scooter", scooterSection,
                "Bicycle", bicycleSection,
                "Motorcycle", motorcycleSection,
                "Saloon Car", saloonCarSection,
                "Van", vanSection,
                "Truck", truckSection
        );
    }

    // Look for a free space in a particular section pertinent to the vehicle type
    public ParkingSpace getParkingSpace() {
        // Park the vehicle of a specified type in an available parking space of the parking section for such vehicles
        for (int i = 0; i < parkSpaceCount; i++) {
            parkedVehicles++; // Used to specify the number of the selected parking space
            parkSpaceCount--;
            System.out.println(vehicleType.toString().charAt(0)
                    + vehicleType.toString().substring(1).toLowerCase()
                    + " parked in space " + parkedVehicles + " in the " + this.vehicleType.toString().toLowerCase() + " section.");
            return new ParkingSpace(this, parkedVehicles);
        }
        // When there aren't any available parking spaces for the specified vehicle
        if (parkSpaceCount == 0) {
            System.out.println("There are no parking spaces left for your " + vehicleType.toString().toLowerCase()
                    + ". Please look for another parking lot.");
        }
        return null;
    }

    // Let the vehicle exit the parking lot
    public void leaveTheLot() {
        // Check that there are parked vehicles in the parking lot
        if (parkedVehicles > 0) {
            for (int i = 0; i < parkedVehicles; i++) {
                parkedVehicles--; // Update the value of parked vehicles
                parkSpaceCount++; // Update the value of available parking spaces for this section
                System.out.println(vehicleType.toString().substring(0, 1)
                        + vehicleType.toString().substring(1).toLowerCase()
                        + ", parked in space " + (parkedVehicles + 1) + " in the "
                        + this.vehicleType.toString().toLowerCase() + " section, left the parking lot.");
            }
        }
    }
}
