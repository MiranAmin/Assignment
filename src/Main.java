public class Main {


    /*
    * Main class is here do demonstrate the library
    *  */
    public static void main(String[] args) {

        ProcessingFiles process = new ProcessingFiles("Put file path here");
        process.wordCount();
        process.lineCount();
        process.avgLetterPerWord();
        process.mostFrequentLetter();



    }

}
