package maria.incyberspace.Lesson5;

import java.util.Random;

public class Vector {
    // Coordinates fields
    private double xCoordinate;
    private double yCoordinate;
    private double zCoordinate;

    // A constructor that takes 3 arguments and instantiates a Vector object, initializing its three fields with values passed as parameters
    public Vector(double xCoordinate, double yCoordinate, double zCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;
    }

    // An instance method that calculates the length of the Vector object that called it
    public double calculateMagnitude() {
        return Math.sqrt((xCoordinate * xCoordinate) + (yCoordinate * yCoordinate) + (zCoordinate * zCoordinate));
    }

    // An instance method that finds the scalar product two vectors
    public double findDotProduct(Vector vector) {
        return this.xCoordinate * vector.xCoordinate + this.yCoordinate * vector.yCoordinate + this.zCoordinate * vector.zCoordinate;
    }

    // An instance method that finds the vector product of two vectors
    public Vector findCrossProduct(Vector vector) {
        double xCoord = this.yCoordinate * vector.zCoordinate - this.zCoordinate * vector.yCoordinate;
        double yCoord = this.zCoordinate * vector.xCoordinate - this.xCoordinate * vector.zCoordinate;
        double zCoord = this.xCoordinate * vector.yCoordinate - this.yCoordinate * vector.xCoordinate;
        return new Vector(xCoord, yCoord, zCoord);
    }

    // An instance method that finds the angle between two Vectors
    public double findAngleBetween(Vector vector) {
        double dotProd = this.findDotProduct(vector);
        double thisMagnitude = this.calculateMagnitude();
        double otherMagnitude = vector.calculateMagnitude();
        double angle = Math.acos((dotProd / (thisMagnitude * otherMagnitude)));
        return Math.toDegrees(angle);
    }

    // An instance method that adds two vectors
    public Vector addAnother(Vector vector) {
        return new Vector(this.xCoordinate + vector.xCoordinate, this.yCoordinate + vector.yCoordinate,
                this.zCoordinate + vector.zCoordinate);
    }

    // An instance method that subtracts one vector from another
    public Vector subtractAnother(Vector vector) {
        return new Vector(this.xCoordinate - vector.xCoordinate, this.yCoordinate - vector.yCoordinate,
                this.zCoordinate - vector.zCoordinate);
    }

    // A static method that generates a random array of vectors
    public static Vector[] generateRandomVectorArray(int size) {
        Random random = new Random(); // Needed to get a random number
        Vector[] vectors = new Vector[size]; // Instantiate a new array of Vector objects of a varied size
        for (int i = 0; i < vectors.length; i++) { // Populate the array with randomized Vector objects
            vectors[i] = new Vector(random.nextDouble(15), random.nextDouble(15), random.nextDouble(15));
        }
        return vectors;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x-Axis Coordinate=" + xCoordinate +
                ", y-Axis Coordinate=" + yCoordinate +
                ", z-Axis Coordinate=" + zCoordinate +
                '}';
    }
}

