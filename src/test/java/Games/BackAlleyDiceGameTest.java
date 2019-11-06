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
    public void testPoints() {
        Dice dice = new Dice(1);
        BackAlleyDiceGame testingPoints = new BackAlleyDiceGame();
        testingPoints.diceHand.add(1);
        testingPoints.diceHand.add(1);
        testingPoints.diceHand.add(5);
        Integer actual = testingPoints.checkDoublesPoints();
        Integer expected = 5;
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void testDoubleLose(){
        Dice dice = new Dice(1);
        BackAlleyDiceGame testingPoints = new BackAlleyDiceGame();
        testingPoints.diceHand.add(1);
        testingPoints.diceHand.add(5);
        testingPoints.diceHand.add(5);
        Boolean actual = testingPoints.checkDoublesLose();
        Assert.assertEquals(true, actual);
    }
}