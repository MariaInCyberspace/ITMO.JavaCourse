package maria.incyberspace.Lesson11;

import java.io.File;
import java.io.FilenameFilter;

public class FindByName {
    public static void main(String[] args) {
        // Directory in which to look for the specified file
        String directory = "src/maria/incyberspace/Lesson11";
        String findFile = "SampleFile"; // Filename to look for
        findFileInDirectory(findFile, directory);
    }

    public static void findFileInDirectory(String fileName, String directory) {
        // Construct a File object based on the path given by 'directory' parameter
        File directoryToSearch = new File(directory);
        // 'listFiles' method returns an array of pathnames in this directory filtered by a FilenameFilter
        // FilenameFilter is a Functional Interface, therefore it can be defined as a function
        // This function checks whether the specified filename exists in this directory
        File[] files = directoryToSearch.listFiles((dir, name) -> name.toLowerCase().contains(fileName.toLowerCase()));
        assert files != null;
        for (File file : files) {
            System.out.println("File found: " + file.getName());
        }
    }
}
