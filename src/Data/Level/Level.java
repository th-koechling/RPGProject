package Data.Level;

import Data.GameObjects.Player;
import Data.GameObjects.Rooms;
import javafx.scene.image.Image;

import java.util.Map;

/**
 * Interface Level collects all methods that are needed for Levels in the DND game
 * Methods are mostly derived from Castle by Martin and Interface was implemented by Fabian
 * @author Martin
 * @author Andreas
 * @author Fabian Billenkamp - Realisation Castle als Interface
 */
public interface Level {
    /*
     **********************************************************************************
     *               Getter methods for the different components                      *
     **********************************************************************************
     */

    /**
     * Please fill.
     * @return your documentation
     * @author Martin?
     */
    Image[][] getCastleView();

    /**
     * Please fill.
     * @return your documentation
     * @author Martin?
     */
    Map<String, Image> getDungeonOneInfoPics();

    /**
     * Please fill.
     * @return your documentation
     * @author Martin?
     */
    Image[][] getViewAllRooms();

    /**
     * Please fill.
     * @return your documentation
     * @author Martin?
     */
    Rooms getAllRooms();

    /**
     * This method is used to determine if a player meets the win condition of a level.
     * @param player the current DND player
     * @return boolean: true: if the player meets the win condition of the level, false: else
     * @author Fabian Billenkamp
     */
    boolean getWinCondition(Player player);

    /**
     * This method is used for getting the opening text of a level
     * @return String: the opening text for a level.
     * @author Fabian Billenkamp
     */
    String getStartText();

    /**
     * This method is used for getting the closing text of a level
     * @return String: the closing text for a level
     * @author Fabian Billenkamp
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
     * @author Fabian Billenkamp
     */
    void load();

    /*
     **********************************************************************************
     *                               Level usage                                      *
     **********************************************************************************
     */
    /**
     * Please fill.
     * your documentation
     * @author unknown Martin Andreas Jonas?
     */
    void move(String direction);

    /**
     * Please fill.
     * your documentation
     * @author unknown Martin Andreas Jonas?
     */
    void positionRoomsByName();
}
