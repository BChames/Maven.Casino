package Games;

import GameComponents.Dice;
import io.zipcoder.casino.MainApplication.Console;
import io.zipcoder.casino.MainApplication.MainMenu;
import player.Player;
import java.util.ArrayList;
import java.util.Collections;


    public class BackAlleyDiceGame {


        Player baPlayer;
        ArrayList<Integer> diceHand = new ArrayList<>();
        private Dice dice = new Dice(3);
        private Integer playerPoints = 0;
        private Integer computerPoints = 0;
        private Double playerBet = 0.0;

        public BackAlleyDiceGame(Player casinoPlayer) {
            this.baPlayer = casinoPlayer;
        }

        public void startBackAlley() {
            playerBet = Console.getDoubleInput("Welcome to BackAlley Dice!\n You currently have: " + baPlayer.getWallet() + "\nPlease place your bet : ");
            if (playerBet > baPlayer.getWallet()) {
                Console.println("HAHA... no you don't have that much try again :)\n\n");
                startBackAlley();
            }
            baPlayer.setWallet(baPlayer.getWallet() - playerBet);
            backPlayerRoll();
        }


        public void backPlayerRoll() {
            diceHand.clear();
            diceHand.add(dice.diceToss());
            diceHand.add(dice.diceToss());
            diceHand.add(dice.diceToss());
            Console.println(diceHand.toString());


            if (checkForAutoWin()) {
                isWinner();

            }

            else if (checkForAutoLose()) {
                isLoser();

            }

            else if (checkDoublesWin()) {
                isWinner();
            }

            else if (checkDoublesLose()) {
                isLoser();
            }


            else if (checkDoublesPoints() > 0) {
                playerPoints += checkDoublesPoints();
                Console.getStringInput("Your points : " + playerPoints + "\nThe Computer will now try to beat you. Please press enter");
                backComputerRoll();
            } else if (!checkForAutoWin() && !checkForAutoLose() && !checkDoublesLose() && !checkDoublesWin() && checkDoublesPoints() == 0) {
                System.out.println("Dead Roll! Rerolling...");
                diceHand.clear();
                backPlayerRoll();
            }
        }


        public boolean checkForAutoWin() {

            if (diceHand.get(0) == diceHand.get(1) && diceHand.get(1) == diceHand.get(2)) {
                return true;
            } else if (diceHand.contains(4) && diceHand.contains(5) && diceHand.contains(6)) {
                return true;
            } else {
                return false;
            }

        }

        public boolean checkForAutoLose() {
            if (diceHand.contains(1) && diceHand.contains(2) && diceHand.contains(3)) {
                return true;
            } else return false;
        }

        public boolean checkDoublesWin() {
            for (int i = 1; i < 7; i++) {
                if (Collections.frequency(diceHand, i) == 2) {
                    if (Collections.frequency(diceHand, 6) == 1) {
                        return true;
                    }
                }
            }
            return false;
        }


        public boolean checkDoublesLose() {
            for (int i = 1; i < 7; i++) {
                if (Collections.frequency(diceHand, i) == 2) {
                    if (Collections.frequency(diceHand, 1) == 1) {
                        return true;
                    }
                }
            }
            return false;
        }


        public Integer checkDoublesPoints() {
            Integer points = 0;
            for (int i = 1; i < 7; i++) {
                if (Collections.frequency(diceHand, i) == 2) {
                    if (Collections.frequency(diceHand, 2) == 1) {
                        points = 2;
                    }
                    if (Collections.frequency(diceHand, 3) == 1) {
                        points = 3;
                    }
                    if (Collections.frequency(diceHand, 4) == 1) {
                        points = 4;
                    }
                    if (Collections.frequency(diceHand, 5) == 1) {
                        points = 5;
                    }
                }

            }
            return points;
        }


        public void isWinner() {
            baPlayer.setWallet(baPlayer.getWallet() + (playerBet * 2));

            Console.println("CONGRATS YOU WON ! WOO \n You won :" + "Your bet x2:  " + playerBet * 2 +
                    "\nYour wallet now has: $" + baPlayer.getWallet() +
                    "\nDon't spend it all in once place :)");
            transitionMenu(baPlayer);

        }

        public void isLoser() {
            Console.println("You lose.. awkward..." + "\nYour bet of $" + playerBet + " is ours now....." +
                    "\nYour wallet now has: $" + baPlayer.getWallet());
            transitionMenu(baPlayer);
        }

        public void backComputerRoll() {
            diceHand.clear();
            diceHand.add(dice.diceToss());
            diceHand.add(dice.diceToss());
            diceHand.add(dice.diceToss());
            Console.println(diceHand.toString());

            if (checkForAutoWin()) {
                isLoser();
            }
            else if (checkForAutoLose()) {
                isWinner();

            }
            else if (checkDoublesWin()) {
                isLoser();
            }

            else if (checkDoublesLose()) {
                isWinner();
            }

            else if (checkDoublesPoints() > 0) {
                computerPoints = checkDoublesPoints();
                Console.print("Computer points : " + computerPoints);
                Console.getStringInput("\nDrum roll please...\n" +
                        "                 /\n" +
                        "              __o____\\____\n" +
                        "            /._______o__.\\\n" +
                        "            |'-=-=-=-=-='|\n" +
                        "            |\\  /\\  /\\  /|\n" +
                        "            | \\/  \\/  \\/ |\n" +
                        "            \\'-=-=-=-=-='/\n" +
                        "             `\"\"\"\"\"\"\"\"\"\"`" +
                        "\nPress enter to see who won... ");
                if (computerPoints > playerPoints) {
                    isLoser();
                } else isWinner();;

            } else if (!checkForAutoWin() && !checkForAutoLose() && !checkDoublesLose() && !checkDoublesWin() && checkDoublesPoints() == 0) {
                System.out.println("Computer has a Dead Roll! Rerolling...");
                diceHand.clear();
                backComputerRoll();
            }
        }


        public void transitionMenu(Player player) {
           Integer choice = Console.getIntegerInput("What do you wanna do now?\nPress 1 : Continue Playing" +
                "\n Press 2 : Go back to Main Menu");
            switch (choice) {
                case 1:
                    startBackAlley();
                    break;

                case 2:

                    break;

            }
        }
    }
