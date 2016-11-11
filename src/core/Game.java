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
 * Created by Fabian Billenkamp on 08.11.2016.
 */
public class Game {
    public Map<String, Treasure> getTreasures() {
        return treasures;
    }

    private Map<String, Treasure> treasures = new TreasureParser().parseTreasures("./src/GameInputFiles/gold.txt");

    public HashMap<String, Weapon> getWeapons() {
        return weapons;
    }

    private HashMap<String, Weapon> weapons = WeaponParser.collectWeapons("./src/GameInputFiles/weapons.txt");

    public HashMap<String, Armour> getArmours() {
        return armours;
    }

    private HashMap<String, Armour> armours = ArmorParser.parseArmours("./src/GameInputFiles/armors.txt");

    public HashMap<String, Creature> getCreatures() {
        return creatures;
    }

    private HashMap<String, Creature> creatures = CreatureParser.collectCreatures("./src/GameInputFiles/creatures.txt",weapons,armours);

    public boolean getWin(){
        if(levelsWon>=levels.length){
            return true;
        }else{
            return false;
        }
    }

    private Creature monster;
    private Player player;
    private Level currentLevel;
    private Level[]levels;


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

    private int levelsWon=0;

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
