package Data.GameObjects;

/**
 * Created by andre_000 on 27.10.2016.
 */
public class Armour implements Item {
    private String name;
    private int defence;
    private String description;

    /**
     * Constructor for an armor with name, force and a description
     * @param name String: the name of the armor
     * @param defence int: the power of the armor
     * @param description String: the description of the armor
     */

    public Armour(String name, int defence, String description) {
        this.setName(name);
        this.setDefence(defence);
        this.setDescription(description);
    }

    /**
     * Default Constructor for a weapon
     */
    public Armour(){}

    /**
     * Setter method for the power of an armor
     * @param defence int: power value of the armor (used for defense calculations)
     */
    public void setDefence(int defence) {
        this.defence = defence;
    }

    /**
     * Getter method for the power of an armor
     * @return int: power value of the armor (used for defense calculations)
     */

    public int getDefence() {
        return defence;
    }

    public void setDescription(String description) {
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
