package Service;



import Model.Device;
import Model.Room;
import Model.VirtualHouse;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class DeviceManagerTest {

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
    void createDeviceObject() {
        var room2 = new Room("Room2");
        room2.addDevice(new Device("D1", 4353, 53));
        room2.addDevice(new Device("D2", 4531, 16));
        room2.addDevice(new Device("D3", 7862, 76));
        room2.addDevice(new Device("D4", 0132, 10));

        assertNotNull(DeviceManager.createDeviceObject(room2, "D5", 6548, 10),
                "New Device object wasn't created");

    }

    @Test
    void deleteDevice() {
        fillArray();

        var expected = house.getRoom(0).devicesCount()-1;
        DeviceManager.deleteDevice(house, house.getRoom(0).getDevice(0));

        assertEquals(expected, house.getRoom(0).devicesCount(), "Device was not deleted");
    }
}