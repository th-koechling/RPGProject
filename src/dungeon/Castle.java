/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author Martins
 */


import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;
import view.*;
import Parser.RoomsParser;
import javafx.scene.image.Image;


// remove call of method to test in FXwithMVC.java  / view.DnDcontrol (test2) !!!!!!!!

public class Castle {

    private  Room[] roomsInCastle;
    public  String roomsInput = new String();
    private  Image[][] castleView;
    static Map<String, Image> imageToDescription = new HashMap<>();
    private Image[][] roomView;
    static Map<String, Image> roomImageToDescription = new HashMap<>();
    Rooms allRooms = new RoomsParser().parseRooms("src/GameInputFiles/rooms_new.txt");
    Map<String, Room> test = allRooms.getRoomMap();


    public Castle() {
        this.castleView = new Image[7][7];
        this.roomView = new Image[7][7];
        
    }

    public static void buildCastle() {
        
    }
    public  void setCastleSize(int inputSize){
        roomsInCastle = new Room[inputSize];
    }
    public  int getCastleSize(){
        return roomsInCastle.length;
    }
    public void setRoomsInCastle(Room[] roomsInCastle) {
        this.roomsInCastle = roomsInCastle;
    }

    public Room[] getRoomsInCastle() {
        return this.roomsInCastle;
    }
    public  void setRoomInCastle(Room inputRoom, int index){
        roomsInCastle[index] = inputRoom;
    }
    public  Room getRoomInCastle(int index){
        return roomsInCastle[index];
    }

    public Room generateRoom() {
        // TODO: implement
        return null;
    }
    
    public  Image[][] getCastleView(){
        return castleView;
    }
    public  Image[][] getViewAllRooms(){
        return roomView;
    }
    
