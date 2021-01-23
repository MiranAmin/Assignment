import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class ProcessingFiles {

    private final String filePath;
    private final String fileContent;
    private String[] words;

    //rawInput and clean input? Consider changing file content to one of these


    /*
     * Constructor
     * */
    public ProcessingFiles(String filePath) {
        this.filePath = new InputCleaner().cleanFilePath(filePath);
        this.fileContent = readFile();
        cleanAndSplit();
    }


    /*
     * This method counts the words in a text document, separated by white
     * spaces
     * */
    public void wordCount() {
        File file = new File(getFilePath());
        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            int counter = 0;
            while (scanner.hasNext()) {
                scanner.next();
                counter++;
            }
            System.out.println("Number of word in document: " + counter);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
     * Counts each line in a text document excluding lines that are empty
     * in the line count
     * */
    public void lineCount() {
        File file = new File(getFilePath());
        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            int counter = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    counter++;
                }
            }
            System.out.println("Number of lines in document: " + counter);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void avgLetterCount() {
        String[] wordArr = getWords();
        double letterCount = 0;
        for (String word : wordArr) {
            letterCount += word.length();
        }
        System.out.print("Average number of letters: ");
        System.out.printf("%.1f", letterCount / wordArr.length);
        System.out.println();

    }


    /*
     * This method cleans the files contents of commas and periods
     * then splits the input on white spaces and stores
     * each individual word in the String[] field 'words'
     */
    private void cleanAndSplit() { //make this private and use it in another method?
        setWords(new InputCleaner().splitOnSpaces(getFileContent()));
    }//add a line in here to set up the fileContent field --- make three different methods and put them into one?



    /*
     * Will read the contents from a file and will return the contents
     * of that file as a string without the commas or periods.
     *
     * return type: String
     * */

    private String readFile() {
        String str = "";
        try (FileInputStream fis = new FileInputStream(getFilePath())) {
            str = new InputCleaner().cleanFileContents(new String(fis.readAllBytes()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return str;
    }


    /*Prints the contents of the file to the console
     * */
    public void printFileContent() {
        System.out.println(getFileContent());
    }


    /*
     * Getters and Setters
     * */
    public String getFilePath() {
        return filePath;
    }

    public String[] getWords() {
        return words;
    }

    public String getFileContent() {
        return fileContent;
    }

    private void setWords(String[] words) {
        this.words = words;
    }

}
