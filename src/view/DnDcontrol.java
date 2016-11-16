package view;

import Data.GameObjects.*;
import Data.GameObjects.Room;
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
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Data.Game;

/**
 * This class mediates player control over the available in-game actions via the graphical user interface (GUI)
 * @author Thorsten
 * @author TODO
 *
 */
public class DnDcontrol {

    private Scene scene;
    private Stage primaryStage;
    private String currentWorkDir;
    private Game game;
    private ImageView[][] currentMap;
    private Image[][] currentRoomViewMap;


    // declaration of the GUI elements referred to as variables by the game (Thorsten)
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

    /* the map grid, broken up into 49 (7 by 7) individual cells. Each cell can hold a small square image
     * for illustration purposes (dungeon features) (Thorsten)
     */
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
     * Initializes the main window (Thorsten)
     *
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
     * Displays the main window (Thorsten)
     *
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
         * (function must be defined in this or another class) (Thorsten)
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
     * Action for exit button. (Thorsten)
     * @param actionEvent press the 'Exit' button
     */
    private void exitPressed(ActionEvent actionEvent) {
        Platform.exit();        // destroys resources before exiting (calls Application.stop())
    }

    /**
     * Action for go_ahead button. (Thorsten)
     * @param actionEvent press the 'Up-Arrow' button
     */
    private void go_aheadPressed(ActionEvent actionEvent) {
        move("S");
    }

    /**
     * Action for go_left button. (Thorsten)
     * @param actionEvent press the 'Left-Arrow'  button
     */
    private void go_leftPressed(ActionEvent actionEvent) {
        move("W");
    }

    /**
     * Action for go_right button. (Thorsten)
     * @param actionEvent press the 'Right-Arrow' button
     */
    private void go_rightPressed(ActionEvent actionEvent) {
        move("O");
    }

    /**
     * Action for go_back button. (Thorsten)
     * @param actionEvent press the 'Down-Arrow' button
     */
    private void go_backPressed(ActionEvent actionEvent) {
        move("N");
    }

    /**
     * Determines the valid directions in which the player can move on the map.
     * and toggles accessibility of the corresponding buttons.
     * Movement buttons that point to an invalid direction are greyed out. (Thorsten)
     */
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

    /**
     * When the player moves on the dungeon map this method displays graphical and text information
     * about the new location. (TODO..., Thorsten, ...)
     * @param direction the direction in which the player moves
     */
    private void move(String direction){
        game.move(direction);
        messageWindow.setText("");
        adjustRoomViews();
        adjustMoveButtons();
        adjustInfoPic();
        adjustLifeStat();
        checkRoom();
    }


    /**
     * Method that changes the position of the player on the map. (TODO author)
     */
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

