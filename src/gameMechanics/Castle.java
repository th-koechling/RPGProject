/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameMechanics;

/**
 *
 * @author Martins
 */
public class Castle {

    private Room[] roomsInCastle;

    public Castle(Room[] roomsInCastle) {
        this.roomsInCastle = roomsInCastle;
    }

    void buildCastle() {

    }


    public void setRoomsInCastle(Room[] roomsInCastle) {
        this.roomsInCastle = roomsInCastle;
    }

    public Room[] getRoomsInCastle() {
        return this.roomsInCastle;
    }

    public Room generateRoom() {
        // TODO: implement
        return null;
    }

}
