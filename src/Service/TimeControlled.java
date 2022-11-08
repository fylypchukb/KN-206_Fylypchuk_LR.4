package Service;

import Model.Device;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TimeControlled {

    private static final Thread timeControlledThread = new Thread(() -> {
        while (true) {
            checkTime();
        }
    });
    private static final ArrayList<Device> timeControlledDevices = new ArrayList<>();

    public static void switchOnTime(Device device, LocalDateTime time) {
        device.setSwitchTime(time);
        formDevicesList(device);
    }

    private static void formDevicesList(Device device) {
        if (timeControlledThread.getState() == Thread.State.NEW) {
            setAsync();
        }
        if (timeControlledThread.getState() == Thread.State.WAITING){
            timeControlledThread.notifyAll();
        }
        timeControlledDevices.add(device);
    }

    private static void setAsync() {
        timeControlledThread.setName("Time-control");
        timeControlledThread.start();
    }

    private static void checkTime() {
        LocalDateTime curr = LocalDateTime.now();
        for (int i = 0; i < timeControlledDevices.size(); i++) {
            if (curr.isAfter(timeControlledDevices.get(i).getSwitchTime())) {
                System.out.println(timeControlledDevices.get(i).getName() + " is deactivated!");
                timeControlledDevices.get(i).deactivateDevice();
                timeControlledDevices.remove(i);
                i--;
            }
        }

        if (timeControlledDevices.size() == 0) {
            try {
                timeControlledThread.join();
            } catch (InterruptedException e) {
                System.out.println("Exception handled " + e);
            }
        }

        if (!timeControlledThread.isInterrupted())
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Exception handled " + e);
            }

    }

    public static ArrayList<Device> getTimeControlledDevices() {
        return timeControlledDevices;
    }
}
