package io.zipcoder.casino;

import diceGame.Dice;
import org.junit.Test;

public class DiceTest {

    @Test
    public void diceTossTest(){
        Dice dice = new Dice();
        dice.diceToss(3);

    }

}
