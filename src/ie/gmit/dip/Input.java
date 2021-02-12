package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * The Input class represents user input. It contains all directories used for
 * simplifying text. Class encapsulates all variables therefore they cannot be
 * accessed directly and they are protected from unexpected changes. Class
 * provides public accessors.
 */
public class Input {

    private static final String googleWordFile = "resources/google-1000.txt";
    private static final String mobyThessaurus2File = "resources/MobyThesaurus2.txt";

    private String workOfArt;
    private String inputText;

    private Scanner scanner = new Scanner(System.in);

    public static String getGooglewordFile() {
        return googleWordFile;
    }

    public static String getMobythessaurus2File() {
        return mobyThessaurus2File;
    }

    public String getWorkOfArt() {
        return workOfArt;
    }

    public String getInputText() {
        return inputText;
    }

    /*
     * public String acquireFilesForMapping() {
     *
     * return ""; }
     */

    /**
     * Asks user for an input.
     *
     * @return inputText - input from user
     */
    public String acquireInputText() {
        System.out.println("Please enter the text you want to simplify.");
        inputText = scanner.nextLine();
        return inputText;
    }

    /**
     * Asks user to select name file to be simplified.
     *
     * @return workOfArt - returns the path to wanted document.
     */
    public String acquireWorkOfArt() {

        System.out.println("\nAvailable actions:\nPress: ");
        System.out.println("1 - The Gallic Wars by Julius Caesar.");
        System.out.println("2 - The Divine Comedy by Dante Alighieri.");
        System.out.println("3 - The Happy Prince by Oscar Wilde. ");
        System.out.println("4 - The Picture of Dorian Gray by Oscar Wilde.");
        System.out.println("5 - The Poblacht na hÉireann by the Provisional Goverment of the Irish Republic.");
        System.out.println("6 - The Prince by Niccolo Machiavelli.");
        System.out.println("7 - War and Peace by Leo Tolstoy.");
        while (true) {

            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    workOfArt = "resources/DeBelloGallico-Caesar.txt";

                    break;
                case 2:
                    workOfArt = "resources/DivineComedy-Dante.txt";

                    break;

                case 3:
                    workOfArt = "resources/HappyPrince-Wilde.txt";

                    break;
                case 4:
                    workOfArt = "resources/PictureOfDorianGray-Wilde.txt";

                    break;
                case 5:
                    workOfArt = "resources/PoblachtNaHEireann.txt";

                    break;

                case 6:
                    workOfArt = "resources/ThePrince-Machiavelli.txt";

                    break;

                case 7:
                    workOfArt = "resources/WarAndPeace-Tolstoy.txt";

                    break;

            }
            return workOfArt;
        }

    }

    /**
     * Displays README document
     */
    public void displayReadMe() {
        try {
            FileReader reader = new FileReader(
                    "C:\\\\Users\\\\janha\\\\eclipse-workspace\\\\GMIT-TextParserProject\\\\src\\README.TXT.");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
