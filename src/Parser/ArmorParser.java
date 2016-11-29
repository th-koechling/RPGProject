package Parser;

import Data.GameObjects.Armour;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * This class is the representation of a parser for treasures.txt files based on WeaponParser.java
 * @author Andreas Hoek
 * @author Fabian Billenkamp
 */
public class ArmorParser {
    /*
     **********************************************************************************
     *                               Parsing Method                                   *
     **********************************************************************************
     */
    /**
     * This method is used to create a hash map of armours from a txt file.
     * @param file The Path where the armours.txt file is located
     * @return HashMap: Armourname:Armour
     */
    public static HashMap<String,Armour> parseArmours (String file) {
        HashMap<String, Armour> allArmours = new HashMap<>();
        try {
            BufferedReader br = readFile(file);
            String name = "";
            int defence = 0;
            String description = "";
            String line;
            while ((line = br.readLine()) != null) {
                if (line.matches("Name: .*")) {
                    name = line.substring(6);
                } else if (line.matches("Defence: .*")) {
                    defence = Integer.valueOf(line.substring(9));
                } else if (line.matches("Description: .*")) {
                    description = line.substring(13);

                } else if (line.matches("")) {
                    allArmours.put(name, new Armour(name, defence, description));
                }
            }
            allArmours.put(name, new Armour(name, defence, description));
        }catch (Exception e){
            System.out.println("Could not parse Weapons");
        }
        return allArmours;
    }

    private static BufferedReader readFile(String file) throws IOException{
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        return br;
    }
}
