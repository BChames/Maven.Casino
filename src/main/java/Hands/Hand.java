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
}
