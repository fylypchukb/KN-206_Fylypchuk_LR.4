package Service;

import Model.Device;
import Model.VirtualHouse;

import java.util.ArrayList;
import java.util.Comparator;



public class SortDevices {

    public static ArrayList<Device> sortHouse(VirtualHouse house){
        ArrayList<Device> toReturn = new ArrayList<>();
        for (int i = 0; i < house.roomCount(); i++){
            toReturn.addAll(house.getRoom(i).getDevicesList());
        }

        toReturn.sort(new SortDeviceByPower().reversed());
        return toReturn;
    }
}

class SortDeviceByPower implements Comparator<Device> {

    @Override
    public int compare(Device o1, Device o2) {
        return Double.compare(o1.getElectricPower(), o2.getElectricPower());
    }
}