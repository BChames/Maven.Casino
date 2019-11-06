package GameComponents;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import GameComponents.Card.CardValue;
import GameComponents.Card.Suit;


public class Deck {

    //Defines arrayList for the cards
    private ArrayList<Card> deck;


    //Constructor for when that draws every card from th deck
    public Deck () {

        //Refers to encapsulated class fields
        //nested for loops
        //for loop through the 'enum', Integer values for the cards: CardValues
        this.deck = new ArrayList<Card>();
        for (int i=0; i < 12; i++) {

            //BLOCK OF CODE THAT GOES THROUGH EACH CARD VALUE 'i'
            CardValue value = CardValue.values()[i];

            //Inner for loop
            //for loop through the 'enum', Suit for the cards: Suit
            for (int j=0; j < 4; j++) {

                //instantiates newCard, gets the 'value' from the first for loop and the SUIT 'j'
                Card card = new Card(value, Suit.values()[j]);
                deck.add(card);//adds the card variable from the inner loop to the deck
            }
        }
        //Shuffle method for all collections that takes the deck arraylist
        Collections.shuffle(deck);


        //prints out every card in the deck. Commented out bc it's not really needed for anything other than testing.
/*
        Iterator<Card> cardIterator = deck.iterator();
        while (cardIterator.hasNext())
        {
            Card aCard = cardIterator.next();
            System.out.println(aCard.getCardValue() + " of " + aCard.getSuit());
        }
 */
    }

    public Card drawCard(){
        Collections.shuffle(deck);
        Iterator<Card> cardIterator = deck.iterator();

        Card aCard = cardIterator.next();
        System.out.println(aCard.getCardValue() + " of " + aCard.getSuit());

        return aCard;

    }


}

