import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class ProcessingFiles {

    private final String filePath;
    private final String fileContent;
    private String[] words;
    private static InputCleaner cleaner;
    //rawInput and clean input? Consider changing file content to one of these


    /*
     * Constructor
     * */
    public ProcessingFiles(String filePath) {
        this.cleaner = setCleaner();
        this.filePath = new InputCleaner().cleanFilePath(filePath);
        this.fileContent = readFile();
        cleanAndSplit();
    }

    private InputCleaner setCleaner() {
        if (getCleaner() == null) {
            return new InputCleaner();
        }
        return cleaner;
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

    /*
    * The average number of letters per word is printed to one decimal place
    * */
    public void avgLetterPerWord() {
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
    * This method will print out the most frequently reoccuring letter
    * in a string. It does not account for multiple letters that
    * occur an equal amount of times*/
    public void mostFrequentLetter() {
        int ASCII_SIZE = 256;
        String str = cleaner.removeSpace(getFileContent().toLowerCase());
        int[] count = new int[ASCII_SIZE];
        int len = str.length();
        for (int i = 0; i < len; i++)
            count[str.charAt(i)]++;
        int max = -1;
        char result = ' ';

        for (int i = 0; i < len; i++) {
            if (max < count[str.charAt(i)]) {
                max = count[str.charAt(i)];
                result = str.charAt(i);
            }
        }
        System.out.println("Most frequently occurring letter: " + result);
    }


    /*
     * This method cleans the files contents of commas and periods
     * then splits the input on white spaces and stores
     * each individual word in the String[] field 'words'
     */
    private void cleanAndSplit() {
        setWords(cleaner.splitOnSpaces(getFileContent()));
    }



    /*
     * Will read the contents from a file and will return the contents
     * of that file as a string without the commas or periods.
     *
     * return type: String
     * */

    private String readFile() {
        String str = "";
        try (FileInputStream fis = new FileInputStream(getFilePath())) {
            str = cleaner.cleanFileContents(new String(fis.readAllBytes()));
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
        return this.words;
    }

    public String getFileContent() {
        return this.fileContent;
    }

    private void setWords(String[] arr) {
        this.words = arr;
    }

    public InputCleaner getCleaner() {
        return cleaner;
    }
}
