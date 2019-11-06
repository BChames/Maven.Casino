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

        Card card = new Card(Card.CardValue.EIGHT , Card.Suit.DIAMONDS);
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

        Card card = new Card(Card.CardValue.ACE , Card.Suit.HEARTS);
        hand.addCardToHand(card);

        int expected = 0;
        //When


        hand.discardCard(card);
        int actual = hand.getNumberOfCardsInHand();

        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void clearAllCardsInHand1() {
        // Given
        Card card1 = new Card (Card.CardValue.FIVE, Card.Suit.DIAMONDS);
        Card card2 = new Card (Card.CardValue.FOUR, Card.Suit.HEARTS);

        // When

        Hand hand = new Hand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);

        hand.clearAllCardsInHand();
        int actual=hand.getNumberOfCardsInHand();
        System.out.println(actual);

        //Then

        Assert.assertEquals(0, actual);


    }

    @Test
    public void clearAllCardsInHand2() {
        // Given
        Card card1 = new Card (Card.CardValue.FIVE, Card.Suit.DIAMONDS);
        Card card2 = new Card (Card.CardValue.SIX, Card.Suit.HEARTS);
        Card card3 = new Card (Card.CardValue.NINE, Card.Suit.SPADES);
        Card card4 = new Card (Card.CardValue.ACE, Card.Suit.CLUBS);

        // When

        Hand hand = new Hand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);

        hand.clearAllCardsInHand();
        int actual=hand.getNumberOfCardsInHand();
        System.out.println(actual);

        //Then

        Assert.assertEquals(0, actual);
    }

    @Test
    public void discardCardNullTest() {
        //Given
        Hand cardsInHand;
        Hand hand=new Hand();

        List<Card> expectedCardsInhand = new ArrayList(4);
        Card card = new Card(Card.CardValue.SIX, Card.Suit.CLUBS);
        int expected = expectedCardsInhand.size();
        //When


        hand.discardCard(null);
        int actual = hand.getNumberOfCardsInHand();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void addCardToHand1(){
        //Given
        Hand cardsInHand;

        Card card1 = new Card(Card.CardValue.SIX, Card.Suit.CLUBS);
        Card card2 = new Card(Card.CardValue.SIX, Card.Suit.CLUBS);
        Card card3 = new Card(Card.CardValue.SIX, Card.Suit.CLUBS);

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
    public void addCardToHand2(){
        //Given
        Hand cardsInHand;

        Card card1 = new Card(Card.CardValue.SIX, Card.Suit.CLUBS);
        Card card2 = new Card(Card.CardValue.TEN, Card.Suit.CLUBS);
        Card card3 = new Card(Card.CardValue.ACE, Card.Suit.HEARTS);
        Card card4 = new Card(Card.CardValue.JACK, Card.Suit.SPADES);
        Card card5 = new Card(Card.CardValue.KING, Card.Suit.SPADES);

        //When
        Hand hand=new Hand();

        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);
        int actual =hand.getNumberOfCardsInHand();

        //Then
        Assert.assertEquals(5,actual);

    }

    @Test
    public void removeCardFromHandTest1(){
        Hand hand = new Hand();
        Card card1 = new Card(Card.CardValue.SIX, Card.Suit.CLUBS);
        Card card2 = new Card(Card.CardValue.TEN, Card.Suit.HEARTS);
        Card card3 = new Card(Card.CardValue.JACK, Card.Suit.DIAMONDS);
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        int expected = 2;

        //When
        hand.removeCardFromHand(card3);
        int actual = hand.getNumberOfCardsInHand();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeCardFromHandTest2(){
        Hand hand = new Hand();
        Card card1 = new Card(Card.CardValue.SIX, Card.Suit.CLUBS);
        Card card2 = new Card(Card.CardValue.TEN, Card.Suit.HEARTS);
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        int expected = 1;

        //When
        hand.removeCardFromHand(card2);
        int actual = hand.getNumberOfCardsInHand();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void hasCardTest1() {

        //Given
        Hand hand = new Hand();
        Card card = new Card(Card.CardValue.TEN, Card.Suit.HEARTS);
        Card card1 = new Card(Card.CardValue.SIX, Card.Suit.DIAMONDS);
        Card card2 = new Card(Card.CardValue.FOUR, Card.Suit.SPADES);
        hand.addCardToHand(card);
        hand.addCardToHand(card1);
        boolean expected = true;

        //When
        boolean actual = hand.hasCard(card);

        //Then
        Assert.assertEquals(expected, actual); }
    @Test
    public void hasCardTest2() {
        //Given
        Hand hand = new Hand();
        Card card1 = new Card(Card.CardValue.TEN, Card.Suit.HEARTS);
        Card card2 = new Card(Card.CardValue.TEN, Card.Suit.DIAMONDS);
        Card card3 = new Card(Card.CardValue.TEN, Card.Suit.SPADES);
        hand.addCardToHand(card2);
        hand.addCardToHand(card1);
        boolean expected = false;

        //When
        boolean actual = hand.hasCard(card3);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHandCards1() {
        //Given

        Hand hand = new Hand();
        Card card1 = new Card(Card.CardValue.TEN, Card.Suit.HEARTS);
        Card card2 = new Card(Card.CardValue.ACE, Card.Suit.SPADES);
        Card card3 = new Card(Card.CardValue.TWO, Card.Suit.DIAMONDS);
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
    public void getHandCards2() {
        //Given

        Hand hand = new Hand();
        Card card1 = new Card(Card.CardValue.NINE, Card.Suit.HEARTS);
        Card card2 = new Card(Card.CardValue.JACK, Card.Suit.SPADES);
        Card card3 = new Card(Card.CardValue.KING, Card.Suit.CLUBS);
        Card card4 = new Card(Card.CardValue.FOUR, Card.Suit.CLUBS);
        Card card5 = new Card(Card.CardValue.THREE, Card.Suit.CLUBS);
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









