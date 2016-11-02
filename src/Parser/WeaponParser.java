package Parser;

import GameObjects.Weapon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Patrick
 */
public class WeaponParser {
    private static HashMap<String,Weapon> parseWeapons (String file) {
        HashMap<String, Weapon> allWeapons = new HashMap<>();
        try {
            BufferedReader br = readFile(file);



            String name = "";
            int force = 0;
            String description = "";


            String line;

            while ((line = br.readLine()) != null) {

                if (line.matches("Name: .*")) {
                    name = line.substring(6);
                } else if (line.matches("Force: .*")) {
                    force = Integer.valueOf(line.substring(7));
                } else if (line.matches("Description: .*")) {
                    description = line.substring(13);

                } else if (line.matches("")) {
                    allWeapons.put(name, new Weapon(name, force, description));
                }
            }
            allWeapons.put(name, new Weapon(name, force, description));
        }catch (Exception e){
            System.out.println("Could not parse Weapons");
        }

        return allWeapons;
    }
    /**
     * Returns an array that contains all weapons saved in weapons.txt
     * @returnArray  with all weapons
     */
    //could delete this method now since we use the files from method call in dnd control (also see creatures)
    public static HashMap<String, Weapon> collectWeapons(String file){
        return parseWeapons(file);
    }



    private static BufferedReader readFile(String file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        return br;
    }
}
