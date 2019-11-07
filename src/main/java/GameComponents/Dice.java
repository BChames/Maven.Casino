package GameComponents;

<<<<<<< HEAD
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

    //returns the sum of the dice you roll
=======
public class Dice extends gamecomponents {
    public Dice() {
>>>>>>> d21861debec359643ae77d913b55ba7d30f4b6dd

    }
}
