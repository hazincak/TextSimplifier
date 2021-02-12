package ie.gmit.dip;

/**
 * This class implements InputHandler interface therefore it can process input
 * from Scanner and display output in formatted way.
 */
public class CustomInputHandler implements InputHandler {
    MapProcessing processMaps = new MapProcessing();
    StringBuilder sb = new StringBuilder();
    private String preparedOutput;

    /**
     * /** This implemented method from the InputHandler interface is simplifying
     * input from wanted source. It reads the source document, line by line and
     * splitting each line by space or any punctuation mark and converting each splitted word to lowerCase.
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
    @Override
    public void handleInput(String text) {

        String[] words = text.split("([.,!?:;'\"-]|\\s)+");
        for (String eachWord : words) {
            String eachWordInLC = eachWord.toLowerCase();
            String simplifiedWord = processMaps.getMapG1000().getOrDefault(eachWordInLC,
                    getGoogleEquivalent(eachWordInLC)); // O(1)

            prepareOutput(simplifiedWord, 100);
        }
        printOutput(preparedOutput);
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
     * This method cumulates simplified words in a StringBuilder.
     *
     * @param word, simplified word passed as argument for formatting
     * @param charsPerLine, determined by the length of desired lines in the output
     * @return preparedOutput, formatted String ready for printing
     */
    @Override
    public String prepareOutput(String word, int charsPerLine) {

        sb.append(word + " ");

        if (sb.length() > charsPerLine) {
            sb.append("\n");
        }

        preparedOutput = sb.toString();
        return preparedOutput;
    }

    @Override
    public void printOutput(String word) {
        System.out.print(word);

    }

}
