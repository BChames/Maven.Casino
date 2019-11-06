package Players;
import GameComponents.Deck;
import GameComponents.Card;
import Hands.Hand;

import java.util.ArrayList;
import java.util.Arrays;
/*
 * Creates a dealer that the user plays against.
 */
public class Dealer {
    ArrayList<Card> hand;//represents the dealer's hand

    Deck dealerDeck = new Deck();

    public Dealer() {

    }

    public void dealerDeal() {
        dealerDeck.drawCard();
    }
}


