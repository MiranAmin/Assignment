public class InputCleaner {

    /*
     * This class acts as a helper class to the ProcessingFiles class.
     * It performs regular expressions on String inputs
     *  */


    /*
     * Will ensure the backslash character  is converted into a
     * forward slash so that files are found
     * */
    public String cleanFilePath(String rawPath) {
        return rawPath.replaceAll("\\\\", "/");
    }


    // Removes any non alphabetical letters from the String
    public String cleanFileContents(String str) {
        return str.replaceAll("[^a-zA-Z]", "");
    }


    // removes the white space characters from the string
    public String removeSpace(String str) {
        return str.replaceAll("\\s+", "");
    }


    /*
     * Will split the contents of a string on white spaces
     * and return an array with a word at each index
     * */
    public String[] splitOnSpaces(String str) {
        return str.split("\\s+");
    }


}
