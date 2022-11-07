package Service;

import Model.Room;
import Model.VirtualHouse;

import java.util.Scanner;

public class RoomManager {

    public static void createRoom(VirtualHouse house) {
        System.out.print("\nEnter room's name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        while (!isUniqueRoomName(house, name)) {
            System.out.print("\nThat name is already taken.\nName of your room: ");
            name = scanner.nextLine();
        }
        Room toReturn = new Room(name);

        house.addRoom(toReturn);
    }

    private static boolean isUniqueRoomName(VirtualHouse house, String name) {
        for (int i = 0; i < house.roomCount(); i++) {
            if (house.getRoom(i).getName().compareToIgnoreCase(name) == 0) {
                return false;
            }
        }

        return true;
    }

    public static void deleteRoom(VirtualHouse house, String name){
        for (int i = 0; i < house.roomCount(); i++){
            if (house.getRoom(i).getName().compareToIgnoreCase(name) == 0){
                house.removeRoom(i);
                break;
            }
        }
    }
}
