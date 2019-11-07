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
import io.zipcoder.casino.MainApplication.MainMenu;
import jdk.nashorn.internal.ir.WhileNode;
import players.CrapsPlayer;
import players.Player;
//import player.CrapsPlayer;
// import player.Player;
//>>>>>>> Craps

import java.util.Scanner;

public class CrapsGame implements GamblingGame {
    Dice dice = new Dice(2);
    CrapsPlayer crapsPlayer;
    Integer wager;
    MainMenu userInput = new MainMenu();

    public CrapsGame (CrapsPlayer user){
        //this.user = crapsPlayer;
        this.wager = 0;
    }

    public CrapsGame() {

    }

    public void startCraps() {
        addToBet();
        firstRoll();
        continuePlayingMenu();
    }

    private void continuePlayingMenu() {
        Integer input = Console.getIntegerInput("\nDo you want to play again? \n1. Yes \n2. No");
        continueMenu(input);
    }

    @Override
    public Double addToBet() {
        Scanner scan = new Scanner(System.in);
        Console.print("Welcome to Craps! How much would you like to wager?");

        wager = scan.nextInt();

        Console.print("You have chosen to wager $" + wager + ". Good luck!");

        return null;
    }

    @Override
    public Double payOut() {
        return  null;
    }

    public void firstRoll() {
        Console.getStringInput("\nPress enter to roll the dice");
        int roll = dice.tossAndSum();
        //Console.print(""+roll);
        if (roll == 7 || roll == 11) {

            Console.print("Congratulations! You rolled a " + roll + ". You won $" + wager);
        } else if (roll == 2 || roll == 3 || roll == 12) {
            Console.print("Sorry, you rolled a " + roll + ". You lost $" + wager);
        } else {
            int point = roll;
            Boolean keepPlaying = true;
            Console.getStringInput("You rolled a " + roll + ". Press enter to roll the dice.");
            //Match the point to win
            while (keepPlaying) {
                int roll2 = dice.tossAndSum();
                if (roll2 == 7) {
                    Console.print("Sorry, you rolled a 7. You lost $" + wager);
                    keepPlaying = false;
                } else {
                    if (roll2 == point) {
                        Console.print("Congratulations! You rolled a " + roll2 + " and matched your point. You won $" + wager);
                        keepPlaying = false;
                    } else {
                        Console.getStringInput("You rolled a " + roll2 + ". Press enter to roll the dice.");
                    }
                }
            }
        }
    }
    private void continueMenu(Integer input){
        switch (input){
            case 1:
                startCraps();
                break;
            case  2:
                MainMenu main = new MainMenu();
                main.getMainMenu();
                break;
        }
    }
}
