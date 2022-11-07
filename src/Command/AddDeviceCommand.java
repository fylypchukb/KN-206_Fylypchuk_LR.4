package Command;

import Model.Room;
import Service.DeviceManager;
import UI.DevicesListScreen;

public class AddDeviceCommand implements Command{

    private Room room = null;

    public AddDeviceCommand(Room room) {
        this.room = room;
    }

    @Override
    public void execute() {
        DeviceManager.createDevice(room);
        new RedirectViewCommand(new DevicesListScreen()).execute();
    }
}
