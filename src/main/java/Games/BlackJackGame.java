package Games;
import Hands.Hand;
import Players.BlackJackPlayer;
import Interfaces.GamblingGame;
import GameComponents.Deck;
import GameComponents.Card;
import Players.Dealer;

import java.util.*;

public class BlackJack implements GamblingGame {

 Hand dealer;
 Deck newdeck;

    public BlackJack(Hand dealer1, Hand player)
    {
        dealer = dealer1;
        BlackJack player;
        newdeck = new Deck();
    }

    //Blackjack constructor

    public void dealInitialCards()
    {
        dealer.getRandomCard();
        dealer.getRandomCard();
        player.getRandomCard;
        player.getRandomCard;

    }
    public int handValue(Hand playerHand)
    {
        int result = playerHand.getHandValue();

        return result;

    }
    public void discard(Hand whodis, Card discrd) throws ElementNotFoundException
    {
        Card card=null;
        boolean found = false;
        Iterator<Card> scan = whodis.iterator();
        while (scan.hasNext() && !found)
        {
            card = scan.next();
            if(discrd.equals(card))
            {
                whodis.remove(card);
                found = true;
            }
        }
        if(!found)
            throw new ElementNotFoundException("BlackJack");

    }

    public static boolean hasBlackJack(int handValue) {
        if (handValue == 21) {
            return true;
        }
        return false;
    }

    public static boolean checkBust(int handvalue) {
        if (handvalue > 21) {
            System.out.println("You have busted!");
            return true;
        }
        return false;
    }
    public Hand dealerPlays()
    {
        Hand result = dealer;

        while(dealer.getHandValue() <= 16)
        {
            dealer.newCard(newdeck);
        }

        return result;

    }




