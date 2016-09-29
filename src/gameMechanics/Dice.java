package gameMechanics;

/**
 * Created by tito on 04.07.16.
 */

public class Dice {

    private int numberOfDice;
    private int numberOfPips;

    public Dice(int numberOfDice, int numberOfPips) {
        this.setNumberOfDice(numberOfDice);
        this.setNumberOfPips(numberOfPips);
    }




    public void setNumberOfDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public void setNumberOfPips(int numberOfPips) {
        this.numberOfPips = numberOfPips;
    }

    public int getNumberOfDice() {
        return this.numberOfDice;
    }

    public int getNumberOfPips() {
        return this.numberOfPips;
    }

}
