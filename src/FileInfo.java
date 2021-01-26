public class FileInfo {

    /*
    * The purpose of this class is to store the details of a file
    * that will have statistical processes performed on it
    * */


    //fields
    private final String filePath;
    private String fileContent;
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
