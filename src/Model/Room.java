package Model;

import java.util.ArrayList;

public class Room {
    private final ArrayList<Device> devices;
    private String name;

    public Room(String name) {
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

    public void removeDevice(int id) {
        devices.remove(id);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int devicesCount() {
        return devices.size();
    }

    public Device getDevice(int index) {
        return devices.get(index);
    }

    public ArrayList<Device> getDevicesList() {
        return devices;
    }
}
