package Lesson6;

// Ex. 1
// Adding a constructor and testing its functionality

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Study {

    private String course;

    public String printCourse() {
        return this.course;
    }

    Study(String course) {
        this.course = course;
    }

}

class JavaProgram {
    public static void main(String[] args) {
        Study studySomething = new Study("Learning Java's easy peasy lemon squeezy!..");
        System.out.println(studySomething.printCourse());
    }
}