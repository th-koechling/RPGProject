/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameMechanics;

/**
 * Class for special weapons that have additional damage modifiers
 * @author Fabian Billenkamp
 */
public class SpecialWeapon extends Weapon {
    private String name;
    private int force;
    private int special;
    private String description;

    /**
     * Constructor for a special weapon
     * @param name String: the name of the weapon
     * @param force int: the power of the weapon
     * @param special int: additional power of the weapon
     */
    public SpecialWeapon(String name,  int force, int special) {
        this.setName(name);
        this.setForce(force);
        this.setSpecial(special);
    }

    /**
     * Getter method for the special power of a weapon
     * @return int: powervalue for specialpower
     */
    public int getSpecial() {
        return special;
    }

    /**
     * Setter method for the powervalue of the special power
     * @param special int: value of special power
     */
    public void setSpecial(int special) {
        this.special = special;
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
    public int getForce() {
        return force;
    }
    @Override
    public void setName(String name) {
    this.name=name;
    }
    @Override
    public void setForce(int force) {
        this.force = force;
    }
    @Override
    public String getName() {
        return name;
    }
}
