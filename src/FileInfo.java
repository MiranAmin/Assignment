public class FileInfo {

    /*
    * The purpose of this class is to store the details of a file
    * that will have statistical processes performed on it
    * */


    //stores the path to the text file
    private final String filePath;
    //stores the text inside the file as a string
    private String fileContent;
    //each index hold each individual word from the file
    private String[] words;


    // Constructor
    public FileInfo(String filePath) {
        this.filePath = filePath;
    }


    // Getters and setters
    public String getFilePath() {
        return filePath;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }
}
