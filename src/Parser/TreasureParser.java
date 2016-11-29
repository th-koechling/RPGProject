package Parser;

import Data.GameObjects.Treasure;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is the representation of a parser for treasures.txt files
 * @author Fabian Billenkamp
 */
public class TreasureParser {
    /*
     **********************************************************************************
     *                               Parsing Method                                   *
     **********************************************************************************
     */
    /**
     * This method is used to create a hash map of treasures from a txt file.
     * @param treasureFilePath The Path where the treasures.txt file is located
     * @return HashMap: Treasurename:Treasure
     */
    public Map<String, Treasure> parseTreasures(String treasureFilePath){
        Map<String, Treasure> treasures = new HashMap<>();
        Path textFile= Paths.get(treasureFilePath).toAbsolutePath();
        try{
            BufferedReader br = new BufferedReader( Files.newBufferedReader(textFile));
            String line = br.readLine();
            String name = new String();
            while(line!=null){
                if(line.contains("Name")){
                    name = line.split(":")[1].substring(1).trim();
                }
                if(line.contains("Description")){
                    treasures.put(name,new Treasure(name,line.split(":")[1].substring(1)));
                    name = new String();
                }
                line=br.readLine();
            }
        }catch(Exception e){
            System.err.println(e);
        }

        return treasures;
    }
}
