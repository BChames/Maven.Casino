package player;

import GameComponents.Card;
import io.zipcoder.casino.MainApplication.Console;
import io.zipcoder.casino.MainApplication.MainMenu;

public class Player {

    private String userName;
    private Double wallet;

    public Player(String userName, Double wallet){
        this.userName = userName;
    }

    public Player() {

        this.userName = "Player 1";
        this.wallet = 500.0;
    } // default constructor


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getWallet() {
        return wallet;
    }

    public void setWallet(Double wallet) {
        this.wallet = wallet;
    }

}
