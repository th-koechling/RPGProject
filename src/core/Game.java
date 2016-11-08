package core;

import GameObjects.*;
import Parser.ArmorParser;
import Parser.CreatureParser;
import Parser.TreasureParser;
import Parser.WeaponParser;
import dungeon.Castle;
import dungeon.Room;
import javafx.scene.image.Image;
import view.Pictures;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Fabian Billenkamp on 08.11.2016.
 */
public class Game {
    private Map<String, Treasure> treasures = new TreasureParser().parseTreasures("./src/GameInputFiles/gold.txt");
    private HashMap<String, Weapon> weapons = WeaponParser.collectWeapons("./src/GameInputFiles/weapons.txt");
    private HashMap<String, Armour> armours = ArmorParser.parseArmours("./src/GameInputFiles/armors.txt");
    private HashMap<String, Creature> creatures = CreatureParser.collectCreatures("./src/GameInputFiles/creatures.txt",weapons,armours);
    private Player player;

    public Castle getCurrentMap() {
        return currentMap;
    }

    private Castle currentMap;

    Castle[]levels = new Castle[1];
    public Game() {
        levels[0] = new Castle();
        player= new Player(creatures.get("You"),49);
        currentMap=levels[0];
    }
    public void move(String direction){
        currentMap.getAllRooms().goToNextRoom(direction);
        player.heal();
    }

}
