package del1;

import java.util.Scanner;

import static java.lang.Runtime.getRuntime;

public class Adventure {
  Room currentRoom;
  char direction;
  Scanner in = new Scanner(System.in);


  public static void main(String[] args) {
    new Adventure().go();
  }

  void go() {

    Room room1 = new Room("Room One", "This room 1");
    Room room2 = new Room("Room Two", "This room 2");
    Room room3 = new Room("Room Three", "This room 3");
    Room room4 = new Room("Room Four", "This room 4");
    Room room5 = new Room("Room Five", "This room 5");
    Room room6 = new Room("Room Six", "This room 6");
    Room room7 = new Room("Room Seven", "This room 7");
    Room room8 = new Room("Room Eight", "This room 8");
    Room room9 = new Room("Room nine", "This room 9");

    room1.setRooms(null, room4, null, room2);
    room2.setRooms(null, null, room1, room3);
    room3.setRooms(null, room6, room2, null);
    room4.setRooms(room1, room7, null, null);
    room5.setRooms(null, room8, null, null);
    room6.setRooms(room3, room9, null, null);
    room7.setRooms(room4, null, null, room8);
    room8.setRooms(room5, null, room7, room9);
    room9.setRooms(room6, null, room8, null);

    setCurrentRoom(room1);

    typeDirection();
  }

  public void setDirection(char direction) {
    this.direction = direction;
  }

  public char getDirection() {
    return direction;
  }

  public void setCurrentRoom(Room currentRoom) {
    this.currentRoom = currentRoom;
  }

  public Room getCurrentRoom() {
    return currentRoom;
  }

  void typeDirection() {
    String input;
    System.out.print("Type direction or look around: ");
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
      case "look", "look around":
        System.out.println("The user looked around and saw: " + getCurrentRoom().getRoomDescription());
        break;
      case "exit":
        exitFunction();
      default:
        typeDirection();
    }
    typeDirection();
  }

  void userOutput() {
    switch (getDirection()) {
      case 'W':
        System.out.println("The user went west.");
        break;
      case 'E':
        System.out.println("The user went east.");
        break;
      case 'S':
        System.out.println("The user went south.");
        break;
      case 'N':
        System.out.println("The user went north.");
        break;
    }
  }

  public void moveRoom() {
    if(getCurrentRoom().getRooms(direction) == null) {
      System.out.println("Not possible to move that direction, try again.");
    } else {
      setCurrentRoom(getCurrentRoom().getRooms(direction));
      userOutput();
    }
  }

  void exitFunction(){
    getRuntime().halt(0);
  }
}
