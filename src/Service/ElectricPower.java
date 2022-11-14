package Service;

import Model.Room;
import Model.VirtualHouse;

public class ElectricPower {
    public static double calculateGeneralInRoom(Room room) {
        double sum = 0;
        for (int i = 0; i < room.devicesCount(); i++) {
            if (room.getDevice(i).getIsActive()) {
                sum += room.getDevice(i).getElectricPower();
            }
        }
        return sum;
    }

    public static double calculateGeneralInHome(VirtualHouse house) {
        double sum = 0;
        for (int i = 0; i < house.roomCount(); i++) {
            Room currRoom = house.getRoom(i);
            for (int j = 0; j < currRoom.devicesCount(); j++){
                if (currRoom.getDevice(j).getIsActive()) {
                    sum += currRoom.getDevice(j).getElectricPower();
                }
            }
        }
        return sum;
    }
}
