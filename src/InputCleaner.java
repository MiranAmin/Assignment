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


    public static void main(String[] args) {
        String h = "hello these are some words";
        String[] arr = h.split("\\s+");
        for (String a : arr) {
            System.out.println(a);
        }
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

    // Removes any non alphabetical letters from the String
    public String cleanFileContents(String str) {
        return str.replaceAll("[^a-zA-Z\\s]", "");
    }


}
