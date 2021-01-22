
import java.io.FileInputStream;

import java.io.IOException;

import java.util.Arrays;


public class App {


    public static void main(String[] args)  {



        try (FileInputStream fis = new FileInputStream("C:/Users/miran/Desktop/test/text.txt")) {

            byte[] b = new byte[fis.available()];
            String rawInput = new String(fis.readAllBytes());
            String cleaner = rawInput.replaceAll("[.,]","");
            System.out.println(cleaner);
            String[] arr = cleaner.split("\\s+");
            System.out.println(Arrays.toString(arr));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



}
