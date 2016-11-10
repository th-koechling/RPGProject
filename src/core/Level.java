package core;

import Data.Rooms;
import GameObjects.Player;
import javafx.scene.image.Image;

import java.util.Map;

/**
 * Created by Fabian Billenkamp on 10.11.2016.
 */
public interface Level {
    public Image[][] getCastleView();
    public  Map<String, Image> getDungeonOneInfoPics();
    public void move(String direction);
    public  Image[][] getViewAllRooms();
    public Rooms getAllRooms();
    public boolean getWinCondition(Player player);
    public String getStartText();
    public String getWinText();
    public void positionRoomsByName();
}
