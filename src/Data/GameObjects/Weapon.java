/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.GameObjects;

/**
 * This class contains the implementation of a base weapon for the game
 * @author Fabian Billenkamp
 */

public class Weapon implements Item {
    /*
   **********************************************************************************
   *                                  Variables                                     *
   **********************************************************************************
   */
    private String name;
    private int force;
    private String description;

    /*
     **********************************************************************************
     *                                 Constructors                                   *
     **********************************************************************************
     */
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

    /*
     **********************************************************************************
     *            Getter methods for the different variables                          *
     **********************************************************************************
     */
    /**
     * Getter method for the power of a weapon
     * @return int: power value of the weapon (used for damage calculations)
     */
    public int getForce() {
        return force;
    }

    /**
     * {@inheritDoc}
     */
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    public String getDescription() {
        return description;
    }

    /*
     **********************************************************************************
     *            Setter methods for the different variables                          *
     **********************************************************************************
     */
    /**
     * Setter method for the power of a weapon
     * @param force int: power value of the weapon (used for damage calculations)
     */
    public void setForce(int force) {
        this.force = force;
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


}
