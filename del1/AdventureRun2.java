package del1;

public class AdventureRun2 {

        Adventure2 A = new Adventure2();
        RoomDescription D = new RoomDescription();

        public static void main(String[] args) {
            new del1.AdventureRun().go();
        }

        void go() {

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

            A.setCurrentRoom(room1);
            A.typeDirection();
        }
    }

