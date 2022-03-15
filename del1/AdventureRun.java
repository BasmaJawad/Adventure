package del1;

import java.util.Locale;
import java.util.Scanner;

public class AdventureRun {
  private boolean playAgain;
  Adventure A = new Adventure();
  RoomDescriptions D = new RoomDescriptions();

  public static void main(String[] args) {
    new del1.AdventureRun().go();
  }

  void go() { //Create 9 new rooms with a name and description
    Room room1 = new Room("Room One", D.room1());
    Room room2 = new Room("Room Two", D.room2());
    Room room3 = new Room("Room Three", D.room3());
    Room room4 = new Room("Room Four", D.room4());
    Room room5 = new Room("Room Five", D.room5());
    Room room6 = new Room("Room Six", D.room6());
    Room room7 = new Room("Room Seven", D.room7());
    Room room8 = new Room("Room Eight", D.room8());
    Room room9 = new Room("Room nine", D.room9());

    //             north, south, west, east
    room1.setRooms(null, room4, null, room2);
    room2.setRooms(null, null, room1, room3);
    room3.setRooms(null, room6, room2, null);
    room4.setRooms(room1, room7, null, null);
    room5.setRooms(null, room8, null, null);
    room6.setRooms(room3, room9, null, null);
    room7.setRooms(room4, null, null, room8);
    room8.setRooms(room5, null, room7, room9);
    room9.setRooms(room6, null, room8, null);

    do {
      A.setWinnerRoom(room5);
      A.setPlayerWon(false);
      A.setCurrentRoom(room1);
      printIntroduction();
      A.userAction();
      changePlayAgain();
    } while (playAgain);
  }

  void changePlayAgain() {
    Scanner in = new Scanner(System.in);
    String input;
    System.out.print("Do you wish to play again, type 'no' or 'yes': ");
    input = in.nextLine();
    switch(input.toLowerCase()) {
      case "yes", "y":
        playAgain = true;
        break;
      case "no", "n":
        playAgain = false;
        break;
      default:
        changePlayAgain();
    }
    System.out.println();
  }

  void printIntroduction() {
    System.out.println("Welcome to 'game missing name'.\n" +
        "You need to get/do 'missing winning scenario'.\n" +
        "Type a direction North, South, West or East.\n" +
        "Type 'Look around' to get a description of the room.\n" +
        "Type 'Help' to get the controls of the game.\n" +
        "Type 'Exit' to end the game.\n" +
        "Current room is: " + A.getCurrentRoom().getName() + ".\n");
  }
}