    /**
     *
     */
    private void adjustLifeStat(){
        lifeStat.setText(String.valueOf(game.getPlayer().getHp())+" / "+String.valueOf(game.getPlayer().getMaxhp()));
    }
    /*
        Method that changes the position of the player on the map.
     */
    private void adjustRoomViews(){
        String roomName = game.getCurrentRoom().getName();
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

    /**
     * Takes inventory of a room in the dungeon and displays information about the location
     * (flavor text) and, if encountered, about monsters or items.
     * Found armor and weapons are picked up, compared to the ones in the player's inventory
     * and equipped if their stats exceed those. (TODO: author)
     *
     */
    private void checkRoom() {
        if(game.getCurrentRoom().getName().equals("Entry")){
            messageWindow.appendText(game.getCurrentLevel().getStartText()+"\n");
        }
        String content = game.getCurrentRoom().getContent();
        messageWindow.appendText(game.getCurrentRoom().getDescription());
        if(game.getCreatures().containsKey(content)){
            toggleMovement(true);
            game.setMonster(game.getCreatures().get(content));
            messageWindow.appendText("\nA monster is in the room:\n\nName: " + game.getMonster().getName() + "\nSpecies: " +
                    game.getMonster().getSpecies()+"\nDescription: "+game.getMonster().getDescription()+"\n\n" +
                    "You have to fight!");
            attack.setDisable(false);
        }
        if(game.getArmours().containsKey(content)){
            pickup(game.getArmours().get(content));
            messageWindow.appendText("\nChecking armours...");
            game.getPlayer().pickBestArmourFromInv();
            messageWindow.appendText("\nEquipped: \n"+game.getPlayer().getArmour().getName()+"\n"+game.getPlayer().getArmour().getDescription());
            armorPic.setImage(game.getCurrentLevel().getDungeonOneInfoPics().get(game.getPlayer().getArmour().getName()));
            adjustArmourView();
            game.getCurrentRoom().setContent("none");
        }
        if(game.getWeapons().containsKey(content)){
            pickup(game.getWeapons().get(content));
            messageWindow.appendText("\nChecking weapons...");
            game.getPlayer().pickBestWeaponFromInv();
            messageWindow.appendText("\nEquipped:\n"+game.getPlayer().getWeapon().getName()+"\n"+game.getPlayer().getWeapon().getDescription());
            weaponPic.setImage(game.getCurrentLevel().getDungeonOneInfoPics().get(game.getPlayer().getWeapon().getName()));
            adjustDamageView();
            game.getCurrentRoom().setContent("none");
        }
        if(game.getTreasures().containsKey(content)){
            pickup(game.getTreasures().get(content));
            game.getCurrentRoom().setContent("none");
            if(game.getCurrentLevel().getWinCondition(game.getPlayer())){
                game.setLevelsWon(game.getLevelsWon()+1);
                messageWindow.setText(game.getCurrentLevel().getWinText());
                if(!game.getWin()){
                    game.nextLevel();
                }else{
                    messageWindow.appendText("\n\n****\nYou have completed the game!\nNo dungeon was too dark...\nNo monster was too big...\n"+
                            playerName.getText()+", YOU are a true hero\n****");
                    endGame();
                }
            }
        }
    }

    /**
     * This method contains the logic for a turn-based fight between the player and a monster.
     * When encountered, a monster will always attack the player. The battle has to be fought out,
     * escaping is not possible. (TODO: author)
     * @param monster the monster encountered in room of the dungeon
     */

    // Method for the fight between player and monsters. Bleibt hier der Messagebox einträge wegen
    private boolean fight(Creature monster) {
        if (game.getPlayer().getHp() > 0) {
            int attackPlayer = game.getPlayer().attack();
            monster.defend(attackPlayer);
            messageWindow.appendText("\n->You hit "+monster.getName()+" with " + attackPlayer + "\n"+monster.getName()+" has still " + monster.getHp() + " life points.");
        }
        if (monster.getHp() > 0) {
            int attackMonster = monster.attack();
            game.getPlayer().defend(attackMonster);
            adjustLifeStat();
            messageWindow.appendText("\n->"+monster.getName()+" hits you with " + attackMonster + ".\nYou have " + game.getPlayer().getHp() + " life points remaining\n");
            if(game.getPlayer().getHp()==0) {
                messageWindow.setText("Game over!\n"+monster.getName()+", "+monster.getDescription()+" killed you."
                        +"\nTry to be better next time!");
                roomPic.setImage(game.getCurrentLevel().getDungeonOneInfoPics().get(monster.getName()));
                switchMapRoomView();
                endGame();
                return false;
            }
        } else {
            attack.setDisable(true);
            game.getPlayer().setXp(game.getPlayer().getXp() + monster.getXp());
            xpStat.setText("" + game.getPlayer().getXp());
            adjustDamageView();
            adjustMoveButtons();
            String monsterweapon= monster.getWeapon().getName();
            messageWindow.appendText("\n\nYou killed "+monster.getName()+" and examine his remains.");
            if(new Random().nextInt(2)==0 && !monsterweapon.equals("Fire")) {
                pickup(monster.getWeapon());
                messageWindow.appendText("\nChecking weapons...");
                game.getPlayer().pickBestWeaponFromInv();
                messageWindow.appendText("\nEquipped:\n"+game.getPlayer().getWeapon().getName()+"\n"+game.getPlayer().getWeapon().getDescription());
                weaponPic.setImage(game.getCurrentLevel().getDungeonOneInfoPics().get(game.getPlayer().getWeapon().getName()));
                adjustDamageView();
            }else{
                pickup(monster.getArmour());
                messageWindow.appendText("\nChecking armours...");
                game.getPlayer().pickBestArmourFromInv();
                messageWindow.appendText("\nEquipped: \n"+game.getPlayer().getArmour().getName()+"\n"+game.getPlayer().getArmour().getDescription());
                armorPic.setImage(game.getCurrentLevel().getDungeonOneInfoPics().get(game.getPlayer().getArmour().getName()));
                adjustArmourView();
            }
            game.getCurrentRoom().setContent("none");
            return true;
        }
        return false;
    }

    private void endGame(){
        toggleMovement(true);
        attack.setDisable(true);
        toggleView.setDisable(true);
    }

    private void pickup(Item item){
        messageWindow.appendText("\n\nYou found:\n"+item.getName()+"\n"+item.getDescription()+".\n");
        boolean added=game.getPlayer().pickupItem(item);
        if(added){
            messageWindow.appendText("The item was added to the inventory.\n");
        }
    }

    /**
     * Scans the name from player input at the beginning of a game (new game button pressed)
     * and displays it on-screen (Thorsten)
     * @param actionEvent press the OK-button in the dialogue window
     */
    private void nameOkPressed(ActionEvent actionEvent) {
        if (nameEntry.getText().equals(""))
        {
            playerName.setText("Player 1");
        }
        else
        {
            playerName.setText(nameEntry.getText());
        }
        infoPic.setImage(null);
        weaponPic.setImage(null);
        armorPic.setImage(null);
        nameDialogue.setVisible(false);
        if(roomPic.isVisible()){
            switchMapRoomView();
        }
        currentMap = loadDungeonMap(game.getCurrentLevel().getCastleView());// Martin tmp to test castle class will be removed
        currentRoomViewMap = game.getCurrentLevel().getViewAllRooms();
        adjustRoomViews();
        messageWindow.setText(playerName.getText()+", your adventure has started.\n"+game.getCurrentLevel().getStartText());
        messageWindow.appendText("\n"+game.getCurrentRoom().getDescription());
        lifeStat.setText("" + String.valueOf(game.getPlayer().getHp())+" / "+String.valueOf(game.getPlayer().getMaxhp()));
        xpStat.setText("" + game.getPlayer().getXp());
        adjustDamageView();
        adjustArmourView();
        adjustMoveButtons();
        toggleView.setDisable(false);
    }

    /**
     * Generates a little pop-up window on pressing the new_game button, where the player
     * can input his/ her name or just click OK. The initial player stats are displayed
     * in the corresponding sections of the GUI (Thorsten)
     * @param actionEvent press the 'New Game' button
     */
    private void new_gamePressed(ActionEvent actionEvent) {
        game=new Game();
        toggleMovement(true);
        attack.setDisable(true);
        toggleView.setDisable(true);
        nameDialogue.setVisible(true);

    }

    /**
     * Switches the view on the larger panel of the GUI between the dungeon map or a
     * graphical depiction of the location.
     * @param actionEvent press the 'Room/ Map' button
     */
    private void toggleViewPressed(ActionEvent actionEvent) {
        switchMapRoomView();
    }

    private void adjustDamageView(){
        String minDamage=String.valueOf(2+(game.getPlayer().getRawdamage()));
        String maxDamage=String.valueOf(12+(game.getPlayer().getRawdamage()));
        attackStat.setText(minDamage+" - "+maxDamage);
    }
    private void adjustArmourView(){
        int defense = game.getPlayer().getArmour().getDefence();
        int mitigation = 100 - game.getPlayer().getDamagePassing(100);
        defStat.setText(defense+" ("+mitigation+"%)");
    }

    /**
     * When the attack button is pressed, the fight method is called to initiate
     * a battle between player and monster. (Thorsten)
     * @param actionEvent press the 'Attack' button
     */
    private void attackPressed(ActionEvent actionEvent) {   // test method (thorsten)
        fight(game.getMonster());
    }

    /**
     * Renders all movement (arrow) buttons functional or disables them. (TODO: author)
     * @param mode true: movement possible, false: movement disabled
     */
    private void toggleMovement(boolean mode){
        go_ahead.setDisable(mode);
        go_back.setDisable(mode);
        go_left.setDisable(mode);
        go_right.setDisable(mode);
    }

    /**
     * Switches between displaying the dungeon map or the room view on
     * the large panel in the middle of the GUI (TODO: author Martin?)
     */
    private void switchMapRoomView(){
        ImageView[][] imageCells = {{img00, img01, img02, img03, img04, img05, img06},
                {img10, img11, img12, img13, img14, img15, img16},
                {img20, img21, img22, img23, img24, img25, img26},
                {img30, img31, img32, img33, img34, img35, img36},
                {img40, img41, img42, img43, img44, img45, img46},
                {img50, img51, img52, img53, img54, img55, img56},
                {img60, img61, img62, img63, img64, img65, img66}};
        switch(toggleView.getText()){
            case "Map": loadDungeonMap(game.getCurrentLevel().getCastleView());
                        adjustRoomViews();
                        for (int i = 0; i < imageCells.length; i++) {
                            for (int j = 0; j < imageCells[0].length; j++) {
                                imageCells[i][j].setVisible(true);
                            }
                        }
                        toggleView.setText("Room");
                        break;
            case "Room":
                        toggleView.setText("Items");
                        for (int i = 0; i < imageCells.length; i++) {
                            for (int j = 0; j < imageCells[0].length; j++) {
                                imageCells[i][j].setVisible(false);
                            }
                        }
                        dungeon_map.setGridLinesVisible(false);
                        roomPic.setVisible(true);
                        break;
            case "Items":
                        roomPic.setVisible(false);
                        loadInventoryMap();
                        toggleView.setText("Map");
                        for (int i = 0; i < imageCells.length; i++) {
                            for (int j = 0; j < imageCells[0].length; j++) {
                                imageCells[i][j].setVisible(true);
                            }
                        }
                        dungeon_map.setGridLinesVisible(true);
                        break;
        }


    }

    /**
     * Populates the dungeon map on the GUI with a picture tile for each
     * map cell, displaying dungeon characteristics (e.g. rock wall, arch,
     * descriptive features). (Thorsten)
     * @param images a two-dimensional array of image tiles
     * @return a two-dimensional array of JavaFX ImageViews: displays the dungeon map
     */
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

    private ImageView[][] loadInventoryMap() {
        Image[][] images=game.getPlayer().getInventoryView(game);
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
