package Hands;

import GameComponents.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hand {

    List<Card> cardsInHand;

    public Hand() {
        this.cardsInHand = new ArrayList<Card>();
    }

    public void discardCard(Card card) {
        for(int i = 0 ; i < cardsInHand.size(); i++){
            Card inHand = cardsInHand.get(i);
            if(inHand.equals(card)){
                cardsInHand.remove(inHand);
            }
        }
    }

    public void clearAllCardsInHand() {
        cardsInHand.clear();
    }

    public void addCardToHand(Card card){
        cardsInHand.add(card);
    }

    public int getNumberOfCardsInHand() {
        return cardsInHand.size();
    }

    public Card getRandomCard() {
        Random random = new Random();

        int randomIdx = random.nextInt(cardsInHand.size());
        return cardsInHand.get(randomIdx);
    }

    public boolean manageDuplicateCards() {
        boolean foundMatch = false;
        int i = 0;
        while(i < cardsInHand.size()) {
            foundMatch = false;
            Card cardTobeMatched = cardsInHand.get(i);
            for (int j = i + 1; j < cardsInHand.size(); j++) {
                foundMatch = removeMatchingCards(cardTobeMatched, cardsInHand.get(j));
                if (foundMatch) {
                    break;
                }
            }
            if(!foundMatch) {
                i++;
            }
        }
        return foundMatch;
    }

    private boolean removeMatchingCards(Card card1, Card card2) {
        boolean matchfound = false;
        if (card1.equals(card2)) {
            cardsInHand.remove(card1);
            cardsInHand.remove(card2);
            matchfound = true;
        }
        return matchfound;
    }


    public void removeCardFromHand(Card card) {
        cardsInHand.remove(card);
    }

    public boolean hasCard(Card card) {
        return cardsInHand.contains(card);
    }

    public List<Card> getHandCards() {
        return new ArrayList<Card>(this.cardsInHand);
    }

    public static void main(String[] args) {
        // write your code here
    }
    public void showPlayerCardValues() {
        System.out.println("^Your cards are");
        System.out.println(cardsInHand);

    }
    //Print the dealers card values
    public void showDealerCardValues() {
        System.out.println("^Dealer cards are");
        System.out.println(cardsInHand);

    }

    //sum of players total cards
    public int printCurrentHand() {
        int handValue = 0;

        for (int i = 0; i < cardsInHand.size(); i++) {
            if (cardsInHand.get(i) != null) {
                handValue += cardsInHand.get(i).getCardValue();
            }

        }
        System.out.println( "Your total cards are " + handValue);
        return handValue;
    }

    //sum of players total cards
    public int sumOfCurrentHand() {
        int handValue = 0;

        for (int i = 0; i < cardsInHand.size(); i++) {
            if (cardsInHand.get(i) != null) {
                handValue += cardsInHand.get(i).getCardValue();
            }
        }
        return handValue;
    }
    public int printDealerCurrentHand() {
        int handValue = 0;

        for (int i = 0; i < cardsInHand.size(); i++) {
            if (cardsInHand.get(i) != null) {
                handValue += cardsInHand.get(i).getCardValue();
            }

        }
        System.out.println( "Dealer total cards are " + handValue);
        return handValue;
    }

}




