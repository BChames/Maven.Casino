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

//    @Test
//    public void frequencyTest() {
//        Dice dice = new Dice(3);
//        BackAlleyDiceGame feqTest = new BackAlleyDiceGame();
//        feqTest.diceHand.add(5);
//        feqTest.diceHand.add(1);
//        feqTest.diceHand.add(5);
//        String actual = feqTest.checkDoublesWinLose();
//        String expected = "You rolled an automatic loss :( Sorry...";
//        Assert.assertEquals(expected, actual);
//
//    }
//
//    @Test
//    public void doublesWinTest() {
//        Dice dice = new Dice(3);
//        BackAlleyDiceGame feqTest = new BackAlleyDiceGame();
//        feqTest.diceHand.add(6);
//        feqTest.diceHand.add(1);
//        feqTest.diceHand.add(1);
//        String actual = feqTest.checkDoublesWinLose();
//        String expected = "You rolled an automatic win ! Congrats!";
//        Assert.assertEquals(expected, actual);
//    }
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
}