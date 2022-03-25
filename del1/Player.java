package del1;

import java.util.ArrayList;

public class Player {
  private UserInterface UI;
  private Room currentRoom;
  private ArrayList<Item> itemsPlayerCarry = new ArrayList<>();
  private char playerDirection;


  public Player(UserInterface UI) {
    this.UI = UI;
  }

  void pickOrDropItem(boolean isPicked) {
    ArrayList<Item> inventoryWeTakeFrom = getPlayerOrRoomItemList(isPicked);
    ArrayList<Item> inventoryWeAddToo = getPlayerOrRoomItemList(!isPicked);
    int itemCount = inventoryWeTakeFrom.size();
    if (itemCount > 0) {
      userChangesItemList(inventoryWeTakeFrom, inventoryWeAddToo, isPicked);
    } else {
      UI.emptyInventory(isPicked);
    }
  }

  public ArrayList<Item> getPlayerOrRoomItemList(boolean isPicked) {
    if(isPicked) {
      return currentRoom.getItemsInRoom();
    } else {
      return itemsPlayerCarry;
    }
  }

  public void userChangesItemList(ArrayList<Item> inventoryWeTakeFrom, ArrayList<Item> inventoryWeAddToo, boolean isPicked) {
    if (inventoryWeTakeFrom.size() == 1) {
     // String itemShortName = inventoryWeTakeFrom.get(0).getItemNameShort();
      String longItemName = inventoryWeTakeFrom.get(0).getItemNameLong();
      UI.itemPickedOrDropped(longItemName, isPicked);
      addAndRemoveItemFromInventory(0, isPicked);

    } else {
      UI.askPickOrDropItem(isPicked);
      String input = UI.returnsUserInput().toLowerCase();
      if (input.equals("all")) {
        UI.allWasPickedOrDropped(isPicked);
        takeOrDropAllItems(inventoryWeTakeFrom, inventoryWeAddToo);
      } else {
        for (int i = inventoryWeTakeFrom.size() - 1; i >= 0; i--) {
          String shortItemName = inventoryWeTakeFrom.get(i).getItemNameShort().toLowerCase();
          String longItemName = inventoryWeTakeFrom.get(i).getItemNameLong().toLowerCase();
          if (input.equals(shortItemName) || input.equals(longItemName)) {
            UI.itemPickedOrDropped(longItemName, isPicked); //printer item dropped/picket
            addAndRemoveItemFromInventory(i, isPicked);
            i = -1;
          }
        }
      }
    }
  }


  public void addAndRemoveItemFromInventory(int indexOfItem, boolean isPicked) {
    if(isPicked) {
      moveItemToPlayerFromRoom(indexOfItem);
    } else {
      moveItemToRoomFromPlayer(indexOfItem);
    }
  }

  void moveItemToPlayerFromRoom(int indexOfWantedItem){
    Item wantedItem = currentRoom.getItemsInRoom().get(indexOfWantedItem); //Item der bliver fjernet fra currentRoom og tilført til itemsPlayerCarry
    addItemPlayerCarry(wantedItem); //Adder en Item fra currentRoom Item liste ud efter et index til spillerens inventory
    currentRoom.getItemsInRoom().remove(wantedItem); //Fjerner den selv samme item fra currentRoom Item liste
  }

  void moveItemToRoomFromPlayer(int indexOfDroppedItem){
    Item droppedItem = itemsPlayerCarry.get(indexOfDroppedItem); //Item der bliver fjernet fra spillerens inventory og tilført til currentRoom
    currentRoom.getItemsInRoom().add(droppedItem); //Adder en Item til currentRoom fra spillerens inventory
    removeItemPlayerCarry(droppedItem); //Fjerner den selv samme item fra players inventory
  }



  void takeOrDropAllItems(ArrayList<Item> inventoryWeTakeFrom, ArrayList<Item> inventoryWeAddToo){
    for (int i = inventoryWeTakeFrom.size() - 1; i >= 0; i--) {
      inventoryWeAddToo.add(inventoryWeTakeFrom.get(i));
      inventoryWeTakeFrom.remove(i);
    }
  }


  /*
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

   */




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