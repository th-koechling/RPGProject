package view;

import GameObjects.*;
import Data.Room;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import core.Game;

/**
 * @author: TODO
 *
 */
public class DnDcontrol {

    private Scene scene;
    private Stage primaryStage;
    private String currentWorkDir;
    private Game game;
    private ImageView[][] currentMap;
    private Image[][] currentRoomViewMap;


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

    @FXML // fx:id="pick_up
    private Button pick_up;

    @FXML // fx:id="messageWindow"  //
    private TextArea messageWindow;  // also done by hand, does this work?

    @FXML // fx:id="playerName"
    private Label playerName;

    @FXML // fx:id="attack"
    private Button attack;

    @FXML // fx:id="infoPic"
    private ImageView infoPic;

    @FXML // fx:id="nameDialogue"
    private Pane nameDialogue;

    @FXML // fx:id="nameEntry"
    private TextField nameEntry;

    @FXML // fx:id="nameOk"
    private Button nameOk;

    @FXML // fx:id="nameTitle"
    private TextField nameTitle;

    @FXML // fx:id="weaponPic"
    private ImageView weaponPic;

    @FXML // fx:id="xpStat"
    private TextField xpStat;

    @FXML // fx:id="armorPic"
    private ImageView armorPic;

    @FXML // fx:id="testButton"
    private Button testButton;

    @FXML // fx:id="new_game"
    private Button new_game;

    @FXML // fx:id="toggleView"
    private Button toggleView;

    @FXML
    private TextField lifeStat;

    @FXML // fx:id="attackStat"
    private TextField attackStat;

    @FXML // fx:id="defStat"
    private TextField defStat;

    @FXML // fx:id="infoPic2"  //test
    private ImageView roomPic;
    
