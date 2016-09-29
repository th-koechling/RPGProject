package gameMechanics;

/**
 * Created by tito on 04.07.16.
 */

import java.util.Random;

// could we use the pre-made MVC structure here? (thorsten)

public class Control {
                                           // thorsten:
    public static int throwDice() {        // use this class as container for static/ helper methods?
        int score = 0;
        Dice dice = new Dice(2, 6);        // where has the number and type of dice to be set?
        Random dieCast = new Random();

        for(int i = 0; i < dice.getNumberOfDice(); i++) {
            score += dieCast.nextInt(dice.getNumberOfPips()) + 1;
        }

        return score;

    }

    public void examine() {
        // TODO
    }

    public void go() {
        // TODO
    }

    // test the method with two 6 sided dice:
    public static void main(String[] args) {
        System.out.println("dice test:");
        for(int i = 0; i < 20; i++) {
            System.out.print(throwDice() + " ");
        }
    }
}
