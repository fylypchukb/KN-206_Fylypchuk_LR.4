package Service;

import Model.Room;
import Model.VirtualHouse;

import java.util.ArrayList;

public class ActiveDevices {

    public static ArrayList<Room> showActiveHouse(VirtualHouse house) {
        ArrayList<Room> arrayList = new ArrayList<>();

        for (int i = 0; i < house.roomCount(); i++) {
            Room room = house.getRoom(i);

            arrayList.add(new Room(room.getName()));
            for (int j = 0; j < room.devicesCount(); j++) {
                if (room.getDevice(j).getIsActive()) {
                    arrayList.get(i).addDevice(room.getDevice(j));
                }
            }
        }

        return arrayList;
    }
}
