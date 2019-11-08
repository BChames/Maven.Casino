package io.zipcoder.casino.MainApplication;

import Games.*;
import player.Player;



public class MainMenu {

    Boolean menuRun = true;
    Player casinoPlayer = new Player();


        public void getMainInputMenu () {

        mainMenuActions(casinoPlayer);
    }

    public void mainMenuActions(Player player) {


        while (menuRun) {
            try {
                Console.println("  _____                          _  _         _____          _             \n" +
                        " / ____|                        | |(_)       / ____|        (_)            \n" +
                        "| |  __ _ __ ___  _   _ _ __   / __)___  __ | |     __ _ ___ _ _ __   ___  \n" +
                        "| | |_ | '__/ _ \\| | | | '_ \\  \\__ \\ \\ \\/ / | |    / _` / __| | '_ \\ / _ \\ \n" +
                        "| |__| | | | (_) | |_| | |_) | (   / |>  <  | |___| (_| \\__ \\ | | | | (_) |\n" +
                        " \\_____|_|  \\___/ \\__,_| .__/   |_||_/_/\\_\\  \\_____\\__,_|___/_|_| |_|\\___/ \n" +
                        "                       | |                                                 \n" +
                        "                       |_|             ");
                Integer input = Console.getIntegerInput(
                        "\nWelcome to the Casino! " +
                                "\nWhere you don't need money, because all you got is time to spend.\n-Brandon Chambers\n\nYour current balance is: $" + casinoPlayer.getWallet() + "\nChoose your game by selecting the corresponding number!" +
                                "\n\n  _____              _    _____                           \n" +
                                " / ____|            | |  / ____|                          \n" +
                                "| |     __ _ _ __ __| | | |  __  __ _ _ __ ___   ___  ___ \n" +
                                "| |    / _` | '__/ _` | | | |_ |/ _` | '_ ` _ \\ / _ \\/ __|\n" +
                                "| |___| (_| | | | (_| | | |__| | (_| | | | | | |  __/\\__ \\\n" +
                                " \\_____\\__,_|_|  \\__,_|  \\_____|\\__,_|_| |_| |_|\\___||___/\n" +
                                "1. Go Fish\n" +
                                "2. Blackjack\n" +
                                "\n" +
                                " _____  _             _____                           \n" +
                                "|  __ \\(_)           / ____|                          \n" +
                                "| |  | |_  ___ ___  | |  __  __ _ _ __ ___   ___  ___ \n" +
                                "| |  | | |/ __/ _ \\ | | |_ |/ _` | '_ ` _ \\ / _ \\/ __|\n" +
                                "| |__| | | (_|  __/ | |__| | (_| | | | | | |  __/\\__ \\\n" +
                                "|_____/|_|\\___\\___|  \\_____|\\__,_|_| |_| |_|\\___||___/\n" +
                                "3. Craps\n" +
                                "4. BackAlley Dice\n\n\n" +
                                "5. Exit Casino");

                switch (input) {
                    case 1:
                        GoFishGame gofish = new GoFishGame();
                        gofish.startGoFish();
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
            }catch(Exception exception){
                Console.println("Dont do that..Please behave and try again.");
                mainMenuActions(player);
            }
        }
    }
        }


