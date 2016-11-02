package gameMechanics;

import java.util.Random;

/**
 * Created by tito on 04.07.16.
 * modified by Fabian on 02/11/16 merged control into dice, since only dice method in control
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


    /**
     * This method is used to create a temporary dice, throw it and return the results
     * @author Andreas
     * @coauthor Fabian
     * @param numberOfDice
     * @param numberOfPips
     * @return the total number rolled in the dice throw
     */
    public static int throwDice(int numberOfDice, int numberOfPips) {
        int score = 0;
        Dice dice = new Dice(2, 6);
        Random dieCast = new Random();

        for(int i = 0; i < dice.getNumberOfDice(); i++) {
            score += dieCast.nextInt(dice.getNumberOfPips()) + 1;
        }

        return score;

    }

}
