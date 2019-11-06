package Games;

import GameComponents.Deck;
import player.Player;

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
            return null;

        }
        public void gameOver() {

        }
        public void getMenu () {
        }

    }
}