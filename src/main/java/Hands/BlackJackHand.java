package Hands;
import GameComponents.Card;
import Hands.Hand;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BlackJackHand extends Hand{
    Hand hand;
    // public ArrayList hand;
    Integer handValue;
    Map<String, Integer> valueMap = new HashMap();

    public BlackJackHand(Card... cards) {

     //   this.hand = new ArrayList();
    }

    public String getHand() {

        return hand.toString();
    }

    public Integer getHandValue() {

        return handValue;
    }

    public Integer calculateHandValue() {

        return null;
    }

    public Integer getcardValue(String cardValue) {

        return valueMap.get(cardValue);
    }

    public Boolean checkForBust() {
        return null;
    }

    public Integer changeAceValue() {
        return null;

    }
}