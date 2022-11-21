package Command;

import DB.DataBaseStorage;
import Logger.LoggingClass;
import Model.Room;
import Service.DeviceManager;
import Service.SearchRoom;
import UI.DevicesListScreen;

import java.util.logging.Level;

public class AddDeviceCommand implements Command {
    private final String request;

    public AddDeviceCommand(String request) {
        this.request = request;
    }

    @Override
    public void execute() {
        Room room = SearchRoom.searchRoom(DataBaseStorage.getHouse(0), request);

        if (room != null)
            DeviceManager.createDevice(room);
        else {
            System.out.println("Room is no found!");
            LoggingClass.logger.log(Level.WARNING, "Room wasn't found. Request - " + request);
        }

        LoggingClass.logger.log(Level.INFO, "Added new device");
        new RedirectViewCommand(new DevicesListScreen()).execute();
    }
}
