package players;

import Hands.BlackJackHand;
import Interfaces.GamblingPlayer;
import GameComponents.Card;

public class BlackJackPlayer implements GamblingPlayer {
    Player BlackJackPlayer;
    BlackJackHand hand = new BlackJackHand();

    public BlackJackPlayer(Player player) {

        this.BlackJackPlayer = player;
    }

    public Double placeBet() {
        return null;
    }

    public Card hit() {
        return null;

    }

    public Boolean stay() {
        return null;

    }


}