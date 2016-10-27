package gameMechanics;

/**
 * Created by tito on 04.07.16.
 */
public class Creature {

    private String name;
    private String species;
    private String description;
    private int xp;
    private final int maxhp;
    private int hp;
    private Armour armour;
    private Weapon weapon;

    public Creature(String name, String species, String description, int xp, int hp, Armour armour, Weapon weapon) {
        this.maxhp = hp;
        this.setName(name);
        this.setSpecies(species);
        this.setDescription(description);
        this.setXp(xp);
        this.setHp(hp);
        this.setArmour(armour);
        this.setWeapon(weapon);
    }

    // object methods


    /**
     * Carries out an attack by the creature (Player or NPC)
     * @return Int Value of the attack.
     */
    public int attack() {
        int dice = Control.throwDice();
        return (xp * weapon.getForce()) + dice;
    }

    /**
     * If the creature gets attacked, it can defend itself and reduce the incoming damage.
     * @param attackValue Value of the attack.
     */
    public void defend(int attackValue) {
        int dice = Control.throwDice();
        /*if(dice < 12 && dice > 6){
            hp = hp - attackValue/2;
        } else {
            hp = hp - attackValue;
        }
        */
        this.hp = this.hp + armour.getDefence() - attackValue;
        if(this.hp < 0){
            this.hp = 0;
        }
    }

    public void heal(){
        if(this.hp + 7 <= maxhp){
            this.hp += 7;
        } else {
            this.hp = maxhp;
        }
    }


    // setters and getters
    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setArmour(Armour armour) {
        this.armour = armour;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getName() {
        return this.name;
    }

    public String getSpecies() {
        return this.species;
    }

    public String getDescription() {
        return this.description;
    }

    public int getXp() {
        return this.xp;
    }

    public int getHp() {
        return this.hp;
    }

    public Armour getArmour() {
        return this.armour;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public int getMaxhp() {return this.maxhp; }
}
