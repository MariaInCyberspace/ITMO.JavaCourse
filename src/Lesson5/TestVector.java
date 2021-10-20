package Lesson5;

import java.util.Arrays;

public class TestVector {
    public static void main(String[] args) {

        // Testing Vector class created as a Lesson 5 assignment

        // Instantiate and initialize two Vector objects needed to perform some operations on
        Vector vector = new Vector(3,4, 1);
        Vector vector1 = new Vector(3, 2, -5);

        // Calculate the lengths of the Vector objects declared above
        double magnitude1 = vector.calculateMagnitude();
        double magnitude2 = vector1.calculateMagnitude();

        // Find the scalar (dot) product of those vectors
        double dotProduct1 = vector.findDotProduct(vector1);
        System.out.println("Dot product of those vectors is: " + dotProduct1);

        // Find the vector product of the vectors
        Vector crossProduct = vector.findCrossProduct(vector1);
        System.out.println(crossProduct);

        // Find the angle between vectors
        double angleBetweenVectors = vector.findAngleBetween(vector1);
        System.out.println("Angle between the vectors is: " + angleBetweenVectors);

        // Add another vector to one of the initially declared ones
        Vector plusAnother = vector.addAnother(new Vector(2, 3, -4));
        System.out.println(plusAnother);

        // Subtract another vector from one of the initially declared
        Vector minusAnother = vector1.subtractAnother(new Vector(-2, 4, 3));
        System.out.println(minusAnother);

        // Use the static method of Vector class to generate an array of random vectors of a given size
        Vector[] randomVectors = Vector.generateRandomVectorArray(3);
        System.out.print(Arrays.toString(randomVectors));

    }
}
