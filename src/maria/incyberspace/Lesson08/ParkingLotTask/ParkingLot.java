package maria.incyberspace.Lesson08.ParkingLotTask;

import java.util.Map;

public class ParkingLot {
    private Map<String, Section> sections;

    // Sections get created upon construction of a Parking Lot object
    public ParkingLot() {
        sections = Section.createSections();
    }

    // We look for a free parking space in the section that's specifically made for this type of vehicle and which contains a certain number of parking spaces
    public ParkingSpace findParkingSpaceFor(Vehicle vehicle) {
        VehicleType vehicleType = vehicle.vehicleType;
        ParkingSpace parkingSpace;
        switch (vehicleType) {
            case SEGWAY -> {
                parkingSpace =  sections.get("Segway").getParkingSpace();
                return parkingSpace;
            }
            case SCOOTER -> {
                parkingSpace = sections.get("Scooter").getParkingSpace();
                return parkingSpace;
            }
            case BICYCLE -> {
                parkingSpace = sections.get("Bicycle").getParkingSpace();
                return parkingSpace;
            }
            case MOTORCYCLE -> {
                parkingSpace = sections.get("Motorcycle").getParkingSpace();
                return parkingSpace;
            }
            case SALOONCAR -> {
                parkingSpace =  sections.get("Saloon Car").getParkingSpace();
                return parkingSpace;
            }
            case VAN -> {
                parkingSpace =  sections.get("Van").getParkingSpace();
                return parkingSpace;
            }
            case TRUCK -> {
                parkingSpace =  sections.get("Truck").getParkingSpace();
                return parkingSpace;
            }
            default -> System.out.println("No match");
        }
        return null;

    }

    public void leaveTheParkingLot(Vehicle vehicle) {
        VehicleType vehicleType = vehicle.vehicleType;
        switch (vehicleType) {
            case SEGWAY -> sections.get("Segway").leaveTheLot();
            case SCOOTER -> sections.get("Scooter").leaveTheLot();
            case BICYCLE -> sections.get("Bicycle").leaveTheLot();
            case MOTORCYCLE -> sections.get("Motorcycle").leaveTheLot();
            case SALOONCAR -> sections.get("Saloon Car").leaveTheLot();
            case VAN -> sections.get("Van").leaveTheLot();
            case TRUCK -> sections.get("Truck").leaveTheLot();
            default -> System.out.println("No match");
        }
    }
}
