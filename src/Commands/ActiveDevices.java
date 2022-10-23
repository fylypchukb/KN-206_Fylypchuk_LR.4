package Commands;

import Devices.Device;
import Rooms.Room;
import Rooms.VirtualHouse;

public class ActiveDevices {
    public static void showActiveRoom(Room room) {
        for (Device device : SearchDevice.findActiveRoom(room)) {
            System.out.println(device);
        }
    }

    public static void showActiveHouse(VirtualHouse house) {
        for (Device device : SearchDevice.findActiveHouse(house)) {
            System.out.println(device);
        }
    }
}
