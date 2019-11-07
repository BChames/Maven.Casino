package players;

import Interfaces.GamblingPlayer;

public class CrapsPlayer extends Player implements GamblingPlayer {

        private Player gamblingPlayer;

        public CrapsPlayer(Player user) {
            super(0);
        }

    public CrapsPlayer() {

    }

    @Override
    public Double placeBet() {
        return null;
    }


    //public void setWallet(Double wallet) {
            //this.wallet = wallet;
       // }


    /*public CrapsPlayer(Double wallet){

    }
        public CrapsPlayer() {

        }*/
    }
