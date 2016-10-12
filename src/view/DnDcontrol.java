package view;

import java.util.Random;

import com.sun.rowset.internal.Row;
import dungeon.DnDmodel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gameMechanics.Castle;
/**
 * Created by andreas on 13.06.16.
 */
public class DnDcontrol {


    private Scene scene;
    private Stage primaryStage;
    private String currentWorkDir;

    //@FXML
    //private Text blah;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="anchor"
    private AnchorPane anchor; // Value injected by FXMLLoader

    @FXML // fx:id="exit"
    private Button exit; // Value injected by FXMLLoader

    @FXML // fx:id="go_ahead"
    private Button go_ahead; // Value injected by FXMLLoader

    @FXML // fx:id="go_back"
    private Button go_back; // Value injected by FXMLLoader

    @FXML // fx:id="go_right"
    private Button go_right; // Value injected by FXMLLoader

    @FXML // fx:id="go_left"
    private Button go_left; // Value injected by FXMLLoader

    @FXML // fx:id="topLabel"
    private Label topLabel; // Value injected by FXMLLoader
    private DnDmodel model;

    @FXML // fx:id="pick_up  // stuff injected by me, tito, master of all things grok
    private Button pick_up;

    @FXML // fx:id="messageWindow"
    private TextArea messageWindow;  // also done by hand, does this work?

    @FXML // fx:id="attack"
    private Button attack;

    @FXML // fx:id="infoPic"
    private ImageView infoPic;

    @FXML // fx:id="weaponPic"
    private ImageView weaponPic;

    @FXML // fx:id="armorPic"
    private ImageView armorPic;

    @FXML // fx:id="testButton"
    private Button testButton;

    @FXML // fx:id="new_game"
    private Button new_game;

    @FXML // fx:id="clic"
    private Button clic;

    @FXML
    private ImageView img00, img01, img02, img03, img04, img05, img06,      // row 0 of visual map grid
                      img10, img11, img12, img13, img14, img15, img16,      // row 1
                      img20, img21, img22, img23, img24, img25, img26,      // row 2
                      img30, img31, img32, img33, img34, img35, img36,      // row 3
                      img40, img41, img42, img43, img44, img45, img46,      // row 4
                      img50, img51, img52, img53, img54, img55, img56,      // row 5
                      img60, img61, img62, img63, img64, img65, img66;      // row 6

    /**
     * Init control
     */
    public DnDcontrol(Stage primaryStage) {

        this.primaryStage = primaryStage;
        init();
        primaryStage.setResizable(false);
    }


    /**
     * Initialises the main window (no exception in constructor!)
     */
    private void init() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DnDMainWindow.fxml"));
        fxmlLoader.setController(this);

        try {
            Scene scene = new Scene(fxmlLoader.load());
            this.scene = scene;
            scene.getStylesheets().add("/view/styles.css");

            messageWindow.setEditable(false);   // --> player can't change the messages on-screen (thorsten)
            this.currentWorkDir = System.getProperty("user.home");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setModel(DnDmodel game) {

        this.model = game;
    }

    /**
     * Displays the main window
     */
    public void showAndWait() {

        // setting the stage
        this.primaryStage.setScene(this.scene);
        this.primaryStage.setTitle("DnD");
        this.primaryStage.show();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert anchor != null : "fx:id=\"anchor\" was not injected: check your FXML file 'DnDMainWindow.fxml'.";
        assert exit != null : "fx:id=\"exit\" was not injected: check your FXML file 'DnDMainWindow.fxml'.";
        assert go_ahead != null : "fx:id=\"go_ahead\" was not injected: check your FXML file 'DnDMainWindow.fxml'.";
        assert go_back != null : "fx:id=\"go_back\" was not injected: check your FXML file 'DnDMainWindow.fxml'.";
        assert go_right != null : "fx:id=\"go_right\" was not injected: check your FXML file 'DnDMainWindow.fxml'.";
        assert go_left != null : "fx:id=\"go_left\" was not injected: check your FXML file 'DnDMainWindow.fxml'.";
        assert topLabel != null : "fx:id=\"topLabel\" was not injected: check your FXML file 'DnDMainWindow.fxml'.";
        // assert attack != null : "fx:id=\"attack\" was not injected: check your FXML file 'DnDMainWindow.fxml'."; // added manually

        /*
         * For each button: Assign function to action
         * (function must be defined in this or another class)
         */
        exit.setOnAction(this::exitPressed);
        go_ahead.setOnAction(this::go_aheadPressed);
        go_left.setOnAction(this::go_leftPressed);
        go_right.setOnAction(this::go_rightPressed);
        go_back.setOnAction(this::go_backPressed);
        attack.setOnAction(this::attackPressed);
        pick_up.setOnAction(this::pick_upPressed);
        testButton.setOnAction(this::testButtonPressed);
        new_game.setOnAction(this::new_gamePressed);
        clic.setOnAction(this::clicPressed);

        // nope...: fw.setOnAction(this::fwPressed);

    }

    Image rip = new Image("/view/images/misc/grave.png");

    /**
     * Action for pressed exit button.
     * @param actionEvent
     */

    // eh.... the picture and message don't show, the program just goes to sleep and exits
    private void exitPressed(ActionEvent actionEvent) {
        infoPic.setImage(rip);
        messageWindow.appendText("\nBye bye!\n");
        pause();
        Platform.exit();        // destroys resources before exiting (calls Application.stop())
    }
    private void pause() {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException intEx) {
            Thread.currentThread().interrupt();
        }
    }

