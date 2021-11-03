package maria.incyberspace.Lesson11;

import java.io.*;

import static maria.incyberspace.Lesson11.ReadTextFile.readTextFile;

public class AppendToFile {
    public static void main(String[] args) {
        File file = new File("src/maria/incyberspace/Lesson11/SampleFile.txt");
        addToFile(file, "\nHello there!");
        System.out.println(readTextFile(file));
    }

    public static void addToFile(File file, String addMe) throws NullPointerException {
        // Construct a new FileWriter object, giving it a file to write and indicating that we want to append to the file and not overwrite it
        try (FileWriter fileWriter = new FileWriter(file, true)) { // fileWriter.close() called automatically when using this syntax
            fileWriter.append(addMe); // Append specified string to the file
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
