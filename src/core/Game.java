package core;

import Data.Level.Easy.Castle;
import Data.Level.Hard.Castle2;
import Data.GameObjects.Level;
import Data.GameObjects.*;
import Parser.ArmorParser;
import Parser.CreatureParser;
import Parser.TreasureParser;
import Parser.WeaponParser;
import Data.GameObjects.Room;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Fabian Billenkamp
 */
public class Game {
    private Map<String, Treasure> treasures = new TreasureParser().parseTreasures("./src/GameInputFiles/gold.txt");
    private HashMap<String, Weapon> weapons = WeaponParser.collectWeapons("./src/GameInputFiles/weapons.txt");
    private HashMap<String, Armour> armours = ArmorParser.parseArmours("./src/GameInputFiles/armors.txt");
    private HashMap<String, Creature> creatures = CreatureParser.collectCreatures("./src/GameInputFiles/creatures.txt",weapons,armours);
    private Creature monster;
    private Player player;
    private Level currentLevel;
    private Level[]levels;
    private int levelsWon=0;

    /*
     **********************************************************************************
     *            Getter methods for the different game components                    *
     **********************************************************************************
     */

    public Map<String, Treasure> getTreasures() {
        return treasures;
    }



    public HashMap<String, Weapon> getWeapons() {
        return weapons;
    }



    public HashMap<String, Armour> getArmours() {
        return armours;
    }



    public HashMap<String, Creature> getCreatures() {
        return creatures;
    }



    public boolean getWin(){
        if(levelsWon>=levels.length){
            return true;
        }else{
            return false;
        }
    }




    public void nextLevel(){
        levels[levelsWon].load();
        currentLevel=levels[levelsWon];

    }

    public int getLevelsWon() {
        return levelsWon;
    }

    public void setLevelsWon(int levelsWon) {
        this.levelsWon = levelsWon;
    }



    public Game() {
        levels = new Level[2];
        levels[0] = new Castle();
        levels[1] = new Castle2();
        player = new Player(creatures.get("You"),49);
        levels[levelsWon].load();
        currentLevel = levels[levelsWon];

    }

    public void setMonster(Creature monster) {
        this.monster = monster;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public Player getPlayer() {
        return player;
    }

    public Creature getMonster() {
        return monster;
    }

    public void move(String direction){
        currentLevel.move(direction);
        player.heal();
    }

    public Room getCurrentRoom(){
        return currentLevel.getAllRooms().getRoomByName(currentLevel.getAllRooms().getAktuellePosition());
    }

}
