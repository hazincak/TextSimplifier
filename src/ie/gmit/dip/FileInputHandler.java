package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class implements InputHandler interface therefore it can process input
 * from desired folder and display output in formatted way.
 */
public class FileInputHandler implements InputHandler {

    MapProcessing processMaps = new MapProcessing();
    StringBuilder sb = new StringBuilder();
    private String preparedOutput;

    @Override
    /** This implemented method from the InputHandler interface is simplifying
     * input from wanted source. It reads the source document, line by line and
     * splitting each line by space or any punctuation mark and converting each split word to lowerCase.
     *
     *
     * Depending upon the type of input, the method can be executed in two ways.
     * <p>
     * In the first case, the method is looking for the key in G1000 map, whose
     * associated value is to be returned. If not found, method calls helper method
     * getGoogleEquivalent, which is looking for a key in the ThessaurusMap.

     *
     * @param text the source text obtained from a text scanner.
     */
    public void handleInput(String nameOfBook) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(nameOfBook))));

            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("([.,!?:;'\"-]|\\s)+");
                for (String eachWord : words) {
                    String eachWordInLC = eachWord.toLowerCase();
                    String simplifiedWord = processMaps.getMapG1000().getOrDefault(eachWordInLC,
                            getGoogleEquivalent(eachWordInLC)); // O(1)
                    printOutput(simplifiedWord);
                }

            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method returns simplified word if this map contains a mapping for the specified key.
     * @param word,
     * @return a simplified word found in the ThessaurusMap or custom red coloured word, if not mapped in the map.
     */
    @Override
    public String getGoogleEquivalent(String word) {
        String simplifiedWord;
        if (processMaps.getThesaurusMap().containsKey(word)) { // O(1)
            simplifiedWord = processMaps.getThesaurusMap().get(word); // O(1)
            return simplifiedWord;
        } else {

            return simplifiedWord = ConsoleColour.RED + word + ConsoleColour.RESET;

        }

    }

    /**
     * This method gathers simplified words in a StringBuilder.
     *
     * @param word	 Simplified word passed as argument for formatting
     * @param charsPerLine,
     * @return preparedOutput	Formatted String ready for printing
     */
    @Override
    public String prepareOutput(String word, int charsPerLine) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void printOutput(String output) {
        System.out.println(output);


    }

}
