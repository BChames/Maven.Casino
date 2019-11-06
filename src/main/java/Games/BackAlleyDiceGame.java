package Games;

import GameComponents.Dice;
import Interfaces.GamblingGame;
import Interfaces.GamblingPlayer;
import io.zipcoder.casino.MainApplication.Console;

import java.util.ArrayList;
import java.util.Collections;

    public class BackAlleyDiceGame implements GamblingGame, GamblingPlayer {
        ArrayList<Integer> diceHand = new ArrayList<Integer>();
        private Dice dice = new Dice(3);
        private Integer playerPoints = 0;
        private Integer computerPoints = 0;
        private Double playerBet = 0.0;


        public void startBackAlley() {
            Double playerBet = Console.getDoubleInput("Welcome to BackAlley Dice!\nPlease place your bet. : ");
            backPlayerRoll();
        }


        public void backPlayerRoll() {
            System.out.println(playerBet);
            diceHand.add(dice.diceToss());
            diceHand.add(dice.diceToss());
            diceHand.add(dice.diceToss());
            System.out.println(diceHand);

            checkForAutoWin();
            if (checkForAutoWin()) {
                Console.getStringInput(isWinner());

            }
            checkForAutoLose();
            if (checkForAutoLose()) {
                Console.getStringInput(isLoser());

            }
            checkDoublesWin();
            if (checkDoublesWin()) {
                Console.getStringInput(isWinner());
            }
            checkDoublesLose();
            if (checkDoublesLose()) {
                Console.getStringInput(isLoser());
            }

            checkDoublesPoints();
            if (checkDoublesPoints() > 0) {
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

        public String isWinner() {
            return "CONGRATS YOU WON ! WOO \n You won :" + "Your bet" + playerBet + playerBet * .5 + "\nDon't spend it all in once place :)";

        }

        public String isLoser() {
            return "You lose.. awkward..." + "\nYour bet" + playerBet + "is ours now.....";
        }

        public void backComputerRoll() {
            diceHand.clear();

            diceHand.add(dice.diceToss());
            diceHand.add(dice.diceToss());
            diceHand.add(dice.diceToss());
            System.out.println(diceHand);

            checkForAutoWin();
            if (checkForAutoWin()) {
                Console.getStringInput(isLoser());
            }
            checkForAutoLose();
            if (checkForAutoLose()) {
                Console.getStringInput(isWinner());

            }
            checkDoublesWin();
            if (checkDoublesWin()) {
                Console.getStringInput(isLoser());
            }

            checkDoublesLose();
            if (checkDoublesLose()) {
                Console.getStringInput(isWinner());
            }

            checkDoublesPoints();
            if (checkDoublesPoints() > 0) {
                computerPoints += checkDoublesPoints();
                Console.getStringInput("Computer points : " + computerPoints);
                Console.getStringInput("Computer points: " + computerPoints + "\nPlayer points :" + playerPoints + "\nPress enter to see who won... ");
                Console.getStringInput(isLoser());
            } else if (!checkForAutoWin() && !checkForAutoLose() && !checkDoublesLose() && !checkDoublesWin() && checkDoublesPoints() == 0) {
                System.out.println("Computer has a Dead Roll! Rerolling...");
                diceHand.clear();
                backComputerRoll();
            }
        }

        @Override
        public Double addToBet() {
            return null;
        }

        @Override
        public Double payOut() {
            return null;
        }

        @Override
        public Double placeBet() {
            return null;
        }
    }

