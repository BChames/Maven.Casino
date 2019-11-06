package io.zipcoder.casino.MainApplication;

import Games.BackAlleyDiceGame;
import Games.CrapsGame;
import Games.DiceGame;
import players.Player;

public class MainMenu {

    public void userMoneyMenu(){

        Integer input = Console.getIntegerInput(
                "\nWelcome to the Casino! " +
                        "\nEnter the amount of money you'd like to risk\n\n");

        Player userPlayer = new Player(input);
        getMainMenu();
    }




    public void getMainMenu() {
        Integer input = Console.getIntegerInput(
                "\nWelcome to the Casino! " +
                        "\nWhere you don't need money, because all you got is time to spend\n\n" +
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
                CrapsGame craps  = new CrapsGame();
                craps.startCraps();
                break;
            case 4:
                BackAlleyDiceGame backalley = new BackAlleyDiceGame();
                backalley.startBackAlley();
                break;
            default:
                Console.println("\nInvalid selection. Please try again.");
        }


    }
}
