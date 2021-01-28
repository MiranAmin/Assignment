import java.io.FileInputStream;
import java.io.IOException;

public class FileDetails {

    /*
    * The purpose of this class is to store the details of a file
    * that will have statistical operations performed on it
    * */


    //stores the path to the text file
    private final String filePath;
    //stores the contents of the file as a string
    private final String fileContent;
    //each index will hold each individual word from the file
    private final String[] words;

    // Constructor
    public FileDetails(String filePath) {
        this.filePath = filePath;
        this.fileContent = readFile();
        this.words =  splitOnSpaces();
    }

    /*
     * This method splits the input on white spaces and stores
     * each individual word at a an index in an array
     */
    private String[] splitOnSpaces() {
        return new InputCleaner().splitOnSpaces(this.fileContent);
    }

    /*
     * Will read the contents from a file and will return the contents
     * of that file.
     * */
    private String readFile() {
        String str = "";
        try (FileInputStream fis = new FileInputStream(this.filePath)) {
            str = new  InputCleaner().cleanFileContents(new String(fis.readAllBytes()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return str;
    }

    // Getters and setters
    public String getFilePath() {
        return filePath;
    }

    public String getFileContent() {
        return fileContent;
    }

    public String[] getWords() {
        return words;
    }

}
