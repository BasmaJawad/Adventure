package del1;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Scanner in = new Scanner(System.in);


    String returnsUserInput() {
        return in.nextLine();
    }

    void printIntroduction(Room currentRoom) {
        System.out.print("  \033[1;97m                                                                                \n" +
                " _____ ____  _____ _____ _____ _____ _____ _____ _____    _____ _____ _____ _____ \n" +
                "|  _  |    \\|  |  |   __|   | |_   _|  |  | __  |   __|  |   __|  _  |     |   __|\n" +
                "|     |  |  |  |  |   __| | | | | | |  |  |    -|   __|  |  |  |     | | | |   __|\n" +
                "|__|__|____/ \\___/|_____|_|___| |_| |_____|__|__|_____|  |_____|__|__|_|_|_|_____|\n"+
        "TYPE YOUR NAME: ");
        String name = in.nextLine();
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
                Game controls:
                Move direction type 'North', 'South', 'West' or 'East'.
                Pick up an item in a room type 'Grab' and 'the name' of the item or type 'All' to pick up all the items.
                To see the items in your inventory type 'Inventory'.
                Get information about the current room you are in type 'Look' or type 'Help' to get the commands.
                To end game type 'Exit'.""");
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
            System.out.print("There are these items in the room: " + currentRoom.getItemsInRoom().get(0).getItemNameLong());
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


    void itemPickedOrDropped(ArrayList<Item> roomOrPlayerInventory, boolean isPicked) {
        String itemShortName = roomOrPlayerInventory.get(roomOrPlayerInventory.size() - 1).getItemNameShort();

        if (isPicked == true) {
            System.out.print("The user has picked up ");
        } else {
            System.out.print("The user has dropped ");
        }
        System.out.print(itemShortName + ".\n");
    }

    void allWasPickedOrDropped(boolean isPicked){
        if (isPicked){
            System.out.println("The user has picked up everything in the room");
        } else
            System.out.println("The user has dropped everything in their inventory");
    }
    
    void emptyInventory(boolean isPicked) {
        if (isPicked)
            System.out.println("No items in the room to be picked up.");
        else
            System.out.println("No items in player's inventory to be dropped.");
    }


    void printInventory(Player player) {
        int playerInvSize = player.getItemsPlayerCarry().size();

        if (playerInvSize > 0) {
            System.out.print("The user is carrying " + player.getItemsPlayerCarry().get(0).getItemNameShort());
            if (playerInvSize > 1) {
                for (int i = 1; i < player.getItemsPlayerCarry().size(); i++) {
                    System.out.print(", " + player.getItemsPlayerCarry().get(i).getItemNameShort());
                }
            }
            System.out.print(".\n");
        } else
            System.out.println("Your inventory is empty.");
    }


    void direction (String direction, Room currentRoom) {
        System.out.println("The user went\033[1;97m " + direction + ".\033[0m");
        System.out.println("You have entered: " + currentRoom.getName() + ".");
    }


    void wrongDirection () {
        System.out.println("Not possible to move that direction, try again.");
    }


    void winnerOutput() {
        System.out.println("The player has won!\n");
    }


    void playAgain() {
        System.out.print("Do you wish to play again, type 'no' or 'yes': ");
    }
}