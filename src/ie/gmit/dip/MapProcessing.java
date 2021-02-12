package ie.gmit.dip;

import java.util.*;
import java.io.*;

/**
 * This class is populating maps with words from selected directories obtained in Input
 * class.
 *
 */
class MapProcessing {
    private static final Map<String, String> mapG1000 = new HashMap<>();
    private static final Set<String> setG1000 = new HashSet<>();
    private static final Map<String, String> thesaurusMap = new HashMap<>();

    public Map<String, String> getMapG1000() {
        return mapG1000;
    }

    public Set<String> getSetG1000() {
        return setG1000;
    }

    public Map<String, String> getThesaurusMap() {
        return thesaurusMap;
    }

    /**
     * This method populates map with the equal keys and values consisting of words
     * extracted from needed document. It is populating a set of 1000 most common
     * words in English at the same time.
     *
     * @param googleWords the source document
     * @throws IOException if the document cannot be found
     */
    public void populateGmapAndGset(String googleWords) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(googleWords))));

            String googleWord = null;

            while ((googleWord = br.readLine()) != null) {
                String googleWordInLC = googleWord.toLowerCase();
                mapG1000.put(googleWordInLC, googleWordInLC); // O(1)
                setG1000.add(googleWordInLC);

            }
            br.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

    }

    /**
     * This method reads words from MobyThesaurus2 document. Words then can be matched
     * with the set of Google's 1000 words, populated in the previous method. The
     * map is populated on the synonymous relation between words in MobyThesaurus2 and
     * Google 1000 words document.
     *
     * @param mobyThesaurus		The source document
     * @throws IOException if the file cannot be found
     */
    public void populateThesaurusMap(String mobyThesaurus) throws IOException {
        try {
            String readWord = null;
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(mobyThesaurus))));

            while ((readWord = br.readLine()) != null) {
                String[] words = readWord.split(",");
                String googleEquivalent = null;

                for (String word : words) {
                    if (setG1000.contains(word)) { // O(1)
                        googleEquivalent = word;
                        break;
                    }
                }
                if (googleEquivalent != null) {
                    addAll(words, googleEquivalent);
                }

            }
            br.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }

    /**
     * Adds all words linked to their equivalent based on their synonymous relation
     *
     * @param words		Words to be stored as keys in this map
     * @param googleWord	Google equivalent for keys
     */
    private void addAll(String[] words, String googleWord) {
        for (String word : words) {
            thesaurusMap.put(word.toLowerCase(), googleWord); // O(1)
        }
    }

}
