public class Main {


    /*
    * Main class is here do demonstrate the library
    *  */
    public static void main(String[] args) {

        ProcessingFiles process = new ProcessingFiles("C:\\Users\\miran\\Desktop\\test\\text.txt");
        process.wordCount();
        process.lineCount();
        process.avgLetterPerWord();
        process.mostFrequentLetter();



    }

}
