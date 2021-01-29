/*
 * This class acts as a helper class to the FileDetails class.
 * It performs regular expressions on String inputs.
 * */

public class Cleaner {

    private static Cleaner cleaner;


    /*
    * Singleton design pattern used on InputCleaner object
    * @return InputCleaner
    * */
    public static Cleaner getInstance() {
        if (cleaner == null) {
            cleaner = new Cleaner();
        }
        return cleaner;
    }


    /*
    * Backslash characters are converted into a forward slash
    * @param str - A String with backslashes in it
    * @return String - A String with backslashes replaced by forward slashes
    * */
    public String backSlashToForwardSlash(String str) {
        return str.replaceAll("\\\\", "/");
    }


    /*
    * Removes the white space characters from the string
    * @param str - A String with words separated by spaces
    * @return a String without spaces
    * */
    public String removeSpace(String str) {
        return str.replaceAll("\\s+", "");
    }

    /*
     * Splits the contents of a string on white spaces and return
     * an array containing each word at separate index
     * @param str - A String of containing spaces between words
     * @return String[] - Array with individual words at each index
     * */
    public String[] splitOnSpaces(String str) {
        return str.split("\\s+");
    }


    /*
    * Removes any non alphabetical letters from the String
    * @param str - A String with containing non-aliphatic characters
    * @return String - A String with only spaces and alphabetical characters
    * */
    public String removeNonAlphabetical(String str) {
        return str.replaceAll("[^a-zA-Z\\s]", "");
    }


}
