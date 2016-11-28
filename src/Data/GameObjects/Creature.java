package Data.GameObjects;

/**
 * This class is a representation for creatures in the DND game. It contains all attributes of the creature such as name, species, xp, hp, equipped weapons & armors etc.
 * @author Andreas Hoek
 */
public class Creature {
    /*
     **********************************************************************************
     *                                  Variables                                     *
     **********************************************************************************
     */
    private String name;
    private String species;
    private String description;
    private int xp;
    private final int maxhp;
    private int hp;
    private int basedamage;
    private Armour armour;
    private Weapon weapon;

    /*
    **********************************************************************************
    *                                  Constructor                                   *
    **********************************************************************************
    */
    /**
     * Constructor for a new creature.
     * @param name String: The name of the creature
     * @param species String: The species of the creature (e.g. Human, Dragon,...)
     * @param description String: A description of the creature
     * @param xp int: Value of the experience of the creature. The xp value affects the attack power of the creature.
     * @param hp int: Value for the health of the creature.
     * @param basedamage int: Basic Damage the creature causes without equipped weapons.
     * @param armour Armour: Current equipped Armour of the creature.
     * @param weapon Weapon: Current equipped Weapon of the creature.
     */
    public Creature(String name, String species, String description, int xp, int hp, int basedamage, Armour armour, Weapon weapon) {
        this.maxhp = hp;
        this.setName(name);
        this.setSpecies(species);
        this.setDescription(description);
        this.setXp(xp);
        this.setHp(hp);
        this.basedamage=basedamage;
        this.setArmour(armour);
        this.setWeapon(weapon);
    }


    /*
    **********************************************************************************
    *                                  Object methods                                *
    **********************************************************************************
    */
    /**
     * Carries out an attack by the creature (Player or NPC)
     * @return int: Value of the attack.
     */
    public int attack() {
        int dice = Dice.throwDice(2,6);
        return getRawdamage() + dice;
    }

    /**
     * If the creature gets attacked, it can defend itself and reduce the incoming damage.
     * @param attackValue int: Value of the attack.
     */
    public void defend(int attackValue) {
        this.hp = this.hp - getDamagePassing(attackValue);
        if(this.hp < 0){
            this.hp = 0;
        }
    }

    /**
     * The creature can heal itself by changing rooms until its max hp is recovered.
     */
    public void heal(){
        if(this.hp + 7 <= maxhp){
            this.hp += 7;
        } else {
            this.hp = maxhp;
        }
    }


    /*
     **********************************************************************************
     *            Getter & Setter methods for the different variables                 *
     **********************************************************************************
     */

    /**
     * Getter method for the dealed damage by a creature.
     * @return int: Dealed damage by the creature in an attack.
     */
    public int getRawdamage(){
        /*
         **********************************************************************************
         * Here a modificiation of the original formula from the script is used.          *
         * The used formula here takes creature base damage, weapon force and experience  *
         * into considderation for a raw damage before adding of dice values.             *
         * Also experienced is divided to not get too high attack from xp.                *
         * Fabian Billenkamp                                                              *
         **********************************************************************************
         */
        return (int)((xp/2.) * (basedamage+weapon.getForce()));
    }

    /**
     * Getter method for the damage that hits a creature.
     * @return int: Damage that hits the creature during an attack by a hostile creature.
     */
    public int getDamagePassing(int attackValue){
        /*
         **********************************************************************************
         * Here a modificiation of the original formula from the script is used.          *
         * The used formula here take armour into consideration by %  rather than         *
         * by substraction, this makes armour effective also against bigger hits.         *
         * Fabian Billenkamp                                                              *
         **********************************************************************************
         */
        return (int)(attackValue -(attackValue *(armour.getDefence()/10.)));
    }


    /**
     * Setter method for the name of a creature.
     * @param name String: Name for the creature.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter method for the species of a creature.
     * @param species String: Species for the creature.
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * Setter method for the description of a creature.
     * @param description String: Description for the creature.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Setter method for the xp value of a creature.
     * @param xp int: xp value for the creature.
     */
    public void setXp(int xp) {
        this.xp = xp;
    }

    /**
     * Setter method for the hp value of a creature.
     * @param hp int: hp value for the creature.
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Setter method for the armour of a creature.
     * @param armour armour: Armour to be equipped.
     */
    public void setArmour(Armour armour) {
        this.armour = armour;
    }

    /**
     * Setter method for the weapon of a creature.
     * @param weapon weapon: Weapon to be equipped.
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * please
     * @return fill
     */
    public String getName() {
        return this.name;
    }

    /**
     * please
     * @return fill
     */
    public String getSpecies() {
        return this.species;
    }

    /**
     * please
     * @return fill
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * please
     * @return fill
     */
    public int getXp() {
        return this.xp;
    }

    /**
     * please
     * @return fill
     */
    public int getHp() {
        return this.hp;
    }

    /**
     * please
     * @return fill
     */
    public Armour getArmour() {
        return this.armour;
    }

    /**
     * please
     * @return fill
     */
    public Weapon getWeapon() {
        return this.weapon;
    }

    /**
     * please
     * @return fill
     */
    public int getMaxhp() {return this.maxhp; }

    /**
     * please
     * @return fill
     */
    public int getBasedamage(){return this.basedamage;}
}
