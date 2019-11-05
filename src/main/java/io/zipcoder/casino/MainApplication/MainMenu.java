package io.zipcoder.casino.MainApplication;

public class MainMenu {

    public void getMainMenu() {
        Integer input = Console.getIntegerInput(
                "\nWelcome to the Casino! " +
                        "\nWhere you don't need money, because all you got it time to spend\n\n" +
                        "CARD GAMES\n" +
                            "1. Go Fish\n" +
                            "2. Blackjack\n" +
                             "\n" +
                        "DICE GAMES! \n" +
                            "3. Craps\n" +
                            "4. Street Alley Dice\n");

        mainMenuActions(input);
    }

    private void mainMenuActions(Integer input) {

        switch (input) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                Console.println("\nInvalid selection. Please try again.");
        }


    }
}
