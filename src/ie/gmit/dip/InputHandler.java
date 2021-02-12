package ie.gmit.dip;

public interface InputHandler {
    void handleInput(String input) throws Exception;
    String getGoogleEquivalent(String word);
    String prepareOutput (String word, int charsPerLine);
    void printOutput (String word);
}