    public static boolean checkBust(int handvalue) {
        if (handvalue > 21) {
            System.out.println("You have busted!");
            return true;
        }
        return false;
    }



/**  public static int cash;//cash the user bets with
  public static int bet;//how much the user wants to bet
  public static int AceCounter;//how many aces are in the user's hand
  public static ArrayList<Card> hand;//represents the user's hand
  public static int handValue;//the value of the user's hand
  public static String name;//name of the user

  public static void main(String[] args) {


      /**System.out.println("Hello, " + name + ", lets play some BlackJack!");

      Scanner money = new Scanner(System.in);
      cash = money.nextInt();
      System.out.println("You start with cash: " + cash);
      while (cash > 0) {
          Deck deck = new Deck();//initialize deck, dealer, hands, and set the bet.
          AceCounter = 0;
          Dealer dealer = new Dealer();
          List<Card> hand = new ArrayList<Card>();
          hand.add(deck.drawCard());
          hand.add(deck.drawCard());
          //System.out.println("How much would you like to bet?");
          //bet = Bet(cash);
          //System.out.println("Cash:" + (cash - bet));
          //System.out.println("Money on the table:" + bet);
          //System.out.println("Here is your hand: ");
          //System.out.println(hand);






          int handValue = calcHandValue(hand);
          System.out.println("The dealer is showing: ");
          dealer.showFirstCard();
          if (hasBlackJack(handValue) && dealer.hasBlackJack())//check if both the user and dealer have blackjack.
          {
              Push();
          } else if (hasBlackJack(handValue))//check if the user has blackjack.
          {
              System.out.println("You have BlackJack!");
              System.out.println("You win 2x your money back!");
              cash = cash + bet;
              Win();
          } else if (dealer.hasBlackJack())//check if the dealer has blackjack.
          {
              System.out.println("Here is the dealer's hand:");
              dealer.showHand();
              Lose();
          } else {
              if (2 * bet < cash)//check if the user can double down.
              {
                  System.out.println("Would you like to double down?");//allows the user to double down.
                  Scanner doubledown = new Scanner(System.in);
                  String doubled = doubledown.nextLine();
                  while (!isyesorno(doubled)) {
                      System.out.println("Please enter yes or no.");
                      doubled = doubledown.nextLine();
                  }
                  if (doubled.equals("yes")) {
                      System.out.println("You have opted to double down!");
                      bet = 2 * bet;
                      System.out.println("Cash:" + (cash - bet));
                      System.out.println("Money on the table:" + bet);
                  }
              }
              System.out.println("Would you like to hit or stand?");//ask if the user will hit or stand
              Scanner hitorstand = new Scanner(System.in);
              String hitter = hitorstand.nextLine();
              while (!isHitorStand(hitter)) {
                  System.out.println("Please enter 'hit' or 'stand'.");
                  hitter = hitorstand.nextLine();
              }
              while (hitter.equals("hit"))//hits the user as many times as he or she pleases.
              {
                  Hit(deck, hand);
                  System.out.println("Your hand is now:");
                  System.out.println(hand);
                  handValue = calcHandValue(hand);
                  if (checkBust(handValue))//checks if the user busted
                  {
                      Lose();
                      break;
                  }
                  if (handValue <= 21 && hand.size() == 5)//checks for a five card trick.
                  {
                      fivecardtrick();
                      break;
                  }
                  System.out.println("Would you like to hit or stand?");
                  hitter = hitorstand.nextLine();
              }
              if (hitter.equals("stand"))//lets the user stand.
              {
                  int dealerhand = dealer.takeTurn(deck);//takes the turn for the dealer.
                  System.out.println("");
                  System.out.println("Here is the dealer's hand:");
                  dealer.showHand();
                  if (dealerhand > 21)//if the dealer busted, user wins.
                  {
                      Win();
                  } else {
                      int you = 21 - handValue;//check who is closer to 21 and determine winner
                      int deal = 21 - dealerhand;
                      if (you == deal) {
                          Push();
                      }
                      if (you < deal) {
                          Win();
                      }
                      if (deal < you) {
                          Lose();
                      }
                  }
              }
          }
          System.out.println("Would you like to play again?");//ask if the user wants to keep going
          Scanner yesorno = new Scanner(System.in);
          String answer = yesorno.nextLine();
          while (!isyesorno(answer)) {
              System.out.println("Please answer yes or no.");
              answer = yesorno.nextLine();
          }
          if (answer.equals("no")) {
              break;
          }
      }
      System.out.println("Your cash is: " + cash);//if user doesn't want to play or runs out of cash, either congratulates them on their winnings or lets them know
      if (cash == 0) {
          System.out.println("You ran out of cash!");
      } else {
          System.out.println("Enjoy your winnings, " + name + "!");
      }
  }

  /*
   * Checks if the user has blackjack.
   */
  /**  public static boolean hasBlackJack(int handValue) {
        if (handValue == 21) {
            return true;
        }
        return false;
    }

    /*
     * Calculates the value of a player's hand.
     */
 /**   public static int calcHandValue(List<Card> hand) {

        //hand = userHand
        Card sum;
        int sum = 0;
        for(int i = 0; i < hand.size(); i++){
            handValue += hand[i].getCardValue();

        }


    /**    Card[] aHand = new Card[]{};
        aHand = hand.toArray(aHand);
        Card.CardValue handValue;
        for (int i = 0; i < aHand.length; i++) {
            handvalue += aHand[i].getCardValue();
            if (aHand[i].getCardValue().equals(11)) {
                AceCounter++;
            }
            while (AceCounter > 0 && handvalue > 21) {
                handvalue -= 10;
                AceCounter--;
            }
        }
        return handValue;
    }

    /*
     * Asks the user how much he or she would like to bet.
     */
 /**   public static int Bet(int cash) {
        Scanner sc = new Scanner(System.in);
        int bet = sc.nextInt();
        while (bet > cash) {
            System.out.println("You cannot bet more cash than you have!");
            System.out.println("How much would you like to bet?");
            bet = sc.nextInt();
        }
        return bet;
    }

    /*
     * Called if the user wins.
     */
 /**   public static void Win() {
        System.out.println("Congratulations, you win!");
        cash = cash + bet;
        System.out.println("Cash: " + cash);
    }

    /*
     * Called if the user loses.
     */
 /**   public static void Lose() {
        System.out.println("Sorry, you lose!");
        cash = cash - bet;
        System.out.println("Cash: " + cash);
    }

    /*
     * Called if the user pushes
     */
 /**   public static void Push() {
        System.out.println("It's a push!");
        System.out.println("You get your money back.");
        System.out.println("Cash: " + cash);
    }

    /*
     * Adds a card to user's hand and calculates the value of that hand. Aces are taken into account.
     */
    /**public static void Hit(Deck deck, List<Card> hand) {
        hand.add(deck.drawCard());
        Card[] aHand = new Card[];
        aHand = hand.toArray(aHand);
        handValue = 0;
        for (int i = 0; i < aHand.length; i++) {
            handValue += aHand[i].getCardValue();
        }
    }
            /**if (hand[i].getCardValue().equals(11)) {
                AceCounter++;
            }
            while (AceCounter > 0 && handValue > 21) {
                handValue -= 10;
                AceCounter--;
            }
        }
    }

    /*
     * Determines if a user has input hit or stand.
     */
  /**  public static boolean isHitorStand(String hitter) {
        if (hitter.equals("hit") || hitter.equals("stand")) {
            return true;
        }
        return false;
    }

    /*
     * Determines if a user has input yes or no.
     */
 /**   public static boolean isyesorno(String answer) {
        if (answer.equals("yes") || answer.equals("no")) {
            return true;
        }
        return false;
    }

    /*
     * Called if the user has a five card trick.
     */
  /**  public static void fivecardtrick() {
        System.out.println("You have achieved a five card trick!");
        Win();
    }
}
*/