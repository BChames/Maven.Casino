package Games;

import GameComponents.Dice;
//<<<<<<< HEAD
//import com.sun.org.apache.xpath.internal.operations.Bool;
import io.zipcoder.casino.MainApplication.Console;
//import jdk.nashorn.internal.ir.WhileNode;
//=======
import Interfaces.GamblingGame;
import Interfaces.GamblingPlayer;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.zipcoder.casino.MainApplication.Console;
import jdk.nashorn.internal.ir.WhileNode;
// import player.CrapsPlayer;
// import player.Player;
//>>>>>>> Craps

import java.util.Scanner;

public class CrapsGame implements GamblingGame {
    Dice dice = new Dice(2);
    //CrapsPlayer crapsPlayer = new CrapsPlayer();
    double betWinnings;
    double wager;
    double winnings;
    double loss;

    public void startCraps() {
        //String addBet = Console.getStringInput("Welcome to Craps! \n Enter the amount you want to bet.");
        addToBet();
            //String start = Console.getStringInput("Press enter to begin game");
            firstRoll();
        }
    @Override
    public Double addToBet() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Craps! How much would you like to wager?");

        wager = scan.nextDouble();
        System.out.println("You have chosen to wager $"+wager+", Good luck!");

        return null;
    }
    @Override
    public Double payOut() {
        return null;
    }

    public void firstRoll(){
        String firstRoll = Console.getStringInput("Press enter to roll the dice");
        int roll = dice.tossAndSum();
        System.out.println(""+roll);
        if (roll == 7 || roll == 11){
            System.out.println("Congratulations! You rolled a "+roll+". You won $"+wager);
        }
        else if (roll == 2 || roll == 3 || roll == 12){
            System.out.println("Sorry, you rolled a "+roll+". You lost $"+wager);
        }
        else {
            int point = roll;
            Boolean keepPlaying = true;
                String secondRoll = Console.getStringInput("You rolled a " + roll + ". Press enter to roll the dice.");
                //Match the point to win
            while (keepPlaying) {
                int roll2 = dice.tossAndSum();
                if (roll2 == point) {
                    System.out.println("Congratulations! You rolled a " + roll2 + " and matched your point. You won $"+wager);
                    keepPlaying = false;
                }
                if (roll2 == 7) {
                    System.out.println("Sorry ,you rolled a 7. You lost $"+wager);
                    keepPlaying = false;
                }
                if (roll2 != point){
                    String keepRolling = Console.getStringInput("You rolled a " + roll2 + ". Press enter to roll the dice.");
                }
            }
        }
    }
}
