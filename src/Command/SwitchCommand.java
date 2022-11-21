package Command;

import DB.DataBaseStorage;
import Logger.LoggingClass;
import Model.Device;
import Service.SearchDevice;
import UI.DevicesListScreen;

import java.util.logging.Level;

public class SwitchCommand implements Command {

    private final String request;

    public SwitchCommand(String request) {
        this.request = request;
    }

    @Override
    public void execute() {

        Device device = SearchDevice.generalSearch(DataBaseStorage.getHouse(0), Integer.parseInt(request));

        if (device != null){
            device.setActive(!device.getIsActive());
            LoggingClass.logger.log(Level.INFO, device.getName() + " was switched to " + device.getIsActive());
        }
        else {
            System.out.println("Device is not found!");
            LoggingClass.logger.log(Level.INFO, "Device wasn't found. Request - " + request);
        }

        var forAction = new RedirectViewCommand(new DevicesListScreen());
        forAction.execute();
    }
}
