package io.zipcoder.casino;

import GameComponents.Dice;
import org.junit.Test;

import java.util.ArrayList;

public class DiceTest {

    @Test
    public void diceTossTest(){
        ArrayList<Integer> diceHand = new ArrayList<>();
        Dice dice = new Dice();
        diceHand.add( dice.diceToss());
        diceHand.add( dice.diceToss());
        diceHand.add( dice.diceToss());
        System.out.println(diceHand);
       }

}