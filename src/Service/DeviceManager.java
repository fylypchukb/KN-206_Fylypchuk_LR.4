package Service;

import Model.Device;
import Model.Room;
import Model.VirtualHouse;

import java.util.Scanner;

public class DeviceManager {

    public static void createDevice(Room room) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nName of your device: ");
        String name = scanner.nextLine();

        System.out.print("ID of " + name + ": ");
        int id = scanner.nextInt();

        System.out.print("Electric power of " + name + ": ");
        double power = scanner.nextDouble();

        var device = createDeviceObject(room, name, id, power);
        if (device != null)
            room.addDevice(createDeviceObject(room, name, id, power));
    }

    public static Device createDeviceObject(Room room, String name, int id, double power) {
        if (!isUniqueDeviceName(name, room)) {
            System.out.println("Name is not unique");
            return null;
        }

        if (!isUniqueDeviceId(id, room)) {
            System.out.println("Id is not unique");
            return null;
        }

        return new Device(name, id, power);
    }

    public static void deleteDevice(VirtualHouse house, Device device) {
        for (int i = 0; i < house.roomCount(); i++) {
            Room room = house.getRoom(i);
            for (int j = 0; j < room.devicesCount(); j++) {
                if (room.getDevice(j).getId() == device.getId()) {
                    room.removeDevice(j);
                    break;
                }
            }
        }
    }


    private static boolean isUniqueDeviceName(String name, Room room) {
        for (int i = 0; i < room.devicesCount(); i++) {
            if (room.getDevice(i).getName().compareToIgnoreCase(name) == 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isUniqueDeviceId(int id, Room room) {
        for (int i = 0; i < room.devicesCount(); i++) {
            if (room.getDevice(i).getId() == id) {
                return false;
            }
        }

        return true;
    }

}
