public class InputCleaner {
/*
    public static void main(String[] args) {
        String str = "C:\\Users\\miran\\Desktop\\test\\test2.txt";


        String cleanPath = str.replaceAll("\\\\", "/" );
        System.out.println(cleanPath);

    }*/

    /*
     * Will ensure the backslash character  is converted into a
     * forward slash so that files are found*/
    public String cleanFilePath(String rawPath) {
        return rawPath.replaceAll("\\\\", "/");
    }

    /*
     * Removes commas and periods from a String
     * and return a new string*/
    public String cleanInput(String input) {
        return input.replaceAll("[.,]", "");

    }

    /*
    * Will split the contents of a string on white spaces
    * and return an array with a word at each index*/
    public String[] splitOnSpaces(String string) {
        return string.split("\\s+");
    }


}
