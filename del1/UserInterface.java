package del1;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Scanner in = new Scanner(System.in);

    String returnsUserInput() {
        return in.nextLine();
    }

    void printIntroduction(Room currentRoom) {
        System.out.println("""
                Welcome to 'game missing name'.
                You need to get/do 'missing winning scenario'.
                Type a direction North, South, West or East.
                Type 'Look around' to get a description of the room.
                Type 'Grab' to collect items in a room.
                Type 'Inventory' to see the items you have.
                Type 'Help' to get the controls of the game.
                Type 'Exit' to end the game.
                Current room is:""" + " " + currentRoom.getName());
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

    void typeDirectionOrLookAround(){
        System.out.print("\nType direction or look around: ");
    }

    void lookAround(Room currentRoom){
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

    void askPickUpItem(){
        System.out.print("Which item do you want to pick up? ");
    }

    void lastItemPickedUp(ArrayList<Item> itemsPlayerCarry) {
        System.out.print("The user has picked up ");
        System.out.print(itemsPlayerCarry.get(itemsPlayerCarry.size() - 1).getItemNameShort() + ".\n");
    }

    void emptyRoom(){
        System.out.println("No items in the room to be picked up.");
    }


    void printInventory(Player player){
        int playerInvSize = player.getItemsPlayerCarry().size();

        if (playerInvSize > 0){
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


    void direction (String direction, Room currentRoom){
        System.out.println("The user went\033[1;97m " + direction + ".\033[0m");
        System.out.println("You have entered: " + currentRoom.getName() + ".");
    }
    void wrongDirection (){
        System.out.println("Not possible to move that direction, try again.");
    }
    void winnerOutput(){
        System.out.println("The player has won!\n");
    }
    void playAgain(){
        System.out.print("Do you wish to play again, type 'no' or 'yes': ");
    }


}
