import java.io.FileInputStream;
import java.io.IOException;

/*
 * The purpose of this class is to store the details about a file
 * that will have statistical operations performed on it.
 * */


public class FileDetails {

    private final String filePath;
    private final String fileContent;
    private final String[] individualWords;
    private final Cleaner cleaner;

    /*
     * CONSTRUCTOR
     * The InputCleaner object is used to clean the given String argument.
     * The contents of the file are read, cleaned and stored in fileContent field.
     * Each individual word from the file is stored in the array individualWords[]
     * @param filePath- A String that represents the given file path
     * */
    public FileDetails(String filePath) {
        this.cleaner = Cleaner.getInstance();
        this.filePath = cleaner.backSlashToForwardSlash(filePath);
        this.fileContent = readFile(filePath);
        this.individualWords = cleaner.splitOnSpaces(fileContent);
    }


    //Returns the fileContent field as a String without any spaces between each word.
    public String contentWithoutSpaces() {
        return cleaner.removeSpace(this.fileContent);
    }

    /*
     * Contents of a file are read and any non-alphabetical characters
     * are removed. This is returned as a String to the fileContent field
     * @param path - A String that represents the file path
     * */
    private String readFile(String path) {
        String str = "";
        try (FileInputStream fis = new FileInputStream(path)) {
            str = this.cleaner.removeNonAlphabetical(new String(fis.readAllBytes()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return str;
    }

    // Getters
    public String getFilePath() {
        return filePath;
    }

    public String[] getIndividualWords() {
        return individualWords;
    }

}
