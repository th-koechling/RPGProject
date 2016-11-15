package Data.GameObjects;

/**
 * TODO
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
     * this
     * @param name has
     * @param species to
     * @param description be
     * @param xp done
     * @param hp stil
     * @param basedamage for
     * @param armour this
     * @param weapon class
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
     * @return Int Value of the attack.
     */
    public int attack() {
        int dice = Dice.throwDice(2,6);
        //added basedamage and weapondamage to formula, exp is somehow overkill
        return (xp * (basedamage+weapon.getForce())) + dice;
    }

    /**
     * If the creature gets attacked, it can defend itself and reduce the incoming damage.
     * @param attackValue Value of the attack.
     */
    public void defend(int attackValue) {
        //changed formula, so armour actually means something
        this.hp = this.hp - (int)(attackValue/(armour.getDefence()*0.6));
        if(this.hp < 0){
            this.hp = 0;
        }
    }

    /**
     * Fill in
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
     * please
     * @param name fill
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * please
     * @param species fill
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * please
     * @param description fill
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * please
     * @param xp fill
     */
    public void setXp(int xp) {
        this.xp = xp;
    }

    /**
     * please
     * @param hp fill
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * please
     * @param armour fill
     */
    public void setArmour(Armour armour) {
        this.armour = armour;
    }

    /**
     * please
     * @param weapon fill
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
