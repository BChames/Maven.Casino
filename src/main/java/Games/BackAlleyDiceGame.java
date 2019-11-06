package Games;

import GameComponents.Dice;
import io.zipcoder.casino.MainApplication.Console;

import java.util.ArrayList;
import java.util.Collections;

public class BackAlleyDiceGame {
    ArrayList<Integer> diceHand = new ArrayList<>();

    Dice dice = new Dice(3);
    Boolean isWinner = null;
    Integer playerPoints = 0;
    Integer computerPoints = 0;


    public void startBackAlley() {
        String s = Console.getStringInput("Welcome to BackAlley Dice! \n Press enter to start");
        backAlleyRoll();
    }


    public void backAlleyRoll() {


        diceHand.add(dice.diceToss());
        diceHand.add(dice.diceToss());
        diceHand.add(dice.diceToss());
        System.out.println(diceHand);
        if (!checkForAutoWin()){
            checkForAutoLose();
        }
        if (!checkForAutoLose()){
            checkDoublesWinLose();
        }
        if (checkDoublesWinLose() == "We'll check for points now!" ){
           playerPoints = checkDoublesPoints();
            System.out.println("Your point is" + playerPoints);
        }
        else System.out.println("Dead roll try again");


    }


    public boolean checkForAutoWin() {

        if (diceHand.get(0) == diceHand.get(1) && diceHand.get(1) == diceHand.get(2)) {
            System.out.println("You rolled an automatic win ! Congrats!");
            return true;
        } else if (diceHand.contains(4) && diceHand.contains(5) && diceHand.contains(6)) {
            System.out.println("You rolled an automatic win ! Congrats!");
            return true;
        } else {
            return false;
        }

    }

    public boolean checkForAutoLose() {
        if (diceHand.contains(1) && diceHand.contains(2) && diceHand.contains(3)) {

            System.out.println("You rolled an automatic loss :( Sorry...");
            return true;
        } else return false;
    }

    public String checkDoublesWinLose() {
        for (int i = 1; i < 7; i++) {
            if (Collections.frequency(diceHand, new Integer(i)) == 2) {
                if (Collections.frequency(diceHand, new Integer(1)) == 1) {
                    isWinner = false;
                    return "You rolled an automatic loss :( Sorry...";
                } else if (Collections.frequency(diceHand, new Integer(6)) == 1) {

                    isWinner = true;
                    return "You rolled an automatic win ! Congrats!";
                }

                return  "You got a pair";
            }

        }
        return "We'll check for points now!";
    }

    public Integer checkDoublesPoints() {
        for (int i = 1; i < 7; i++) {
            if (Collections.frequency(diceHand, new Integer(i)) == 2) {
                if (Collections.frequency(diceHand, new Integer(2)) == 1) {
                    return 2;
                } else if (Collections.frequency(diceHand, new Integer(3)) == 1) {
                    return 3;
                } else if (Collections.frequency(diceHand, new Integer(4)) == 1) {
                    return 4;
                } else if (Collections.frequency(diceHand, new Integer(5)) == 1) {
                    return 5;
                }
            }

        }return 0;
    }
}

