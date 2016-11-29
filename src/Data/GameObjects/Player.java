package Data.GameObjects;

import Data.Game;
import javafx.scene.image.Image;
import view.Pictures;


/**
 * The class player extends Creature and adds inventory functionality as well as inventory usage
 * @author Fabian Billenkamp
 * @author Andreas Hoek
 * @author Martin
 */
public class Player extends Creature {
    /*
    **********************************************************************************
    *                                  Variables                                     *
    **********************************************************************************
    */
    int inventorySpace;
    boolean isAlive;
    boolean hasDragonTreasure;
    Inventory inventory;
    private Image [][] inventoryView;

    /*
    **********************************************************************************
    *                                  Constructors                                  *
    **********************************************************************************
    */
    /**
     * This constructor for a PLayer takes all possible values as parameters
     * @param name String: Playername
     * @param species String: Playerspecies
     * @param description String: Player description
     * @param xp Integer: Experiencepoints
     * @param hp Integer: Healthpoints
     * @param basedamage Integer: Player Basedamage
     * @param armour Armour: Player Armour
     * @param weapon Weapon: Player Weapon
     */
    public Player(String name, String species, String description, int xp, int hp, int basedamage, Armour armour, Weapon weapon) {
        super(name, species, description,xp, hp,basedamage, armour, weapon);
        inventoryView=new Image[7][7];
        this.isAlive = true;
        this.hasDragonTreasure = false;
        this.inventorySpace = 49;
        this.inventory = new Inventory((inventorySpace));
        if(!weapon.getName().equals("Hand")){
            inventory.addItem(weapon);
        }
        inventory.addItem(armour);
    }

    /**
     * This constructor for Player takes a Creature model as the basis for creating a player.
     * The values from creature are transcribed into Player
     * @param model: Creature: the Creature model the Player is based on
     */
    public Player(Creature model) {
        super(model.getName(), model.getSpecies(), model.getDescription(),model.getXp(), model.getMaxhp(),model.getBasedamage(), model.getArmour(), model.getWeapon());
        this.inventorySpace = 49;
        this.inventoryView= new Image[7][7];
        this.inventory = new Inventory((inventorySpace));
        if(!this.getWeapon().getName().equals("Hand")){
            inventory.addItem(this.getWeapon());
        }
        inventory.addItem(model.getArmour());
    }

   /*
    **********************************************************************************
    *                              Getter methods                                    *
    **********************************************************************************
    */
    /**
     * This method returns the free space in a player inventory
     * @author Fabian Billenkamp
     * @deprecated
     */
    public int getInventorySpace() {
        return this.inventory.getFreeCapacity();
    }

    /**
     * Getter method for player inventory
     * @return The inventory
     */
    public Inventory getInventory(){return  this.inventory;}

    /**
     * This method returns an Image matrix representing the current player inventory.
     * @param game the current game
     * @return Image[][]: an Image Matrix representing the inventory
     * @author Fabian
     * @author Martin
     */
    public Image[][] getInventoryView(Game game){
        int pos = 0;
        for(int i=0;i<inventoryView.length;i++){
            for(int j=0;j<inventoryView[i].length;j++){
                if(pos<inventory.getSize()){
                    inventoryView[i][j]= game.getItemViewInfo().get(inventory.showItem(pos).getName());
                    pos++;
                }else{
                    inventoryView[i][j]= Pictures.corridor;
                }
            }
        }

        return inventoryView;
    }


    /*
    **********************************************************************************
    *                              Further player methods                            *
    **********************************************************************************
    */
    /**
     * This method is used to take an item object and add the object to the inventory
     * In case the item can not be added due to inventory being full, the weakest
     * weapon is removed from inventory and the item is added.
     * @author Fabian Billenkamp
     */
    public boolean pickupItem(Item item){
        boolean added = this.inventory.addItem(item);
        if(!added){
            Weapon weakest= this.inventory.getWeakestWeapon();
            this.inventory.removeItem(weakest);
            added=this.inventory.addItem(item);
        }
        return added;
    }

    /**
     * This method sets the weapon of a player to be the best weapon by force from the inventory
     * @author Fabian Billenkamp
     * @author Andreas
     */
    public void pickBestWeaponFromInv(){
        this.setWeapon(inventory.getBestWeapon());
    }

    /**
     * This method sets the armour of a player to be the best weapon by force from the inventory
     * @author Fabian Billenkamp
     * @author Andreas
     */
    public void pickBestArmourFromInv(){
        this.setArmour(inventory.getBestArmour());
    }






}


