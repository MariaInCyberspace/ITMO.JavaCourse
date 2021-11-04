package maria.incyberspace.Lesson11;

import java.io.*;

public class CopyFileByteByByte {
    public static void main(String[] args) throws IOException {
        // File to be copied
        File file = new File("src/maria/incyberspace/Lesson11/SampleFile.txt");
        // Copy file to the specified directory
        copyFileByteByByte(file, "src/maria/incyberspace/Lesson11/SampleFileCopy.txt");
    }

    public static void copyFileByteByByte(File file, String path) throws NullPointerException {
        File copy = new File(path); // New file in the specified directory
        try (FileInputStream input = new FileInputStream(file)) { // Try with resources of a FileInputStream from the specified file
            try (FileOutputStream output = new FileOutputStream(copy)) { // Try with resources of a FileOutputStream
                int b; // Will hold the value of a byte 'read()' method returns
                while ((b = input.read()) != -1) { // Read till the end of the file
                    output.write(b); // Add this byte to the file output stream
                }
            }
        } catch (SecurityException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
