package Service;

import Rooms.Room;
import Rooms.VirtualHouse;

public class SearchRoom {
    public Room searchRoom(VirtualHouse house, String name) {
        for (int i = 0; i < house.roomCount(); i++) {
            if (house.getRoom(i).getName().compareToIgnoreCase(name) == 0) {
                return house.getRoom(i);
            }
        }

        return null;
    }
}
