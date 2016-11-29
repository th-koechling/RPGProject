package Data.GameObjects;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Class for an inventory for the game implementation, is iterable and using Item as an iterator
 * @author Fabian Billenkamp
 */
public class Inventory implements Iterable<Item>{
    /*
    **********************************************************************************
    *                                  Variables                                     *
    **********************************************************************************
    */
    private Item[] items;
    private int maxCapacity;

    /*
    **********************************************************************************
    *                                  Constructors                                  *
    **********************************************************************************
    */
    /**
     * Creates an Inventory that can store objects that implement the Interface Item in an array
     * Current implementation allows to store more or less unlimited items (up to Integer.MAX_VALUE)
     * with respect to play turns and items otbainable
     */
    public Inventory() {
        this.maxCapacity = Integer.MAX_VALUE;
        this.items=new Item[0];
    }

    /**
     * Creates an Inventory that can store objects that implement the Interface Item in an array
     * @param maxCapacity maximum Number of objects that can be stored in the inventory
     */
    public Inventory(int maxCapacity){
        this.maxCapacity=maxCapacity;
        this.items=new Item[0];
    }

    /**
     * Creates an Inventory that can store one object that implements the Interface Item in an array
     * @param item the item object to be stored in the inventory
     */
    public Inventory(Item item){
        this.maxCapacity=1;
        this.items=new Item[1];
        this.items[0]=item;
    }

     /*
     **********************************************************************************
     *            Getter methods for different inventory variables                    *
     **********************************************************************************
     */
    /**
     * Returns the maximum number of items the inventory can store (the actual size of the inventory)
     * @return Integer: maximum number of items the inventory can store
     */
    public int getMaxCapacity(){
        return maxCapacity;
    }

    /**
     * Returns the number of items in the inventory (the current size of the inventory)
     * @return integer total number of items
     */
    public int getSize(){
        return items.length;
    }

    /**
     * Returns the free capacity for an inventory (number of item objects that can still be stored)
     * @return Integer: maximum capacity for additional items
     */
    public int getFreeCapacity() {
        return maxCapacity-items.length;
    }

    /**
     * Returns the item array of the inventory
     * @return Item[]: Items inventory
     */
    public Item[] getItems() {
        return items;
    }

    /**
     * Returns a weapon array of all weapons in the inventory
     * @return Weapon[]: Weapons in inventory
     */
    public Weapon[] getWeapons() {
        Weapon[] weapons=new Weapon[0];
        for(Item current:items){
            if(current.getClass().equals(Weapon.class)){
                Weapon anotherWeapon = (Weapon)current;
                Weapon[]temp=weapons;
                weapons=new Weapon[temp.length+1];
                for(int i=0;i<temp.length;i++){
                    weapons[i]=temp[i];
                }
                weapons[temp.length]=anotherWeapon;
            }
        }
        return weapons;
    }

    /**
     * Returns an armour array of all armours in the inventory
     * @return Armour[]: Armours in inventory
     */
    public Armour[] getArmours() {
        Armour[] armours=new Armour[0];
        for(Item current:items){
            if(current.getClass().equals(Armour.class)){
                Armour anotherArmour = (Armour) current;
                Armour[]temp=armours;
                armours=new Armour[temp.length+1];
                for(int i=0;i<temp.length;i++){
                    armours[i]=temp[i];
                }
                armours[temp.length]=anotherArmour;
            }
        }
        return armours;
    }

    /**
     * Returns a treasure array of all treasures in the inventory
     * @return Treasure[]: Treasures in inventory
     */
    public Treasure[] getTreasures() {
        Treasure[] treasures=new Treasure[0];
        for(Item current:items){
            if(current.getClass().equals(Treasure.class)){
                Treasure[]temp=treasures;
                treasures=new Treasure[temp.length+1];
                for(int i=0;i<temp.length;i++){
                    treasures[i]=temp[i];
                }
                treasures[temp.length]=(Treasure)current;
            }
        }
        return treasures;
    }

