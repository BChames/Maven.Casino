package Games;

import GameComponents.Dice;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import player.Player;

import static org.junit.Assert.*;

public class CrapsGameTest {
Player casinoPlayer;
@Before
public void setUP () {
    casinoPlayer = new Player();
}
    @Test
    public void autoWinTest() {
        Dice dice = new Dice (2);
        CrapsGame testAutoWin = new CrapsGame(casinoPlayer);
        testAutoWin.dice.tossAndSum();
        Boolean actual = testAutoWin.autoWin();
        assertEquals(false, actual);
    }
    @Test
    public void autoWinTest2() {
        Dice dice = new Dice (2);
        CrapsGame testAutoWin = new CrapsGame(casinoPlayer);
        testAutoWin.dice.tossAndSum();
        Boolean actual = !testAutoWin.autoWin();
        assertEquals(true, actual);
    }
    @Test
    public void autoLoseTest() {
        Dice dice = new Dice (2);
        CrapsGame testAutoLose = new CrapsGame(casinoPlayer);
        testAutoLose.dice.tossAndSum();
        Boolean actual = !testAutoLose.autoLose();
        assertEquals(true, actual);
    }
    @Test
    public void autoLoseTest2() {
        Dice dice = new Dice (2);
        CrapsGame testAutoLose = new CrapsGame(casinoPlayer);
        testAutoLose.dice.tossAndSum();
        Boolean actual = testAutoLose.autoLose();
        assertEquals(false, actual);
    }
}