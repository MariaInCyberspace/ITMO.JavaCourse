package Lesson6;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Building {
    private int storeysNum;
    private int yearOfCompletion;
    private String name;

    // Getters and setters for the fields
    public int getStoreysNum() {
        return storeysNum;
    }

    public void setStoreysNum(int storeysNum) {
        this.storeysNum = storeysNum;
    }

    public int getYearOfCompletion() {
        return yearOfCompletion;
    }

    public void setYearOfCompletion(int yearOfCompletion) {
        this.yearOfCompletion = yearOfCompletion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Default constructor
    Building() {

    }

    // Constructor with parameters
    Building(String name, int yearOfCompletion, int storeysNum) {
        this.name = name;
        this.yearOfCompletion = yearOfCompletion;
        this.storeysNum = storeysNum;
    }

    public String printInfo() {
        return this.toString();
    }

    public int yearsSinceCompletion() {
        Calendar current = Calendar.getInstance();
        int currentYear = current.get(Calendar.YEAR);
        return currentYear - yearOfCompletion;
    }

    @Override
    public String toString() {
        return this.name +
                " number of storeys: " + storeysNum +
                ", year of completion: " + yearOfCompletion +
                ", name: '" + name + '\'';
    }
}

class TestBuilding {
    public static void main(String[] args) {
        // Using setters to set the fields
        Building building = new Building();
        building.setName("Chrysler Building");
        building.setYearOfCompletion(1930);
        building.setStoreysNum(77);

        System.out.println(building.printInfo());
        System.out.println(building.getName() + " has been standing for "  + building.yearsSinceCompletion() + " years.");

        // Using a constructor to set all the fields at once
        Building library = new Building("Livraria Lello", 1881, 2);
        System.out.println(library.printInfo());
        System.out.println(library.getName() + " has been standing for " + library.yearsSinceCompletion() + " years.");
    }
}
