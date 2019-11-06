package Games;

import GameComponents.Deck;
import Players.Player;

abstract class CardGame {
    Deck deckOfCards;
    Player player;

    public CardGame() {
        public CardGame(Deck deckOfCards, APIPlayer apiPlayer, player Player) {
            this.deckOfCards = deckOfCards;
            this.apiPlayer = apiPlayer;
            this.player = player;
        }
        public void startGame() {

        }
        public Boolean determineWin() {
                String result = "";
                if((player.getHandValue() < dealer.getHandValue()) &&
                        dealer.getHandValue() <= 21 )
                    result = "Lose";
                else if ((player.getHandValue() == dealer.getHandValue()) &&
                        dealer.getHandValue() <= 21 )
                    result = "Push";
                else
                    result = "Win";

                return result;
            }

        }
        public void gameOver() {
            System.out.println("Sorry, you lose!");
            cash = cash - bet;
            System.out.println("Cash: " + cash);
        }
        public void getMenu () {
        }


        }

    }
}