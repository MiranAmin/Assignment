/*
 * Main class is here do demonstrate the library
 *  */
public class Main {

    public static void main(String[] args) {

        FileStatistics process = new FileStatistics("C:\\Users\\miran\\Desktop\\test\\text.txt");
        process.wordCount();
        process.lineCount();
        process.avgLetterPerWord();
        process.mostFrequentLetter();

    }

}
