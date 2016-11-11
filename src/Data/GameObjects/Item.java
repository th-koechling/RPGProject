/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.GameObjects;



/**
 * Interface collecting methods that are shared by all items
 * @author Fabian Billenkamp
 */
public interface Item{
    /**
     * Setter method for the name of an item
     * @param name String: name of the item
     */
    public void setName(String name);

    /**
     * Setter method for the description of an item
     * @param description String: the description for the item
     */
    public void setDescription(String description);
    /**
     * Getter method for the description of an item
     * @return String: the item description
     */
    public String getDescription();
    /**
     * Getter method for the  name of an item
     * @return String: the name of the item
     */
    public String getName();


}
