package Parser;


import GameObjects.Treasure;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fabian Billenkamp on 20.10.2016.
 */
public class TreasureParser {
    public Map<String, Treasure> parseTreasures(String treasureFilePath){
        Map<String, Treasure> treasures = new HashMap<>();
        Path textFile= Paths.get(treasureFilePath).toAbsolutePath();
        try{
            BufferedReader br = new BufferedReader( Files.newBufferedReader(textFile));
            String line = br.readLine();
            String name = null;
            while(line!=null){
                if(line.contains("Name")){
                    name = line.split(":")[1].substring(1);
                }
                if(line.contains("Description")){
                    treasures.put(name,new Treasure(name,line.split(":")[1].substring(1)));
                    name = null;
                }
                line=br.readLine();
            }
        }catch(Exception e){
            System.err.println(e);
        }

        return treasures;
    }
}
