package maria.incyberspace.Lesson6;

public class Plane {
    class Wing {
        private int weight;

        Wing(int weight) {
            this.weight = weight;
        }

        void print() {
            System.out.println("This wing weighs " + weight + " kg.");
        }
    }
}

class TestPlane {
    public static void main(String[] args) {
        // Instantiate a new Plane object
        Plane somePlane = new Plane();
        // Create a wing object for the plane declared just above
        Plane.Wing wing = somePlane.new Wing(30000);
        wing.print(); // See the info about how much this particular wing weighs
    }
}