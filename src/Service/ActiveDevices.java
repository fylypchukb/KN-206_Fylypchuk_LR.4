package Service;

import Model.Device;
import Model.Room;
import Model.VirtualHouse;

public class ActiveDevices {
    public static void showActiveRoom(Room room) {
        for (Device device : SearchDevice.findActiveRoom(room)) {
            System.out.println(device);
        }
    }

    public static void showActiveHouse(VirtualHouse house) {
        for (int i = 0; i < house.roomCount(); i++) {
            Room room = house.getRoom(i);
            System.out.println("---" + room.getName());
            for (int j = 0; j < room.devicesCount(); j++) {
                if (room.getDevice(j).getIsActive()) {
                    System.out.println(room.getDevice(j));
                }
            }
        }
    }
}
