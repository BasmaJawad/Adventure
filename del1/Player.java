package del1;

import java.util.ArrayList;

public class Player {
  private Room currentRoom;
  private ArrayList<Item> itemsPlayerCarry = new ArrayList<>();
  private char playerDirection;

  void pickUpItem(UserInterface userInterface) {
    int itemAmountInRoom = currentRoom.getItemsInRoom().size();
    if (itemAmountInRoom > 0) {
        if (itemAmountInRoom == 1) {
          moveItemToPlayerFromRoom(0);
          userInterface.itemPickedOrDropped(itemsPlayerCarry, true);
      } else {
          userInterface.askPickOrDropItem(true);
          String input = userInterface.returnsUserInput();

          if(input.toLowerCase().equals("all")) {
            takeAllItemsFromInventory(userInterface, itemAmountInRoom);
          } else {
            searchForSpecificItemInInventory(userInterface, itemAmountInRoom, input);
          }
        }
    } else {
      userInterface.emptyInventory(true);
    }
  }

  void takeAllItemsFromInventory (UserInterface userInterface, int itemAmountInRoom){
    for (int i = 0; i < itemAmountInRoom; i++) {
      moveItemToPlayerFromRoom(0); //indexOfDroppedItem er 0 fordi hver gang der fjernes en, rykkes næste item på nulte plads
    }
    userInterface.allWasPickedOrDropped(true);
  }

  void searchForSpecificItemInInventory(UserInterface userInterface, int itemAmountInRoom, String input){
    for (int i = itemAmountInRoom - 1; i >= 0; i--) {
      String shortItemName = currentRoom.getItemsInRoom().get(i).getItemNameShort();
      if (input.toLowerCase().equals(shortItemName)) {
        moveItemToPlayerFromRoom(i);
        userInterface.itemPickedOrDropped(itemsPlayerCarry, true);
        i = -1;
      }
    }
  }
  
  void dropItem (UserInterface userInterface) {
    int itemAmountPlayerHave = itemsPlayerCarry.size();
    if (itemAmountPlayerHave > 0) {
      if (itemAmountPlayerHave == 1) {
        moveItemToRoomFromPlayer(0);
        userInterface.itemPickedOrDropped(currentRoom.getItemsInRoom(), false);
      } else {
        userInterface.askPickOrDropItem(false);
        String input = userInterface.returnsUserInput();
        if (input.toLowerCase().equals("all")) {
          for (int i = 0; i < itemAmountPlayerHave; i++) {
            moveItemToRoomFromPlayer(0); //indexOfDroppedItem er 0 fordi hver gang der fjernes en, rykkes næste item på nulte plads
          }
          userInterface.allWasPickedOrDropped(false);
        } else {
          for (int i = itemAmountPlayerHave - 1; i >= 0; i--) {
            String shortItemName = itemsPlayerCarry.get(i).getItemNameShort();
            if (input.toLowerCase().equals(shortItemName)) {
              moveItemToRoomFromPlayer(i);
              userInterface.itemPickedOrDropped(currentRoom.getItemsInRoom(), false);
              i = -1; //bryder ud af for-loopet efter det ønskede item er fundet
            }
          }
        }
      }
    } else
      userInterface.emptyInventory(false);
  }

  void moveItemToPlayerFromRoom(int indexOfWantedItem){
    Item wantedItem = currentRoom.getItemsInRoom().get(indexOfWantedItem); //Item der bliver fjernet fra currentRoom og tilført til itemsPlayerCarry
    itemsPlayerCarry.add(wantedItem); //Adder en Item fra currentRoom Item liste ud efter et index til spillerens inventory
    currentRoom.getItemsInRoom().remove(wantedItem); //Fjerner den selv samme item fra currentRoom Item liste
  }

  void moveItemToRoomFromPlayer(int indexOfDroppedItem){
    Item droppedItem = itemsPlayerCarry.get(indexOfDroppedItem); //Item der bliver fjernet fra spillerens inventory og tilført til currentRoom
    currentRoom.getItemsInRoom().add(droppedItem); //Adder en Item til currentRoom fra spillerens inventory
    itemsPlayerCarry.remove(droppedItem); //Fjerner den selv samme item fra players inventory
  }

  public void addItemPlayerCarry(Item item){
    itemsPlayerCarry.add(item);
  }

  public void removeItemPlayerCarry(Item item){
    itemsPlayerCarry.remove(item);
  }

  public void clearPlayerInventory (){
    itemsPlayerCarry.clear();
  }

  // Setters og Getters

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

  public ArrayList<Item> getItemsPlayerCarry (){
    return itemsPlayerCarry;
  }
}