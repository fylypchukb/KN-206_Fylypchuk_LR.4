package Service;

import Model.Room;
import Model.VirtualHouse;

import java.util.ArrayList;
import java.util.Comparator;

public class SortRooms {
    public static ArrayList<Room> sortRooms(VirtualHouse house){
        ArrayList<Room> toReturn = house.getRooms();
        toReturn.sort(new SortRoomByPower().reversed());

        return toReturn;
    }
}

class SortRoomByPower implements Comparator<Room>{
    @Override
    public int compare(Room r1, Room r2){
        return Double.compare(ElectricPower.calculateGeneralInRoom(r1), ElectricPower.calculateGeneralInRoom(r2));
    }
}
