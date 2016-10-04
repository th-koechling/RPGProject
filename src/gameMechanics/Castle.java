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

    private static Room[] roomsInCastle;
    public static String roomsInput = new String();
    private static Image[][] castleView = new Image[7][7];
    static Map<String, Image> imageToDescription = new HashMap<>();
    
    
    
    public Castle(Room[] roomsInCastle) {
        this.roomsInCastle = roomsInCastle;
        
    }

    public static void buildCastle() {
        
    }
    public static void setCastleSize(int inputSize){
        roomsInCastle = new Room[inputSize];
    }
    public static int getCastleSize(){
        return roomsInCastle.length;
    }
    public void setRoomsInCastle(Room[] roomsInCastle) {
        this.roomsInCastle = roomsInCastle;
    }

    public Room[] getRoomsInCastle() {
        return this.roomsInCastle;
    }
    public static void setRoomInCastle(Room inputRoom, int index){
        roomsInCastle[index] = inputRoom;
    }
    public static Room getRoomInCastle(int index){
        return roomsInCastle[index];
    }

    public Room generateRoom() {
        // TODO: implement
        return null;
    }
    
    public static Image[][] getCastleView(){
        return castleView;
    }
    
    private static void fillIamgeToDescription (){
        
        imageToDescription.put("You see the entry to a dark dungeon. Just go ahead to enter!", view.Pictures.dngn_entrance);
        imageToDescription.put("A long dark hallway", view.Pictures.lit_corridor);
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
                
    }
    static Rooms allRooms = new Rooms("src/data/rooms.txt");
    static Map<String, Room> test = allRooms.getRoomMap();
    public static void positionRoomsByName()  {
        fillIamgeToDescription ();
        for (Map.Entry<String, Room> pair : test.entrySet()) {
             //System.out.println(pair.getKey());
             //System.out.println(pair.getValue().getDescription());
             Pattern pattern = Pattern.compile("(\\d*)-(\\d*)");
             int posRow = 0;
             int posCol = 0;
             Matcher match = pattern.matcher(pair.getKey());
             if (match.find()) {
                    posRow = Integer.parseInt(match.group(1))-1;
                    posCol = Integer.parseInt(match.group(2))-1;
                    
             }
             castleView[posRow][posCol]= imageToDescription.get(pair.getValue().getDescription());
             
        }
        
        for (int  i = 0; i < castleView.length; i++){
            for (int j = 0; j < castleView[i].length; j++){
                if(castleView[i][j]== null){
                    castleView[i][j] = view.Pictures.rock_wall01;
                }
                    
            }
        }
                    
    }
    
}