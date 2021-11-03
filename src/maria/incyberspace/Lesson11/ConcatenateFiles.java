package maria.incyberspace.Lesson11;

import java.io.*;

public class ConcatenateFiles {
    public static void main(String[] args) {
        // Two files to concatenate
        File file = new File("src/maria/incyberspace/Lesson11/anotherTextFile.txt");
        File file2 = new File("src/maria/incyberspace/Lesson11/SampleFile.txt");
        // Concatenate the files and save the result to a separate file
        concatenateFiles(file, file2, "src/maria/incyberspace/Lesson11/Concatenated.txt");
    }

    // The method takes 3 arguments: 2 files to be concatenated and a path for where to save the result
    public static File concatenateFiles(File file, File concatMe, String pathName) throws NullPointerException {
        File newFile = new File(pathName); // new file to append to
        // FileWriter based on the new file to append to
        try (FileWriter fileWriter = new FileWriter(newFile, true)) { // boolean indicates that we want to append to the file and not overwrite it
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) { // BufferedReader for the first file
                StringBuilder stringBuilder = new StringBuilder(); // StringBuilder for the first file
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n"); // Append to the StringBuilder
                }
                fileWriter.append(stringBuilder); // Append to the FileWriter object for the new file
            }
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(concatMe))) { // BufferedReader for the second file
                StringBuilder stringBuilder = new StringBuilder(); // StringBuilder for the second file
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n"); // Append to the StringBuilder
                }
                fileWriter.append(stringBuilder); // Append to the FileWriter object for the new file
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return newFile;
    }
}
