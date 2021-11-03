package maria.incyberspace.Lesson11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {
    public static void main(String[] args) {
        File file = new File("src/maria/incyberspace/Lesson11/SampleFile.txt");
        System.out.println(readTextFile(file));
    }

    public static String readTextFile(File file) throws NullPointerException {
        // Create a StringBuilder to append text to
        StringBuilder stringBuilder = new StringBuilder();
        // Initialize BufferedReader of a size specified by the file that was passed as a parameter of this method
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            // Append to the StringBuilder object until there are no more lines in the buffered reader
            String line;
            while ((line = bufferedReader.readLine()) != null)
                stringBuilder.append(line).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
