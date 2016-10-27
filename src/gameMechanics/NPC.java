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
public class NPC extends Creature {

    int attitude;       // e.g.: 0 --> friendly (talk/ do nothing)
                        //       1 --> hostile (attack player)

    public NPC(String name,String species, String description, int xp, int hp, Armour armour, Weapon weapon, int attitude) {
        super(name, species,description,xp, hp, armour, weapon);
        this.setAttitude(attitude);
    }


    // getters, setters
    /*
    public void setName(String name) {
        this.name = name;
    }
    */

    public void setAttitude(int attitude) {
        this.attitude = attitude;
    }

    /*
    public String getName() {
        return this.name;
    }
    */

    public int getAttitude() {
        return this.attitude;
    }


}