    @FXML // fx:id="dungeon_map" // test
    private GridPane dungeon_map;

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
        this.primaryStage.setTitle("Into the dungeon!");
        this.primaryStage.show();
        attack.setDisable(true);
        go_ahead.setDisable(true);
        go_right.setDisable(true);
        go_left.setDisable(true);
        go_back.setDisable(true);
        toggleView.setDisable(true);

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
        new_game.setOnAction(this::new_gamePressed);
        toggleView.setOnAction(this::toggleViewPressed);
        nameOk.setOnAction(this::nameOkPressed);
    }


    /**
     * Action for pressed exit button.
     * @param actionEvent
     */

    private void exitPressed(ActionEvent actionEvent) {
        Platform.exit();        // destroys resources before exiting (calls Application.stop())
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


    // check all directions for valid movement (th)
    private void adjustMoveButtons() {
        Room currentRoom = game.getCurrentRoom();
        Button[] buttons = {go_ahead, go_back, go_left, go_right};
        for (Button button: buttons) {
            button.setDisable(true);
        }
        if (!(currentRoom.getSued().equals("none"))) {
            go_ahead.setDisable(false);

        }
        if (!(currentRoom.getNord().equals("none"))) {
            go_back.setDisable(false);

        }
        if (!(currentRoom.getWest().equals("none"))) {
            go_left.setDisable(false);

        }
        if (!(currentRoom.getOst().equals("none"))) {
            go_right.setDisable(false);
        }
    }

    private void move(String direction){
            game.move(direction);
            adjustRoomViews();
            adjustMoveButtons();
            adjustInfoPic();
            adjustLifeStat();
            checkRoom();
    }

    private void adjustInfoPic(){
        Room room = game.getCurrentRoom();
        if (game.getCurrentLevel().getDungeonOneInfoPics().containsKey(room.getContent()))     // show image of item in room
        {
            infoPic.setImage(game.getCurrentLevel().getDungeonOneInfoPics().get(room.getContent()));
        }
        else
        {
            infoPic.setImage(null);
        }
    }
    private void adjustLifeStat(){
        lifeStat.setText(String.valueOf(game.getPlayer().getHp())+" / "+String.valueOf(game.getPlayer().getMaxhp()));
    }
    // Method that changes the position of the player on the map.
    private void adjustRoomViews(){
        String roomName = game.getCurrentRoom().getName();
        messageWindow.setText("");
        if(!roomName.equals("Entry")) {
            Pattern pattern = Pattern.compile("(\\d*)-(\\d*)");
            int posRow = 0;
            int posCol = 0;
            Matcher match = pattern.matcher(roomName);
            if (match.find()) {
                posRow = Integer.parseInt(match.group(1)) ;
                posCol = Integer.parseInt(match.group(2)) - 1;
                loadDungeonMap(game.getCurrentLevel().getCastleView());
                Image currentRoomImage = currentRoomViewMap[posRow][posCol];
                roomPic.setImage(currentRoomImage);
                currentMap[posRow][posCol].setImage(Pictures.player_orange_bg);
            }
        } else {
            loadDungeonMap(game.getCurrentLevel().getCastleView());
            Image currentRoomImage = currentRoomViewMap[0][2];
            roomPic.setImage(currentRoomImage);
            currentMap[0][2].setImage(Pictures.player_orange_bg); // eventually add info where in rooms.txt
            
        }
    }

    private void checkRoom() {
        String content = game.getCurrentRoom().getContent();
        messageWindow.appendText(game.getCurrentRoom().getDescription());
        if(game.getCreatures().containsKey(content)){
            toggleMovement(true);
            attack.setDisable(false);
            game.setMonster(game.getCreatures().get(content));
            messageWindow.appendText("\n\n" + game.getMonster().getName() + " is in the room!\nYou have to fight!\n");
            attack.setDisable(false);
        }
        if(game.getArmours().containsKey(content)){
            pickup(game.getArmours().get(content));
            messageWindow.appendText("\nChecking armours...");
            game.getPlayer().pickBestArmourFromInv();
            armorPic.setImage(game.getCurrentLevel().getDungeonOneInfoPics().get(game.getPlayer().getArmour().getName()));
            defStat.setText(String.valueOf(game.getPlayer().getArmour().getDefence()));
            game.getCurrentRoom().setContent("none");
        }
        if(game.getWeapons().containsKey(content)){
            pickup(game.getWeapons().get(content));
            messageWindow.appendText("\nChecking weapons...");
            game.getPlayer().pickBestWeaponFromInv();
            weaponPic.setImage(game.getCurrentLevel().getDungeonOneInfoPics().get(game.getPlayer().getWeapon().getName()));
            adjustDamageView();
            game.getCurrentRoom().setContent("none");
        }
        if(game.getTreasures().containsKey(content)){
           pickup(game.getTreasures().get(content));
           if(game.getCurrentLevel().getWinCondition(game.getPlayer())){
               game.setLevelsWon(game.getLevelsWon()+1);
               messageWindow.setText(game.getCurrentLevel().getWinText());
                if(!game.getWin()){
                    game.nextLevel();
                }else{
                    endGame();
                }
           }
        }
    }


    // Method for the fight between player and monsters. Bleibt hier der Messagebox einträge wegen
    private boolean fight(Creature monster) {
        if (game.getPlayer().getHp() > 0) {
            int attackPlayer = game.getPlayer().attack();
            monster.defend(attackPlayer);
            messageWindow.appendText("\n->You hit "+monster.getName()+" with " + attackPlayer + "\n"+monster.getName()+" has still " + monster.getHp() + " life points.");
        } else {
            messageWindow.setText("You died.");
            toggleMovement(false);
            attack.setDisable(true);
            return false;
        }
        if (monster.getHp() > 0) {
            int attackMonster = monster.attack();
            game.getPlayer().defend(attackMonster);
            adjustLifeStat();
            messageWindow.appendText("\n->"+monster.getName()+" hits you with " + attackMonster + ".\nYou have " + game.getPlayer().getHp() + " life points remaining\n");
            lifeStat.setText(String.valueOf(String.valueOf(game.getPlayer().getHp())+" / "+String.valueOf(game.getPlayer().getMaxhp())));
        } else {
            attack.setDisable(true);
            game.getPlayer().setXp(game.getPlayer().getXp() + 1);
            xpStat.setText("" + game.getPlayer().getXp());
            adjustMoveButtons();
            game.getCurrentRoom().setContent("none");
            return true;
        }

        return false;
    }
    private void endGame(){
        toggleMovement(false);
        attack.setDisable(true);
        toggleView.setDisable(true);
    }

    private void pickup(Item item){
        messageWindow.appendText("\n\nYou found "+item.getName()+"\n"+item.getDescription()+".\n");
        boolean added=game.getPlayer().pickupItem(item);
        if(added){
            messageWindow.appendText("Added to inventory.\n\nNow in inventory:\n=====");
            for(Item loot:game.getPlayer().getInventory()){
                messageWindow.appendText("\n"+loot.getName()+"\n-> "+loot.getDescription()+"\n=====");
            }
            messageWindow.appendText("\n");
        }
    }


    // scan name information from player (user input)
    private void nameOkPressed(ActionEvent actionEvent) {
        //String testString = nameTitle.getText();
        if (nameEntry.getText().equals(""))
        {
            playerName.setText("Player 1");
        }
        else
        {
            playerName.setText(nameEntry.getText());
        }
        infoPic.setImage(null);
        nameDialogue.setVisible(false);
        currentMap = loadDungeonMap(game.getCurrentLevel().getCastleView());// Martin tmp to test castle class will be removed
        currentRoomViewMap = game.getCurrentLevel().getViewAllRooms();
        adjustRoomViews();
        messageWindow.setText(game.getCurrentLevel().getStartText());
        lifeStat.setText("" + String.valueOf(game.getPlayer().getHp())+" / "+String.valueOf(game.getPlayer().getMaxhp()));
        xpStat.setText("" + game.getPlayer().getXp());
        adjustDamageView();
        defStat.setText("" + game.getPlayer().getArmour().getDefence());
        adjustMoveButtons();
        toggleView.setDisable(false);
    }


    private void new_gamePressed(ActionEvent actionEvent) {
        game=new Game();
        nameDialogue.setVisible(true);

    }

    private void toggleViewPressed(ActionEvent actionEvent) {
        switchMapRoomView();
    }
    private void adjustDamageView(){
        String minDamage=String.valueOf(2+game.getPlayer().getXp()* (game.getPlayer().getBasedamage()+game.getPlayer().getWeapon().getForce()));
        String maxDamage=String.valueOf(12+game.getPlayer().getXp()* (game.getPlayer().getBasedamage()+game.getPlayer().getWeapon().getForce()));
        attackStat.setText(minDamage+" - "+maxDamage);
    }

    // implement or call the behavior expected from the game
    // when the player clicks on the "attack" button (thorsten)
    private void attackPressed(ActionEvent actionEvent) {   // test method (thorsten)
        fight(game.getMonster());
    }

    private void toggleMovement(boolean mode){
        go_ahead.setDisable(mode);
        go_back.setDisable(mode);
        go_left.setDisable(mode);
        go_right.setDisable(mode);
    }



    private void switchMapRoomView(){
        ImageView[][] imageCells = {{img00, img01, img02, img03, img04, img05, img06},
            {img10, img11, img12, img13, img14, img15, img16},
            {img20, img21, img22, img23, img24, img25, img26},
            {img30, img31, img32, img33, img34, img35, img36},
            {img40, img41, img42, img43, img44, img45, img46},
            {img50, img51, img52, img53, img54, img55, img56},
            {img60, img61, img62, img63, img64, img65, img66}};
        if (!roomPic.isVisible()) {
            toggleView.setText("Map");
            for (int i = 0; i < imageCells.length; i++) {
                for (int j = 0; j < imageCells[0].length; j++) {
                    imageCells[i][j].setVisible(false);
                }
            }
            dungeon_map.setGridLinesVisible(false);
            roomPic.setVisible(true);
        } else {
            toggleView.setText("Room");
            for (int i = 0; i < imageCells.length; i++) {
                for (int j = 0; j < imageCells[0].length; j++) {
                    imageCells[i][j].setVisible(true);
                }
            }
            dungeon_map.setGridLinesVisible(true);
            roomPic.setVisible(false);
        }

    }
    private ImageView[][] loadDungeonMap(Image[][] images) {
        game.getCurrentLevel().positionRoomsByName();
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
