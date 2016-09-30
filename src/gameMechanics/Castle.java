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

import com.sun.xml.internal.ws.util.StringUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;
import javafx.scene.image.Image;


// remove call of method to test in FXwithMVC.java !!!!!!!!

public class Castle {

    private static Room[] roomsInCastle;
    private static Room[][] orderedRooms;
    public static String roomsInput = new String();
    private Image[][] castleView;
    Map<String, Image> imageToDescription = new HashMap<>();
    //static Map<String, Room> allRooms = Rooms.getRoomMap();
    
    
    
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
    
    private  void fillIamgeToDescription (){
        
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
        for (Map.Entry<String, Room> pair : test.entrySet()) {
             System.out.println(pair.getKey());
             System.out.println(pair.getValue().getDescription());
        }
        
                
    }
    
}