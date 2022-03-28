package del1;

import java.util.ArrayList;
import java.util.Random;

public class NPC {
  private Room npcCurrentRoom;
  private boolean wantsSpecifikItemClass = false;
  private Item wantedItemClass;
  private ArrayList<Item> npcInventory = new ArrayList<>();
  private ArrayList<Room> allRoomsInAMap;
  private final Random random = new Random();
  private String npcName;


  public NPC (ArrayList<Room> allRoomsInAMap, Item wantedItemClass, Item winnerItem) {
    npcName = "an old man";
    this.allRoomsInAMap = allRoomsInAMap;
    this.wantedItemClass = wantedItemClass;
    wantsSpecifikItemClass = true;
    Room npcStartRoom = getRandomRoom(allRoomsInAMap);
    Room mapStartRoom = allRoomsInAMap.get(0);
    while (npcStartRoom == mapStartRoom) {
      npcStartRoom = getRandomRoom(allRoomsInAMap);
    }
    npcCurrentRoom = npcStartRoom;
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
    if (wantsSpecifikItemClass && numOfItems > 0) {
      boolean foundWantedItem = false;
      for (int i = numOfItems - 1; i >= 0; i--) {
        Item roomItem = roomInventory.get(i);
        if (roomItem.getClass() == wantedItemClass.getClass()) {
          npcInventory.add(roomItem);
          npcCurrentRoom.getItemsInRoom().remove(roomItem);
          foundWantedItem = true;
        }
      }
      if (foundWantedItem) {
        dropAllItemsButWantedTypes();
      }
    }
  }

  public void dropAllItemsButWantedTypes() {
    if (npcInventory.size() > 0) {
      for (int i = npcInventory.size() - 1; i >= 0; i--) {
        Item npcItem = npcInventory.get(i);
        if (npcItem.getClass() != wantedItemClass.getClass()) {
          npcCurrentRoom.getItemsInRoom().add(npcItem);
          npcInventory.remove(npcItem);
        }
      }
    }
  }

  // Skal få fat i et tilfældigt rum i den ArrayListe der holder rum i et Map

  public Room getRandomRoom (ArrayList<Room> allRoomsInAMap) {
    int roomAmount = allRoomsInAMap.size();
    int randomNum = random.nextInt(roomAmount);
    Room randomRoom = allRoomsInAMap.get(randomNum); //finder rum-indexet med et random tal
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

}
