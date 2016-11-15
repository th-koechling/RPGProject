/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.GameObjects;

/**
 * This class implements features of treasures.
 * Treasures implement methods from Item
 * @author Fabian Billenkamp
 */
public class Treasure implements Item {
    private String name;
    private String description;

    /**
     * Constructor for a treasure with name, value and description
     * @param name String: the name of the treasure
     * @param description String: description for the treasure
     */
    public Treasure(String name,String description){
        this.setName(name);
        this.setDescription(description);
    }

    /**
     * {@inheritDoc}
     */
    public String getDescription() {
        return description;
    }

    /**
     * {@inheritDoc}
     */
    public void setDescription(String description) {
        this.description=description;
    }

    /**
     * {@inheritDoc}
     */
    public void setName(String name) {
        this.name=name;
    }

    /**
     * {@inheritDoc}
     */
    public String getName() {
        return name;
    }

}
