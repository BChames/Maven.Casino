package Games;

import Interfaces.GamblingGame;
import Interfaces.Game;

public class BlackJackGame extends CardGame implements Game, GamblingGame {

    Double minimumBet;
    Double betAmount;


    public BlackJackGame(){

    }

    public Double addToBet() {

        return null;
    }

    public Double payOut() {

        return null;
    }

    public void setMinimumBet(Double minimumBet) {

        this.minimumBet = minimumBet;
    }

    public Boolean playerTurn(Player BlackJackPlayer) {

        return null;
    }

    public Boolean dealerTurn(Dealer BlackJackDealer) {

        return null;
    }
}
