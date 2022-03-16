package del1;

import java.util.Scanner;

public class Map {
    private RoomDescriptions roomDescriptions = new RoomDescriptions();

    private Room room1 = new Room("Room One", roomDescriptions.room1);
    private Room room2 = new Room("Room Two", roomDescriptions.room2);
    private Room room3 = new Room("Room Three", roomDescriptions.room3);
    private Room room4 = new Room("Room Four", roomDescriptions.room4);
    private Room room5 = new Room("Room Five", roomDescriptions.room5);
    private Room room6 = new Room("Room Six", roomDescriptions.room6);
    private Room room7 = new Room("Room Seven", roomDescriptions.room7);
    private Room room8 = new Room("Room Eight", roomDescriptions.room8);
    private Room room9 = new Room("Room nine", roomDescriptions.room9);

    void createRooms() {
        //             north, south, west, east
        room1.setRooms(null, room4, null, room2);
        room2.setRooms(null, null, room1, room3);
        room3.setRooms(null, room6, room2, null);
        room4.setRooms(room1, room7, null, null);
        room5.setRooms(null, room8, null, null);
        room6.setRooms(room3, room9, null, null);
        room7.setRooms(room4, null, null, room8);
        room8.setRooms(room5, null, room7, room9);
        room9.setRooms(room6, null, room8, null);
    }

    public Room getRoom1(){
        return room1;
    }
    public Room getRoom2(){
        return room2;
    }
    public Room getRoom3(){
        return room3;
    }
    public Room getRoom4(){
        return room4;
    }
    public Room getRoom5(){
        return room5;
    }
    public Room getRoom6(){
        return room6;
    }
    public Room getRoom7(){
        return room7;
    }
    public Room getRoom8(){
        return room8;
    }
    public Room getRoom9(){
        return room9;
    }

}
