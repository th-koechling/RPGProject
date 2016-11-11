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
     void setName(String name);

    /**
     * Setter method for the description of an item
     * @param description String: the description for the item
     */
    void setDescription(String description);
    /**
     * Getter method for the description of an item
     * @return String: the item description
     */
    String getDescription();
    /**
     * Getter method for the  name of an item
     * @return String: the name of the item
     */
    String getName();


}
