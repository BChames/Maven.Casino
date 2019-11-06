package io.zipcoder.casino.MainApplication;

import Games.BackAlleyDiceGame;
import Games.CrapsGame;
import Games.DiceGame;
import player.Player;



public class MainMenu {

    public void userMoneyMenu(){}

    Player casinoPlayer = new Player();


        public void getMainInputMenu () {
            Integer input = Console.getIntegerInput(
                    "\nWelcome to the Casino! " +
                            "\nEnter the amount of money you'd like to risk\n\n");

           // Player userPlayer = new Player(input);
            getMainMenu();
        }




    public void getMainMenu() {
        Integer input = Console.getIntegerInput(
                "What game would you like to play\n" +
                        "CARD GAMES\n" +
                            "1. Go Fish\n" +
                            "2. Blackjack\n" +
                             "\n" +
                        "DICE GAMES! \n" +
                            "3. Craps\n" +
                            "4. BackAlley Dice\n");

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
                BackAlleyDiceGame backalley = new BackAlleyDiceGame(casinoPlayer);
                backalley.startBackAlley();
                break;
            default:
                Console.println("\nInvalid selection. Please try again.");
        }
    }
}
