package Data.Level;

/**
 * This class represents a copy of Castle.
 * Castle2 also represents a DND level with its own room file & win condition.
 * Pictures related to game events are adjusted.
 * This class serves as a proof of principle reasons to show extendebility of the DND game.
 * The main idea here is extension and reusage of object components and graphical components, while completely
 * new quests can be created through a Level implementation combined with an individual rooms.txt.
 * @author Fabian Billenkamp
 * @author Martin Schneider
 */


import Data.GameObjects.Room;
import Data.GameObjects.Rooms;
import Data.GameObjects.Player;
import Data.GameObjects.Treasure;
import Parser.RoomsParser;
import javafx.scene.image.Image;
import view.Pictures;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Castle2 implements Level{
    /*
     **********************************************************************************
     *                                  Variables                                     *
     **********************************************************************************
     */
    private Image[][] castleView;
    private Map<String, Room> currentRoomsMap;
    private Map<String, Image> imageToDescription;
    private Image[][] roomView;
    private Map<String, Image> roomImageToDescription;
    private Rooms allRooms;
    private Map<String, Image> dungeonTwoInfoPics;

    /*
     **********************************************************************************
     *                                 Constructor                                    *
     **********************************************************************************
     */
    /**
     * Creates a Castle containing two image matrices to display the castle map
     * and the individual room pictures. Currently the dimensions of the matrices
     * are fixed due to the display grid dimensions in the fxml.
     * @author Martin Schneider
     */
    public Castle2() {
        this.castleView = new Image[7][7];
        this.roomView = new Image[7][7];
    }

    /*
     **********************************************************************************
     *            Getter methods for the different variables                          *
     **********************************************************************************
     */
    /**
     * {@inheritDoc}
     * Here content of level two is returned.
     */
    public  Map<String, Image> getDungeonInfoPics() {
        return dungeonTwoInfoPics;
    }

    /**
     * {@inheritDoc}
     */
    public  Image[][] getCastleView(){
        return castleView;
    }

    /**
     * {@inheritDoc}
     */
    public  Image[][] getViewAllRooms(){
        return roomView;
    }

    /**
     * {@inheritDoc}
     * Here the Rooms object of level two is returned.
     */
    public Rooms getAllRooms(){
        return allRooms;
    }

    /*
     **********************************************************************************
     *                                Level initialization                            *
     **********************************************************************************
     */
    /**
     * {@inheritDoc}
     * Using roomsHard.txt for loading a level layout.
     */
    public void load(){
        allRooms = new RoomsParser().parseRooms("src/Data/Level/roomsHard.txt");
        currentRoomsMap = allRooms.getRoomMap();
        imageToDescription = new HashMap<>();
        roomImageToDescription = new HashMap<>();
        dungeonTwoInfoPics = new HashMap<>();
        fillImageToDescription();
        fillDungeonTwoInfoPics();
    }

    /*
     **********************************************************************************
     *                                Game methods                                    *
     **********************************************************************************
     */
    /**
     * {@inheritDoc}
     * Here the starting text for level two of the DND implementation is loaded.
     */
    public String getStartText(){
        return "In the land of the ancient evil...\n\nYou are standing at the entrance of a castle again. Everything " +
                "looks strangely familiar. You can feel a scent of evil....\n\nMonsters might overwhelm you...\n";
    }

    /**
     * {@inheritDoc}
     * Here the text up on winning level two of the DND implementation is loaded.
     */
    public String getWinText(){
        return "You have killed the ancient evil and found the legendary treasure of the dragon. In the chest you find" +
                "they key to a new dimension....\n\nJust kidding, you find overflowing riches.\n";
    }

    /**
     * {@inheritDoc}
     * *Here the win condition for level two of the DND implementation is tested.
     * The item "The legendary treasure of the dragon." has to be in the inventory.
     */
    public boolean getWinCondition(Player player) {
        for (Treasure treasure : player.getInventory().getTreasures()) {
            if (treasure.getDescription().contains("The legendary treasure of the dragon.")) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public void move(String direction){
        allRooms.goToNextRoom(direction);
    }

    /*
     **********************************************************************************
     *                  Public picture manipulation methods                           *
     **********************************************************************************
     */
    /**
     * {@inheritDoc}
     * Here in level two of the DND implementation the image matrices
     * "castleView" and "roomView" are filled and pictures of red walls
     * are used to fill grids with no content. This graphically separates
     * level two from level one.
     */
    public void positionRoomsByName()  {
        fillImageToDescription();
        for (Map.Entry<String, Room> pair : currentRoomsMap.entrySet()) {
            Pattern pattern = Pattern.compile("(\\d*)-(\\d*)");
            int posRow = 0;
            int posCol = 0;
            Matcher match = pattern.matcher(pair.getKey());
            if (match.find()) {
                posRow = Integer.parseInt(match.group(1));
                posCol = Integer.parseInt(match.group(2))-1;
                castleView[posRow][posCol]= imageToDescription.get(pair.getValue().getDescription());
                roomView[posRow][posCol]= roomImageToDescription.get(pair.getValue().getDescription());
            }
            if(pair.getKey().contains("Entry")){
                castleView[0][2]= imageToDescription.get(pair.getValue().getDescription()); // eventually add info where in rooms.txt
                roomView[0][2]= roomImageToDescription.get(pair.getValue().getDescription());
            }
        }
        for (int  i = 0; i < castleView.length; i++){
            for (int j = 0; j < castleView[i].length; j++){
                if(castleView[i][j]== null){
                    castleView[i][j] = Pictures.tile01;
                    roomView[i][j] = Pictures.rock_wall01;
                }
            }
        }
    }

    /*
     **********************************************************************************
     *                  Private picture manipulation methods                          *
     **********************************************************************************
     */
    /**
     * Fills the hash maps containing string-, picture pairs for the dungeon map view and
     * the room view of the castle in level two of the DND implementation. 
     * The description strings of the rooms are matched with their designated 
     * picture for map and room.
     */
    private void fillImageToDescription(){
        imageToDescription.put("You see the entry to a dark dungeon. Just go ahead to enter!", Pictures.tile03);
        imageToDescription.put("A long dark hallway.", Pictures.tile11);
        imageToDescription.put("A small room, sparsely lighted by a torch." ,Pictures.tile12);
        imageToDescription.put("A high hall - the high ceiling is lost in the darkness.", Pictures.tile13);
        imageToDescription.put("Hallway with a tight branch-off.", Pictures.tile21);
        imageToDescription.put("An old chamber thomb with lots of cobweb.", Pictures.tile22);
        imageToDescription.put("Small dimly lit room.", Pictures.tile23);
        imageToDescription.put("Chamber lighted by bright torches.", Pictures.tile31);
        imageToDescription.put("Gloomy chamber with many old carcases.", Pictures.tile33);
        imageToDescription.put("This seems to be the armory of the dwarf. The most mighty weapon seems to be the lance.", Pictures.tile41);
        imageToDescription.put("Gloomy room with many bones.", Pictures.tile24 );
        imageToDescription.put("Gloomy room with many bones", Pictures.tile25);
        imageToDescription.put("Dark room with no light.", Pictures.tile26 );
        imageToDescription.put("Big hall with an offensive smell of burned meat.", Pictures.tile36);
        imageToDescription.put("Narrow hallway", Pictures.tile37);
        imageToDescription.put("Big dark cave arch.", Pictures.tile47);
        imageToDescription.put("Narrow hall.", Pictures.tile35);
        imageToDescription.put("Narrow hallway.", Pictures.tile45);
        imageToDescription.put("Hallway with thousands of spiders.", Pictures.tile44);
        imageToDescription.put("Narrow hallway with thousands of spiders.", Pictures.tile46);
        imageToDescription.put("Small room with an old wooden box.", Pictures.tile56);
        imageToDescription.put("Large Hallway with mysterious cold white light.", Pictures.tile16);
        imageToDescription.put("Crossing with two large tubes, dark with rotten smell to the right and dimly lit with gentle breeze of cold air to the left.", Pictures.tile06);
        imageToDescription.put("Round room sun-drenched with broken glass all over the ground, the ceiling is too high to get out.", Pictures.tile05);
        imageToDescription.put("Muddy cave with strong rotten smell and foggy greenish light.", Pictures.tile07);
        imageToDescription.put("Ostentatious hallway made of bright shiny stone with huge chandeliers and a luxuriant ceiling painting.", Pictures.tile54);
        imageToDescription.put("Luxuriant hall with sacral ceiling paintings.", Pictures.tile64);
        imageToDescription.put("Shiny room flooded with candle light and walls covered with amber and gold.", Pictures.tile65);
        imageToDescription.put("Graveyard with burned still glowing trees all inside a church like room with a large pentagram on the ceiling, the air is filled with burning ash and a red light seems to emerge from the pentagram.", Pictures.tile61);
        imageToDescription.put("Very narrow and dark, you found a secret passage! With a 3 meter fall at the end...", Pictures.tile52);
        imageToDescription.put("High hallway flanked with statuary.", Pictures.tile63);
        imageToDescription.put("Disfigured hallway with burn marks and strange writings and symbols on the pillars.", Pictures.tile62);
        
        roomImageToDescription.put("You see the entry to a dark dungeon. Just go ahead to enter!", Pictures.dungeon_entry);
        roomImageToDescription.put("A long dark hallway.", Pictures.long_dark_hallway);
        roomImageToDescription.put("A small room, sparsely lighted by a torch." ,Pictures.small_torch);
        roomImageToDescription.put("A high hall - the high ceiling is lost in the darkness.", Pictures.big_hall);
        roomImageToDescription.put("Hallway with a tight branch-off.", Pictures.tight_branch);
        roomImageToDescription.put("An old chamber thomb with lots of cobweb.", Pictures.thom_cobweb);
        roomImageToDescription.put("Small dimly lit room.", Pictures.dimly_lit);
        roomImageToDescription.put("Chamber lighted by bright torches.", Pictures.chamber_lighted);
        roomImageToDescription.put("Gloomy chamber with many old carcases.", Pictures.old_carcases);
        roomImageToDescription.put("This seems to be the armory of the dwarf. The most mighty weapon seems to be the lance.", Pictures.dwarf_armory);
        roomImageToDescription.put("Gloomy room with many bones.", Pictures.gloomy_bones );
        roomImageToDescription.put("Gloomy room with many bones", Pictures.bone_hall);
        roomImageToDescription.put("Dark room with no light.", Pictures.no_light );
        roomImageToDescription.put("Big hall with an offensive smell of burned meat.", Pictures.bighall_burned );
        roomImageToDescription.put("Narrow hallway", Pictures.narrow_hallway);
        roomImageToDescription.put("Big dark cave arch.", Pictures.cave_arch);
        roomImageToDescription.put("Narrow hall.", Pictures.narrow_hall);
        roomImageToDescription.put("Narrow hallway.", Pictures.hallway_narrow);
        roomImageToDescription.put("Hallway with thousands of spiders.", Pictures.thousand_spiders);
        roomImageToDescription.put("Narrow hallway with thousands of spiders.", Pictures.hallway_spiders);
        roomImageToDescription.put("Small room with an old wooden box.", Pictures.wooden_box);
        roomImageToDescription.put("Large Hallway with mysterious cold white light.", Pictures.cold_white);
        roomImageToDescription.put("Crossing with two large tubes, dark with rotten smell to the right and dimly lit with gentle breeze of cold air to the left.", Pictures.two_tubes);
        roomImageToDescription.put("Round room sun-drenched with broken glass all over the ground, the ceiling is too high to get out.", Pictures.sun_drenched);
        roomImageToDescription.put("Muddy cave with strong rotten smell and foggy greenish light.", Pictures.green_cave);
        roomImageToDescription.put("Ostentatious hallway made of bright shiny stone with huge chandeliers and a luxuriant ceiling painting.", Pictures.fancy_hallway);
        roomImageToDescription.put("Luxuriant hall with sacral ceiling paintings.", Pictures.fancy_hall);
        roomImageToDescription.put("Shiny room flooded with candle light and walls covered with amber and gold.", Pictures.amber_gold);
        roomImageToDescription.put("Graveyard with burned still glowing trees all inside a church like room with a large pentagram on the ceiling, the air is filled with burning ash and a red light seems to emerge from the pentagram.", Pictures.graveyard_pentagram);
        roomImageToDescription.put("Very narrow and dark, you found a secret passage! With a 3 meter fall at the end...", Pictures.secret_passage);
        roomImageToDescription.put("High hallway flanked with statuary.", Pictures.statue_hallway);
        roomImageToDescription.put("Disfigured hallway with burn marks and strange writings and symbols on the pillars.", Pictures.disfigured_hallway);
    }

     /**
     * Fills the hash map containing string- and picture pairs for room content display
     * in level two of the DND implementation. The content strings of rooms being
     * items or creatures are matched to their designated picture.
     */
    private void fillDungeonTwoInfoPics()
    {
        dungeonTwoInfoPics = new HashMap<String, Image>();
        dungeonTwoInfoPics.put("Troll leather armour", Pictures.troll_leather_armor);
        dungeonTwoInfoPics.put("Cursed Dragonscale armour", Pictures.shimmering_dragon_scale_mail);
        dungeonTwoInfoPics.put("Old Sword", Pictures.sword_of_power);
        dungeonTwoInfoPics.put("Sabre", Pictures.sabre);
        dungeonTwoInfoPics.put("Mjolnir", Pictures.hammer);
        dungeonTwoInfoPics.put("Gloin", Pictures.gnomish_wizard);
        dungeonTwoInfoPics.put("Splinter", Pictures.redback);
        dungeonTwoInfoPics.put("Fidibus", Pictures.lich_old);
        dungeonTwoInfoPics.put("Leech", Pictures.quasit);
        dungeonTwoInfoPics.put("Dominus", Pictures.gloorx_vloq);
        dungeonTwoInfoPics.put("Treasure", Pictures.chest);
        dungeonTwoInfoPics.put("Gargoyle", Pictures.gargoyle);
        dungeonTwoInfoPics.put("Grodagrim", Pictures.dwarf_king);
        dungeonTwoInfoPics.put("Gothofiedus", Pictures.sewer_rat);
        dungeonTwoInfoPics.put("Lothofiedus", Pictures.wererat);
        dungeonTwoInfoPics.put("Rothofiedus", Pictures.vampire_bat);
        dungeonTwoInfoPics.put("Excursius", Pictures.serpent_of_hell);
        dungeonTwoInfoPics.put("Ratskin",Pictures.animal_skin);
        dungeonTwoInfoPics.put("Teeth",Pictures.unicorn_horn);
        dungeonTwoInfoPics.put("Mithril armour", Pictures.elven_mithril_coat);
        dungeonTwoInfoPics.put("Dragonscale armour", Pictures.dragon_armor);
        dungeonTwoInfoPics.put("Sword", Pictures.sword1);
        dungeonTwoInfoPics.put("Knife", Pictures.crysknife);
        dungeonTwoInfoPics.put("Lance", Pictures.lance);
        dungeonTwoInfoPics.put("Key", Pictures.skeleton_key);
        dungeonTwoInfoPics.put("SaphireRing", Pictures.sapphire_ring);
        dungeonTwoInfoPics.put("Book",Pictures.book_of_the_dead);
        dungeonTwoInfoPics.put("Ratskin",Pictures.animal_skin);
        dungeonTwoInfoPics.put("Teeth",Pictures.unicorn_horn);
        dungeonTwoInfoPics.put("Dragonscales",Pictures.violet_gem);
        dungeonTwoInfoPics.put("Axe",Pictures.battle_axe1);
        dungeonTwoInfoPics.put("Shirt",Pictures.cloak);
    }
}