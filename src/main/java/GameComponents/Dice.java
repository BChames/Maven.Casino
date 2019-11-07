package GameComponents;


public class Dice {

    Integer numOfDice = 0;


    public Dice(Integer numOfDice) {
        this.numOfDice = numOfDice;
    }

    public Dice() {

    }
    // constructor for dice

    public int diceToss() {

        return (int) ((Math.random() * 6) + 1);

    }
    //rolls a dice

    public int tossAndSum() {
        int diceResult = 0;
        for (int i = 1; i <= numOfDice; i++) {
            diceResult += (int) (Math.random() * 6 + 1);
        }
        return diceResult;

    }
}