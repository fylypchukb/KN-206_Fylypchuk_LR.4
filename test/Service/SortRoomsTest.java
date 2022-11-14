package Service;

import Model.Device;
import Model.Room;
import Model.VirtualHouse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SortRoomsTest {

    private final VirtualHouse house = new VirtualHouse();

    private void fillArray() {
        var room1 = new Room("Room1");
        room1.addDevice(new Device("TV", 1345, 20));
        room1.addDevice(new Device("PS4", 9874, 60));
        room1.addDevice(new Device("JBL Boombox", 8465, 45));
        room1.addDevice(new Device("Device2", 6451, 120));
        room1.getDevice(1).setActive(true);
        room1.getDevice(2).setActive(true);

        var room2 = new Room("Room2");
        room2.addDevice(new Device("D1", 4353, 53));
        room2.addDevice(new Device("D2", 4531, 16));
        room2.addDevice(new Device("D3", 7862, 76));
        room2.addDevice(new Device("D4", 0132, 10));
        room2.getDevice(1).setActive(true);
        room2.getDevice(3).setActive(true);

        var room3 = new Room("Room2");
        room3.addDevice(new Device("f1", 3540, 32));
        room3.addDevice(new Device("f2", 6410, 77));
        room3.addDevice(new Device("f3", 7981, 102));
        room3.addDevice(new Device("f4", 3207, 78));
        room3.getDevice(0).setActive(true);
        room3.getDevice(1).setActive(true);

        house.addRoom(room1);
        house.addRoom(room2);
        house.addRoom(room3);
    }

    @Test
    void sortRooms() {
        fillArray();

        ArrayList<Room> array = new ArrayList<>();
        array.add(house.getRoom(2));
        array.add(house.getRoom(0));
        array.add(house.getRoom(1));

        var toCheck = SortRooms.sortRooms(house);

        for (int i = 0; i < array.size(); i++){
            assertEquals(array.get(i), toCheck.get(i), "Sorting rooms is wrong");
        }
    }
}