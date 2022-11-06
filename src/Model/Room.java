package Model.Rooms.Devices;

import Model.Rooms.Devices.Device;

import java.util.ArrayList;

public class Room {
    private ArrayList<Device> devices;
    private String name;

    public Room(String name) {
        // todo: перевірка на одинакове ім'я
        this.name = name;
        this.devices = new ArrayList<>();
    }

    public void addDevice(Device toAdd) {
        devices.add(toAdd);
    }

    public void showDevices() {
        for (Device device : devices) {
            System.out.println(device);
        }
    }

    public void removeDevice(int searchId){
        for (int i = 0; i < devices.size(); i++){
            if (devices.get(i).getId() == searchId) {
                devices.remove(i);
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int devicesCount(){
        return devices.size();
    }

    public Device getDevice(int index){
        return devices.get(index);
    }

    public ArrayList<Device> getDevicesList(){
        return devices;
    }
}
