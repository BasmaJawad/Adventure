package del1;
import java.util.ArrayList;

import static java.lang.Runtime.getRuntime;

public class TheGame {
  private Room winnerRoom; //Rykkes til Map class
  private Room startRoom; //Rykkes til Map class

  private boolean playerWon;

  private final Player player = new Player();
  private final Map map = new Map();
  private final UserInterface userInterface = new UserInterface();


  void createGame(){
    playerWon = false;
    map.createRooms();
    setWinnerRoom(map.getRoom(5));
    setStartRoom(map.getRoom(1));
    player.setCurrentRoom(startRoom);
    map.addItemsToRoomsAtFirst();   //adder items til rooms
    userInterface.printIntroduction(player.getCurrentRoom());
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
          //pickUpItem();
        case "help", "h":
          userInterface.printCommand();
          break;
        case "exit", "ex","0":
          exitFunction();
        default:
          userAction();
      }
      playerWon();
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
      case 'W':
        userInterface.direction("west", player.getCurrentRoom());
        break;
      case 'E':
        userInterface.direction("east", player.getCurrentRoom());
        break;
      case 'S':
        userInterface.direction("south", player.getCurrentRoom());
        break;
      case 'N':
        userInterface.direction("north", player.getCurrentRoom());
        break;
    }
  }

  public void playerWon() {
    if (player.getCurrentRoom() == getWinnerRoom()) {
      userInterface.winnerOutput();
      playerWon = true;
    }
  }

  //Setters og Getters
  public void setWinnerRoom(Room winnerRoom) {
    this.winnerRoom = winnerRoom;
  }

  public Room getWinnerRoom() {
    return winnerRoom;
  }

  public void setStartRoom(Room startRoom) {
    this.startRoom = startRoom;
  }

  public UserInterface getUserInterface(){
    return userInterface;
  }

  void exitFunction(){
    getRuntime().halt(0);
  }
}
