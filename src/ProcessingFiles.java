import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ProcessingFiles {


    /*
     * This method counts the words in a text document, separated by white
     * spaces
     * */

    public void wordCount() throws FileNotFoundException {

        File file = new File("C:/Users/miran/Desktop/test/test2.txt");
        try (Scanner scanner = new Scanner(new FileInputStream(file))) {

            int counter = 0;
            while (scanner.hasNext()) {
                scanner.next();
                counter++;
            }

            System.out.println("Number of word: " + counter);
        }
    }


    /*
     * Counts each line in a text document excluding lines that are empty
     * in the word count
     * */
    public void lineCount() throws FileNotFoundException {

        File file = new File("C:/Users/miran/Desktop/test/test2.txt");
        try (Scanner scanner = new Scanner(new FileInputStream(file))) {

            int counter = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(!line.isEmpty()) {
                    counter++;
                }
            }

            System.out.println("Number of rows: " + counter);
        }
    }

    /*
    * Will read a file
    * */
    public void readFile() {
        try (FileInputStream fr = new FileInputStream("C:/Users/miran/Desktop/test/text.txt")) {

            byte[] b = new byte[fr.available()];
           // fr.read(b);
            String str = new String(b);
            System.out.println(str);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
