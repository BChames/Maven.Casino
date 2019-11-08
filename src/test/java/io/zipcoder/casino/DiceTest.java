package io.zipcoder.casino;

import GameComponents.Dice;
import org.junit.Test;

import java.util.ArrayList;

public class DiceTest {

    @Test
    public void diceTossTest(){
        ArrayList<Integer> diceHand = new ArrayList<Integer>();
        Dice dice = new Dice(1);
        diceHand.add( dice.diceToss());
        diceHand.add( dice.diceToss());
        diceHand.add( dice.diceToss());
        System.out.println(diceHand);
       }

}
