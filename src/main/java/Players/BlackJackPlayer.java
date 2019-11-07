package Players;

import GameComponents.Deck;
import Hands.BlackJackHand;
import Hands.Hand;
import Interfaces.GamblingPlayer;
import GameComponents.Card;
import Games.BlackJack;

public class BlackJackPlayer implements GamblingPlayer {
    Player BlackJackPlayer;
    BlackJackHand hand = new BlackJackHand();
    ArrayList<Card> dealerHand;//represents the dealer's hand
    public Card.CardValue handValue;//value of the dealer's hand (starts at 0)
    public Card[] aHand;//used to convert the dealer's hand to an array
    public int AceCounter;//counts the aces in the dealer's hand
    Hand dealer;
    Player player;
    Deck deck;
    Deck getRandomCard;

    public BlackJackPlayer(Player player) {

        this.BlackJackPlayer = player;
    }

    public BlackJackPlayer() {
    }

    public Double placeBet() {

        return null;
    }

        public void Card hit() {
        hand.add(deck.drawCard());
        aHand = hand.toArray(aHand);
        handValue = 0;
        for (int i = 0; i < aHand.length; i++) {
            handValue += aHand[i].getCardValue();
            if (aHand[i].getCardValue().equals(11)) {
                AceCounter++;
            }
            while (AceCounter > 0 && handValue > 21) {
                handValue -= 10;
                AceCounter--;
            }

        }
    }


    public void showTopCard () {
        Card[] firstCard = new Card[]{};
        firstCard = hand.toArray(firstCard);
        System.out.println("[" + firstCard[0] + "]");
    }



    public Boolean stay() {
        return null;

    }


    public boolean wantsToHit() {
        if (handValue < 17) {
            return true;
        }
        return false;
    }


    public boolean hasBlackJack() {
        if (hand.size() == 2 && handValue == 21) {
            System.out.println("The dealer has blackjack!");
            return true;
        }
        return false;
    }


    public boolean busted(int handValue) {
        if (handValue > 21) {
            System.out.println("The dealer busted!");
            return true;
        }
        return false;
    }


    public int getHandValue() {

        return handValue;
    }


    public int takeTurn(Deck deck) {
        while (wantsToHit()) {
            System.out.println("The dealer hits");
            Hit(deck);
            if (busted(handValue)) {
                break;
            }
        }
        if (handValue <= 21) {
            System.out.print("The dealer stands.");
        }
        return handValue;
    }

    public void showHand() {

        System.out.println(hand);
    }


    }
}