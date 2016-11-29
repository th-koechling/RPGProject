package Data.GameObjects;

import java.util.Random;

/**
 * This class can be used to throw a number of dice with a number of eyes each.
 * @author Thorsten Köchling
 */

public class Dice {
    /*
   **********************************************************************************
   *                                  Variables                                     *
   **********************************************************************************
   */
    private int numberOfDice;
    private int numberOfPips;

    /*
     **********************************************************************************
     *                                 Constructors                                   *
     **********************************************************************************
     */
    /**
     * Creates a representation of dice with numberOfDice dice with numberOfPips eyes each.
     * @param numberOfDice Integer: the number of dice to use
     * @param numberOfPips Integer: the number of eyes for each dice
     */
    public Dice(int numberOfDice, int numberOfPips) {
        this.setNumberOfDice(numberOfDice);
        this.setNumberOfPips(numberOfPips);
    }

    /*
    **********************************************************************************
    *            Setter methods for the different variables                          *
    **********************************************************************************
    */
    /**
     * This method allows to change the number of dice.
     * @param numberOfDice Integer: new number of dice
     */
    public void setNumberOfDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    /**
     * This method allows to change the number of eyes per dice.
     * @param numberOfPips Integer: new number of eyes per dice
     */
    public void setNumberOfPips(int numberOfPips) {
        this.numberOfPips = numberOfPips;
    }

    /*
     **********************************************************************************
     *            Getter methods for the different variables                          *
     **********************************************************************************
     */
    /**
     * This method gets the current number of dice
     * @return Integer: current number of dice
     */
    public int getNumberOfDice() {
        return this.numberOfDice;
    }

    /**
     * This method returns the current number of eyes per dice.
     * @return Integer: current number of eyes per dice
     */
    public int getNumberOfPips() {
        return this.numberOfPips;
    }

     /*
    **********************************************************************************
    *                                  Object methods                                *
    **********************************************************************************
    */
    /**
     * This method is used to create a temporary dice, throw it and return the results
     * @param numberOfDice Integer: number of dice used
     * @param numberOfPips Integer: number of pips per dice
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
