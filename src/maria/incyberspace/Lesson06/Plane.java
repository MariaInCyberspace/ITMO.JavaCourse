package maria.incyberspace.Lesson06;

// Ex. 4
// Create an outer Plane class with an inner Wing subclass

public class Plane {
    class Wing {
        private int weight;

        // Constructor for the Wing class
        public Wing(int weight) {
            this.weight = weight;
        }

        // A method that logs information about the weight of a particular plane wing to the console
        public void print() {
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