/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

/**
 * This class contains the implementation of a base weapon for the game
 * @author Fabian Billenkamp
 */

public class Weapon implements Item {
    private String name;
    private int force;
    private String description;

    /**
     * Constructor for a weapon with name, force and a description
     * @param name String: the name of the weapon
     * @param force int: the power of the weapon
     * @param description String: the descirption of the weapon
     */

    public Weapon(String name, int force, String description) {
        this.setName(name);
        this.setForce(force);
        this.setDescription(description);
    }


    /**
     * Default Constructor for a weapon
     */
    public Weapon(){}

    /**
     * Setter method for the power of a weapon
     * @param force int: power value of the weapon (used for damage calculations)
     */
    public void setForce(int force) {
        this.force = force;
    }

    /**
     * Getter method for the power of a weapon
     * @return int: power value of the weapon (used for damage calculations)
     */

    public int getForce() {
        return force;
    }


    @Override
    public void setDescription(String description) {
        this.description=description;
    }

    @Override
    public String getDescription() {
        return description;
    }


    @Override
    public void setName(String name) {
    this.name=name;
    }


    @Override
    public String getName() {
        return name;
    }


}
