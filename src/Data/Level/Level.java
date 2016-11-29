package Data.Level;

import Data.GameObjects.Player;
import Data.GameObjects.Rooms;
import javafx.scene.image.Image;

import java.util.Map;

/**
 * Interface Level collects all methods that are needed for Levels in the DND game
 * Methods are mostly derived from Castle by Martin and Interface was implemented by Fabian
 * @author Martin Schneider
 * @author Andreas Hoek
 * @author Patrick Barth
 * @author Thorsten Köchling
 * @author Fabian Billenkamp - Realisation as Interface
 */
public interface Level {
    /*
     **********************************************************************************
     *               Getter methods for the different components                      *
     **********************************************************************************
     */

    /**
     * Returns the image matrix containing the pictures for the map view of the dungeon.
     * The picture position in the matrix is based on the room name (its position).
     * In this way the picture arrangement equals the dungeon architecture specified
     * in the room text file. 
     * @return Image[][] of the castle map
     */
    Image[][] getCastleView();

    /**
     * Returns the hash map containing room content (string-, picture pairs) for
     * the room content of the current castle. The map content is specified
     * via the room text file content. The pictures are matched via the
     * content string.
     * @return Map: String:Image
     */
    Map<String, Image> getDungeonInfoPics();

    /**
     * Returns the image matrix containing the pictures for the room view of 
     * the dungeon. The picture position in the matrix is based on
     * the room name (its position). In this way the picture arrangement
     * equals the dungeon architecture specified in the room text file. 
     * @return Image[][] of the rooms in the castle
     */
    Image[][] getViewAllRooms();

    /**
     * Returns the Rooms object from the current castle based on the
     * parsed room text file of the level.
     * @return Rooms
     */
    Rooms getAllRooms();

    /**
     * This method is used to determine if a player meets the win condition of a level.
     * @param player the current DND player
     * @return boolean: true: if the player meets the win condition of the level, false: else
     */
    boolean getWinCondition(Player player);

    /**
     * This method is used for getting the opening text of a level.
     * @return String: the opening text for a level.
     */
    String getStartText();

    /**
     * This method is used for getting the closing text of a level.
     * @return String: the closing text for a level
     */
    String getWinText();

     /*
     **********************************************************************************
     *                               Level initialization                             *
     **********************************************************************************
     */

    /**
     * Loads a level and makes its objects and picture tilesets available.
     * Needs to be called before a level can be used by the game.
     */
    void load();

    /*
     **********************************************************************************
     *                               Level usage                                      *
     **********************************************************************************
     */
    /**
     * Moves the player to a new room of the dungeon, as specified by a
     * directional parameter of type "String".
     * @param direction String: the direction to move to, can be N,S,W,O
     */
    void move(String direction);

    /**
     * Calls "fillImageToDescription()" to fill the hash maps containing
     * description string, map- and room pictures. Then each room name is parsed
     * to get the designated position in the castle architecture. The parsed numbers
     * are adjusted to fit the matrix pattern and the case "Entry" is handled
     * individually. Then the room description is searched in botch hash maps
     * and the designated pictures are placed at the parsed position of the 
     * image matices for map- and room view. For matrix positions with no room
     * a level dependent default picture is placed.
     */
    void positionRoomsByName();
}
