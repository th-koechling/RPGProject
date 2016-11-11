package Data.GameObjects;

/**
 * TODO
 */
public class Creature {

    private String name;
    private String species;
    private String description;
    private int xp;
    private final int maxhp;
    private int hp;
    private int basedamage;
    private Armour armour;
    private Weapon weapon;

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

    // object methods


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
        //change formula, so armour actually means something
        this.hp = this.hp - (int)(attackValue/(armour.getDefence()*0.5));
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

    public int getBasedamage(){return this.basedamage;}
}