    /**
     * This method is used to determine the weakest weapon by force from inventory
     * @return Weapon: the weakest weapon in the inventory, if non available, a dummy is returned
     */
    public Weapon getWeakestWeapon(){
        Weapon dummy = new Weapon("Dummy",Integer.MAX_VALUE,"Dummy");
        Weapon[] weapons = getWeapons();
        for(int i=0;i<weapons.length;i++){
            if(weapons[i].getForce()<dummy.getForce()){
                dummy=weapons[i];
            }
        }
        return dummy;
    }

    /**
     * This method is used to determine the strongest weapon by force from inventory
     * @return Weapon: the strongest weapon in the inventory, if non available, a dummy is returned
     */
    public Weapon getBestWeapon() {
        Weapon dummy = new Weapon("Dummy",0,"Dummy");
        Weapon[] weapons = getWeapons();
        for(int i=0;i<weapons.length;i++){
            if(weapons[i].getForce()>dummy.getForce()){
                dummy=weapons[i];
            }
        }
        return dummy;
    }

    /**
     * This method is used to determine the best armour by defence from inventory
     * @return Armour: the best armour in the inventory, if non available, a dummy is returned
     */
    public Armour getBestArmour() {
        Armour dummy = new Armour("Dummy",0,"Dummy");
        Armour[] armours = getArmours();
        for(int i=0;i<armours.length;i++){
            if(armours[i].getDefence()>dummy.getDefence()){
                dummy=armours[i];
            }
        }
        return dummy;
    }

    /*
     **********************************************************************************
     *                       Additional inventory methods                             *
     **********************************************************************************
     */
    /**
     * Adds an Object that implements the Interface item to the inventory, as long as there is space and returns the status
     * @param item The item object to be added
     * @return true if there was space for the item and it was added, false if the item could not be added
     */
    public boolean addItem(Item item){
        if(items.length<maxCapacity) {
            Item[] temp = new Item[items.length + 1];
            for (int i = 0; i < items.length; i++) {
                temp[i] = items[i];
            }
            temp[items.length] = item;
            items = temp;
            return true;
        }else{
            return false;
        }
    }

    /**
     * Returns the item at an index of the inventory, without removing it from the inventory
     * @param index the inventory index to show
     * @return the item object at index
     */
    public Item showItem(int index){
        return items[index];
    }

    /**
     * Removes an item from the inventory
     * @param item the item that should be removed from the inventory
     * @return the item that was removed
     */
    public Item removeItem(Item item){
        List<Item> temp = new ArrayList<Item>(Arrays.asList(items));
        temp.remove(item);
        items=new Item[0];
        for(Item keep : temp){
            addItem(keep);
        }
        return item;
    }

   /*
     **********************************************************************************
     *                       Iterable implementation                                  *
     **********************************************************************************
     */

    /**
     * Creates an Iterator for the Item[] items
     * @return an ItemIterator over the items in the Item[] items
     */
    public Iterator<Item> iterator(){
        return new ItemIterator(items);
    }


    /**
     *Inner Class containing the Iterator functions for ItemIterator
     */
    class ItemIterator implements Iterator<Item>{
        private int zaehler;
        Item[] items;

        /**
         * Contructor for an ItemIterator
         * @param items an array of containing objects imlementing Item
         */
        public ItemIterator(Item[] items) {
            this.zaehler = 0;
            this.items = items;
        }

        /**
         * Returns the item at position zaehler and adds +1 to zaehler
         * @return the item on position zaehler
         */
        public Item next() {
            return items[zaehler++];
        }


        /**
         * Method for finding out if there is a next item
         * @return boolean true if zaehler smaller than items.length, false: else
         */
        public boolean hasNext() {
            if (zaehler < items.length) {
                return true;
            } else {
                return false;
            }
        }

    }
}
