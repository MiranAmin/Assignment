public class Main {

    public static void main(String[] args) {

        ProcessingFiles process = new ProcessingFiles("C:\\Users\\miran\\Desktop\\test\\text.txt");

        process.mostFrequentLetter();
        process.wordCount();
        process.avgLetterPerWord();
        process.lineCount();



    }

}