    private static void fillIamgeToDescription (){
        
        imageToDescription.put("You see the entry to a dark dungeon. Just go ahead to enter!", view.Pictures.tile03);
        imageToDescription.put("A long dark hallway.", view.Pictures.tile11);
        imageToDescription.put("A small room, sparsely lighted by a torch." ,view.Pictures.tile12);
        imageToDescription.put("A high hall - the high ceiling is lost in the darkness.", view.Pictures.tile13);
        imageToDescription.put("Hallway with a tight branch-off.", view.Pictures.tile21);
        imageToDescription.put("An old chamber thomb with lots of cobweb.", view.Pictures.tile22);
        imageToDescription.put("Small dimly lit room.", view.Pictures.tile23);
        imageToDescription.put("Chamber lighted by bright torches.", view.Pictures.tile31);
        imageToDescription.put("Gloomy chamber with many old carcases.", view.Pictures.tile33);
        imageToDescription.put("This seems to be the armory of the dwarf. The most mighty weapon seems to be the lance.", view.Pictures.tile41);
        imageToDescription.put("Gloomy room with many bones.", view.Pictures.tile24 );
        imageToDescription.put("Gloomy room with many bones", view.Pictures.tile25);
        imageToDescription.put("Dark room with no light.", view.Pictures.tile26 );
        imageToDescription.put("Big hall with an offensive smell of burned meat.", view.Pictures.tile36);
        imageToDescription.put("Narrow hallway", view.Pictures.tile37);
        imageToDescription.put("Big dark cave arch.", view.Pictures.tile47);
        imageToDescription.put("Narrow hall.", view.Pictures.tile35);
        imageToDescription.put("Narrow hallway.", view.Pictures.tile45);
        imageToDescription.put("Hallway with thousands of spiders.", view.Pictures.tile44);
        imageToDescription.put("Narrow hallway with thousands of spiders.", view.Pictures.tile46);
        imageToDescription.put("Small room with an old wooden box.", view.Pictures.tile56);
        imageToDescription.put("Large Hallway with mysterious cold white light.", view.Pictures.tile16);
        imageToDescription.put("Crossing with two large tubes, dark with rotten smell to the right and dimly lit with gentle breeze of cold air to the left.", view.Pictures.tile06);
        imageToDescription.put("Round room sun-drenched with broken glass all over the ground, the ceiling is too high to get out.", view.Pictures.tile05);
        imageToDescription.put("Muddy cave with strong rotten smell and foggy greenish light.", view.Pictures.tile07);
        imageToDescription.put("Ostentatious hallway made of bright shiny stone with huge chandeliers and a luxuriant ceiling painting.", view.Pictures.tile54);
        imageToDescription.put("Luxuriant hall with sacral ceiling paintings.", view.Pictures.tile64);
        imageToDescription.put("Shiny room flooded with candle light and walls covered with amber and gold.", view.Pictures.tile65);
        imageToDescription.put("Graveyard with burned still glowing trees all inside a church like room with a large pentagram on the ceiling, the air is filled with burning ash and a red light seems to emerge from the pentagram.", view.Pictures.tile61);
        imageToDescription.put("Very narrow dark passage with a 3 meter fall at the end.", view.Pictures.tile52);
        imageToDescription.put("High hallway flanked with statuary.", view.Pictures.tile63);
        imageToDescription.put("Disfigured hallway with burn marks and strange writings and symbols on the pillars.", view.Pictures.tile62);
        roomImageToDescription.put("You see the entry to a dark dungeon. Just go ahead to enter!", view.Pictures.dungeon_entry);
        roomImageToDescription.put("A long dark hallway.", view.Pictures.long_dark_hallway);
        roomImageToDescription.put("A small room, sparsely lighted by a torch." ,view.Pictures.small_torch);
        roomImageToDescription.put("A high hall - the high ceiling is lost in the darkness.", view.Pictures.big_hall);
        roomImageToDescription.put("Hallway with a tight branch-off.", view.Pictures.tight_branch);
        roomImageToDescription.put("An old chamber thomb with lots of cobweb.", view.Pictures.thom_cobweb);
        roomImageToDescription.put("Small dimly lit room.", view.Pictures.dimly_lit);
        roomImageToDescription.put("Chamber lighted by bright torches.", view.Pictures.chamber_lighted);
        roomImageToDescription.put("Gloomy chamber with many old carcases.", view.Pictures.old_carcases);
        roomImageToDescription.put("This seems to be the armory of the dwarf. The most mighty weapon seems to be the lance.", view.Pictures.dwarf_armory);
        roomImageToDescription.put("Gloomy room with many bones.", view.Pictures.gloomy_bones );
        roomImageToDescription.put("Gloomy room with many bones", view.Pictures.bone_hall);
        roomImageToDescription.put("Dark room with no light.", view.Pictures.no_light );
        roomImageToDescription.put("Big hall with an offensive smell of burned meat.", view.Pictures.bighall_burned );
        roomImageToDescription.put("Narrow hallway", view.Pictures.narrow_hallway);
        roomImageToDescription.put("Big dark cave arch.", view.Pictures.cave_arch);
        roomImageToDescription.put("Narrow hall.", view.Pictures.narrow_hall);
        roomImageToDescription.put("Narrow hallway.", view.Pictures.hallway_narrow);
        roomImageToDescription.put("Hallway with thousands of spiders.", view.Pictures.thousand_spiders);
        roomImageToDescription.put("Narrow hallway with thousands of spiders.", view.Pictures.hallway_spiders);
        roomImageToDescription.put("Small room with an old wooden box.", view.Pictures.wooden_box);
        roomImageToDescription.put("Large Hallway with mysterious cold white light.", view.Pictures.cold_white);
        roomImageToDescription.put("Crossing with two large tubes, dark with rotten smell to the right and dimly lit with gentle breeze of cold air to the left.", view.Pictures.two_tubes);
        roomImageToDescription.put("Round room sun-drenched with broken glass all over the ground, the ceiling is too high to get out.", view.Pictures.sun_drenched);
        roomImageToDescription.put("Muddy cave with strong rotten smell and foggy greenish light.", view.Pictures.green_cave);
        roomImageToDescription.put("Ostentatious hallway made of bright shiny stone with huge chandeliers and a luxuriant ceiling painting.", view.Pictures.fancy_hallway);
        roomImageToDescription.put("Luxuriant hall with sacral ceiling paintings.", view.Pictures.fancy_hall);
        roomImageToDescription.put("Shiny room flooded with candle light and walls covered with amber and gold.", view.Pictures.amber_gold);
        roomImageToDescription.put("Graveyard with burned still glowing trees all inside a church like room with a large pentagram on the ceiling, the air is filled with burning ash and a red light seems to emerge from the pentagram.", view.Pictures.graveyard_pentagram);
        roomImageToDescription.put("Very narrow dark passage with a 3 meter fall at the end.", view.Pictures.secret_passage);
        roomImageToDescription.put("High hallway flanked with statuary.", view.Pictures.statue_hallway);
        roomImageToDescription.put("Disfigured hallway with burn marks and strange writings and symbols on the pillars.", view.Pictures.disfigured_hallway);
         
    }

    public void positionRoomsByName()  {
        fillIamgeToDescription ();
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
                    castleView[i][j] = view.Pictures.tile01;
                    roomView[i][j] = view.Pictures.rock_wall01;
                }
                    
            }
        }
                    
    }

    public Rooms getAllRooms(){
        return allRooms;
    }
}