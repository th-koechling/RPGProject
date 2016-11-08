/**
 * Created by andreas on 13.06.16.
 */

import dungeon.DnDmodel;
import javafx.application.Application;
import javafx.stage.Stage;
import view.DnDcontrol;

public class FXwithMVC extends Application {

    private static final String RUN_AS_CLI = "-cli";

    public static void main(String[] args) {
       
        if (args.length == 1 && args[0].equals(RUN_AS_CLI)) {
            runAsCMDline(args);
        } else {
            runAsFX(args);      // the one we want (graphical user interface)
        }
    }

    private static void runAsFX(String[] args) {

        launch(args);
    }

    private static void runAsCMDline(String[] args) {
        //TODO: implement cmd-line interface
        System.out.println("this is a VIDEO game!");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        DnDcontrol mainControl = new DnDcontrol( primaryStage);

        // introduce Control and Model to each other:
        DnDmodel game = new DnDmodel(mainControl);
        mainControl.setModel(game);
        mainControl.showAndWait();
    }
}
