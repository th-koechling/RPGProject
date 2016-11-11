/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Level.Easy;

/**
 *
 * @author Martins
 */
import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;
import Data.GameObjects.Player;
import Data.GameObjects.Treasure;
import Data.GameObjects.Level;
import view.*;
import Data.GameObjects.Room;
import Data.GameObjects.Rooms;
import Parser.RoomsParser;
import javafx.scene.image.Image;


public class Castle implements Level{
    private Image[][] castleView;
    private Map<String, Room> test;
    private Map<String, Image> imageToDescription;
    private Image[][] roomView;
    private Map<String, Image> roomImageToDescription;
    private Rooms allRooms;
    private Map<String, Image> dungeonOneInfoPics;

    public Castle() {
        this.castleView = new Image[7][7];
        this.roomView = new Image[7][7];

    }

    public void load(){
        allRooms = new RoomsParser().parseRooms("src/Data/Level/Easy/roomsEasy.txt");
        test = allRooms.getRoomMap();
        imageToDescription = new HashMap<>();
        roomImageToDescription = new HashMap<>();
        dungeonOneInfoPics = new HashMap<>();
        fillImageToDescription();
        fillDungeonOneInfoPics();
    }
    public String getStartText(){
        return "You are on a hunt for the legendary treasure of the dragon. This legendary treasure was protected by " +
                "Excursius, an ancient wise dragon, for more than one hundred years now. You are standing at the entrance" +
                " to his castle.\n\nTake care of monsters!\n";
    }

    public String getWinText(){
        return "You have found a way through the castle and killed Excursius, but he was only one manifestation of " +
                "the ancient evil that protects the treasure. The bone key opens a door to the land of the ancient evil...";
    }
    public boolean getWinCondition(Player player) {
        for (Treasure treasure : player.getInventory().getTreasures()) {
            if (treasure.getDescription().contains("A key made of bones")) {
                return true;
            }
        }
        return false;
    }


    public  Map<String, Image> getDungeonOneInfoPics() {
        return dungeonOneInfoPics;
    }


    public  Image[][] getCastleView(){
        return castleView;
    }
    public  Image[][] getViewAllRooms(){
        return roomView;
    }




    public void positionRoomsByName()  {
        fillImageToDescription();
        for (Map.Entry<String, Room> pair : test.entrySet()) {
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

    public Rooms getAllRooms(){
        return allRooms;
    }

    public void move(String direction){
        allRooms.goToNextRoom(direction);
    }


    
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
        imageToDescription.put("Very narrow dark passage with a 3 meter fall at the end.", Pictures.tile52);
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
        roomImageToDescription.put("Graveyard with burned still glowing trees all inside a church like room with a large pentagram on the ceiling, the air is filled with burning ash and a red light seems to emerge from the pentagram.", view.Pictures.graveyard_pentagram);
        roomImageToDescription.put("Very narrow dark passage with a 3 meter fall at the end.", Pictures.secret_passage);
        roomImageToDescription.put("High hallway flanked with statuary.", Pictures.statue_hallway);
        roomImageToDescription.put("Disfigured hallway with burn marks and strange writings and symbols on the pillars.", Pictures.disfigured_hallway);
         
    }



    // dungeon number one: hash map containing the images for the infopic view pane:
    //moved to castle by FB for better level handling purposes

    private void fillDungeonOneInfoPics()
    {
        dungeonOneInfoPics = new HashMap<String, Image>();
        dungeonOneInfoPics.put("Mithril armour", Pictures.elven_mithril_coat);
        dungeonOneInfoPics.put("Dragonscale armour", Pictures.dragon_armor);
        dungeonOneInfoPics.put("Sword", Pictures.sword1);
        dungeonOneInfoPics.put("Knife", Pictures.crysknife);
        dungeonOneInfoPics.put("Lance", Pictures.lance);
        dungeonOneInfoPics.put("Grodagrim", Pictures.dwarf_king);
        dungeonOneInfoPics.put("Gothofiedus", Pictures.sewer_rat);
        dungeonOneInfoPics.put("Lothofiedus", Pictures.wererat);
        dungeonOneInfoPics.put("Rothofiedus", Pictures.vampire_bat);
        dungeonOneInfoPics.put("Excursius", Pictures.serpent_of_hell);
        dungeonOneInfoPics.put("Key", Pictures.skeleton_key);
        dungeonOneInfoPics.put("SaphireRing", Pictures.sapphire_ring);
        dungeonOneInfoPics.put("Book",Pictures.book_of_the_dead);
    }
}