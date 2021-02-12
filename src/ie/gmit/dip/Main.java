package ie.gmit.dip;

/**
 * This application allows the user to enter text into a console and dynamically
 * swap every word for its synonym from the Google List of 1 000 most common
 * words in English.
 *

 * @author Jan Hazincak
 * @version V0.1
 *
 *
 */

/**
 * This class starts the application.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        MapProcessing processInput = new MapProcessing();
        Menu menu = new Menu();
        processInput.populateGmapAndGset(Input.getGooglewordFile());
        processInput.populateThesaurusMap(Input.getMobythessaurus2File());

        System.out.println(ConsoleColour.BLUE_BRIGHT);
        System.out.println("***************************************************");
        System.out.println("* GMIT - Dept. Computer Science & Applied Physics *");
        System.out.println("*                                                 *");
        System.out.println("*             Text Simplifier V0.1                *");
        System.out.println("*       (AKA Orwellian Language Compliance)       *");
        System.out.println("*                                                 *");
        System.out.println("***************************************************");

        menu.runMenu();

        System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);

        System.out.println(ConsoleColour.RESET);
    }

}
