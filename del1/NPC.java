package del1;

import java.util.ArrayList;
import java.util.Random;

public class NPC {
  private Room npcCurrentRoom;
  private ArrayList<Item> npcInventory = new ArrayList<>();
  private ArrayList<Room> allRoomsInAMap;
  private Random random = new Random();
  private String npcName;
  private int npcHealth, npcBaseDamage;


  public NPC (ArrayList<Room> allRoomsInAMap){
    setNpcHealth(10);
    setNpcBaseDamage(2);
    setNpcName("Random Thug");
    this.allRoomsInAMap = allRoomsInAMap;
    // Npc'ens currentRoom sættes til et tilfældigt rum tildelt ud fra rummene som et Map holder
    setNpcCurrentRoom(getRandomRoom(allRoomsInAMap));
  }

  public NPC (int health, int damage, Item startItem, String name, Room startRoom) {
    npcHealth = health;
    npcBaseDamage = damage;
    npcInventory.add(startItem);
    npcName = name;
    npcCurrentRoom = startRoom;
  }

  // Skal få fat i et tilfældigt rum i den ArrayListe der holder rum i et Map

  public Room getRandomRoom (ArrayList<Room> allRoomsInAMap) {
    int roomAmount = allRoomsInAMap.size();
    int randomNum = random.nextInt(roomAmount);
    Room randomRoom = allRoomsInAMap.get(randomNum);
    return randomRoom;
  }




  // Getters og Setters
  public void setNpcHealth (int npcHealth) {
    this.npcHealth = npcHealth;
  }
  public int getNpcHealth () {
    return npcHealth;
  }

  public void setNpcBaseDamage (int npcBaseDamage) {
    this.npcBaseDamage = npcBaseDamage;
  }
  public int getNpcBaseDamage () {
    return npcBaseDamage;
  }

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
