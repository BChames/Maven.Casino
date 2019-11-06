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

    while (keepPlaying) {

        String secondRoll = Console.getStringInput("You rolled a " + roll + ". Press enter to roll the dice.");

        //Match the point to win

        int roll2 = dice.tossAndSum();
        if (roll2 == point) {
            System.out.println("You rolled a " + roll2 + " and matched your point. You win!");
            keepPlaying = false;
        }
        //Did they win? (roll a 7)
        else if (dice.tossAndSum() == 7) {
            System.out.println("You rolled a 7. You lose!");
            keepPlaying = false;
        }
    }
}
}
}
