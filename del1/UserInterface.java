package del1;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    String userName;
    Scanner in = new Scanner(System.in);


    String returnsUserInput() {
        return in.nextLine();
    }

    String userName(){
        System.out.print("TYPE YOUR NAME: ");
        userName = returnsUserInput();
        return userName;
    }


    void printIntroduction(Room currentRoom) {
        System.out.print("""
                  \033[1;97m                                                                               \s
                 _____ ____  _____ _____ _____ _____ _____ _____ _____    _____ _____ _____ _____\s
                |  _  |    \\|  |  |   __|   | |_   _|  |  | __  |   __|  |   __|  _  |     |   __|
                |     |  |  |  |  |   __| | | | | | |  |  |    -|   __|  |  |  |     | | | |   __|
                |__|__|____/ \\___/|_____|_|___| |_| |_____|__|__|_____|  |_____|__|__|_|_|_|_____|
                """);
        String name = userName();
        System.out.println("\nWelcome to Adventure Game, " + name +"!\033[0m\n");
        System.out.println("""
                You need to get/do 'missing winning scenario'.
                Type a direction \033[1;97mNorth, South, West or East\033[0m.
                Type \033[1;97m'Look around' \033[0m to get a description of the room.
                Type \033[1;97m'Grab' \033[0mto collect items in a room.
                Type \033[1;97m'Inventory' \033[0mto see the items you have.
                Type \033[1;97m'Help' \033[0mto get the controls of the game.
                Type \033[1;97m'Exit' \033[0mto end the game.
                You are Currently standing in:"""  + " \033[1;97m"+ currentRoom.getName()+"\033[0m");
    }


    void printCommand() {
        System.out.println("""
                \nGame controls:
                Move direction -> \033[1;97m'North', 'South', 'West' or 'East'\033[0m.
                Pick up item -> \033[1;97m'Grab' \033[0m(type 'All' to pick up all the items).
                Items in your inventory \033[1;97m'Inventory'\033[0m.
                Information about the room you are standing in -> \033[1;97m 'Look'\033[0m.
                List of commands -> \033[1;97m'Help'\033[0m.
                End game -> \033[1;97m'Exit'\033[0m.""");

        /*"""
                Game controls:
                Move direction type 'North', 'South', 'West' or 'East'.
                Pick up an item in a room type 'Grab' and 'the name' of the item or type 'All' to pick up all the items.
                To see the items in your inventory type 'Inventory'.
                Get information about the current room you are in type 'Look' or type 'Help' to get the commands.
                To end game type 'Exit'."""

         */
    }


    void typeDirectionOrLookAround() {
        System.out.print("\nType direction or look around: ");
    }


    void lookAround(Room currentRoom) {
        System.out.println("You are standing in \033[1;97m" + currentRoom.getName() + "\033[0m");
        System.out.println(currentRoom.getRoomDescription() + ".");

        //Viser items i room
        int amountOfItemsInRoom = currentRoom.getItemsInRoom().size(); //Antal items
        if (amountOfItemsInRoom > 0){
            System.out.print("Items in the room: " + currentRoom.getItemsInRoom().get(0).getItemNameLong());
            if (amountOfItemsInRoom > 1) {
                for (int i = 1; i < amountOfItemsInRoom; i++) {
                    String itemNameLong = currentRoom.getItemsInRoom().get(i).getItemNameLong(); //Finder alle lange navne for items
                    System.out.print(", " + itemNameLong);
                }
            }
            System.out.print(".\n");
        } else
            System.out.println("No items in " + currentRoom.getName() + ".");
    }


    void askPickOrDropItem(boolean isPicked) {
        if(isPicked){
            System.out.print("Which item do you want to pick up? ");
        } else
            System.out.print("Which item do you want to drop? ");

    }


    void itemPickedOrDropped(String itemShortName, boolean isPicked) {

        if (isPicked)
            System.out.print(userName+ " has picked up ");
         else
            System.out.print(userName+ " has dropped ");

        System.out.print(itemShortName + ".\n");
    }

    void allWasPickedOrDropped(boolean isPicked){
        if (isPicked)
            System.out.println(userName + " has picked up everything in the room");
         else
            System.out.println(userName + " dropped everything in the inventory");
    }
    
    void emptyInventory(boolean isPicked) {
        if (isPicked)
            System.out.println("No items in the room to be picked up.");
        else
            System.out.println("No items in your inventory to be dropped.");
    }


    void printInventory(Player player) {
        int playerInvSize = player.getItemsPlayerCarry().size();

        if (playerInvSize > 0) {
            System.out.print("You are carrying: " + player.getItemsPlayerCarry().get(0).getItemNameLong()); //Skiftede til long name
            if (playerInvSize > 1) {
                for (int i = 1; i < player.getItemsPlayerCarry().size(); i++) {
                    System.out.print(", " + player.getItemsPlayerCarry().get(i).getItemNameLong()); //Skiftede til long name
                }
            }
            System.out.print(".\n");
        } else
            System.out.println("Your inventory is empty.");
    }

    void direction (String direction, Room currentRoom) {
        System.out.println(userName + " went " + direction + ".");
        System.out.println("You have entered \033[1;97m" + currentRoom.getName() + ".\033[0m");
    }

    void wrongDirection () {
        System.out.println("Not possible to move that direction, try again.");
    }

    void winnerOutput() {
        System.out.println(userName + " has won the game!\n");
    }

    void playAgain() {
        System.out.print("Do you wish to play again, type 'no' or 'yes': ");
    }
}