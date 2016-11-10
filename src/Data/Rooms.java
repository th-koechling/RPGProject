package Data;

import java.util.Map;

/**
 * Stellt die Röume für das Verlies bereit. Räume können über die Namen in der Datei rooms.txt angesprochen bzw. aufgerufen werden (siehe Methoden unten).
 * Created by jonas on 27/09/16.
 * Split into Parser and rooms object by Fabian on 02/11/16.
 */
public class Rooms {
    /**
     * Zeigt die aktuelle Position des Spielers an. Defaultmäßig steht aktuellePosition auf Entry.
     */
    private String aktuellePosition = "Entry";
    /**
     * Beinhaltet die Räume. Die Namen der Räume sind als Schlüssel der Map hinterlegt.
     */
    private static Map<String, Room> roomMap;

    /**
     * Konstruktor für Rooms.
     * Nimmt eine HashMap aus geparseten Rooms, die als Schlüssel die Namen der Räume aus der Datei "rooms.txt" und als
     * Values die Räume hat und erzeugt ein Objekt Rooms, das die notwendigen Methoden für die Nutzung besitzt
     * @param listOfRooms eine Hashmap von geparseten Räumen aus rooms.txt
     */
    public Rooms( Map<String, Room> listOfRooms){
        this.roomMap=listOfRooms;
    }

    /**
     * Ermöglicht es, einen Raum bei seinem Namen aufzurufen.
     * @param query_name
     * @return
     */
    public Room getRoomByName(String query_name) {
        return this.roomMap.get(query_name);
    }

    /**
     * Setzt die aktuelle Position auf einen angrenzenden Raum und gibt TRUE oder FALSE zurueck, je nachdem ob der Raumwechsel moeglich ist.
     * @param direction
     */
    public void goToNextRoom(String direction){
        Room aktuellerRaum = getRoomByName(this.getAktuellePosition());
        /*
        Je nachdem, welche Richtung gewuenscht wurde, wird die aktuelle Position auf den Raum gesetzt, der in dieser Richtung liegt.
         */
        if(direction.equals("N")){
            this.setAktuellePosition(aktuellerRaum.getNord());
        }else if (direction.equals("O")){
            this.setAktuellePosition(aktuellerRaum.getOst());
        }else if (direction.equals("S")){
            this.setAktuellePosition(aktuellerRaum.getSued());
        }else if(direction.equals("W")){
            this.setAktuellePosition(aktuellerRaum.getWest());
        }else{
            this.setAktuellePosition("none");
        }
        /*
        Sollte kein Raum in der gewuenschten Richtung liegen oder wurde eine ungueltige Eingabe gemacht, zeigt "aktuellePosition"
        jetzt auf "none". Dann wird die Position wieder zurueckgeaendert, eine Rueckmeldung auf der Kommandozeile ausgegeben & FALSE
        zurueckgegeben.
         */
        if (this.getAktuellePosition().equals("none")) {
            setAktuellePosition(aktuellerRaum.getName());

        }
    }

    /**
     * Gibt die aktuelle Position im Verlies zurück.
     * @return
     */

    public String getAktuellePosition() {
        return aktuellePosition;
    }

    /**
     * Erlaubt, die aktuelle Position im Verlies zu verändern.
     * @param aktuellePosition
     */
    public void setAktuellePosition(String aktuellePosition) {
        this.aktuellePosition = aktuellePosition;
    }
    
    // created from Martin
    public static Map getRoomMap() {
        return roomMap;
    }
}
