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
     *                              Game constructor                                  *
     **********************************************************************************
     */

    /**
     *
     */
    public Game() {
        levels = new Level[2];
        levels[0] = new Castle();
        levels[1] = new Castle2();
        player = new Player(creatures.get("You"),49);
        levels[levelsWon].load();
        currentLevel = levels[levelsWon];

    }



    /*
     **********************************************************************************
     *            Getter methods for the different game components                    *
     **********************************************************************************
     */

    /**
     *
     * @return
     */
    public Map<String, Treasure> getTreasures() {
        return treasures;
    }

    /**
     *
     * @return
     */
    public HashMap<String, Weapon> getWeapons() {
        return weapons;
    }


    /**
     *
     * @return
     */
    public HashMap<String, Armour> getArmours() {
        return armours;
    }

    /**
     *
     * @return
     */
    public HashMap<String, Creature> getCreatures() {
        return creatures;
    }

    /**
     *
     * @return
     */
    public boolean getWin(){
        if(levelsWon>=levels.length){
            return true;
        }else{
            return false;
        }
    }

    /**
     *
     * @return
     */
    public Room getCurrentRoom(){
        return currentLevel.getAllRooms().getRoomByName(currentLevel.getAllRooms().getAktuellePosition());
    }

    /**
     *
     * @return
     */
    public int getLevelsWon() {
        return levelsWon;
    }

    /**
     *
     * @return
     */
    public Level getCurrentLevel() {
        return currentLevel;
    }

    /**
     *
     * @return
     */
    public Player getPlayer() {
        return player;
    }

    /**
     *
     * @return
     */
    public Creature getMonster() {
        return monster;
    }


    /*
     **********************************************************************************
     *                                Level change                                    *
     **********************************************************************************
     */

    /**
     *
     */
    public void nextLevel(){
        levels[levelsWon].load();
        currentLevel=levels[levelsWon];

    }

    /**
     *
     * @param levelsWon
     */
    public void setLevelsWon(int levelsWon) {
        this.levelsWon = levelsWon;
    }

    /*
     **********************************************************************************
     *                        Current level manipulation                              *
     **********************************************************************************
     */

    /**
     * 
     * @param direction
     */
    public void move(String direction){
        currentLevel.move(direction);
        player.heal();
    }
    /**
     *
     * @param monster
     */
    public void setMonster(Creature monster) {
        this.monster = monster;
    }




}
