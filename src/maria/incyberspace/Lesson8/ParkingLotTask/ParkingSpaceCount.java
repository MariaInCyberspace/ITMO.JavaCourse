package maria.incyberspace.Lesson8.ParkingLotTask;

public enum ParkingSpaceCount {
    SEGWAY(10),
    SCOOTER(20),
    BICYCLE(20),
    MOTORCYCLE(20),
    SALOONCAR(50),
    VAN(15),
    TRUCK(10);

    public int value;
    ParkingSpaceCount(int i) {
        value = i;
    }
}
