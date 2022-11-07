package Command;

import DB.DataBaseStorage;
import Model.Device;
import Service.DeviceManager;
import UI.DevicesListScreen;

public class DeleteCommand implements Command{
    private Device device = null;

    public DeleteCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        DeviceManager.deleteDevice(DataBaseStorage.getHouseArrayList().get(0), device);
        new RedirectViewCommand( new DevicesListScreen()).execute();
    }
}
