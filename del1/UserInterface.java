package del1;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    String userName;
    Scanner in = new Scanner(System.in);
    String blueColor = "\033[0;34m";
    String resetColor ="\033[0m";
    String greenColor = "\033[0;32m";
    String redColor = "\033[0;31m";
    String yellowColor ="\033[0;33m";


    String returnsUserInput() {
        return in.nextLine();
    }

    String userName() {
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
        System.out.println("\nWelcome to Adventure Game, " + name + "!\033[0m\n");
        System.out.println("""
                You are trapped within a factory and need to escape and not be eaten by rats.
                The only way out is through the green trapdoor using the green key.
                
                Type a direction \033[1;97mNorth, South, West or East\033[0m.
                Type \033[1;97m'Look around' \033[0m to get a description of the room.
                Type \033[1;97m'Grab' \033[0mto collect items in a room to your inventory.
                Type \033[1;97m'Drop' \033[0mto drop items in from your inventory to a room.
                Type \033[1;97m'Inventory' \033[0mto see the items you have and what weapon is equiped, if there is an equipped weapon.
                Type \033[1;97m'Health' \033[0mto check your healthpoints.
                Type \033[1;97m'Equip'/'Unequip'\033[0m to equip/unequip a weapon from your inventory.
                Type \033[1;97m'Eat'\033[0m to eat food from your inventory.
                Type \033[1;97m'Attack'\033[0m to attack a hostile creature with your equipped weapon.
                Type \033[1;97m'Help' \033[0mto get the controls of the game.
                Type \033[1;97m'Exit' \033[0mto end the game.
                
                You are Currently standing in""" + " \033[1;97m" + currentRoom.getName() + "\033[0m");
    }


    void printCommand() {
        System.out.println("""
                \n\033[1;97mGAME CONTROLS:\033[1;97m.
                Move direction -> \033[1;97m'North', 'South', 'West' or 'East'\033[1;97m.
                Information about the room you are standing in -> \033[1;97m 'Look'\033[0m.
                Pick up item -> \033[1;97m'Grab' \033[0m(type 'All' to pick up all the items in a room).
                Drop item -> \033[1;97m'Drop' \033[0m(type 'All' to drop up all the items in your inventory).
                Items in your inventory -> \033[1;97m'Inventory'\033[0m.
                Your healthpoints -> \033[1;97m'Health'\033[0m.
                Equip or unequip a weapon -> \033[1;97m'Equip/Unequip'\033[0m.
                Eat food within your inventory -> \033[1;97m'Eat'\033[0m.
                Attack a hostile enemy that's within the same room as you -> \033[1;97m'Attack'\033[0m.
                
                List of commands -> \033[1;97m'Help'\033[0m.
                End game -> \033[1;97m'Exit'\033[0m.""");
    }


    void userNextMove() {
        System.out.print("\nNext move: ");
    }


    void lookAround(Room currentRoom, NPC npc, ArrayList<NPC> allMonstersInMap) {
        Room npcCurrentRoom = npc.getNpcCurrentRoom();
        System.out.println("You are standing in \033[1;97m" + currentRoom.getName() + "\033[0m");
        System.out.println(currentRoom.getRoomDescription() + ".");
        if (currentRoom == npcCurrentRoom) {
            System.out.println(yellowColor+ "There is " + npc.getNpcName() + " in the room with you."+ resetColor);
            System.out.println("He mumbles something that sounds like 'my wife's dentures'");
        }
        for (int i = 0 ; i < allMonstersInMap.size(); i++) {
            NPC aMonster = allMonstersInMap.get(i);
            Room monsterCurrentRoom = aMonster.getNpcCurrentRoom();
            if (monsterCurrentRoom == currentRoom) {
                System.out.println(resetColor+aMonster.getNpcName() +" is running towards you"+resetColor);
            }
        }
        //Viser items i room
        int amountOfItemsInRoom = currentRoom.getItemsInRoom().size(); //Antal items
        if (amountOfItemsInRoom > 0) {
            System.out.print(greenColor + "Items in the room: " + currentRoom.getItemsInRoom().get(0).getItemNameLong());
            if (amountOfItemsInRoom > 1) {
                for (int i = 1; i < amountOfItemsInRoom; i++) {
                    String itemNameLong = currentRoom.getItemsInRoom().get(i).getItemNameLong(); //Finder alle lange navne for items
                    System.out.print(", " + itemNameLong);
                }
            }
            System.out.print(".\n"+resetColor);
        } else
            System.out.println("No items in " + currentRoom.getName() + ".");
    }


    void askPickOrDropItem(boolean isPicked) {
        if (isPicked) {
            System.out.print("Which item do you want to pick up? ");
        } else
            System.out.print("Which item do you want to drop? ");

    }


    void itemPickedOrDropped(String itemShortName, boolean isPicked) {
        System.out.print(blueColor);

        if (isPicked)
            System.out.print( userName + " has picked up ");
        else
            System.out.print(userName + " has dropped ");

        System.out.println(itemShortName + resetColor);
    }

    void allWasPickedOrDropped(boolean isPicked) {
        System.out.print(blueColor);

        if (isPicked)
            System.out.println(userName + " has picked up everything in the room.");
        else
            System.out.println(userName + " dropped everything in the inventory.");

        System.out.print(resetColor);
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
            System.out.print("You are carrying: "+greenColor);
            for (int i = 0; i < playerInvSize; i++) {
                if (player.getItemsPlayerCarry().get(i) == player.getEquippedWeapon())
                    System.out.print("[Equipped] ");

                System.out.print(player.getItemsPlayerCarry().get(i).getItemNameLong() + ", "); //Skiftede til long name
            }
        } else
            System.out.println("Your inventory is empty.");
        System.out.print(resetColor+"\n");
    }


    void printHealth(int health) {
        System.out.println("Health points: " + greenColor+health+resetColor);
    }

    void playerTookDamage (int damage, String npcName) {
        System.out.println(userName + " took " + damage + " damage from " + npcName + ".");
    }

    void doYouWantToEat() {
        System.out.print("What would you like to eat? ");
    }

    void itemEaten(String itemEaten) {
        System.out.println("You ate " + itemEaten);
    }

    void cannotBeEaten(String notEdibleItem) {
        System.out.println(notEdibleItem + " is not edible");
    }

    void youDontHaveThatItem() {
        System.out.println("You don't have that item");
    }

    void itemNotAWeapon(String notWeapon) {
        System.out.println(notWeapon + " is not a weapon");
    }

    void direction(String direction, Room currentRoom) {
        System.out.println(blueColor + userName + " went " + direction + "."+resetColor);
        System.out.println("You have entered \033[1;97m" + currentRoom.getName() + ".\033[0m");
    }

    void chooseEquipWeapon() {
        System.out.print("Choose weapon to equip: ");
    }

    void weaponNotFound() {
        System.out.println("No such weapon in your inventory.");
    }

    void attackedEnemy(){
        System.out.println(blueColor+userName + " has attacked enemy."+resetColor);
    }

    void attackNotPossible(){
        System.out.println("Not possible to attack, no weapons equipped");
    }


    void usesLeft(int weaponUses){
        System.out.println("Remaining uses of weapon: " + weaponUses);
    }
    void unEquip(String weaponUnequiped){
        System.out.println(weaponUnequiped + " unequiped.");
    }

    void weaponEquipped(String equippedWeapon) {
        System.out.println(blueColor+"Weapon equipped."+resetColor+" \nYou are holding " + equippedWeapon);
    }

    void ineffectualWeapon(){
        System.out.println(redColor+"Weapon ineffectual"+resetColor);
    }

    void wrongDirection() {
        System.out.println("Not possible to move that direction, try again.");
    }

    void winnerOutput() {
        System.out.println("\n\033[1;32m" + userName + " opened the green trapdoor and successfully escaped the factory! \n"+resetColor);
    }

    void loserOutput() {
        System.out.println("\n\033[1;31m" + userName + " was eaten by rats and now rests for all time within the factory. \n" + resetColor);
    }

    void playAgain() {
        System.out.print("\n \033[1;97mDo you wish to play again, type 'no' or 'yes': "+resetColor);
    }
}