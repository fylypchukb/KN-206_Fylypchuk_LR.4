package Command;

import DB.DataBaseStorage;
import Model.Room;
import Service.DeviceManager;
import Service.SearchRoom;
import UI.DevicesListScreen;

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
        else
            System.out.println("Room is no found!");
        new RedirectViewCommand(new DevicesListScreen()).execute();
    }
}
