package del1;

import java.util.ArrayList;

public class Player {
  private Room currentRoom;
  private char playerDirection;
  private ArrayList<Item> itemsPlayerCarry = new ArrayList<>();

  public void setCurrentRoom(Room currentRoom) {
    this.currentRoom = currentRoom;
  }

  public Room getCurrentRoom() {
    return currentRoom;
  }

  public void setDirection(char playerDirection) {
    this.playerDirection = playerDirection;
  }

  public char getDirection() {
    return playerDirection;
  }

  public void setItemPlayerCarry(Item item){
    itemsPlayerCarry.add(item);
  }
  public void removeItemPlayerCarry(Item item){
    itemsPlayerCarry.remove(item);
  }
  public ArrayList getItemsPlayerCarry (){
    return itemsPlayerCarry;
  }

}
