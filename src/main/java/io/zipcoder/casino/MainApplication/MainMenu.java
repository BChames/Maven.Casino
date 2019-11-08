package io.zipcoder.casino.MainApplication;

import Games.BackAlleyDiceGame;
import Games.CrapsGame;
import player.Player;



public class MainMenu {

    Boolean menuRun = true;
    Player casinoPlayer = new Player();


        public void getMainInputMenu () {

        mainMenuActions(casinoPlayer);
    }

    public void mainMenuActions(Player player) {



        while (menuRun) {

            Integer input = Console.getIntegerInput(
                    "\nWelcome to the Casino! " +
                            "\nWhere you don't need money, because all you got is time to spend\n\nYour current balance is: $" + casinoPlayer.getWallet() +
                            "\n\nCARD GAMES\n" +
                            "1. Go Fish\n" +
                            "2. Blackjack\n" +
                            "\n" +
                            "DICE GAMES! \n" +
                            "3. Craps\n" +
                            "4. BackAlley Dice\n\n\n" +
                            "5. Exit Casino");

            switch (input) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    CrapsGame craps = new CrapsGame(player);
                    craps.startCraps();
                    break;
                case 4:
                    BackAlleyDiceGame backalley = new BackAlleyDiceGame(player);
                    backalley.startBackAlley();
                    break;
                case 5:
                    Console.println("Thanks for coming! ");
                    menuRun = false;
                    break;
                default:
                    Console.println("\nInvalid selection. Please try again.");
            }
        }
    }
}
