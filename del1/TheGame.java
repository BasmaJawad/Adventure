package del1;

import static java.lang.Runtime.getRuntime;

public class TheGame {
  private final Map map = new Map();
  private final UserInterface userInterface = new UserInterface();
  private final Player player = new Player(userInterface);

  private Room winnerRoom;
  private Room startRoom;

  private boolean playerWon;

  void createGame(){
    map.createRoomsForMap1();
    winnerRoom = map.getRoom(4);
    startRoom = map.getRoom(0);
    map.addItemsToRoomsAtFirst();   //adder items til rooms
    player.resetPlayer(startRoom, true);
    userInterface.printIntroduction(player.getCurrentRoom());
  }

  void clearItemInventoriesForNewGame(){
    player.clearPlayerInventory();
    map.clearRoomsInventory();
  }

  //Bruger handling
  void userAction() {
    while(playerWon == false) {
      userInterface.typeDirectionOrLookAround();
      String input = userInterface.returnsUserInput();

      switch (input.toLowerCase()) {
        case "west", "go west", "w":
          player.setDirection('W');
          moveRoom();
          break;
        case "east", "go east", "e":
          player.setDirection('E');
          moveRoom();
          break;
        case "south", "go south", "s":
          player.setDirection('S');
          moveRoom();
          break;
        case "north", "go north", "n":
          player.setDirection('N');
          moveRoom();
          break;
        case "look", "look around", "l":
          userInterface.lookAround(player.getCurrentRoom());
          break;
        case "grab", "g", "pick":
          player.pickOrDropItem(true);  //isPicked = true
          break;
        case "drop", "d":
          player.pickOrDropItem(false);
          break;
        case "eat":
          player.eat();
          break;
        case "inventory","inv":
          userInterface.printInventory(player);
          break;
        case "equip", "eq":
          player.equipWeapon();
          break;
        case "attack", "att":
          player.playerAttack();
          break;
        case "health":
          userInterface.printHealth(player.getHealth());
          break;
        case "help", "h":
          userInterface.printCommand();
          break;
        case "unequip", "uneq":
          player.unEquipWeapon();
          break;
        case "exit", "ex","0":
          exitFunction();
      }
      //playerWon();
    }
  }

  public void moveRoom() {
    Room currentRoom = player.getCurrentRoom();
    if(currentRoom.getRooms(player.getDirection()) == null) {
      userInterface.wrongDirection();
    } else {
      player.setCurrentRoom(currentRoom.getRooms(player.getDirection()));
      directionMoved();
    }
  }

  void directionMoved() {
    switch (player.getDirection()) {
      case 'W' -> userInterface.direction("west", player.getCurrentRoom());
      case 'E' -> userInterface.direction("east", player.getCurrentRoom());
      case 'S' -> userInterface.direction("south", player.getCurrentRoom());
      case 'N' -> userInterface.direction("north", player.getCurrentRoom());
    }
  }

  public void playerWon() {
    int numOfItems = startRoom.getItemsInRoom().size();
    for (int i = 0; i < numOfItems; i++) {
      do {
        ItemType roomItemType = startRoom.getItemsInRoom().get(i).getItemType();
        if (roomItemType == ItemType.NONE) {
          userInterface.winnerOutput();
          playerWon = true;
        }
      } while (!playerWon);
    }

  }

  void exitFunction(){
    getRuntime().halt(0);
  }

  //Setters og Getters

  public UserInterface getUserInterface(){
    return userInterface;
  }

  public void setWinnerRoom(Room winnerRoom) {
    this.winnerRoom = winnerRoom;
  }
  public Room getWinnerRoom() {
    return winnerRoom;
  }

  public void setStartRoom(Room startRoom) {
    this.startRoom = startRoom;
  }
  public Room getStartRoom() {
    return startRoom;
  }
}
