package del1;

import java.util.ArrayList;

public class Room {
  private Room north, south, west, east;
  private final ArrayList<Item> itemsInRoom = new ArrayList<>();
  private String name;
  private String roomDescription;


  Room(String name, String roomDescription) {
    setName(name);
    setRoomDescription(roomDescription);
  }


  public void setRooms(Room north, Room south, Room west, Room east) {
    this.north = north;
    this.south = south;
    this.west = west;
    this.east = east;
  }

  public Room getRooms(char direction) {
    switch (direction) {
      case 'N':
        return north;
      case 'S':
        return south;
      case 'W':
        return west;
      case 'E':
        return east;
      default:
        return null;
    }
  }



  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setRoomDescription(String roomDescription) {
    this.roomDescription = roomDescription;
  }

  public String getRoomDescription() {
    return roomDescription;
  }


  public void setItemsInRoom (Item item){
    itemsInRoom.add(item);
  }
  public void removeItemsInRoom (Item item){
    itemsInRoom.remove(item);
  }
  public ArrayList<Item> getItemsInRoom(){
    return itemsInRoom;
  }
  public void clearRoomInventory(){
    itemsInRoom.clear();
  }
}
