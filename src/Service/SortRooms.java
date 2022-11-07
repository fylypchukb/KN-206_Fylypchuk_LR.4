package Service;

import Model.Room;
import Model.VirtualHouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortRooms {
    public static ArrayList<Room> sortRooms(VirtualHouse house){
        ArrayList<Room> toReturn = house.getRooms();
        Collections.sort(toReturn, new SortRoomByPower().reversed());

        return toReturn;
    }
}

class SortRoomByPower implements Comparator<Room>{
    @Override
    public int compare(Room r1, Room r2){
        if (ElectricPower.CalculateGeneralInRoom(r1) > ElectricPower.CalculateGeneralInRoom(r2))
            return 1;
        if (ElectricPower.CalculateGeneralInRoom(r1) < ElectricPower.CalculateGeneralInRoom(r2))
            return -1;
        else
            return 0;
    }
}
