package Command;

import DB.DataBaseStorage;
import Logger.LoggingClass;
import Model.Device;
import Service.DeviceManager;
import Service.SearchDevice;
import UI.DevicesListScreen;

import java.util.logging.Level;

public class DeleteDeviceCommand implements Command {
    private final String request;

    public DeleteDeviceCommand(String request) {
        this.request = request;
    }

    @Override
    public void execute() {
        Device device = SearchDevice.generalSearch(DataBaseStorage.getHouse(0), Integer.parseInt(request));

        if (device != null) {
            DeviceManager.deleteDevice(DataBaseStorage.getHouseArrayList().get(0), device);
            LoggingClass.logger.log(Level.INFO, "Device \"" + device.getName() + "\" is deleted");
        } else {
            System.out.println("Device is not found!");
            LoggingClass.logger.log(Level.INFO, "Device is not found. Request - " + request);
        }


        new RedirectViewCommand(new DevicesListScreen()).execute();
    }
}
