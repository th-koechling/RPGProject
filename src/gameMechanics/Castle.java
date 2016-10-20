/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameMechanics;

/**
 *
 * @author Martins
 */


import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;
import javafx.scene.image.Image;


// remove call of method to test in FXwithMVC.java  / view.DnDcontrol (test2) !!!!!!!!

public class Castle {

    private  Room[] roomsInCastle;
    public  String roomsInput = new String();
    private  Image[][] castleView;
    static Map<String, Image> imageToDescription = new HashMap<>();
    
    
    
    public Castle() {
        this.castleView = new Image[7][7];
        
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
    
    private static void fillIamgeToDescription (){
        
        imageToDescription.put("You see the entry to a dark dungeon. Just go ahead to enter!", view.Pictures.dngn_entrance);
        imageToDescription.put("A long dark hallway.", view.Pictures.lit_corridor);
        imageToDescription.put("A small room, sparsely lighted by a torch." ,view.Pictures.floor_room);
        imageToDescription.put("A high hall - the high ceiling is lost in the darkness.", view.Pictures.stone_arch);
        imageToDescription.put("Hallway with a tight branch-off.", view.Pictures.floor_light);
        imageToDescription.put("An old chamber thomb with lots of cobweb.", view.Pictures.altar);
        imageToDescription.put("Small dimly lit room.", view.Pictures.floor_swamp);
        imageToDescription.put("Chamber lighted by bright torches.", view.Pictures.rock_wall14);
        imageToDescription.put("Gloomy chamber with many old carcases.", view.Pictures.floor_swamp);
        imageToDescription.put("This seems to be the armory of the dwarf. The most mighty weapon seems to be the lance.", view.Pictures.stone_arch);
        imageToDescription.put("Gloomy room with many bones.", view.Pictures.spiked_pit );
        imageToDescription.put("Gloomy room with many bones", view.Pictures.spiked_pit);
        imageToDescription.put("Dark room with no light.", view.Pictures.lit_corridor );
        imageToDescription.put("Big hall with an offensive smell of burned meat.", view.Pictures.lava );
        imageToDescription.put("Narrow hallway", view.Pictures.floor);
        imageToDescription.put("Big dark cave arch.", view.Pictures.stone_arch);
        imageToDescription.put("Narrow hall.", view.Pictures.floor_room);
        imageToDescription.put("Narrow hallway.", view.Pictures.floor);
        imageToDescription.put("Hallway with thousands of spiders.", view.Pictures.corridor);
        imageToDescription.put("Narrow hallway with thousands of spiders.", view.Pictures.dngn_enter_abyss);
        imageToDescription.put("Small room with an old wooden box.", view.Pictures.raised_drawbridge_h);
        imageToDescription.put("Large Hallway with mysterious cold white light.", view.Pictures.hallway_light);
        imageToDescription.put("Crossing with two large tubes, dark with rotten smell to the right and dimly lit with gentle breeze of cold air to the left.", view.Pictures.t_junction);
        imageToDescription.put("Round room sun-drenched with broken glass all over the ground, the ceiling is too high to get out.", view.Pictures.view_outside);
        imageToDescription.put("Muddy cave with strong rotten smell and foggy greenish light.", view.Pictures.green_cave);
        imageToDescription.put("Ostentatious hallway made of bright shiny stone with huge chandeliers and a luxuriant ceiling painting.", view.Pictures.fancy_hallway);
        imageToDescription.put("Luxuriant hall with sacral ceiling paintings.", view.Pictures.fance_hall);
        imageToDescription.put("Shiny room flooded with candle light and walls covered with amber and gold.", view.Pictures.treasure_room);
        imageToDescription.put("Graveyard with burned still glowing trees all inside a church like room with a large pentagram on the ceiling, the air is filled with burning ash and a red light seems to emerge from the pentagram.", view.Pictures.dark_ritual);
        imageToDescription.put("Very narrow dark passage with a 3 meter fall at the end.", view.Pictures.secret_passage);
        imageToDescription.put("High hallway flanked with statuary.", view.Pictures.statue_hallway);
        imageToDescription.put("Disfigured hallway with burn marks and strange writings and symbols on the pillars.", view.Pictures.disfigured_hallway);
         
    }
    Rooms allRooms = new Rooms("src/data/rooms_new.txt");
    Map<String, Room> test = allRooms.getRoomMap();
    public void positionRoomsByName()  {
        fillIamgeToDescription ();
        for (Map.Entry<String, Room> pair : test.entrySet()) {
             //System.out.println(pair.getKey());
             //System.out.println(pair.getValue().getDescription());
              
             Pattern pattern = Pattern.compile("(\\d*)-(\\d*)");
             int posRow = 0;
             int posCol = 0;
             Matcher match = pattern.matcher(pair.getKey());
             if (match.find()) {
                    posRow = Integer.parseInt(match.group(1));
                    posCol = Integer.parseInt(match.group(2))-1;
                    castleView[posRow][posCol]= imageToDescription.get(pair.getValue().getDescription());
             }
             if(pair.getKey().contains("Entry")){
                
                 castleView[0][2]= imageToDescription.get(pair.getValue().getDescription()); // eventually add info where in rooms.txt
                 
             }
        }
        
        for (int  i = 0; i < castleView.length; i++){
            for (int j = 0; j < castleView[i].length; j++){
                if(castleView[i][j]== null){
                    castleView[i][j] = view.Pictures.rock_wall01;
                }
                    
            }
        }
                    
    }

    public Rooms getAllRooms(){
        return allRooms;
    }
}