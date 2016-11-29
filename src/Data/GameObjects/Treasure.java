package Data.GameObjects;

/**
 * This class contains the methods and properties for treasures.
 * Treasures implement methods of Item
 * @author Fabian Billenkamp
 */
public class Treasure implements Item {
    /*
    **********************************************************************************
    *                                  Variables                                     *
    **********************************************************************************
    */
    private String name;
    private String description;

    /*
     **********************************************************************************
     *                                 Constructors                                   *
     **********************************************************************************
     */
    /**
     * Constructor for a treasure with name, value and description
     * @param name String: the name of the treasure
     * @param description String: description for the treasure
     */
    public Treasure(String name,String description){
        this.setName(name);
        this.setDescription(description);
    }

    /*
     **********************************************************************************
     *            Getter methods for the different variables                          *
     **********************************************************************************
     */
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
