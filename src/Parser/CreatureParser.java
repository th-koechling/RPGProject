package Parser;

import Data.GameObjects.Armour;
import Data.GameObjects.Creature;
import Data.GameObjects.Weapon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * This class parses creatures from a .txt file and returns them as a HashMap.
 * @author Patrick Barth
 */
public class CreatureParser {

    /*
     **********************************************************************************
     *                               Parsing Method                                   *
     **********************************************************************************
     */

    /**
     * Parses all creatures from a .txt file
     * @param creatureFile .txt file that contains the creatures
     * @param weapons HashMap that contains all weapons
     * @param armours HashMap that contains all armours
     * @return HashMap that contains all creatures. Key is the name of the monster, value the creature object
     */
    public static HashMap<String, Creature> collectCreatures(String creatureFile, HashMap<String,Weapon> weapons, HashMap<String,Armour> armours){
        return parseCreatures(creatureFile,weapons,armours);
    }

    private static HashMap<String,Creature> parseCreatures (String file, HashMap<String,Weapon> weapons, HashMap<String,Armour> armours){
        HashMap<String, Creature> allCreatures = new HashMap<>();
        try {
            BufferedReader br = readFile(file);
            String name = "";
            String species = "";
            String description = "";
            int xp = 0;
            int hp = 0;
            int baseDamage = 0;
            Armour armour = new Armour("", 0, "");
            Weapon weapon = new Weapon("", 0, "");
            String line;
            while ((line = br.readLine()) != null) {

                if (line.matches("Name: .*")) {
                    name = line.substring(6);
                } else if (line.matches("Species: .*")) {
                    species = line.substring(9);
                } else if (line.matches("Description: .*")) {
                    description = line.substring(13);
                } else if (line.matches("Experience: .*")) {
                    xp = Integer.valueOf(line.substring(12));
                } else if (line.matches("HealthStatus: .*")) {
                    hp = Integer.valueOf(line.substring(14));
                } else if (line.matches("BaseDamage: .*")) {
                    baseDamage = Integer.valueOf(line.substring(12));
                } else if (line.matches("Armor: .*")) {
                    armour = armours.get(line.substring(7));
                } else if (line.matches("Weapon: .*")) {
                    weapon = weapons.get(line.substring(8));
                } else if (line.matches("")) {

                    allCreatures.put(name, new Creature(name, species, description, xp, hp,baseDamage, armour, weapon));
                }
            }
            allCreatures.put(name, new Creature(name, species, description, xp, hp,baseDamage, armour, weapon));
        } catch (Exception e) {
            System.out.println("Could not read creatures");
            System.exit(1);
        }
        return allCreatures;

    }

    private static BufferedReader readFile(String file) throws IOException{
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        return br;
    }
}
