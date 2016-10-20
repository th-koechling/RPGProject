/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameMechanics;

/**
 *
 * @author Martins
 */
public class Player extends Creature {
    // String name;     comes from super class now
    // int lifeNow;   replaced by hp
    int inventorySpace;
    Inventory inventory;

    public Player(String name,String species, String description, int xp, int hp, int armor, Weapon weapon, int inventorySpace) {
        super(name, species, description,xp, hp, armor, weapon);
        this.inventorySpace = inventorySpace;
        this.inventory = new Inventory((inventorySpace));
        inventory.addItem(weapon);
    }

    // getter methods
    /**
     * @Author Fabian Billenkamp
     * This method returns the free space in a player inventory
     */
    public int getInventorySpace() {
        return this.inventory.getFreeMaxCapacity();
    }
    /**
     * @Author Fabian Billenkamp
     * This method is used to take an item object and add the object to the inventory
     * In case the item can not be added due to inventory being full, the weakest
     * weapon is removed from inventory and the item is added.
     */
    public void pickupItem(Item item){
        boolean added= this.inventory.addItem(item);
        if(!added){
            this.inventory.dropWeakestWeapon();
            this.inventory.addItem(item);
        }

    }
    /**
     * @Author Fabian Billenkamp
     * This method sets the weapon of a player to be the best weapon by force from the inventory
     */
    public void pickBestWeaponFromInv(){
        this.setWeapon(inventory.getBestWeapon());
    }

}
