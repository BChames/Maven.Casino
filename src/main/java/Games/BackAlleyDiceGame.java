package Games;

import GameComponents.Dice;
import io.zipcoder.casino.MainApplication.Console;

import java.util.ArrayList;

public class BackAlleyDiceGame {
    ArrayList<Integer> diceHand = new ArrayList<>();
    Dice dice = new Dice(1);

    public void startBackAlley() {
        String s = Console.getStringInput("Welcome to BackAlley Dice! \n Press enter to start");
    }

    public void baFirstRoll() {

        Dice dice = new Dice(1);
        diceHand.add(dice.diceToss());
        diceHand.add(dice.diceToss());
        diceHand.add(dice.diceToss());
        System.out.println(diceHand);
        for (int i = 0; i < diceHand.size(); i++) {
            if (diceHand.contains(4) && diceHand.contains(5) && diceHand.contains(6)) {
                System.out.println("You rolled an automatic win ! Congrats !");
                break;
            }
            else if (diceHand.contains(1) && diceHand.contains(2) && diceHand.contains(3)) {
                System.out.println("You rolled an automatic lose :( Sorry...");
                break;
            }

        }

    }

    public void checkRolls() {
        do{ System.out.println("You rolled an automatic win ! Congrats!");}
        while (diceHand.get(0) == diceHand.get(1) && diceHand.get(1) == diceHand.get(2) );
        while (diceHand.contains(4) && diceHand.contains(5) && diceHand.contains(6));
        while (diceHand.get(0) == diceHand.get(1) && diceHand.contains(6));
        while (diceHand.get(0) == diceHand.get(2) && diceHand.contains(6));
        while (diceHand.get(1) == diceHand.get(2) && diceHand.contains(6));


        do{ System.out.println("You rolled an automatic loss :( Sorry..."); }
        while (diceHand.contains(1) && diceHand.contains(2) && diceHand.contains(3));
        while (diceHand.get(0) == diceHand.get(1) && diceHand.contains(1));
        while (diceHand.get(0) == diceHand.get(2) && diceHand.contains(1));
        while (diceHand.get(1) == diceHand.get(2) && diceHand.contains(1));



    }

}
