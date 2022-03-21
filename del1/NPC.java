package del1;

import java.util.ArrayList;
import java.util.Random;

public class NPC {
  private int npcHealth, npcBaseDamage;
  private ArrayList<Item> npcInventory = new ArrayList<>();
  private String npcName;
  private Room npcCurrentRoom;
  private ArrayList<Room> allRoomsInAMap;


  public NPC (ArrayList<Room> allRoomsInAMap){
    setNpcHealth(10);
    setNpcBaseDamage(2);
    setNpcName("Random Thug");
    // Npc'en skal have et tilfældigt rum tildelt ud fra rummene som et Map holder

  }

  public NPC (int health, int damage, Item startItem, String name, Room startRoom) {
    npcHealth = health;
    npcBaseDamage = damage;
    npcInventory.add(startItem);
    npcName = name;
    npcCurrentRoom = startRoom;
  }

  // Skal få fat i et tilfældigt rum i den ArrayListe der holder rum i et Map
  /*
  public Room getRandomRoom (ArrayList allRoomsInAMap) {
    return
  }

   */


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
