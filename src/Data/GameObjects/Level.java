package Data.GameObjects;

import javafx.scene.image.Image;

import java.util.Map;

/**
 * Interface Level collects all methods that are needed for Levels in the DND game
 * methods are mostly derived from Castle by Martin and Interface was implemented by Fabian
 * @author Martin
 * @author Fabian Billenkamp
 */
public interface Level {
    //make java doc here and write @override in implementing classes
    //reorder into getters, loaders and modifiers

    /*
     **********************************************************************************
     *            Getter methods for the different game components                    *
     **********************************************************************************
     */

    /**
     *
     * @return
     */
    Image[][] getCastleView();

    /**
     *
     * @return
     */
    Map<String, Image> getDungeonOneInfoPics();
    /**
     *
     * @return
     */
    Image[][] getViewAllRooms();

    /**
     *
     * @return
     */
    Rooms getAllRooms();

    /**
     * @author Fabian Billenkamp
     * @param player
     * @return
     */
    boolean getWinCondition(Player player);

    /**
     * @author Fabian Billenkamp
     * @return
     */
    String getStartText();

    /**
     * @author Fabian Billenkamp
     * @return
     */
    String getWinText();

     /*
     **********************************************************************************
     *                               Level initialization                             *
     **********************************************************************************
     */

    /**
     * Loads a level and makes its recources available.
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
     *
     * @param direction
     */
    void move(String direction);



    /**
     *
     */
    void positionRoomsByName();
}
