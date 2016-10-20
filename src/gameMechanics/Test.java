package gameMechanics;

import java.util.Map;

/**
 * Created by Fabian Billenkamp on 17.07.2016.
 */
public class Test {
    public static void main(String[]args) {
        Map<String, Treasure> treasures = new TreasureParser().parseTreasures("./src/data/gold.txt");
        System.out.println("unter treasure abgelegt: "+treasures.get("Treasure").getDescription());

        
        /*Inventory inventory = new Inventory();
        Treasure treasure1 = new Treasure("Alte Socken", "Stinkende alte Sportsocken, früher einmal weiss");
        Inventory roomStack = new Inventory(treasure1);
        inventory.addItem(new Weapon("Rostiges Messer",10,"Fügt fiese Wunden zu"));
        inventory.addItem(roomStack.removeItem(roomStack.getTreasures()[0]));

        for(int i=0;i<inventory.getSize();i++){
            System.out.println("Item gefunden: "+inventory.showItem(i).getName()+": "+inventory.showItem(i).getDescription());
        }
        for(Item i:inventory){
            System.out.println("Item gefunden: "+i.getName()+": "+i.getDescription());
        }*/

    }
}
