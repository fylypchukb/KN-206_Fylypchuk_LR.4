package Service;

import Model.Device;
import Model.Room;
import Model.VirtualHouse;

import java.util.Scanner;

public class DeviceManager {
    public void createRoom(VirtualHouse house) {
        System.out.print("\nEnter room's name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Room toReturn = new Room(name);

        house.addRoom(toReturn);
    }

    public VirtualHouse createHouse() {
        VirtualHouse house = new VirtualHouse();
        return house;
    }

    public void createDevice(Room room) {
        // todo: створити пристрій і добавити в кімнату
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nName of your device: ");
        String name = scanner.nextLine();
        while (!isUniqueDeviceName(name, room)) {
            System.out.print("\nThat name is already taken.\nName of your device: ");
            name = scanner.nextLine();
        }

        System.out.print("\nID of " + name + ": ");
        int id = scanner.nextInt();
        while (!isUniqueDeviceId(id, room)) {
            System.out.print("\nThat id is already taken.\nID of " + name + ": ");
            id = scanner.nextInt();
        }

        System.out.print("\nElectric power of " + name + ": ");
        double power = scanner.nextDouble();

        Device device = new Device(name, id, power);
        room.addDevice(device);
    }


    private boolean isUniqueDeviceName(String name, Room room) {
        for (int i = 0; i < room.devicesCount(); i++) {
            if (room.getDevice(i).getName().compareToIgnoreCase(name) == 0) {
                return false;
            }
        }

        return true;
    }

    private boolean isUniqueDeviceId(int id, Room room) {
        for (int i = 0; i < room.devicesCount(); i++) {
            if (room.getDevice(i).getId() == id) {
                return false;
            }
        }

        return true;
    }

}
