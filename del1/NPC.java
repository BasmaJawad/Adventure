package del1;

import java.util.ArrayList;
import java.util.Random;

public class NPC {
  private Room npcCurrentRoom;
  private ItemType wantedItemType;
  private ArrayList<Item> npcInventory = new ArrayList<>();
  private ArrayList<Room> allRoomsInAMap;
  private final Random random = new Random();
  private String npcName;


  public NPC (ArrayList<Room> allRoomsInAMap, ItemType wantedItemType) {
    npcName = "an old man";
    this.allRoomsInAMap = allRoomsInAMap;
    this.wantedItemType = wantedItemType;
    Room npcStartRoom = getRandomRoom(allRoomsInAMap);
    Room mapStartRoom = allRoomsInAMap.get(0);
    while (npcStartRoom == mapStartRoom) {
      npcStartRoom = getRandomRoom(allRoomsInAMap);
    }
    Item winnerItem = new Item ("Holy Grail", "The Holy Grail");
    npcInventory.add(winnerItem);
  }


  public NPC (Item startItem, String name, Room startRoom) {
    npcInventory.add(startItem);
    npcName = name;
    npcCurrentRoom = startRoom;
  }


  public void picksWantedItem () {
    ArrayList<Item> roomInventory = npcCurrentRoom.getItemsInRoom();
    int numOfItems = roomInventory.size();
    boolean foundWantedItem = false;
    for (int i = 0; i < numOfItems; i++) {
      Item roomItem = roomInventory.get(i);
      ItemType roomItemType = roomItem.getItemType();
      if (roomItemType == wantedItemType) {
        npcInventory.add(roomItem);
      }
    }
    if (foundWantedItem) {
      dropAllItemsButWantedTypes();
    }
  }

  public void dropAllItemsButWantedTypes() {

    for (int i = 0; i < npcInventory.size(); i++) {
      Item npcItem = npcInventory.get(i);
      ItemType npcItemType = npcItem.getItemType();
      if (npcItemType != wantedItemType) {
        npcCurrentRoom.getItemsInRoom().add(npcItem);
        npcInventory.remove(npcItem);
      }
    }
  }

  // Skal få fat i et tilfældigt rum i den ArrayListe der holder rum i et Map

  public Room getRandomRoom (ArrayList<Room> allRoomsInAMap) {
    int roomAmount = allRoomsInAMap.size();
    int randomNum = random.nextInt(roomAmount);
    Room randomRoom = allRoomsInAMap.get(randomNum);
    return randomRoom;
  }




  // Getters og Setters


  public void setNpcName (String npcName) {
    this.npcName = npcName;
  }
  public String getNpcName () {
    return npcName;
  }

  public void setNpcCurrentRoom (Room npcCurrentRoom) {
    this.npcCurrentRoom = npcCurrentRoom;
  }
  public Room getNpcCurrentRoom () {
    return npcCurrentRoom;
  }

  public ItemType getWantedItemType () {
    return wantedItemType;
  }
}
