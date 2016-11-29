/**
 * This is main class of the DND game.
 * @author Patrick Barth
 * @author Fabian Billenkamp
 * @author Andreas Hoek
 * @author Thorsten Köchling
 * @author Martin Schneider
 * @author Jonas Tschammer
 */

import javafx.application.Application;
import javafx.stage.Stage;
import view.DnDcontrol;

public class FXwithMVC extends Application {
    /**
     * The main method
     * @param args potential arguments
     */
    public static void main(String[] args) {

            runAsFX(args);

    }

    private static void runAsFX(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        DnDcontrol mainControl = new DnDcontrol( primaryStage);
        mainControl.showAndWait();
    }
}
