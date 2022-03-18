package del1;

import java.util.ArrayList;

public class Player {
  private Room currentRoom;
  private char playerDirection;
  private ArrayList<Item> itemsPlayerCarry = new ArrayList<>();



  void pickUpItem(UserInterface userInterface) {
    int itemAmountInRoom = currentRoom.getItemsInRoom().size();
    if (itemAmountInRoom > 0) {
        if (itemAmountInRoom == 1) {
          moveItemToPlayerFromRoom(0);
          userInterface.lastItemPickedUp(itemsPlayerCarry);
      } else {
          userInterface.askPickUpItem();
          String input = userInterface.returnsUserInput();
          if(input.toLowerCase().equals("all")) {
            for (int i = 0; i < itemAmountInRoom; i++) {
              moveItemToPlayerFromRoom(0);
            }
          }
          else {
            for (int i = itemAmountInRoom - 1; i >= 0; i--) {
              String shortItemName = currentRoom.getItemsInRoom().get(i).getItemNameShort();
              if (input.toLowerCase().equals(shortItemName)) {
                moveItemToPlayerFromRoom(i);
                userInterface.lastItemPickedUp(itemsPlayerCarry);
                i = -1;
              }
              else
                System.out.println("Sorry, could not understand");
              break; //Skal ændres til anden metode der går ud af for-loopet
            }
          }
        }
    } else {
      userInterface.emptyRoom();
    }
  }

  void moveItemToPlayerFromRoom(int num){
    Item itemOnIndexNum = currentRoom.getItemsInRoom().get(num); //Item der bliver fjernet fra currentRoom og tilført til itemsPlayerCarry

    itemsPlayerCarry.add(itemOnIndexNum); //Adder en Item fra currentRoom Item liste ud efter et index til spillerens inventory
    currentRoom.getItemsInRoom().remove(itemOnIndexNum); //Fjerner den selv samme item fra currentRoom Item liste
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
