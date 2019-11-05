package Games;

import org.junit.Test;

import static org.junit.Assert.*;

public class BackAlleyDiceGameTest {

    @Test
    public void startBackAlleyTest() {
        BackAlleyDiceGame gameTest = new BackAlleyDiceGame();
        gameTest.startBackAlley();
    }
}