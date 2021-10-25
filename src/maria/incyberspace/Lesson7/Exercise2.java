package maria.incyberspace.Lesson7;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise2 {
    public static void main(String[] args) {
        // Instantiate and initialize an array of Shape objects
        Shape[] shapes = new Shape[] { new Ball(3, 5), new Pyramid(4, 2, 2),
                new Cylinder(5, 3) };
        // Instantiate and initialize a Box object with a given volume
        Box box = new Box(11);
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

    public Box(double maxVol) {
        super(maxVol); // Instantiates a new Shape object, initializes the 'volume' field with the given value that represents maximum volume of the box
        shapes = new ArrayList<>(); // Initialize an ArrayList to put shapes into
    }

    public void viewContent() { // View the contents of the box
        System.out.println(Arrays.toString(shapes.toArray()));
    }

    public boolean add(Shape shape) {
        controlVolume += shape.volume; // Update the controlVolume variable
        if (controlVolume <= this.volume) { // Check that the volume of the box isn't exceeded
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

    public Shape(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    @Override // To view info about the Shape object
    public String toString() {
        return "'" + this.name +
                ", volume: " + volume + "'";
    }
}

class Pyramid extends Shape {
    double s;
    double h;
    final String name = "Pyramid";

    public Pyramid(double volume, double s, double h) {
        super(volume);
        super.name = name;
        this.s = s;
        this.h = h;
    }
}

class SolidOfRevolution extends Shape {
    protected double radius;

    public SolidOfRevolution(double volume, double radius) {
        super(volume);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

class Cylinder extends SolidOfRevolution {
    double height;
    final String name = "Cylinder";

    public Cylinder(double volume, double radius) {
        super(volume, radius);
        super.name = name;
    }
}

class Ball extends SolidOfRevolution {
    final String name = "Ball";

    public Ball(double volume, double radius) {
        super(volume, radius);
        super.name = name;
    }
}
