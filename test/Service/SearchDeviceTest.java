package Service;


import Model.Device;
import Model.Room;
import Model.VirtualHouse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchDeviceTest {

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
    void generalSearch() {
        fillArray();

        Device device = new Device("D2", 4531, 16);
        assertEquals(device.getId(), SearchDevice.generalSearch(house, 4531).getId(),
                "Device searching by id in the whole house is wrong");

        Device device1 = new Device("TV", 1345, 20);
        assertEquals(device1.getId(), SearchDevice.generalSearch(house, 1345).getId(),
                "Device searching by id in the whole house is wrong");
    }

    @Test
    void testGeneralSearch() {
        fillArray();

        Device device = new Device("D2", 4531, 16);
        assertEquals(device.getId(), SearchDevice.generalSearch(house, "D2").getId(),
                "Device searching by its name in the whole house is wrong");

        Device device1 = new Device("TV", 1345, 20);
        assertEquals(device1.getId(), SearchDevice.generalSearch(house, "tv").getId(),
                "Device searching by its name in the whole house is wrong");
    }

    @Test
    void roomSearch() {
        fillArray();

        Device device = new Device("D2", 4531, 16);
        assertEquals(device.getId(), SearchDevice.roomSearch(house.getRoom(1), 4531).getId(),
                "Device searching by id in the room is wrong");

        Device device1 = new Device("TV", 1345, 20);
        assertEquals(device1.getId(), SearchDevice.roomSearch(house.getRoom(0), 1345).getId(),
                "Device searching by id in the room is wrong");
    }

    @Test
    void testRoomSearch() {
        fillArray();

        Device device = new Device("D2", 4531, 16);
        assertEquals(device.getId(), SearchDevice.roomSearch(house.getRoom(1), "d2").getId(),
                "Device searching by id in the room is wrong");

        Device device1 = new Device("TV", 1345, 20);
        assertEquals(device1.getId(), SearchDevice.roomSearch(house.getRoom(0), "TV").getId(),
                "Device searching by id in the room is wrong");
    }
}