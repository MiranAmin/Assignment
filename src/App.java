

public class App {


    public static void main(String[] args) {
        //works
        ProcessingFiles process = new ProcessingFiles("C:/Users/miran/Desktop/test/test2.txt");
        /*System.out.println("File path: " + process.getFilePath());
        String[] arr = process.getWords();

        System.out.println("Array length " + arr.length);
        process.avgLetterCount();

        System.out.println();
        process.lineCount();
        process.wordCount();
        System.out.println("File content:\n" + process.getFileContent());
    */


        process.mostFrequentLetter();

        }


}
