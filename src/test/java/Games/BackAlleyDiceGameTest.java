package Games;

import GameComponents.Dice;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BackAlleyDiceGameTest {

    @Test
    public void startBackAlleyTest() {
        BackAlleyDiceGame gameTest = new BackAlleyDiceGame();
        gameTest.startBackAlley();
    }
    @Test
    public void frequencyTest() {
        Dice dice = new Dice();
        BackAlleyDiceGame feqTest = new BackAlleyDiceGame();
        feqTest.diceHand.add(5);
        feqTest.diceHand.add(5);
        feqTest.diceHand.add(1);
        String actual =  feqTest.frequencyCheck();
        String expected = "You rolled an automatic loss :( Sorry...";
        Assert.assertEquals(expected, actual);

    }
}