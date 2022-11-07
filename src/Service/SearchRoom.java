package Service;

import Model.Device;
import Model.Room;
import Model.VirtualHouse;

public class SearchRoom {
    public static Room searchRoom(VirtualHouse house, String name) {
        for (int i = 0; i < house.roomCount(); i++) {
            if (house.getRoom(i).getName().compareToIgnoreCase(name) == 0) {
                return house.getRoom(i);
            }
        }

        return null;
    }

    public static Room searchRoomByDevice(VirtualHouse house, Device device) {

        for (int i = 0; i < house.roomCount(); i++) {
            Room room = house.getRoom(i);
            for (int j = 0; j < room.devicesCount(); j++) {
                if (room.getDevice(j).getId() == device.getId()) {
                    return room;
                }
            }
        }

        return null;
    }
}
