package gameMechanics;

/**
 * Created by Andreas on 28.09.2016.
 */
public class TestCreature {

    public static void main(String[] args){
        Weapon schwert = new Weapon();
        schwert.setForce(10);
        Player testPlayer = new Player("Klaus", "Zwerg", "Kampfzwerg", 1, 100, 15, schwert);
        System.out.println(testPlayer.attack());

        NPC testNpc = new NPC("HAL", "AI", "NPC", 3, 25, 8, schwert, 0);
        System.out.println("HP vor Attacke: " + testPlayer.getHp());
        testPlayer.defend(testNpc.attack());
        System.out.println("HP nach Attacke: " + testPlayer.getHp());
    }
}
