package del1;

import java.util.ArrayList;

public class Player {
    private UserInterface UI;
    private Room currentRoom;
    private ArrayList<Item> itemsPlayerCarry = new ArrayList<>();
    private char playerDirection;
    private boolean playerWon;
    private boolean playerLost;
    private int health = 50;
    private Weapon equippedWeapon;


    public Player(UserInterface UI) {
        this.UI = UI;
    }

    void pickOrDropItem(boolean isPicked) {
        ArrayList<Item> inventoryWeTakeFrom = getPlayerOrRoomItemList(isPicked);
        ArrayList<Item> inventoryWeAddToo = getPlayerOrRoomItemList(!isPicked);
        int itemCount = inventoryWeTakeFrom.size();
        if (itemCount > 0) {
            userChangesItemList(inventoryWeTakeFrom, inventoryWeAddToo, isPicked);
        } else {
            UI.emptyInventory(isPicked);
        }

    }

    public ArrayList<Item> getPlayerOrRoomItemList(boolean isPicked) {
        if (isPicked) {
            return currentRoom.getItemsInRoom();
        } else {
            return itemsPlayerCarry;
        }
    }

    public void userChangesItemList(ArrayList<Item> inventoryWeTakeFrom, ArrayList<Item> inventoryWeAddToo, boolean isPicked) {
        if (inventoryWeTakeFrom.size() == 1) {
            // String itemShortName = inventoryWeTakeFrom.get(0).getItemNameShort();
            String longItemName = inventoryWeTakeFrom.get(0).getItemNameLong();
            UI.itemPickedOrDropped(longItemName, isPicked);
            if (!isPicked) {
                resetEquippedWeapon(inventoryWeTakeFrom.get(0));
            }
            addAndRemoveItemFromInventory(0, inventoryWeTakeFrom, inventoryWeAddToo);

        } else {
            UI.askPickOrDropItem(isPicked);
            String input = UI.returnsUserInput().toLowerCase();
            if (input.equals("all")) {
                UI.allWasPickedOrDropped(isPicked);
                takeOrDropAllItems(inventoryWeTakeFrom, inventoryWeAddToo, isPicked);
            } else {
                for (int i = inventoryWeTakeFrom.size() - 1; i >= 0; i--) {
                    String shortItemName = inventoryWeTakeFrom.get(i).getItemNameShort().toLowerCase();
                    String longItemName = inventoryWeTakeFrom.get(i).getItemNameLong().toLowerCase();
                    if (input.equals(shortItemName) || input.equals(longItemName)) {

                        if (!isPicked) {
                            resetEquippedWeapon(inventoryWeTakeFrom.get(i));
                        } //resetter equippedItem, hvis det er det item der bliver dropped.

                        UI.itemPickedOrDropped(longItemName, isPicked); //printer item dropped/picket
                        addAndRemoveItemFromInventory(i, inventoryWeTakeFrom, inventoryWeAddToo);
                        i = -1;
                    }

                }
            }
        }
    }

    public void addAndRemoveItemFromInventory(int indexOfItem, ArrayList<Item> invWeTakeFrom, ArrayList<Item> invWeAddToo) {
        Item wantedItem = invWeTakeFrom.get(indexOfItem);
        invWeAddToo.add(wantedItem);
        invWeTakeFrom.remove(wantedItem);
    }

    void takeOrDropAllItems(ArrayList<Item> inventoryWeTakeFrom, ArrayList<Item> inventoryWeAddToo, boolean isPicked) {
        for (int i = inventoryWeTakeFrom.size() - 1; i >= 0; i--) {
            if (!isPicked) {
                resetEquippedWeapon(inventoryWeTakeFrom.get(i));
            }
            inventoryWeAddToo.add(inventoryWeTakeFrom.get(i));
            inventoryWeTakeFrom.remove(i);
        }
    }


