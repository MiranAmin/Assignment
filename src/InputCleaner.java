public class InputCleaner {

    /*
     * This class acts as a helper class to the ProcessingFiles class.
     * It performs regular expressions on String inputs
     *  */

    private static InputCleaner cleaner;


    public static InputCleaner getInstance() {
        if(cleaner == null) {
            cleaner = new InputCleaner();
        }
        return cleaner;
    }

    /*
     * Will ensure the backslash character is converted into a
     * forward slash so that a FileNotFound exception is not thrown
     * as a consequence of illegal slashes
     * */
    public String cleanFilePath(String rawPath) {
        return rawPath.replaceAll("\\\\", "/");
    }

    // removes the white space characters from the string
    public String removeSpace(String str) {
        return str.replaceAll("\\s+", "");
    }

    /*
     * Will split the contents of a string on white spaces
     * and return an array containing each individual word
     * at a unique index in the array
     * */
    public String[] splitOnSpaces(String str) {
        return str.split("\\s+");
    }

    // Removes any non alphabetical letters from the String
    public String cleanFileContents(String str) {
        return str.replaceAll("[^a-zA-Z\\s]", "");
    }


}
