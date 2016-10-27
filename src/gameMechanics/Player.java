/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameMechanics;

/**
 *
 * @author Fabian Billenkamp
 */
public class Player extends Creature {
    // String name;     comes from super class now
    // int lifeNow;   replaced by hp
    int inventorySpace;
    boolean isAlive;
    boolean hasDragonTreasure;
    Inventory inventory;

    public Player(String name,String species, String description, int xp, int hp, int armor, Weapon weapon, int inventorySpace) {
        super(name, species, description,xp, hp, armor, weapon);
        this.isAlive = true;
        this.hasDragonTreasure = false;
        this.inventorySpace = inventorySpace;
        this.inventory = new Inventory((inventorySpace));
        if(!weapon.getName().equals("Hand")){
            inventory.addItem(weapon);
        }
        //this.itemsInInventory = null;
    }
    public Player(Creature model, int inventorySpace) {
        super(model.getName(), model.getSpecies(), model.getDescription(),model.getXp(), model.getMaxhp(), model.getArmor(), model.getWeapon());
        this.inventorySpace = inventorySpace;
        this.inventory = new Inventory((inventorySpace));
        if(!this.getWeapon().getName().equals("Hand")){
            inventory.addItem(this.getWeapon());
        }
    }

    // getter methods
    /**
     * @Author Fabian Billenkamp
     * This method returns the free space in a player inventory
     */
    public int getInventorySpace() {
        return this.inventory.getFreeCapacity();
    }
    /**
     * @Author Fabian Billenkamp
     * This method is used to take an item object and add the object to the inventory
     * In case the item can not be added due to inventory being full, the weakest
     * weapon is removed from inventory and the item is added.
     */
    //Since currently there is only one non-weapon item, no conflicts should emerge from this.
    //
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
     * @Author Fabian Billenkamp
     * This method sets the weapon of a player to be the best weapon by force from the inventory
     */
    public void pickBestWeaponFromInv(){
        this.setWeapon(inventory.getBestWeapon());
    }

    /**
     * Getter method for player inventory
     * @return The inventory
     */
    public Inventory getInventory(){return  this.inventory;}
}
