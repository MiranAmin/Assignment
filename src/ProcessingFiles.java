import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class ProcessingFiles {

    private String filePath;
    private String[] words;
    private InputCleaner cleaner; //Singleton??????????




    /*
     * Constructor
     * */
    public ProcessingFiles(String file) {
        this.filePath = new InputCleaner().cleanFilePath(file);
    }


    /*
     * This method counts the words in a text document, separated by white
     * spaces
     * */
    public void wordCount() {

        File file = new File(this.filePath);
        try (Scanner scanner = new Scanner(new FileInputStream(file))) {

            int counter = 0;
            while (scanner.hasNext()) {
                scanner.next();
                counter++;
            }

            System.out.println("Number of word: " + counter);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
     * This method cleans and splits the input --> consider breaking it up into
     separate methods
     */
    public void cleanAndSplit() {

        try (FileInputStream fis = new FileInputStream(this.filePath)) {
            InputCleaner cleaner = new InputCleaner();
            //byte[] b = new byte[fis.available()];
            String rawInput = new String(fis.readAllBytes());
            String cleanInput = cleaner.cleanInput(rawInput);
            //System.out.println(cleanInput);


            String[] arr = cleaner.splitOnSpaces(cleanInput);
            setWords(arr);
            //System.out.println(Arrays.toString(arr));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    /*
     * Counts each line in a text document excluding lines that are empty
     * in the line count
     * */
    public void lineCount() throws FileNotFoundException {

        File file = new File(this.filePath);
        try (Scanner scanner = new Scanner(new FileInputStream(file))) {

            int counter = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    counter++;
                }
            }

            System.out.println("Number of rows: " + counter);
        }
    }

    /*
     * Will simply read from  a file and output its contents
     * to the console
     * */
    public void readFile() {
        try (FileInputStream fr = new FileInputStream(this.filePath)) {

            byte[] b = new byte[fr.available()];
            String str = new String(b);
            System.out.println(str);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
    * Getters and Setters
    * */
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    public InputCleaner getCleaner() {
        return cleaner;
    }

    public void setCleaner(InputCleaner cleaner) {
        this.cleaner = cleaner;
    }
}
