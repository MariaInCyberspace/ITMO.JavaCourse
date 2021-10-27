package maria.incyberspace.Lesson7;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise2 {
    public static void main(String[] args) {
        // Instantiate and initialize an array of Shape objects
        Shape[] shapes = new Shape[] { new Ball(8), new Pyramid(4, 2),
                new Cylinder(3, 3) };
        // Instantiate and initialize a Box object with a given volume
        Box box = new Box(2500);
        // Add the shapes into the box
        for (Shape shape : shapes) {
            box.add(shape);
        }
        // See what's stored in the box
        box.viewContent();
    }
}

class Box extends Shape { // Container for shapes

    private double controlVolume; // A private field needed to store the total volume of the Shapes added to the box

    private ArrayList<Shape> shapes; // Instantiate an ArrayList of Shapes to put shapes into

    public Box(double maxVol) { // Instantiates a new Shape object,
        super.volume = maxVol; // initializes the 'volume' field pertinent to the superclass with the given value that represents maximum volume of the box
        shapes = new ArrayList<>(); // Initialize an ArrayList to put shapes into
    }

    public void viewContent() { // View the contents of the box
        System.out.println(Arrays.toString(shapes.toArray()));
    }

    public boolean add(Shape shape) {
        controlVolume += shape.getVolume(); // Update the controlVolume variable
        // Check that the volume of the box isn't exceeded
        if (controlVolume <= super.volume) { // by checking the volume field of our superclass we've initialized in the constructor
            shapes.add(shape);
            return true;
        } else {
            System.out.println("Box volume exceeded. Couldn't put " + shape + " in the box.");
            return false;
        }
    }
}

class Shape {
    protected double volume;
    protected String name = "Shape";

    protected double getVolume() {
        return volume;
    }

    @Override // To view info about the Shape object
    public String toString() {
        return "'" + this.name +
                ", volume: " + volume + "'";
    }
}

class Pyramid extends Shape {
    private double baseArea;
    private double height;
    private final String name = "Pyramid";

    public Pyramid(double baseArea, double height) {
        super.name = name;
        this.baseArea = baseArea;
        this.height = height;
        super.volume = this.getVolume();
    }

    @Override
    public double getVolume() {
        return (baseArea * height) / 3;
    }
}

class SolidOfRevolution extends Shape {
    protected double radius;

    protected double getRadius() {
        return radius;
    }
}

class Cylinder extends SolidOfRevolution {
    private double height;
    private final String name = "Cylinder";

    public Cylinder(double radius, double height) {
        super.radius = radius;
        super.name = name;
        this.height = height;
        volume = this.getVolume();
    }

    @Override
    public double getVolume() {
        return height * Math.PI * Math.pow(radius, 2);
    }
}

class Ball extends SolidOfRevolution {
    private final String name = "Ball";

    public Ball(double radius) {
        super.radius = radius;
        super.name = name;
        volume = this.getVolume();
    }

    @Override
    public double getVolume() {
        return (4 * Math.PI * Math.pow(radius, 3)) / 3;
    }
}
