package Service;

import Model.Device;
import Model.Room;
import Model.VirtualHouse;

public class SearchDevice {
    public static Device generalSearch(VirtualHouse house, int searchID) {
        Device toReturn = null;
        for (int i = 0; i < house.roomCount(); i++) {
            Device searchResult = roomSearch(house.getRoom(i), searchID);
            toReturn = (searchResult != null) ? searchResult : toReturn;
        }

        return toReturn;
    }

    public static Device generalSearch(VirtualHouse house, String searchName) {
        Device toReturn = null;
        for (int i = 0; i < house.roomCount(); i++) {
            toReturn = roomSearch(house.getRoom(i), searchName);
            if (toReturn != null)
                break;
        }

        return toReturn;
    }

    public static Device roomSearch(Room room, int searchID) {
        Device toReturn = null;
        for (int j = 0; j < room.devicesCount(); j++) {
            if (room.getDevice(j).getId() == searchID) {
                toReturn = room.getDevice(j);
            }
        }
        return toReturn;
    }

    public static Device roomSearch(Room room, String searchName) {
        Device toReturn = null;
        for (int j = 0; j < room.devicesCount(); j++) {
            if (room.getDevice(j).getName().compareToIgnoreCase(searchName) == 0) {
                toReturn = room.getDevice(j);
            }
        }
        return toReturn;
    }


}
