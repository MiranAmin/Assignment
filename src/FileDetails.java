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
    private final String[] individualWords;
    //object of inputCleaner class
    private final InputCleaner cleaner;


    /*
    * Constructor
    * This constructor creates an object of the InputCleaner class first
    * and then uses this object to clean the file path given to it as an argument.
    * Next, the contents of the file are read, cleaned by readFile() and stored into
    * fileContent field.
    * Finally each individual word from the file is stored in the array individualWords.
    * */
    public FileDetails(String filePath) {
        this.cleaner = InputCleaner.getInstance();
        this.filePath = cleaner.cleanFilePath(filePath);
        this.fileContent = readFile(filePath);
        this.individualWords =  splitOnSpaces();
    }

    /*
    * Returns the fileContent field as a String without any spaces
    * between each word*/
    public String contentWithoutSpaces() {
        return cleaner.removeSpace(this.fileContent);
    }


    /*
     * This method splits the input on white spaces and stores
     * each individual word at a an index in an array
     */
    private String[] splitOnSpaces() {
        return this.cleaner.splitOnSpaces(this.fileContent);
    }

    /*
     * Will read the contents from a file and will return the contents
     * of that file.
     * */
    private String readFile(String input) {
        String str = "";
        try (FileInputStream fis = new FileInputStream(input)) {
            str = this.cleaner.cleanFileContents(new String(fis.readAllBytes()));
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
