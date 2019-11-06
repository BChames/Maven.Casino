package io.zipcoder.casino;

import GameComponents.Card;
import GameComponents.Deck;
import org.junit.Assert;
import org.junit.Test;

    public class CardTest {

        @Test
        public void cardValueTest(){
            //Given
            Deck testyDeck = new Deck();
            Card.CardValue expected =  Card.CardValue.TWO;

            //When
            Card.CardValue actual = Card.CardValue.values()[0];

            //Then
            Assert.assertEquals(expected,actual);
        }

        @Test
        public void cardValueTest2(){
            //Given
            Deck testyDeck = new Deck();
            Card.CardValue expected =  Card.CardValue.FOUR;

            //When
            Card.CardValue actual = Card.CardValue.values()[2];

            //Then
            Assert.assertEquals(expected,actual);
        }

        @Test
        public void cardValueTest3(){
            //Given
            Deck testyDeck = new Deck();
            Card.CardValue expected =  Card.CardValue.ACE;

            //When
            Card.CardValue actual = Card.CardValue.values()[12];

            //Then
            Assert.assertEquals(expected,actual);
        }

        @Test
        public void cardValueTest4(){
            //Given
            Deck testyDeck = new Deck();
            Card.CardValue expected = Card.CardValue.ACE;

            //When
            Card.CardValue actual = Card.CardValue.values()[12];

            //Then
            Assert.assertEquals(expected,actual);
        }

        @Test
        public void cardValueMethodTest(){
            //Given
            Deck testyDeck = new Deck();
            int expected = Card.CardValue.ACE.getCardValue();
            //When
            int actual = Card.CardValue.values()[12].getCardValue();

            //Then
            Assert.assertEquals(expected,actual);
        }

        @Test
        public void getSuitTest(){
            //GIVEN
            Card card = new Card(Card.CardValue.ACE, Card.Suit.CLUBS);
            Card.Suit expected = Card.Suit.CLUBS;

            //When
            Card.Suit actual2 =  card.getSuit();

            //Then
            Assert.assertEquals(expected, actual2);

        }


    }


