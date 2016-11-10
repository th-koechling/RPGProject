package Parser;

import Data.Room;
import Data.Rooms;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonas
 * Split into Parser and rooms by Fabian
 */
public class RoomsParser {
    public Rooms parseRooms(String roomsPath) {
        Path roomsFile = Paths.get(roomsPath);
        Map<String, Room> listOfRooms = new HashMap<>();
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(roomsFile, charset)) {
            String line;
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
        return new Rooms(listOfRooms);
    }


}
