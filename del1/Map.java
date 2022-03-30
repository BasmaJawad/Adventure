package del1;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private final RoomDescriptions roomDescriptions = new RoomDescriptions();

    private final Room room1 = new Room("an underground basement", roomDescriptions.room1);
    private final Room room2 = new Room("an empty room", roomDescriptions.room2);
    private final Room room3 = new Room("a huge laboratorie", roomDescriptions.room3);
    private final Room room4 = new Room("a big factory room", roomDescriptions.room4);
    private final Room room5 = new Room("a control room for monitoring", roomDescriptions.room5);
    private final Room room6 = new Room("a long hallway", roomDescriptions.room6);
    private final Room room7 = new Room("a cafeteria", roomDescriptions.room7);
    private final Room room8 = new Room("a locker room", roomDescriptions.room8);
    private final Room room9 = new Room("an office", roomDescriptions.room9);

    private final Room[] roomArray = {room1, room2, room3, room4, room5, room6, room7, room8, room9};
    private final ArrayList<Room> roomArrayList = new ArrayList<>(List.of(roomArray));


    private final Food food1 = new Food("Chocolate", "Chocolate bar",5);
    private final Food food2 = new Food("Black syringe", "black syringe with liquid",-15);
    private final Food food3 = new Food("Purple syringe", "Purple syringe with liquid",15);
    private final Food food4 = new Food("Potion", "Mystery potion",10);
    private final Food food5 = new Food("Bread","Moldy bread",-5);
    private final Food food6 = new Food("Beans","Canned beans",7);
    private final Food food7 = new Food("Water", "Bottle of water",6);

    private final MeleeWeapon mWeapon1 = new MeleeWeapon("Knife", "Sharp knife");
    private final MeleeWeapon mWeapon2 = new MeleeWeapon("Pipe","Metal Pipe");
    private final MeleeWeapon mWeapon3 = new MeleeWeapon("Ladle", "Wooden ladle");

    private final RangedWeapon rWeapon1 = new RangedWeapon("Glass","Glass shard",2);
    private final RangedWeapon rWeapon2 = new RangedWeapon("Matches","Box of matches",3);
    private final RangedWeapon rWeapon3 = new RangedWeapon("Deodorant","Strong deodorant",5);

    private final Item npcWantedItem = new Item("Box", "box labeled 'Margaret's dentures'");
    private final Item winnerItem = new Item("Key", "Big green key");

    private final NPC oldMan = new NPC(roomArrayList, npcWantedItem, winnerItem);

    private final NPC rat1 = new NPC(roomArrayList, "A big evil-looking rat");
    private final NPC rat2 = new NPC(roomArrayList, "A brown hairless rat");
    private final NPC[] monsters = {rat1, rat2};
    private final ArrayList<NPC> allMonstersInMap = new ArrayList<>(List.of(monsters));


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

    void addItemsToRooms(){ //sætter items i et Item arrayList

        room1.setItemsInRoom(mWeapon1);
        room1.setItemsInRoom(food1);

        room3.setItemsInRoom(food2);
        room3.setItemsInRoom(food3);
        room3.setItemsInRoom(food4);
        room3.setItemsInRoom(rWeapon1);

        room4.setItemsInRoom(mWeapon2);
        room5.setItemsInRoom(rWeapon2);

        room7.setItemsInRoom(food5);
        room7.setItemsInRoom(food6);
        room7.setItemsInRoom(food7);
        room7.setItemsInRoom(mWeapon3);

        room8.setItemsInRoom(rWeapon3);
        room8.setItemsInRoom(npcWantedItem);

    }

    public Room getRoom(int i) {
        return roomArrayList.get(i);
    }

    public Item getWinnerItem () {
        return winnerItem;
    }

    public NPC getOldMan () {
        return oldMan;
    }


    void clearRoomsInventory (){
        for (int i=0; i<roomArrayList.size(); i++){
            Room eachRoom = roomArrayList.get(i);
            eachRoom.clearRoomInventory();
        }
    }

    public ArrayList<NPC> getAllMonstersInMap() {
        return allMonstersInMap;
    }
}