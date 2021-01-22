
import java.io.FileInputStream;

import java.io.IOException;

import java.util.Arrays;


public class App {


    public static void main(String[] args) {

        ProcessingFiles process = new ProcessingFiles("C:/Users/miran/Desktop/test/test2.txt");
        process.wordCount();
        String[] arr = process.getWords();
        for (String word : arr) {
            System.out.println(word);
        }

    }


}
