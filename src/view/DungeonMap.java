package view;

import javafx.scene.image.Image;

/**
 * Created by thorsten on 25.07.16.
 *
 * An object of this class stores the images stitched together
 * to display a visual map of the dungeon.
 *
 * The map is shown in the corresponding window of the GUI
 *
 * This class would have to connect with the "Castle" class
 * of the "gameMechanics" package.
 *
 */
public class DungeonMap {

    int size;   // Rank of the map matrix, standard layout is 7 by 7 tiles.
                // A different dimension will result in an error.
    Image[][] mapImages;

    public DungeonMap(Image[][] mapImages) {
        this.size = 7;
        this.mapImages = mapImages;        // matrix of the images for each tile of the map
    }






}
