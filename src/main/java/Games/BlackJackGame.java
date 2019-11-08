package Games;

import GameComponents.Deck;
import Hands.Hand;
import io.zipcoder.casino.MainApplication.Console;
import player.Player;
import players.BlackJackPlayer;


public class BlackJackGame {

    Player bjPlayer;
    private Double playerBet = 0.0;
    Deck dealerDeck = new Deck();
    Hand dealerHand = new Hand();
    Hand playerHand = new Hand();

    public BlackJackGame(Player casinoPlayer) {
        this.bjPlayer = casinoPlayer;
    }

    //hit method
    public void dealToPlayer() {
        playerHand.addCardToHand(dealerDeck.drawCard());
    }
    //hit method
    public void dealToDealer() {
        dealerHand.addCardToHand(dealerDeck.drawCard());
    }
    public void dealToDealerUntil17() {
        do{
            dealerHand.addCardToHand(dealerDeck.drawCard());
            dealerHand.printDealerCurrentHand();

            if(dealerHand.sumOfCurrentHand() == 17 || dealerHand.sumOfCurrentHand() == 18 ||
                    dealerHand.sumOfCurrentHand() == 19 || dealerHand.sumOfCurrentHand() == 20 || dealerHand.sumOfCurrentHand() == 21){
                break;
            }
        }
        while(dealerHand.sumOfCurrentHand() > 0 && dealerHand.sumOfCurrentHand() < 21);

    }

    public void startBlackJack(){

        playerBet = Console.getDoubleInput("Welcome to BlackJack!\n You currently have: " + bjPlayer.getWallet() + "\nPlease place your bet : ");
        if (playerBet > bjPlayer.getWallet()) {
            Console.println("HAHA... no you don't have that much try again :)\n\n");
            startBlackJack();
        }
        bjPlayer.setWallet(bjPlayer.getWallet() - playerBet);
        testMenuMethod();
    }


    public void testMenuMethod() {

        //BlackJackPlayer userPlayer = new BlackJackPlayer();

        //Deal two cards -player
        dealToPlayer();
        dealToPlayer();
        playerHand.printCurrentHand();
        //Deal one card to -dealer -show dealers one card
        dealToDealer();
        dealerHand.printDealerCurrentHand();
        //^all code above this comment is working as needed for this method
        if( playerHand.sumOfCurrentHand() == 21 ){
            System.out.println("21!!!!!!");
            testMenuMethod();
        }

        //if under 21 do you want to hit or stay?

        String input = Console.getStringInput("Would you like to hit or stay?");
        hitOrStay(input);


        // check values
        if( playerHand.sumOfCurrentHand() >= 21 ){
            System.out.println("YOU BUSTED LOSER!!!!");
            isLoser();
        }
        if( playerHand.sumOfCurrentHand() == 21 ){
            System.out.println("21!!!!!!");
            isWinner();
        }
        //if stay dealer go
        if( playerHand.sumOfCurrentHand() < 21){
            dealToDealerUntil17();
        }
        checkWinner();
        //loop through players hand and total the value
/*
           //Check the players hand -user
           String input = Console.getStringInput("Would you like to hit or stay?");
           hitOrStay(input);
           //Create a hit or stand method that takes in a String
           playerHand.printCurrentHand();


*/



    }


    public BlackJackGame() {
/*
      //BlackJackPlayer userPlayer = new BlackJackPlayer();

      //Deal two cards -player
        dealToPlayer();
        dealToPlayer();
      //Deal one card to -dealer -show dealers one card
       dealToDealer();
       dealerHand.showDealerCardValues();

      //loop through players hand and total the value
          playerHand.addCurrentHand();
      //Check the players hand -user
          checkWinner();
      //Create a hit or stand method that takes in a String





*/
    }

    public void checkWinner(){

        //lose statements first
        if( playerHand.sumOfCurrentHand() >= 21 ){
            System.out.println("YOU BUSTED LOSER!!!!");
            isLoser();
        }
        if( dealerHand.sumOfCurrentHand() >= 21 ){
            System.out.println("DEALER BUSTED LOSER!!!!");
            isWinner();
        }
        //Push statement
        if(playerHand.sumOfCurrentHand() == dealerHand.sumOfCurrentHand()){
            System.out.println("PUSH!!!");
        }
        //Winner statement
        if( playerHand.sumOfCurrentHand() == 21 ){
            System.out.println("21!!!!!!");
            isWinner();
        }
        if( playerHand.sumOfCurrentHand() > dealerHand.sumOfCurrentHand() && playerHand.sumOfCurrentHand() <= 21){
            System.out.println("YOU WIN!!!");
            isWinner();
        }
        if( dealerHand.sumOfCurrentHand() > playerHand.sumOfCurrentHand() && dealerHand.sumOfCurrentHand() <= 21){
            System.out.println("DEALER WIN!!!");
            isLoser();
        }


        //Continue statement
        else if( playerHand.sumOfCurrentHand() > 20 ){
            String input = Console.getStringInput("Would you like to hit or stay?");
            hitOrStay(input);
        }
    }
    public void hitOrStay(String input){
        if(input.equals("hit")) {
            dealToPlayer();
            playerHand.printCurrentHand();
        }
        if(input.equals("stay")){
            playerHand.printCurrentHand();
        }
    }

    public void dealerQuestion(){
        String input = Console.getStringInput("Would you like to hit or stay?");
        if( playerHand.sumOfCurrentHand() < 20 ){

        }

    }
    public void isWinner() {
        bjPlayer.setWallet(bjPlayer.getWallet() + (playerBet * 2));

        Console.println("CONGRATS YOU WON ! WOO \n You won :" + "Your bet x2:  " + playerBet * 2 +
                "\nYour wallet now has: $" + bjPlayer.getWallet() +
                "\nDon't spend it all in once place :)");
        transitionMenu(bjPlayer);

    }

    public void isLoser() {
        Console.println("You lose.. awkward..." + "\nYour bet of $" + playerBet + " is ours now.....\n\n" +
                "\nYour wallet now has: $" + bjPlayer.getWallet());
        transitionMenu(bjPlayer);
    }
    public void transitionMenu(Player player) {
        Integer choice = Console.getIntegerInput("\n\nWhat do you wanna do now?\nPress 1 : Continue Playing" +
                "\n Press 2 : Go back to Main Menu");
        switch (choice) {
            case 1:
                startBlackJack();
                break;

            case 2:

                break;

        }
    }
}
