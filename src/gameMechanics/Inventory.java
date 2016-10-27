package gameMechanics;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Class for an inventory for the game implementation, is iterable and using Item as an iterator
 * @author Fabian Billenkamp
 */
public class Inventory implements Iterable<Item>{
    private Item[] items;
    private int maxCapacity;

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


    /**
     * Adds an Object that implements the Interface item to the inventory, as long as their is space and returns the status
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
    /**
     * Returns the number of items in the inventory (the actual size of the inventory)
     * @return integer total number of items
     */
    public int getMaxCapacity(){
        return maxCapacity;
    }
    /**
     * Returns the number of items in the inventory (the actual size of the inventory)
     * @return integer total number of items
     */
    public int getSize(){
        return items.length;
    }

    /**
     * Returns the free capacity for a number of item objects
     * @return integer maximum total capacity for items
     */
    public int getFreeCapacity() {
        return maxCapacity-items.length;
    }

    /**
     * Returns the item array of the inventory
     * @return Item[] inventory
     */
    public Item[] getItems() {
        return items;
    }

    /**
     * Returns a weapon array of all weapons in the inventory
     * @return a Weapon[]
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
     * Returns a weapon array of all treasures in the inventory
     * @return a Treasure[]
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
     * This method is used to determine the weakest weapon by force from inventory and remove it
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
     * Returns a weapon array of all treasures in the inventory
     * @return a Treasure[]
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
     * Creates an Iterator for the Item[] items
     * @return an ItemIterator over the items in the Item[] items
     */
    @Override
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
         * @return true if zaehler<items.length false if zaehler not < items.length
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
