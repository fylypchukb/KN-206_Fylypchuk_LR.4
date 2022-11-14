package Service;

import Model.Device;
import Model.Room;
import Model.VirtualHouse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SortDevicesTest {

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

        house.addRoom(room1);
        house.addRoom(room2);
    }

    @Test
    void sortHouse() {
        fillArray();

        ArrayList<Device> array = new ArrayList<>();
        array.add(new Device("PS4", 9874, 60));
        array.add(new Device("JBL Boombox", 8465, 45));
        array.add(new Device("D2", 4531, 16));
        array.add(new Device("D4", 0132, 10));
        array.add(new Device("TV", 1345, 20));
        array.add(new Device("Device2", 6451, 120));
        array.add(new Device("D1", 4353, 53));
        array.add(new Device("D3", 7862, 76));

        array.get(0).setActive(true);
        array.get(1).setActive(true);
        array.get(2).setActive(true);
        array.get(3).setActive(true);

        var toCompare = SortDevices.sortHouse(house);
        for (int i = 0; i < toCompare.size(); i++){
            assertEquals(array.get(i).getId(), toCompare.get(i).getId(), "Sorting is wrong");
        }

    }
}