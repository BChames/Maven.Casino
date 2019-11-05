package diceGame;

import java.util.ArrayList;

public class Dice {
    int numOfDice = 0;
    String diceHolder ="" ;
    ArrayList<Integer> diceResult = new ArrayList<>();


    public void Dice (int numOfDice){
        this.numOfDice = numOfDice;
    }
    // constructor

    public String diceToss(int numOfDice){
        for (int i =  1; i <= numOfDice ; i++) {
            diceHolder += (int) (Math.random() * 6 + 1);
            System.out.println(diceHolder);
        }return diceHolder;

    }

}
