package maria.incyberspace.Lesson8.ParkingLotTask;

public class ParkingSpace {
    // Any parking space has a section it could be found on and a number
    public Section section;
    public int number;

    ParkingSpace(Section section, int number) {
        this.section = section;
        this.number = number;
    }
}