    void eat(String itemToEat) {
        String input;

        if (itemToEat.contains(" ")) {
            input = itemToEat.substring(itemToEat.indexOf(' ') + 1);
        } else {
            UI.doYouWantToEat();
            input = UI.returnsUserInput().toLowerCase();
        }

        for (int i = itemsPlayerCarry.size() - 1; i >= 0; i--) {
            Item itemToTryToEat = itemsPlayerCarry.get(i);

            String shortItemName = itemToTryToEat.getItemNameShort().toLowerCase();
            String longItemName = itemToTryToEat.getItemNameLong().toLowerCase();
            if (input.equals(shortItemName) || input.equals(longItemName)) {

                if (itemToTryToEat instanceof Food) {
                    UI.itemEaten(longItemName); //printer item spist
                    removeEatenFood(i, itemsPlayerCarry);
                    changeHealth(itemToTryToEat);
                } else
                    UI.cannotBeEaten(longItemName);
                i = -1;
            } else if (i == 0)
                UI.youDontHaveThatItem();
        }
    }


    void changeHealth(Item itemToTryToEat) {
        int foodHealthPoint = ((Food) itemToTryToEat).getHealthPoint(); //typecaster item til food så vi har adgang til foods gethealtpoints
        health += foodHealthPoint;
    }

    void removeEatenFood(int indexOfItem, ArrayList<Item> invWeTakeFrom) {
        Item wantedItem = invWeTakeFrom.get(indexOfItem);
        invWeTakeFrom.remove(wantedItem);
    }


    void equipWeapon(String itemToEquip) {

        String input;

        if (itemToEquip.contains(" ")) {
            input = itemToEquip.substring(itemToEquip.indexOf(' ') + 1);
        } else {
            UI.chooseEquipWeapon();
            input = UI.returnsUserInput().toLowerCase();
        }

        for (int i = itemsPlayerCarry.size() - 1; i >= 0; i--) {
            Item weaponToEquip = itemsPlayerCarry.get(i);

            String shortItemName = weaponToEquip.getItemNameShort().toLowerCase();
            String longItemName = weaponToEquip.getItemNameLong().toLowerCase();

            if (input.equals(shortItemName) || input.equals(longItemName)) {

                if (weaponToEquip instanceof Weapon) {
                    equippedWeapon = (Weapon) weaponToEquip;
                    UI.weaponEquipped(longItemName); //printer equipped våben
                } else
                    UI.itemNotAWeapon(longItemName);
                i = -1;
            } else if (i == 0)
                UI.weaponNotFound();

        }
    }

    void resetEquippedWeapon(Item dropEquippedItem) {
        if (dropEquippedItem == equippedWeapon) //Hvis dropped item er det item player har equipped
            equippedWeapon = null;
    }

    Item getEquippedWeapon() {
        return equippedWeapon;
    }

    void unEquipWeapon() {
        UI.unEquip(equippedWeapon.getItemNameLong());
        equippedWeapon = null;
    }


    void playerAttack() {

        if (equippedWeapon != null) {
            if (equippedWeapon.canUse(equippedWeapon, UI)) {
                UI.attackedEnemy();

            } else {
                UI.ineffectualWeapon();
                equippedWeapon = null;
            }

        } else
            UI.attackNotPossible();

    }


    public void addItemPlayerCarry(Item item) {
        itemsPlayerCarry.add(item);
    }

    public void removeItemPlayerCarry(Item item) {
        itemsPlayerCarry.remove(item);
    }

    public void clearPlayerInventory() {
        itemsPlayerCarry.clear();
    }

    public void resetPlayer(Room startRoom, boolean replayMap) {
        playerWon = false;
        playerLost = false;
        currentRoom = startRoom;
        if (replayMap) {
            clearPlayerInventory();
        }
    }

    // Setters og Getters

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setDirection(char playerDirection) {
        this.playerDirection = playerDirection;
    }

    public char getDirection() {
        return playerDirection;
    }

    public ArrayList<Item> getItemsPlayerCarry() {
        return itemsPlayerCarry;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setPlayerWon(boolean playerWon) {
        this.playerWon = playerWon;
    }

    public boolean getPlayerWon() {
        return playerWon;
    }

    public void setPlayerLost(boolean playerLost) {
        this.playerLost = playerLost;
    }

    public boolean getPlayerLost() {
        return playerLost;
    }
}