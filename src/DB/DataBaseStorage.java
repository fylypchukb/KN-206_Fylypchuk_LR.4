package DB;

import Model.Device;
import Model.Room;
import Model.VirtualHouse;

import java.util.ArrayList;

public class DataBaseStorage {

    private static ArrayList<VirtualHouse> houseArrayList = null;

    public static ArrayList<VirtualHouse> getHouseArrayList() {
        return houseArrayList;
    }

    public static VirtualHouse getHouse(int index){
        return houseArrayList.get(index);
    }

    public DataBaseStorage() {
        VirtualHouse virtualHouse = new VirtualHouse();

        virtualHouse.addRoom(new Room("Kitchen"));
        virtualHouse.getRoom(0).addDevice(new Device("Microwave", 0245, 800));
        virtualHouse.getRoom(0).addDevice(new Device("Coffee machine", 6812, 1500));
        virtualHouse.getRoom(0).addDevice(new Device("Toaster", 6827, 800));

        virtualHouse.getRoom(0).getDevice(0).setActive(true);
        virtualHouse.getRoom(0).getDevice(1).setActive(true);

        virtualHouse.addRoom(new Room("Bedroom"));
        virtualHouse.getRoom(1).addDevice(new Device("Humidifier", 9485, 30));
        virtualHouse.getRoom(1).addDevice(new Device("Table LED lamp", 6543, 4));
        virtualHouse.getRoom(1).addDevice(new Device("Electronic clock", 8132, 6));

        virtualHouse.getRoom(1).getDevice(1).setActive(true);

        virtualHouse.addRoom(new Room("LivingRoom"));
        virtualHouse.getRoom(2).addDevice(new Device("PS5", 3983, 800));
        virtualHouse.getRoom(2).addDevice(new Device("TV", 5132, 500));
        virtualHouse.getRoom(2).addDevice(new Device("Musical center", 7915, 600));

        virtualHouse.getRoom(2).getDevice(2).setActive(true);

        houseArrayList = new ArrayList<>();
        houseArrayList.add(virtualHouse);
    }


}
