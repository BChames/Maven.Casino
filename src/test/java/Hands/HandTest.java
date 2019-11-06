package Hands;

import GameComponents.Card;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HandTest {

    @Test
    public void discardCardTest1() {
        //Given
        Hand hand=new Hand();

        Card card = new Card(Card.CardValue.KING, Card.Suit.HEARTS);
        hand.addCardToHand(card);

        int expected = 0;

        //When
        hand.discardCard(card);
        int actual = hand.getNumberOfCardsInHand();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void discardCardTest2() {
        //Given
        Hand hand=new Hand();

        Card card1 = new Card(Card.CardValue.THREE, Card.Suit.HEARTS);
        Card card2 = new Card(Card.CardValue.FOUR, Card.Suit.DIAMONDS);
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);

        int expected = 1;

        //When
        hand.discardCard(card1);
        int actual = hand.getNumberOfCardsInHand();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void clearAllCardsInHandTest1() {
        //Given

        Card card1 = new Card(Card.CardValue.TWO, Card.Suit.DIAMONDS);
        Card card2 = new Card(Card.CardValue.FOUR, Card.Suit.HEARTS);


        //When
        Hand hand=new Hand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);

        hand.clearAllCardsInHand();
        int actual=hand.getNumberOfCardsInHand();
        System.out.println(actual);
        //Then
        Assert.assertEquals(0, actual);
    }


    @Test
    public void clearAllCardsInHandTest2() {
        //Given

        Card card1 = new Card(Card.CardValue.THREE, Card.Suit.CLUBS);
        Card card2 = new Card(Card.CardValue.FOUR, Card.Suit.SPADES);
        Card card3 = new Card(Card.CardValue.FOUR, Card.Suit.DIAMONDS);

        //When
        Hand hand=new Hand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);

        hand.clearAllCardsInHand();
        int actual=hand.getNumberOfCardsInHand();
        System.out.println(actual);
        //Then
        Assert.assertEquals(0, actual);
    }

    @Test
    public void addCardToHandTest1() {
        //Given
        Hand cardsInHand;

        Card card1 = new Card(Card.CardValue.TWO, Card.Suit.HEARTS);
        Card card2 = new Card(Card.CardValue.FOUR, Card.Suit.CLUBS);
        Card card3 = new Card(Card.CardValue.SIX, Card.Suit.DIAMONDS);

        //When
        Hand hand=new Hand();

        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);

        int actual =hand.getNumberOfCardsInHand();

        //Then
        Assert.assertEquals(3,actual);
    }

    @Test
    public void addCardToHandTest2() {
        //Given
        Hand cardsInHand;

        Card card1 = new Card(Card.CardValue.TWO, Card.Suit.HEARTS);
        Card card2 = new Card(Card.CardValue.EIGHT, Card.Suit.CLUBS);


        //When
        Hand hand=new Hand();

        hand.addCardToHand(card1);
        hand.addCardToHand(card2);


        int actual =hand.getNumberOfCardsInHand();

        //Then
        Assert.assertEquals(2,actual);
    }
    @Test
    public void manageDuplicateCardsTest1() {
        //Given

        Card card1 = new Card(Card.CardValue.TWO, Card.Suit.HEARTS);
        Card card2 = new Card(Card.CardValue.TWO, Card.Suit.DIAMONDS);
        Card card3 = new Card(Card.CardValue.THREE, Card.Suit.HEARTS);
        Card card4 = new Card(Card.CardValue.TWO, Card.Suit.DIAMONDS);

        Hand hand=new Hand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);

        //When
        hand.manageDuplicateCards();

        int actual=hand.getNumberOfCardsInHand();
        //System.out.println(actual);
        //Then
        Assert.assertEquals(4, actual);
    }


    @Test
    public void manageDuplicateCardsTest2() {
        //Given

        Card card1 = new Card(Card.CardValue.TWO, Card.Suit.HEARTS);
        Card card2 = new Card(Card.CardValue.FOUR, Card.Suit.DIAMONDS);
        Card card3 = new Card(Card.CardValue.THREE, Card.Suit.HEARTS);
        Card card4 = new Card(Card.CardValue.FOUR, Card.Suit.DIAMONDS);
        Hand hand=new Hand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);

        //When
        hand.manageDuplicateCards();

        int actual=hand.getNumberOfCardsInHand();
        System.out.println(actual);
        //Then
        Assert.assertEquals(4, actual);
    }

    @Test
    public void manageDuplicateCardsTest3() {
        //Given

        Card card1 = new Card(Card.CardValue.TWO, Card.Suit.HEARTS);
        Card card2 = new Card(Card.CardValue.SIX, Card.Suit.HEARTS);
        Card card3 = new Card(Card.CardValue.SEVEN, Card.Suit.HEARTS);
        Hand hand=new Hand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);


        //When
        hand.manageDuplicateCards();

        int actual=hand.getNumberOfCardsInHand();
        System.out.println(actual);
        //Then
        Assert.assertEquals(3, actual);
    }

    @Test
    public void getRandomCardTest() {

        //Given

        Hand hand = new Hand();
        Card card1 = new Card(Card.CardValue.TWO, Card.Suit.HEARTS);
        Card card2 = new Card(Card.CardValue.FOUR, Card.Suit.DIAMONDS);
        Card card3 = new Card(Card.CardValue.TEN, Card.Suit.CLUBS);
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);


        //When
        System.out.println(hand.getRandomCard());

    }

   @Test
    public void removeCardFromHandTest1() {
        //Given

        Hand hand = new Hand();
        Card card1 = new Card(Card.CardValue.FOUR, Card.Suit.CLUBS);
        Card card2 = new Card(Card.CardValue.FIVE, Card.Suit.DIAMONDS);
        Card card3 = new Card(Card.CardValue.SEVEN, Card.Suit.SPADES);
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        int expected = 2;

        //When
        hand.removeCardFromHand(card1);
        int actual = hand.getNumberOfCardsInHand();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void removeCardFromHandTest2() {
        //Given

        Hand hand = new Hand();
        Card card1 = new Card(Card.CardValue.FOUR, Card.Suit.CLUBS);
        Card card2 = new Card(Card.CardValue.FIVE, Card.Suit.DIAMONDS);

        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        int expected = 1;

        //When
        hand.removeCardFromHand(card1);
        int actual = hand.getNumberOfCardsInHand();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void removeCardFromHandTest3() {
        //Given

        Hand hand = new Hand();
        Card card1 = new Card(Card.CardValue.FOUR, Card.Suit.CLUBS);
        Card card2 = new Card(Card.CardValue.FIVE, Card.Suit.DIAMONDS);
        Card card3 = new Card(Card.CardValue.SEVEN, Card.Suit.SPADES);
        Card card4 = new Card(Card.CardValue.SEVEN, Card.Suit.HEARTS);
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);

        int expected = 3;

        //When
        hand.removeCardFromHand(card4);
        int actual = hand.getNumberOfCardsInHand();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void hasCardTest1() {

        //Given

        Hand hand = new Hand();
        Card card1 = new Card(Card.CardValue.FOUR, Card.Suit.HEARTS);
        Card card2 = new Card(Card.CardValue.EIGHT, Card.Suit.CLUBS);
        Card card3 = new Card(Card.CardValue.QUEEN, Card.Suit.DIAMONDS);
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        boolean expected = true;

        //When
        boolean actual = hand.hasCard(card1);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hasCardTest2() {

        //Given

        Hand hand = new Hand();
        Card card1 = new Card(Card.CardValue.FOUR, Card.Suit.HEARTS);
        Card card2 = new Card(Card.CardValue.EIGHT, Card.Suit.CLUBS);
        Card card3 = new Card(Card.CardValue.QUEEN, Card.Suit.DIAMONDS);
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
       // hand.addCardToHand(card3);
        boolean expected = false;

        //When
        boolean actual = hand.hasCard(card3);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hasCardTest3() {

        //Given

        Hand hand = new Hand();
        Card card1 = new Card(Card.CardValue.FOUR, Card.Suit.HEARTS);
        Card card2 = new Card(Card.CardValue.EIGHT, Card.Suit.CLUBS);
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);

        boolean expected = true;

        //When
        boolean actual = hand.hasCard(card1);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHandCardsTest1() {

        //Given
        Hand hand = new Hand();
        Card card1 = new Card(Card.CardValue.ACE, Card.Suit.HEARTS);
        Card card2 = new Card(Card.CardValue.KING, Card.Suit.CLUBS);
        Card card3 = new Card(Card.CardValue.JACK, Card.Suit.DIAMONDS);
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);

        //When
        Card[] expectedArray =  new Card[]{card1, card2, card3};
        String expectedString = Arrays.toString(expectedArray);
        String actualString = hand.getHandCards().toString();

        //Then
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void getHandCardsTest2() {

        //Given
        Hand hand = new Hand();
        Card card1 = new Card(Card.CardValue.ACE, Card.Suit.HEARTS);
        Card card2 = new Card(Card.CardValue.KING, Card.Suit.CLUBS);
        Card card3 = new Card(Card.CardValue.JACK, Card.Suit.DIAMONDS);
        Card card4 = new Card(Card.CardValue.EIGHT, Card.Suit.SPADES);
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);

        //When
        Card[] expectedArray =  new Card[]{card1, card2, card3, card4};
        String expectedString = Arrays.toString(expectedArray);
        String actualString = hand.getHandCards().toString();

        //Then
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void getHandCardsTest3() {

        //Given
        Hand hand = new Hand();
        Card card1 = new Card(Card.CardValue.JACK, Card.Suit.HEARTS);
        Card card2 = new Card(Card.CardValue.SEVEN, Card.Suit.CLUBS);
        Card card3 = new Card(Card.CardValue.JACK, Card.Suit.DIAMONDS);
        Card card4 = new Card(Card.CardValue.QUEEN, Card.Suit.SPADES);
        Card card5 = new Card(Card.CardValue.TWO, Card.Suit.SPADES);
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);

        //When
        Card[] expectedArray =  new Card[]{card1, card2, card3, card4, card5};
        String expectedString = Arrays.toString(expectedArray);
        String actualString = hand.getHandCards().toString();

        //Then
        Assert.assertEquals(expectedString, actualString);
    }
}




