package Service;

import Devices.Device;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TimeControlled {

    private static Thread timeControlledThread = null;
    private static ArrayList<Device> timeControlledDevices = null;

    public void switchOnTime(Device device, LocalDateTime time) {
        device.setSwitchTime(time);
        formDevicesList(device);
    }

    private void formDevicesList(Device device) {
        if (timeControlledDevices == null) {
            timeControlledDevices = new ArrayList<>();
        }
        if (timeControlledThread == null) {
            setAsync();
        }
        timeControlledDevices.add(device);
    }

    public void setAsync() {
        timeControlledThread = new Thread(() -> {
            while (true) {
                checkTime();
            }
        });

        timeControlledThread.start();
    }

    private void checkTime() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        LocalDateTime curr = LocalDateTime.now();
        for (int i = 0; i < timeControlledDevices.size(); i++) {
            if (curr.isEqual(timeControlledDevices.get(i).getSwitchTime())) {
                timeControlledDevices.get(i).deactivateDevice();
                timeControlledDevices.remove(i);
                i--;
            }
        }
        if (timeControlledDevices.size() == 0) {
            timeControlledThread.interrupt();
        }

    }

}
