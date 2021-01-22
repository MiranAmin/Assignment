import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class ProcessingFiles {

    private String filePath;
    private String fileContent;
    private String[] words;
    private InputCleaner cleaner; //Singleton??????????


    /*
     * Constructor
     * */
    public ProcessingFiles(String file) {
        this.filePath = new InputCleaner().cleanFilePath(file);

        this.fileContent = readNewFIle(this.filePath); // This is currently errored out because of readNewFile() -

        cleanAndSplit();
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
     * This method cleans and splits the input
     */
    private void cleanAndSplit() { //make this private and use it in another method?

        try (FileInputStream fis = new FileInputStream(this.filePath)) {

            InputCleaner cleaner = new InputCleaner();
            String rawInput = new String(fis.readAllBytes());
            String cleanInput = cleaner.cleanInput(rawInput);
            String[] arr = cleaner.splitOnSpaces(cleanInput);
            setWords(arr);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    /*
     * Counts each line in a text document excluding lines that are empty
     * in the line count
     * */
    public void lineCount() {

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
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }



    //ISSUE IN TWO METHODS BELOW


    /*
     * Will simply read from  a file and output its contents
     * to the console
     * */
    private String readFile(String path) throws IOException {

        String str;
        try (FileInputStream fr = new FileInputStream(path)) {

            byte[] b = new byte[fr.available()];
            str = new String(b);
        }

        return str;
    }


    public void readNewFIle(String path) {
        //SINGLETON?
        InputCleaner cleaner = new InputCleaner(); //give input cleaner a constructor so it automatically cleans?
        setFilePath(cleaner.cleanFilePath(path));
        try {

            setFilePath(readFile(path));

        } catch (IOException e) {
            System.out.println(e.getMessage());
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


    /*
     * Singleton??
     * */
    public InputCleaner getCleaner() {
        return cleaner;
    }


    public void setCleaner(InputCleaner cleaner) {
        this.cleaner = cleaner;
    }
}
