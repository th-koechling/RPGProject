package Data;

import Data.Level.Castle;
import Data.Level.Castle2;
import Data.Level.Level;
import Data.GameObjects.*;
import Parser.ArmorParser;
import Parser.CreatureParser;
import Parser.TreasureParser;
import Parser.WeaponParser;
import Data.GameObjects.Room;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

/**
 * This class collects the variables and methods need for a game of DND.
 * Here the needed items, monsters and levels are initialized as well as
 * access methods for game components are available.
 * @author Fabian Billenkamp
 */
public class Game {
    /*
    **********************************************************************************
    *                                  Variables                                     *
    **********************************************************************************
    */
    private Map<String, Treasure> treasures = new TreasureParser().parseTreasures("./src/Data/GameObjectFiles/gold.txt");
    private HashMap<String, Weapon> weapons = WeaponParser.collectWeapons("./src/Data/GameObjectFiles/weapons.txt");
    private HashMap<String, Armour> armours = ArmorParser.parseArmours("./src/Data/GameObjectFiles/armors.txt");
    private HashMap<String, Creature> creatures = CreatureParser.collectCreatures("./src/Data/GameObjectFiles/creatures.txt",weapons,armours);
    private HashMap<String, Image> itemViewInfo= new HashMap<>();
    private Creature monster;
    private Player player;
    private Level currentLevel;
    private Level[]levels;
    private int levelsWon=0;
    /*
     **********************************************************************************
     *                                 Constructor                                    *
     **********************************************************************************
     */
    /**
     *Constructor for a DND game
     * The constructor will create a DND game with 1 player and 2 levels. In addition the first level is loaded
     * and set as current level.
     * @author Fabian Billenkamp
     */
    public Game() {
        levels = new Level[2];
        levels[0] = new Castle();
        levels[1] = new Castle2();
        player = new Player(creatures.get("You"));
        levels[levelsWon].load();
        currentLevel = levels[levelsWon];
        setItemImages();
    }

    /*
     **********************************************************************************
     *            Getter methods for the different variables                          *
     **********************************************************************************
     */
    /**
     * Getter method for a hash map with all treasures in a DND game.
     * Returns a hash map of the treasures available in the current game
     * @return a hash map String treasurename: Treasure treasure
     * @author Fabian Billenkamp
     */
    public Map<String, Treasure> getTreasures() {
        return treasures;
    }

    /**
     * Getter method for a hash map with all weapons in a DND game.
     * Returns a hash map of the weapons available in the current game
     * @return a hash map String weaponname: Weapon weapon
     * @author Fabian Billenkamp
     */
    public HashMap<String, Weapon> getWeapons() {
        return weapons;
    }

    /**
     * Getter method for a hash map with all armours in a DND game.
     * Returns a hash map of the armours available in the current game
     * @return a hash map String armourname: Armour armour
     * @author Fabian Billenkamp
     */
    public HashMap<String, Armour> getArmours() {
        return armours;
    }

    /**
     * Getter method for a hash map with all creatures in a DND game.
     * Returns a hash map of the creatures available in the current game
     * @return a hash map String creaturename: Creature creature
     * @author Fabian Billenkamp
     */
    public HashMap<String, Creature> getCreatures() {
        return creatures;
    }

    /**
     * Getter method for the win condition of a DND game.
     * This methods compares the number of won levels to the number of levels available.
     * If both numbers are equal, game is considered won
     * @return boolean: true: if all levels won, false: else
     * @author Fabian Billenkamp
     */
    public boolean getWin(){
        if(levelsWon>=levels.length){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Getter method for the current room in a DND game.
     * This method returns the current room (where the player is situated) of a game.
     * This room is called from the current level, where the current room is called from the corresponding
     * rooms of the level.
     * @return the current Room of the DND game
     * @author Fabian Billenkamp
     */
    public Room getCurrentRoom(){
        return currentLevel.getAllRooms().getRoomByName(currentLevel.getAllRooms().getAktuellePosition());
    }

    /**
     * Getter method for the number of levels a player has completed in a DND game.
     * Returns the total number of levels where the win condition is met.
     * @return integer: number of levels won.
     * @author Fabian Billenkamp
     */
    public int getLevelsWon() {
        return levelsWon;
    }

    /**
     * Getter method for the current level of a DND game.
     * Returns the currently loaded level
     * @return the current level of a DND game as an objext
     * @author Fabian Billenkamp
     */
    public Level getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Getter method for the player of a DND game.
     * Returns the player of the dnd game
     * @return Player: the player of the DND game
     * @author Fabian Billenkamp
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Returns the current monster in a DND game.
     * Whenever a room with a monster is entered, the monster is created as a Creature object.
     * @return Creature the current monster
     * @author Fabian Billenkamp
     */
    public Creature getMonster() {
        return monster;
    }

    public HashMap<String,Image> getItemViewInfo(){return itemViewInfo;}


    /*
     **********************************************************************************
     *                                Level change                                    *
     **********************************************************************************
     */
    /**
     * Method for changing the level in a DND game.
     * When a level is won, this method can be called to activate the next level of the level array in the game class
     * in case the number of levels won is smaller than the number of total levels.
     * @author Fabian Billenkamp
     */
    public void nextLevel(){
        if (levelsWon<levels.length) {
            levels[levelsWon].load();
            currentLevel = levels[levelsWon];
            setItemImages();
        }
    }

    /**
     * Method for setting the number of won levels in a DND game.
     * Common usage: add 1 to levelsWon
     * @param levelsWon Integer: the number of won levels won, must be smaller than or equal to the total number of levels.
     * @author Fabian Billenkamp
     */
    public void setLevelsWon(int levelsWon) {
        if(levelsWon<=levels.length) {
            this.levelsWon = levelsWon;
        }
    }

    /*
     **********************************************************************************
     *                        Current level manipulation                              *
     **********************************************************************************
     */

    /**
     * Method for moving the player in the current level and heal the player upon moving.
     * Take a direction in String format as parameter
     * @param direction String: N,O,S,W are allowed
     * @author Fabian Billenkamp adjusted and transfered from DNDControl
     */
    public void move(String direction){
        currentLevel.move(direction);
        player.heal();
    }

    /**
     * Sets the current monster of the DND game.
     * Is used when a room contains a monster to spawn this monster an make it available for fights.
     * @param monster a monster Creature
     * @author Fabian Billenkamp
     */
    public void setMonster(Creature monster) {
        this.monster = monster;
    }


    private void setItemImages(){
        for(String name : currentLevel.getDungeonOneInfoPics().keySet()){
            itemViewInfo.put(name,currentLevel.getDungeonOneInfoPics().get(name));
        }
    }
}
