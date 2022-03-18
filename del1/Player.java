package del1;

import java.util.ArrayList;

public class Player {
  private Room currentRoom;
  private char playerDirection;
  private ArrayList<Item> itemsPlayerCarry = new ArrayList<>();



  void pickUpItem(UserInterface ui) {
    ui.pickItemUp();
    if (getCurrentRoom().getItemsInRoom().size() > 0) {

        if (getCurrentRoom().getItemsInRoom().size() == 1) {
          newItemList(0);
          //printer at spilleren har samlet item op

      } else {
          //printer ud fra UI om spillern har lyst til at samle noget op
          String input = ui.returnsUserInput();

          for (int i = 0; i < currentRoom.getItemsInRoom().size(); i++) {
            String shortItemName = currentRoom.getItemsInRoom().get(i).getItemNameShort();
            if (input.toLowerCase().equals(shortItemName)) {
              newItemList(i);
              //printer at spilleren har samlet items op
            }

          }
        }
    } else {
      ui.emptyRoom();
    }
  }

  void newItemList(int num){
    itemsPlayerCarry.add(currentRoom.getItemsInRoom().get(num));
    currentRoom.getItemsInRoom().remove(currentRoom.getItemsInRoom().get(num));
  }




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
  public ArrayList<Item> getItemsPlayerCarry (){
    return itemsPlayerCarry;
  }

}
