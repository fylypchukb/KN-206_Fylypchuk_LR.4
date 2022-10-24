package Commands;

import Devices.Device;
import Rooms.Room;
import Rooms.VirtualHouse;

import java.util.Scanner;

public class DeviceManager {
    public void createRoom(VirtualHouse house){
        System.out.print("\nEnter room's name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Room toReturn = new Room(name);

        house.addRoom(toReturn);
    }

    public VirtualHouse createHouse(){
        VirtualHouse house = new VirtualHouse();
        return house;
    }

    public void createDevice(){
        // todo: створити пристрій і добавити в кімнату
    }

    public void deleteDevice(Room room){
        // todo:
    }

    public void deleteRoom(VirtualHouse house){
        // todo:
    }

    public void renameDevice(Device device){
        // todo:
    }

    public void renameRoom(Room room){
        // todo:
    }

    public void showAllDevices(VirtualHouse house){
        // todo:
    }

    public void showRoomDevices(Room room){
        // todo:
    }

}
