package del1;

import java.util.Scanner;

import static java.lang.Runtime.getRuntime;

public class Adventure {
  private Room winnerRoom;
  private Room currentRoom;
  private char direction;
  private boolean playerWon;
  Scanner in = new Scanner(System.in);


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

  //Bruger handling
  void userAction() {

    while(playerWon == false) {
      String input;
      System.out.print("\nType direction or look around: ");
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
          System.out.println("You are standing in \033[1;97m" + getCurrentRoom().getName() + "\033[0m");
          System.out.println(getCurrentRoom().getRoomDescription() + ".");
          break;
        case "help", "h":
          printCommand();
          break;
        case "exit":
          exitFunction();
        default:
          userAction();
      }
      playerWon();
    }
  }

  void printCommand() {
    System.out.println("Game controls:\n" +
        "Move direction type 'North', 'South', 'West' or 'East'\n" +
        "Get information type 'Look' or 'Help'\n" +
        "To end game type 'Exit'");
  }

  void userOutput() {
    switch (direction) {
      case 'W':
        System.out.println("The user went\033[1;97m west.\033[0m");
        break;
      case 'E':
        System.out.println("The user went\033[1;97m east.\033[0m");
        break;
      case 'S':
        System.out.println("The user went\033[1;97m south.\033[0m");
        break;
      case 'N':
        System.out.println("The user went\033[1;97m north.\033[0m");
        break;
    }
    enteredRoom();
  }

  void enteredRoom(){
    System.out.println("You have entered: " + getCurrentRoom().getName() + ".");
  }

  public void moveRoom() {
    if(getCurrentRoom().getRooms(direction) == null) {
      System.out.println("Not possible to move that direction, try again.");
    } else {
      setCurrentRoom(getCurrentRoom().getRooms(direction));
      userOutput();
    }
  }

  public void playerWon() {
    if (getCurrentRoom() == getWinnerRoom()) {
      System.out.println("The player has won!");
      playerWon = true;
    }
  }

  void exitFunction(){
    getRuntime().halt(0);
  }
}
