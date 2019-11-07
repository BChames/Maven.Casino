package Games;

import GameComponents.Dice;
import io.zipcoder.casino.MainApplication.Console;
import Interfaces.GamblingGame;
import io.zipcoder.casino.MainApplication.MainMenu;

import player.Player;

//import player.CrapsPlayer;
// import player.Player;
//>>>>>>> Craps

import java.util.Scanner;

public class CrapsGame implements GamblingGame {
    Dice dice = new Dice(2);
    Double wager =0.0;
    Player crapsPlayer;
    MainMenu userInput = new MainMenu();

    public CrapsGame (Player casinoPlayer){this.crapsPlayer = casinoPlayer;}

    public void startCraps() {
        addBet();
        firstRoll();
    }
    public void addBet(){
        Scanner scan = new Scanner(System.in);
        wager = Console.getDoubleInput("Welcome to Craps! How much would you like to wager? " + crapsPlayer.getWallet());
        crapsPlayer.setWallet(crapsPlayer.getWallet()-wager);
        Console.print("You have chosen to wager $" + wager + ". Good luck!");
    }

    @Override
    public Double addToBet() {
        return null;
    }

    @Override
    public Double payOut() {
        return  null;
    }
    public void isWinner(){
        crapsPlayer.setWallet(crapsPlayer.getWallet()+wager*2);
        Console.print("Congratulations! You matched your point. You won $" + wager*2 + "\nYour current total is " + crapsPlayer.getWallet());
        continueMenu(crapsPlayer);
    }
    public void isLoser(){
        Console.print("Sorry, you rolled a 7. You lost $" + wager + "\nYour current total is " + crapsPlayer.getWallet());
        continueMenu(crapsPlayer);
    }

    public void firstRoll() {
        Console.getStringInput("\nPress enter to roll the dice");
        int roll = dice.tossAndSum();
        //Console.print(""+roll);
        if (roll == 7 || roll == 11) {
            isWinner();
        } else if (roll == 2 || roll == 3 || roll == 12) {
            isLoser();
        } else {
            int point = roll;
            Boolean keepPlaying = true;
            Console.getStringInput("You rolled a " + roll + ". Press enter to roll the dice.");
            //Match the point to win
            while (keepPlaying) {
                int roll2 = dice.tossAndSum();
                if (roll2 == 7) {
                    isLoser();
                    keepPlaying = false;
                } else {
                    if (roll2 == point) {
                        isWinner();
                        keepPlaying = false;
                    } else {
                        Console.getStringInput("You rolled a " + roll2 + ". Press enter to roll the dice.");
                    }
                }
            }
        }
    }
    private void continueMenu(Player player){
        Integer choice = Console.getIntegerInput("\nWhat would you like to do now?\nPress 1: Continue playing\nPress 2: Go back to Main menu");

        switch (choice){
            case 1:
                startCraps();
                break;
            case  2:

                break;
        }
    }
}
