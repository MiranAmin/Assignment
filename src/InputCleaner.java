public class InputCleaner {

    /*
    * This class acts as a helper class to the ProcessingFiles class.
    * It performs regular expressions on String inputs
    *  */



    /*
     * Will ensure the backslash character  is converted into a
     * forward slash so that files are found*/
    public String cleanFilePath(String rawPath) {
        return rawPath.replaceAll("\\\\", "/");
    }

    /*
     * Removes commas and periods from a String
     * and return a new string*/
    public String cleanFileContents(String str) {
        return str.replaceAll("[.,]", "");
    }

    public String removeSpace(String str) {
        return str.replaceAll("\\s+", "");
    }


    /*
    * Will split the contents of a string on white spaces
    * and return an array with a word at each index*/
    public String[] splitOnSpaces(String str) {
        return str.split("\\s+");
    }


}
