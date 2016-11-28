package Data.GameObjects;

/**
 * This class is a representation for armours in the DND game, it inherits methods of Item and
 * adds armour specific methods
 * @author Fabian Billenkamp
 * @author Andreas Hoek
 */
public class Armour implements Item {
    /*
    **********************************************************************************
    *                                  Variables                                     *
    **********************************************************************************
    */
    private String name;
    private int defence;
    private String description;

    /*
     **********************************************************************************
     *                                 Constructors                                   *
     **********************************************************************************
     */
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
     * Default Constructor for an armour
     */
    public Armour(){}
    /*
     **********************************************************************************
     *            Getter methods for the different variables                          *
     **********************************************************************************
     */
    /**
     * Getter method for the power of an armor
     * @return int: power value of the armor (used for defense calculations)
     */
    public int getDefence() {
        return defence;
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
    public String getName() {
        return name;
    }

    /*
     **********************************************************************************
     *            Setter methods for the different variables                          *
     **********************************************************************************
     */
    /**
     * Setter method for the power of an armor
     * @param defence int: power value of the armor (used for defense calculations)
     */
    public void setDefence(int defence) {
        this.defence = defence;
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
