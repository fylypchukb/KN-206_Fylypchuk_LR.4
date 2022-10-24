package Commands;

import Devices.Device;
import Rooms.Room;
import Rooms.VirtualHouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class SortDevices {
    public ArrayList<Device> sortRoom(Room room){
        ArrayList<Device> toReturn = room.getDevicesList();
        Collections.sort(toReturn, new SortByPower());
        return toReturn;
    }

    public ArrayList<Device> sortHouse(VirtualHouse house){
        ArrayList<Device> toReturn = new ArrayList<>();
        for (int i = 0; i < house.roomCount(); i++){
            toReturn.addAll(house.getRoom(i).getDevicesList());
        }

        Collections.sort(toReturn, new SortByPower());
        return toReturn;
    }
}

class SortByPower implements Comparator<Device> {

    @Override
    public int compare(Device o1, Device o2) {
        if (o1.getElectricPower() > o2.getElectricPower()){
            return 1;
        } else if (o1.getElectricPower() < o2.getElectricPower()) {
            return -1;
        } else {
            return 0;
        }
    }
}