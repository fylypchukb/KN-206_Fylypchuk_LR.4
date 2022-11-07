package Service;

import Model.Device;
import Model.Room;
import Model.VirtualHouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class SortDevices {
    public static ArrayList<Device> sortRoom(Room room){
        ArrayList<Device> toReturn = room.getDevicesList();
        Collections.sort(toReturn, new SortByPower());
        return toReturn;
    }

    public static ArrayList<Device> sortHouse(VirtualHouse house){
        ArrayList<Device> toReturn = new ArrayList<>();
        for (int i = 0; i < house.roomCount(); i++){
            toReturn.addAll(house.getRoom(i).getDevicesList());
        }

        Collections.sort(toReturn, new SortByPower().reversed());
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