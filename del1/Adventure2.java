package del1;
import java.util.Scanner;
import static java.lang.Runtime.getRuntime;

import java.util.Scanner;

import static java.lang.Runtime.getRuntime;

public class Adventure2 {

        private Room currentRoom;
        private char direction;
        Scanner in = new Scanner(System.in);

        //Retning
        public void setDirection(char direction) {
            this.direction = direction;
        }
        public char getDirection() {
            return direction;
        }

        //Nuværende rum
        public void setCurrentRoom(Room currentRoom) {
            this.currentRoom = currentRoom;
        }
        public Room getCurrentRoom() {
            return currentRoom;
        }

        void typeDirection() {
            String input;
            System.out.print("\nType direction or look around: ");
            input = in.nextLine();

            switch (input.toLowerCase()) {
                case "west", "go west", "w":
                    setDirection('W'); //nu får direction en ny værdi
                    break;
                case "east", "go east", "e":
                    setDirection('E');
                    break;
                case "south", "go south", "s":
                    setDirection('S');
                    break;
                case "north", "go north", "n":
                    setDirection('N');
                    break;

                case "look", "look around":
                    System.out.println("\nYou are standing in \033[1;97m"+ getCurrentRoom().getName()+"\033[0m");
                    System.out.println(getCurrentRoom().getRoomDescription());
                    typeDirection();
                    break;
                case "exit":
                    exitFunction();
                default:
                    typeDirection();
            }
            moveRoom(); //bruger den nye værdi for direction
            typeDirection();
        }

        public void moveRoom() {
            if(getCurrentRoom().getRooms(direction) == null) {
                System.out.println("Not possible to move that direction, try again.");
            } else {
                setCurrentRoom(getCurrentRoom().getRooms(direction));
                userOutput();
            }
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
            System.out.println("You have entered: " + getCurrentRoom().getName());
        }

        void exitFunction(){
            getRuntime().halt(0);
        }
    }

