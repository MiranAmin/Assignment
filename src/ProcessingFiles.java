import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class ProcessingFiles {

    // Objects of the FileInfo class and InputCleaner class
    private final FileInfo fileInfo;
    private static InputCleaner cleaner;


    // Constructor
    public ProcessingFiles(String filePath) {
        cleaner = setCleaner();
        fileInfo = new FileInfo(cleaner.cleanFilePath(filePath));

        fileInfo.setFileContent(readFile());

        fileInfo.setWords(splitOnSpaces());
    }

    /*
     * This method counts the words in a text document, separated by white
     * spaces
     * */
    public void wordCount() {
        File file = new File(this.fileInfo.getFilePath());
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
     * Counts each line in a text document excluding lines that
     * are empty in the line count
     * */
    public void lineCount() {
        File file = new File(this.fileInfo.getFilePath());
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
     * The average number of letters per word is printed to one
     * decimal place
     * */
    public void avgLetterPerWord() {
        String[] wordArr = this.fileInfo.getWords();
        double letterCount = 0;
        for (String word : wordArr) {
            letterCount += word.length();
        }
        System.out.print("Average number of letters per word: ");
        System.out.printf("%.1f", letterCount / wordArr.length);
        System.out.println();
    }


    /*
     * This method will print out the most frequently reoccurring letter
     * in a string. It does not account for multiple letters that
     * occur an equal amount of times
     * */
    public void mostFrequentLetter() {
        int ASCII_SIZE = 128;
        String str = cleaner.removeSpace(this.fileInfo.getFileContent().toLowerCase());
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
     * This method splits the input on white spaces and stores
     * each individual word at a an index in an array
     */
    private String[] splitOnSpaces() {
        return cleaner.splitOnSpaces(this.fileInfo.getFileContent());
    }


    /*
     * Will read the contents from a file and will return the contents
     * of that file.
     * */
    private String readFile() {
        String str = "";
        try (FileInputStream fis = new FileInputStream(this.fileInfo.getFilePath())) {
            str = cleaner.cleanFileContents(new String(fis.readAllBytes()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return str;
    }


    //Getters and Setter
    private InputCleaner getCleaner() {
        return cleaner;
    }

    /*
     * Uses the singleton design pattern to create and set
     * an InputCleaner Object
     * */
    private InputCleaner setCleaner() {
        if (getCleaner() == null) {
            return new InputCleaner();
        }
        return cleaner;
    }
}