    private void pick_upPressed(ActionEvent actionEvent) {
        weaponPic.setImage(Pictures.getRandomPic(Pictures.weaponPics));
        armorPic.setImage(Pictures.getRandomPic(Pictures.armorPics));
    }

    //private Label testLabel;

    private void go_aheadPressed(ActionEvent actionEvent) {
        move("S");
    }

    private void go_leftPressed(ActionEvent actionEvent) {
        move("W");
    }

    private void go_rightPressed(ActionEvent actionEvent) {
        move("O");
    }

    private void go_backPressed(ActionEvent actionEvent) {
        move("N");
    }

    private void testButtonPressed(ActionEvent actionEvent) {
        infoPic.setImage(Pictures.getRandomPic(Pictures.creaturePics));
         test2[2][2]= (view.Pictures.flying_skull);
    }

    private void move(String direction){
        boolean movePossible = newDungeon.getAllRooms().goToNextRoom(direction);
        if(movePossible){
            switch (direction){
                case "N" :
                    messageWindow.appendText("\nYou go north.\n");
                    break;
                case "W" :
                    messageWindow.appendText("\nYou go west.\n");
                    break;
                case "O" :
                    messageWindow.appendText("\nYou go east.\n");
                    break;
                case "S" :
                    messageWindow.appendText("\nYou go south.\n");
                    break;
            }
            changeRoom(newDungeon.getAllRooms().getAktuellePosition());
        } else {
            messageWindow.appendText("\nThere is no door in this direction!\n");
        }
    }

    private void changeRoom(String roomName){
        if(roomName != "Entry") {
            Pattern pattern = Pattern.compile("(\\d*)-(\\d*)");
            int posRow = 0;
            int posCol = 0;
            Matcher match = pattern.matcher(roomName);
            if (match.find()) {
                posRow = Integer.parseInt(match.group(1)) - 1;
                posCol = Integer.parseInt(match.group(2)) - 1;
                Image[][] testImage = newDungeon.getCastleView();
                loadDungeonMap(test2);
                currentMap[posRow][posCol].setImage(Pictures.flying_skull);
               
                System.out.println(test2[posRow][posCol]);
                
                System.out.println("POS: " + posRow + " | " + posCol);
            }
        }
    }
    private ImageView[][] currentMap;
    private void new_gamePressed(ActionEvent actionEvent) {
        // test test test
        //loadDungeonMap(test); // Martin tmp to test castle class will be removed this was default
        currentMap = loadDungeonMap(test2);// Martin tmp to test castle class will be removed
        messageWindow.appendText("\nLet's go!\n");
    }

    private void clicPressed(ActionEvent actionEvent) {
        infoPic.setImage(Pictures.getRandomPic(Pictures.treasurePics));

    }

    // implement or call the behavior expected from the game
    // when the player clicks on the "attack" button (thorsten)
    private void attackPressed(ActionEvent actionEvent) {   // test method (thorsten)
        messageWindow.appendText("\nYou attack the monster and hit for x points of damage.\n");
    }


    Image[][] test = Pictures.mapOneImages;
    
    Castle newDungeon = new Castle();
    
    Image[][] test2 = newDungeon.getCastleView(); // Martin tmp to test castle class will be removed
    
    private ImageView[][] loadDungeonMap(Image[][] images) {
        newDungeon.positionRoomsByName(); // Martin tmp to test castle class will be removed
        ImageView[][] imageCells = {{img00, img01, img02, img03, img04, img05, img06},
                                   {img10, img11, img12, img13, img14, img15, img16},
                                   {img20, img21, img22, img23, img24, img25, img26},
                                   {img30, img31, img32, img33, img34, img35, img36},
                                   {img40, img41, img42, img43, img44, img45, img46},
                                   {img50, img51, img52, img53, img54, img55, img56},
                                   {img60, img61, img62, img63, img64, img65, img66}};

        for(int i = 0; i < imageCells.length; i++) {
            for(int j = 0; j < imageCells[0].length; j++) {
                imageCells[i][j].setImage(images[i][j]);
            }
        }
        return imageCells;
    }

}
