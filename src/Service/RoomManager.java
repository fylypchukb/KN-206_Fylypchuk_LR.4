package Service;

import Logger.LoggingClass;
import Model.Room;
import Model.VirtualHouse;

import java.util.Scanner;
import java.util.logging.Level;

public class RoomManager {

    public static void createRoom(VirtualHouse house) {
        System.out.print("\nEnter room's name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        Room toReturn = createRoomObject(house, name);
        if (toReturn != null)
            house.addRoom(toReturn);
    }

    public static Room createRoomObject(VirtualHouse house, String name) {
        if (!isUniqueRoomName(house, name)) {
            return null;
        }

        return new Room(name);
    }

    private static boolean isUniqueRoomName(VirtualHouse house, String name) {
        for (int i = 0; i < house.roomCount(); i++) {
            if (house.getRoom(i).getName().compareToIgnoreCase(name) == 0) {
                return false;
            }
        }

        return true;
    }

    public static void deleteRoom(VirtualHouse house, String name) {
        boolean isDeleted = false;

        for (int i = 0; i < house.roomCount(); i++) {
            if (house.getRoom(i).getName().compareToIgnoreCase(name) == 0) {
                house.removeRoom(i);
                isDeleted = true;
                break;
            }
        }

        if (isDeleted && house.roomCount() != house.roomCount() + 1){
            LoggingClass.logger.log(Level.SEVERE, "Room was not deleted");
        }
    }
}
