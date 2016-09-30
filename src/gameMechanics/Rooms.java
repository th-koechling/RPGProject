package gameMechanics;

import gameMechanics.Room;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Stellt die Röume für das Verlies bereit. Räume können über die Namen in der Datei rooms.txt angesprochen bzw. aufgerufen werden (siehe Methoden unten).
 *
 * Created by jonas on 27/09/16.
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
     * Gibt eine HashMap zurück, die als Schlüssel die Namen der Räume aus der Datei "rooms.txt" und als Values die Räume hat.
     * Als Parameter muss der Pfad zur Datei "rooms.txt" angegeben werden, in der die Räume beschrieben werden.
     */
    public Rooms(String roomsPath) {
        Path roomsFile = Paths.get(roomsPath);
        Map<String, Room> listOfRooms = new HashMap<>();

        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(roomsFile, charset)) {
            String line = null;

            Map<String, String> obj = new HashMap<>();
            /*
            Solange das Dateiende nicht erreicht ist ...
             */
            while ((line = reader.readLine()) != null) {
                /*
                ... lies eine Zeile.
                Trenne am Doppelpunkt.
                Fuege das, was vor dem Doppelpunkt steht als key und das, was hinter dem Doppelpunkt steht, als value in
                die Hashmap ein.
                 */
                if (line.trim().length() > 0) {
                    String[] splLine = line.split(":");
                    obj.put(splLine[0].trim(), splLine[1].trim());
                } else {
                    listOfRooms.put(obj.get("Name"), new Room(obj.get("Name"), obj.get("N"), obj.get("O"), obj.get("S"), obj.get("W"), obj.get("Description"), obj.get("Content")));

                }
            }

        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }


        this.roomMap = listOfRooms;
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
     * Setzt die aktuelle Position auf einen angrenzenden Raum.
     * @param direction
     */
    public void goToNextRoom(String direction){
        Room aktuellerRaum = getRoomByName(this.getAktuellePosition());
        /*
        Je nachdem, welche Richtung gewuenscht wurde, wird die aktuelle Position auf den Raum gesetzt, der in dieser Richtung liegt.
         */
        if(direction.equals("N")){
            this.setAktuellePosition(aktuellerRaum.getNord());
            System.out.println("Sie wollen nach Norden gehen.");
        }else if (direction.equals("O")){
            this.setAktuellePosition(aktuellerRaum.getOst());
            System.out.println("Sie wollen nach Osten gehen.");
        }else if (direction.equals("S")){
            this.setAktuellePosition(aktuellerRaum.getSued());
            System.out.println("Sie wollen nach Sueden gehen.");
        }else if(direction.equals("W")){
            this.setAktuellePosition(aktuellerRaum.getWest());
            System.out.println("Sie wollen nach Westen gehen.");
        }else{
            this.setAktuellePosition("none");
        }
        /*
        Sollte kein Raum in der gewuenschten Richtung liegen oder wurde eine ungueltige Eingabe gemacht, zeigt "aktuellePosition"
        jetzt auf "none". Dann wird die Position wieder zurueckgeaendert und eine Rueckmeldung auf der Kommandozeile ausgegeben.
         */
        if (this.getAktuellePosition().equals("none")) {
            setAktuellePosition(aktuellerRaum.getName());
            System.out.println("In dieser Richtung liegt kein Raum!");
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
