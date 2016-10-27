package gameMechanics;

import java.util.Map;

/**
 * Created by Fabian Billenkamp on 17.07.2016.
 */
public class Test {
    public static void main(String[]args) {
        //starte den Treasure parser und mache eine Map aus treasures
        Map<String, Treasure> treasures = new TreasureParser().parseTreasures("./src/data/gold.txt");
        //erzeuge eine "schwache" waffe
        Weapon base = new Weapon("Schwert",2,"alte klinge");
        //erzeuge einen Spieler mit der schwachen Waffe
        Player testPlayer = new Player("Fabian","human","gestörter typ",0 , 100, 100, base, 3);
        //Ausgabe des Eingangsspielers
        System.out.println("###############################");
        System.out.println("Fabian erzeugt.");
        System.out.println("Default  Waffe: "+ testPlayer.getWeapon().getName()+" Force: "+testPlayer.getWeapon().getForce());
        System.out.println("Freier Platz im Inventar: "+testPlayer.getInventorySpace()+"\\"+testPlayer.inventory.getMaxCapacity());
        System.out.println("Inhalt:");
        for(Item i:testPlayer.inventory){
            if(i.getClass().equals(Treasure.class)) {
                System.out.println(i.getName() + " : " + i.getDescription());
            }
            if(i.getClass().equals(Weapon.class)) {
                Weapon temp =(Weapon)i;
                System.out.println(temp.getName() + " : " + temp.getDescription()+", Force: "+temp.getForce());
            }
        }
        //nimm den Treasure aus der Treasure Map (Schatz des Drachen) und lösche ihn aus der Map nachdem der Player ihn hat
        testPlayer.pickupItem(treasures.get("Treasure"));
        treasures.remove(treasures.get("Treasure"));
        //Ausgabe des Spielers
        System.out.println("###############################");
        System.out.println("Schatz aufgenommen");
        System.out.println("Freier Platz im Inventar: "+testPlayer.getInventorySpace()+"\\"+testPlayer.inventory.getMaxCapacity());
        System.out.println("Inhalt:");
        for(Item i:testPlayer.inventory){
            if(i.getClass().equals(Treasure.class)) {
                System.out.println(i.getName() + " : " + i.getDescription());
            }
            if(i.getClass().equals(Weapon.class)) {
                Weapon temp =(Weapon)i;
                System.out.println(temp.getName() + " : " + temp.getDescription()+", Force: "+temp.getForce());
            }
        }
        //nehme eine neu erzeugte Waffe auf und nimm danach die beste Waffe aus der inventory als Waffe
        testPlayer.pickupItem(new Weapon("Axt",12,"rostig"));
        testPlayer.pickBestWeaponFromInv();
        //ausgabe Spielerdaten
        System.out.println("###############################");
        System.out.println("Waffe aufgenommen");
        System.out.println("Genutzte  Waffe: "+ testPlayer.getWeapon().getName()+" Force: "+testPlayer.getWeapon().getForce());
        System.out.println("Freier Platz im Inventar: "+testPlayer.getInventorySpace()+"\\"+testPlayer.inventory.getMaxCapacity());
        for(Item i:testPlayer.inventory){
            if(i.getClass().equals(Treasure.class)) {
                System.out.println(i.getName() + " : " + i.getDescription());
            }
            if(i.getClass().equals(Weapon.class)) {
                Weapon temp =(Weapon)i;
                System.out.println(temp.getName() + " : " + temp.getDescription()+", Force: "+temp.getForce());
            }
        }

        //erzeuge erzeuge einen schatz und füge ihn zu einem neuen Inventory "roomstack" hinzu
        Treasure socken = new Treasure("Alte Socken", "Stinkende alte Sportsocken, früher einmal weiss");
        Inventory roomStack = new Inventory(socken);
        //tracking
        System.out.println("\n****** Inventory moves*******");
        System.out.println("Größe \"roomstack\": "+roomStack.getSize()+":");
        for(Item j:roomStack){
            System.out.println("Item: "+ j.getName());
        }
        //erzeuge ein leeres inventar
        Inventory inventory = new Inventory();
        //tracking
        System.out.println("Größe \"Inventory\": "+inventory.getSize());
        for(Item k:inventory){
            System.out.println("Item: "+ k.getName());
        }
        // füge eine neue Waffe zum inventar hinzu, nimm den schatz aus roomstack und füge ihn ins inventar
        inventory.addItem(new Weapon("Rostiges Messer",15,"Fügt fiese Wunden zu"));
        inventory.addItem(roomStack.removeItem(roomStack.getTreasures()[0]));
        //tracking
        System.out.println("Filling inventory with new Weapon and roomstack content");
        System.out.println("Größe \"roomstack\": "+roomStack.getSize()+":");
        for(Item j:roomStack){
            System.out.println("Item: "+ j.getName());
        }
        System.out.println("Größe \"Inventory\": "+inventory.getSize());
        for(Item k:inventory){
            System.out.println("Item: "+ k.getName());
        }
        System.out.println("****** Inventory moves ended*******\n");
        //füge alle items aus inventory zur playerinventory
        for(Item z : inventory){
            for(Item in : testPlayer.inventory){
                System.out.println(in.getName());
            }
            System.out.println("adding: "+z.getName());
            testPlayer.pickupItem(z);
            for(Item in : testPlayer.inventory){
                System.out.println(in.getName());
            }

        }
        //tracking
        System.out.println("###############################");
        System.out.println("Waffe aufgenommen");
        System.out.println("Genutzte  Waffe: "+ testPlayer.getWeapon().getName()+" Force: "+testPlayer.getWeapon().getForce());
        System.out.println("Freier Platz im Inventar: "+testPlayer.getInventorySpace()+ "\nPlätze");
        /*for(Item i:testPlayer.inventory){
            if(i.getClass().equals(Treasure.class)) {
                System.out.println(i.getName() + " : " + i.getDescription());
            }
            if(i.getClass().equals(Weapon.class)) {
                Weapon temp =(Weapon)i;
                System.out.println(temp.getName() + " : " + temp.getDescription()+", Force: "+temp.getForce());
            }
        }*/

    }
}
