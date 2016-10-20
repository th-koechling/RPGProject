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
    int secondEnergieNow;
    int thirdEnergieNow;
    int inventorySpace;
    boolean isAlive;
    boolean hasDragonTreasure;
    Inventory inventory = new Inventory();

    public Player(String name,String species, String description, int xp, int hp, int armor, Weapon weapon) {
        super(name, species, description,xp, hp, armor, weapon);
        this.secondEnergieNow = 100;
        this.thirdEnergieNow = 100;
        this.inventorySpace = 10;
        this.isAlive = true;
        this.hasDragonTreasure = false;
        //this.itemsInInventory = null;
    }

    // getter methods
    public int getSecondEnergieNow() {
        return this.secondEnergieNow;
    }

    public int getThirdEnergieNow() {
        return this.thirdEnergieNow;
    }

    public int getInventorySpace() {
        return this.inventorySpace;
    }

    public boolean getIsAlive() {
        return this.isAlive;
    }

    public boolean getHasDragonTreasure() {
        return this.hasDragonTreasure;
    }

    public Inventory getInventory() {
        return this.inventory;
    }
}
