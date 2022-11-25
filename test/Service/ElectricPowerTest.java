package Service;


import Model.Device;
import Model.Room;
import Model.VirtualHouse;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class ElectricPowerTest {

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
    void calculateGeneralInRoomTest() {
        fillArray();

        assertEquals(105, ElectricPower.calculateGeneralInRoom(house.getRoom(0)),
                "General consumption in the room is wrong");
    }

    @Test
    void calculateGeneralInHomeTest() {
        fillArray();

        assertEquals(131, ElectricPower.calculateGeneralInHome(house),
                "General consumption in the room is wrong");
    }
}