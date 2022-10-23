package Commands;

import Devices.Device;
import Rooms.Room;
import Rooms.VirtualHouse;

import java.util.ArrayList;

public class SearchDevice {
    public static Device generalSearch(VirtualHouse house, int searchID) {
        Device toReturn = null;
        for (int i = 0; i < house.roomCount(); i++) {
            toReturn = roomSearch(house.getRoom(i), searchID);
        }

        return toReturn;
    }

    public static Device generalSearch(VirtualHouse house, String searchName) {
        Device toReturn = null;
        for (int i = 0; i < house.roomCount(); i++) {
            toReturn = roomSearch(house.getRoom(i), searchName);
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

    public static ArrayList<Device> findActiveRoom(Room room) {
        ArrayList<Device> toReturn = new ArrayList<Device>();
        for (int i = 0; i < room.devicesCount(); i++) {
            if (room.getDevice(i).getIsActive()) {
                toReturn.add(room.getDevice(i));
            }
        }

        return toReturn;
    }

    public static ArrayList<Device> findActiveHouse(VirtualHouse house){
        ArrayList<Device> toReturn = new ArrayList<Device>();
        for (int i = 0; i < house.roomCount(); i ++){
            toReturn.addAll(findActiveRoom(house.getRoom(i)));
        }

        return toReturn;
    }

}
