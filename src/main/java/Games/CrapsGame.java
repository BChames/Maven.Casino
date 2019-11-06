package Games;

import GameComponents.Dice;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.zipcoder.casino.MainApplication.Console;
import jdk.nashorn.internal.ir.WhileNode;

public class CrapsGame{
    Dice dice = new Dice(2);

    public void startCraps() {
            String start = Console.getStringInput("Welcome to Craps! \n Press enter to begin game");
            firstRoll();
        }

    public void firstRoll(){
        String firstRoll = Console.getStringInput("Press enter to roll the dice");
        int roll = dice.tossAndSum();
        System.out.println(""+roll);
        if (roll == 7 || roll == 11){
            System.out.println("You rolled a "+roll+". You win!");
        }
        else if (roll == 2 || roll == 3 || roll == 12){
            System.out.println("You rolled a "+roll+". You lose!");
        }
        else {
            int point = roll;
            Boolean keepPlaying = true;



                String secondRoll = Console.getStringInput("You rolled a " + roll + ". Press enter to roll the dice.");

                //Match the point to win
            while (keepPlaying) {
                int roll2 = dice.tossAndSum();
                //int roll3 = dice.tossAndSum();
                if (roll2 == point) {
                    System.out.println("You rolled a " + roll2 + " and matched your point. You win!");
                    keepPlaying = false;
                }
                if (roll2 == 7) {
                    System.out.println("You rolled a 7. You lose!");
                    keepPlaying = false;
                }
                if (roll2 != point){
                    // roll3 = dice.tossAndSum();
                    String keepRolling = Console.getStringInput("You rolled a " + roll2 + ". Press enter to roll the dice.");
                    /*
                    if (roll3 == point){
                        System.out.println("You rolled a " + roll3 + " and matched your point. You win!");
                        keepPlaying = false;
                    }
                    */
                }

                //Did they win? (roll a 7)

                /*
                if (roll3 == point){
                    System.out.println("You rolled a"+roll3+" and matched your point. You win!");
                    keepPlaying = false;
                }
                else if (roll3 == 7){
                    System.out.println("You rolled a 7. You lose!");
                    keepPlaying = false;
                }
                */

            }
        }
    }
}
