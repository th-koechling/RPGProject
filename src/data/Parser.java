package data;

import gameMechanics.Creature;
import gameMechanics.Weapon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Patrick on 15.09.2016.
 */
public class Parser {

    public static void main(String[] ARGS)throws IOException{
        HashMap<String,Creature> yoo= collectCreatures();
        System.out.println(yoo.get("You").getWeapon().getName());
    }

    private Parser(){}

    private static HashMap<String,Creature> parseCreatures (String file)throws IOException{
        BufferedReader br=readFile(file);

        HashMap<String,Creature> allCreatures=new HashMap<>();

        String name="";
        String species="";
        String description="";
        int xp=0;
        int hp=0;
        int baseDamage=0;
        int armor=0;
        Weapon weapon=new Weapon("",0,"");

        String line;

        while((line=br.readLine())!=null){

            if(line.matches("Name: .*")){
                name=line.substring(6);
            } else if(line.matches("Species: .*")){
                species=line.substring(9);
            } else if(line.matches("Description: .*")){
                description=line.substring(13);
            } else if(line.matches("Experience: .*")){
                xp=Integer.valueOf(line.substring(12));
            } else if(line.matches("HealthStatus: .*")){
                hp=Integer.valueOf(line.substring(14));
            } else if(line.matches("BaseDamage: .*")){
                baseDamage=Integer.valueOf(line.substring(12));
            } else if(line.matches("Armor: .*")){
                armor=Integer.valueOf(line.substring(7));
            } else if(line.matches("Weapon: .*")){

               weapon=collectWeapons().get(line.substring(8));
            } else if(line.matches("")){

                allCreatures.put(name,new Creature(name,species,description,xp,hp,armor,weapon));
            }
        }
        allCreatures.put(name,new Creature(name,species,description,xp,hp,armor,weapon));


        return allCreatures;
    }

    private static HashMap<String,Weapon> parseWeapons (String file)throws IOException{
        BufferedReader br=readFile(file);

        HashMap<String,Weapon> allWeapons=new HashMap<>();

        String name="";
        int force=0;
        String description="";


        String line;

        while((line=br.readLine())!=null){

            if(line.matches("Name: .*")){
                name=line.substring(6);
            } else if(line.matches("Force: .*")){
                force=Integer.valueOf(line.substring(7));
            } else if(line.matches("Description: .*")){
                description=line.substring(13);

            } else if(line.matches("")){
                allWeapons.put(name,new Weapon(name,force,description));
            }
        }
        allWeapons.put(name,new Weapon(name,force,description));

        return allWeapons;
    }

    /**
     * Returns an array that contains all weapons saved in weapons.txt
     * @returnArray  with all weapons
     * @throws IOException
     */

    public static HashMap<String, Weapon> collectWeapons()throws IOException{
        return parseWeapons("src/data/weapons.txt");
    }

    /**
     * Returns an array that contains all creatures saved in creatures.txt
     * @return Array with all creatures
     * @throws IOException
     */

    public static HashMap<String, Creature> collectCreatures()throws IOException{
        return parseCreatures("src/data/creatures.txt");
    }





    /*private static int countLines(BufferedReader br)throws IOException{
        int lineNumber=0;
        while(br.readLine() != null){
            lineNumber++;
        }
        return lineNumber;
    }*/

    private static BufferedReader readFile(String file) throws IOException{
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        return br;
    }
}
