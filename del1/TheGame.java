package del1;

import java.util.Scanner;

import static java.lang.Runtime.getRuntime;

public class TheGame {
  private Room winnerRoom;
  private Room currentRoom;
  private char direction;
  private boolean playerWon;
  Scanner in = new Scanner(System.in);
  private UserInterface userInterface = new UserInterface();

  public UserInterface getUserInterface(){
    return userInterface;
  }

  //Bruger handling
  void userAction() {

    while(playerWon == false) {
      String input;
      userInterface.typeDirectionOrLookAround();
      input = in.nextLine();

      switch (input.toLowerCase()) {
        case "west", "go west", "w":
          setDirection('W');
          moveRoom();
          break;
        case "east", "go east", "e":
          setDirection('E');
          moveRoom();
          break;
        case "south", "go south", "s":
          setDirection('S');
          moveRoom();
          break;
        case "north", "go north", "n":
          setDirection('N');
          moveRoom();
          break;
        case "look", "look around", "l":
          userInterface.lookAround(currentRoom);
          break;
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
    if(currentRoom.getRooms(direction) == null) {
      userInterface.wrongDirection();
    } else {
      setCurrentRoom(currentRoom.getRooms(direction));
      directionMoved();
    }
  }

  void directionMoved() {
    switch (direction) {
      case 'W':
        userInterface.direction("west", currentRoom);
        break;
      case 'E':
        userInterface.direction("east", currentRoom);
        break;
      case 'S':
        userInterface.direction("south", currentRoom);
        break;
      case 'N':
        userInterface.direction("north", currentRoom);
        break;
    }
  }

  public void playerWon() {
    if (currentRoom == getWinnerRoom()) {
      userInterface.winnerOutput();
      playerWon = true;
    }
  }

  //Retning
  public void setDirection(char direction) {
    this.direction = direction;
  }

  public char getDirection() {
    return direction;
  }

  public void setPlayerWon(boolean playerWon) {
    this.playerWon = playerWon;
  }

  public void setWinnerRoom(Room winnerRoom) {
    this.winnerRoom = winnerRoom;
  }

  public Room getWinnerRoom() {
    return winnerRoom;
  }

  //Nuværende rum
  public void setCurrentRoom(Room currentRoom) {
    this.currentRoom = currentRoom;
  }

  public Room getCurrentRoom() {
    return currentRoom;
  }


  void exitFunction(){
    getRuntime().halt(0);
  }
}
