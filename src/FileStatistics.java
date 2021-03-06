import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * This class performs statistical operations on the contents of
 * a file such as counting the total number of words or line in the
 * file.
 *
 * @author Miran Amin
 */

public class FileStatistics {

    private final FileDetails fileDetails;


    // Constructor
    public FileStatistics(String filePath) {
        this.fileDetails = new FileDetails(filePath);
    }


    // Counts the number words in a text document and prints the total number counted.
    public void wordCount() {
        File file = new File(this.fileDetails.getFilePath());
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

    // Count excludes lines that are empty. The total number of lines are printed.
    public void lineCount() {
        File file = new File(this.fileDetails.getFilePath());
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

    //The average number of letters per word is printed to one decimal place.
    public void avgLetterPerWord() {
        String[] wordArr = this.fileDetails.getIndividualWords();
        double letterCount = 0;
        for (String word : wordArr) {
            letterCount += word.length();
        }
        System.out.print("Average number of letters per word: ");
        System.out.printf("%.1f", letterCount / wordArr.length);
        System.out.println();
    }


    /*
     * prints the most frequently reoccurring letter
     * in a string. It does not account for multiple letters that
     * occur an equal amount of times
     * */
    public void mostFrequentLetter() {
        int ASCII_SIZE = 128;
        String str = fileDetails.contentWithoutSpaces().toLowerCase();
        int[] count = new int[ASCII_SIZE];
        int len = str.length();
        for (int i = 0; i < len; i++) {
            count[str.charAt(i)]++;
        }
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

}
