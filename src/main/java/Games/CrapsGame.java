package Games;

import GameComponents.Dice;

public class CrapsGame{
Dice dice = new Dice();

public void firstRoll(){
if (dice.diceToss() == 7 || dice.diceToss() == 11){
    System.out.println("You Win!");
}
else if (dice.diceToss() == 2 || dice.diceToss() == 3 || dice.diceToss() == 12){
    System.out.println("You Lose!");
}
}
}
