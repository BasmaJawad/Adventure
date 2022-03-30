package del1;

import java.util.ArrayList;
import java.util.Random;

public class NPC {
  private Room npcCurrentRoom;
  private boolean wantsSpecifikItem = false;
  private Item wantedItem;
  private ArrayList<Item> npcInventory = new ArrayList<>();
  private ArrayList<Room> allRoomsInAMap;
  private final Random random = new Random();
  private String npcName;
  private int npcDamage;


  public NPC (ArrayList<Room> allRoomsInAMap, Item wantedItemClass, Item winnerItem) {
    npcName = "an old man";
    this.allRoomsInAMap = allRoomsInAMap;
    this.wantedItem = wantedItemClass;
    wantsSpecifikItem = true;
    Room npcStartRoom = getRandomRoom(allRoomsInAMap);
    Room mapStartRoom = allRoomsInAMap.get(0);
    while (npcStartRoom == mapStartRoom) {
      npcStartRoom = getRandomRoom(allRoomsInAMap);
    }
    npcCurrentRoom = npcStartRoom;
    npcInventory.add(winnerItem);
  }


  public NPC (ArrayList<Room> allRoomsInAMap, String npcName) {
    this.npcName = "\033[0;31m" + npcName + "\033[0m";
    this.allRoomsInAMap = allRoomsInAMap;
    npcCurrentRoom = getRandomRoom(allRoomsInAMap);
    npcDamage = 5;
  }




  public void respawnNPC (Room playerCurrentRoom, NPC anNpc, ArrayList<NPC> allMonstersInMap) {
    if(!npcName.equals("a rat")) {
      Room pastRoom = npcCurrentRoom;
      setNpcCurrentRoom(getRandomRoom(allRoomsInAMap));
      while (pastRoom == npcCurrentRoom) {
        setNpcCurrentRoom(getRandomRoom(allRoomsInAMap));
      }
    } else {
      if (npcCurrentRoom == playerCurrentRoom) {
        allMonstersInMap.remove(anNpc);
      }
      }

    }



  public void picksWantedItem () {
    ArrayList<Item> roomInventory = npcCurrentRoom.getItemsInRoom();
    int numOfItems = roomInventory.size();
    if (wantsSpecifikItem && numOfItems > 0) {
      boolean foundWantedItem = false;
      for (int i = numOfItems - 1; i >= 0; i--) {
        Item roomItem = roomInventory.get(i);
        if (roomItem == wantedItem) {
          npcInventory.add(roomItem);
          npcCurrentRoom.getItemsInRoom().remove(roomItem);
          foundWantedItem = true;
          wantsSpecifikItem = false;
        }
      }
      if (foundWantedItem) {
        dropWinnerItem();
      }
    }
  }

  public void dropWinnerItem() {
    if (npcInventory.size() > 0) {
      for (int i = npcInventory.size() - 1; i >= 0; i--) {
        Item npcItem = npcInventory.get(i);
        if (npcItem != wantedItem) {
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

  public boolean isWantsSpecifikItem () {
    return wantsSpecifikItem;
  }

  public void setNpcCurrentRoom (Room npcCurrentRoom) {
    this.npcCurrentRoom = npcCurrentRoom;
  }
  public Room getNpcCurrentRoom () {
    return npcCurrentRoom;
  }

  public void setNpcDamage (int npcDamage) {
    this.npcDamage = npcDamage;
  }

  public int getNpcDamage () {
    return npcDamage;
  }

}
