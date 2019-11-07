package Games;

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
    public void startCraps() {
        CrapsGame crapsGameTest = new CrapsGame(casinoPlayer);
        crapsGameTest.startCraps();
    }

    @Test
    public void firstRoll() {
    }
}