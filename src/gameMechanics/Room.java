package gameMechanics;

/**
 * Modelliert einen Raum in einem Verlies.
 * Created by jonas on 27/09/16.
 */
public class Room {
    private String name;
    private String nord;
    private String ost;
    private String sued;
    private String west;
    private String description;
    private String content;

    public Room(String name) {
        this.name = name;
    }


    public Room(String name, String nord, String ost, String sued, String west, String description, String content) {
        this.name = name;
        this.nord = nord;
        this.ost = ost;
        this.sued = sued;
        this.west = west;
        this.description = description;
        this.content = content;
    }

    public String getName() {
        return name;
    }


    public String getNord() {
        return nord;
    }


    public String getOst() {
        return ost;
    }


    public String getSued() {
        return sued;
    }


    public String getWest() {
        return west;
    }


    public String getDescription() {
        return description;
    }


    public String getContent() {
        return content;
    }

}
















































