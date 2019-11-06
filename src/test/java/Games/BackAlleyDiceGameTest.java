package Games;

import GameComponents.Dice;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BackAlleyDiceGameTest {

    @Test
    public void checkForAutoWin() {
        Dice dice = new Dice (3);
        BackAlleyDiceGame testAutoWin = new BackAlleyDiceGame();
        testAutoWin.diceHand.add(1);
        testAutoWin.diceHand.add(1);
        testAutoWin.diceHand.add(1);
        Boolean actual = testAutoWin.checkForAutoWin();
        Assert.assertEquals(true, actual);

    }
    @Test
    public void checkForAutoWin2() {
        Dice dice = new Dice (3);
        BackAlleyDiceGame testAutoWin = new BackAlleyDiceGame();
        testAutoWin.diceHand.add(4);
        testAutoWin.diceHand.add(6);
        testAutoWin.diceHand.add(5);
        Boolean actual = testAutoWin.checkForAutoWin();
        Assert.assertEquals(true, actual);

    }

    @Test
    public void checkForAutoLose() {
        Dice dice = new Dice (3);
        BackAlleyDiceGame testAutoLose = new BackAlleyDiceGame();
        testAutoLose.diceHand.add(1);
        testAutoLose.diceHand.add(3);
        testAutoLose.diceHand.add(2);
        Boolean actual = testAutoLose.checkForAutoLose();
        assertEquals(true, actual);
    }

    @Test
    public void checkDoublesWin() {
        Dice dice = new Dice (3);
        BackAlleyDiceGame testDoubleWin = new BackAlleyDiceGame();
        testDoubleWin.diceHand.add(4);
        testDoubleWin.diceHand.add(4);
        testDoubleWin.diceHand.add(6);
        Boolean actual = testDoubleWin.checkDoublesWin();
        assertEquals(true, actual);

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

    @Test
    public void testDoublesPoints() {
        Dice dice = new Dice(3);
        BackAlleyDiceGame testingPoints = new BackAlleyDiceGame();
        testingPoints.diceHand.add(1);
        testingPoints.diceHand.add(1);
        testingPoints.diceHand.add(5);
        Integer actual = testingPoints.checkDoublesPoints();
        Integer expected = 5;
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void checkDoublesPoints() {
        Dice dice = new Dice(3);
        BackAlleyDiceGame testingPoints = new BackAlleyDiceGame();
        testingPoints.diceHand.add(2);
        testingPoints.diceHand.add(2);
        testingPoints.diceHand.add(4);
        Integer actual = testingPoints.checkDoublesPoints();
        Integer expected = 4;
        Assert.assertEquals(expected, actual);
    }
}