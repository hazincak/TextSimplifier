package ie.gmit.dip;

import java.util.Scanner;

/**
 * This class contains a simple menu implementation. The user must follow the
 * instructions from the console.
 */
public class Menu {

    Scanner scanner = new Scanner(System.in);
    Input input = new Input();
    FileInputHandler fileHandler = new FileInputHandler();
    CustomInputHandler textHandler = new CustomInputHandler();

    /**
     * Runs simple console menu.
     */
    public void runMenu() {

        boolean quit = false;
        try {
            System.out.println("\nAvailable actions:\nPress: ");
            System.out.println("1 - to simplify your own text.");
            System.out.println("2 - to simplify one of the great works of literature.");
            System.out.println("3 - to display ReadMe. ");
            System.out.println("4 - to exit a Text Simplifier.");
            while (!quit) {

                int action = scanner.nextInt();

                switch (action) {
                    case 1:
                        input.acquireInputText();
                        textHandler.handleInput(input.getInputText());

                        break;
                    case 2:
                        input.acquireWorkOfArt();
                        fileHandler.handleInput(input.getWorkOfArt());
                        break;
                    case 3:
                        input.displayReadMe();
                        break;
                    case 4:
                        System.out.println("\nThank tou for using a Text Simplifier API.");

                        quit = true;

                }
            }
        } catch (Exception e) {
            System.out.println("Invalid choice. Please press one of the option.");

        }

    }

}
