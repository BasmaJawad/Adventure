package del1;

import java.util.ArrayList;
import java.util.List;

public class Map {


    private final RoomDescriptions roomDescriptions = new RoomDescriptions();


    private final Room room1 = new Room("Room One", roomDescriptions.room1);
    private final Room room2 = new Room("Room Two", roomDescriptions.room2);
    private final Room room3 = new Room("Room Three", roomDescriptions.room3);
    private final Room room4 = new Room("Room Four", roomDescriptions.room4);
    private final Room room5 = new Room("Room Five", roomDescriptions.room5);
    private final Room room6 = new Room("Room Six", roomDescriptions.room6);
    private final Room room7 = new Room("Room Seven", roomDescriptions.room7);
    private final Room room8 = new Room("Room Eight", roomDescriptions.room8);
    private final Room room9 = new Room("Room nine", roomDescriptions.room9);

    private final Room[] roomArray = {room1, room2, room3, room4, room5, room6, room7, room8, room9};
    private final ArrayList<Room> roomArrayList = new ArrayList<>(List.of(roomArray));

    private final Item healingPotion1 = new Item("healing potion", "magic healing potion 1");
    private final Item healingPotion2 = new Item("healing potion", "magic healing potion 2");
    private final Item healingPotion3 = new Item("healing potion", "magic healing potion 3");
    private final Item healingPotion4 = new Item("healing potion", "magic healing potion 4");

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


    public Room getRoom(int i) {
        return roomArrayList.get(i - 1);
    }

    void addItemsToRoomsAtFirst(){ //sætter items i et Item arrayList
        room5.setItemsInRoom(healingPotion1);
        room5.setItemsInRoom(healingPotion2);
        room5.setItemsInRoom(healingPotion3);
        room5.setItemsInRoom(healingPotion4);
    }


}
