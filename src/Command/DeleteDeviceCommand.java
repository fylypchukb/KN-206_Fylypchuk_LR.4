package Command;

import DB.DataBaseStorage;
import Model.Device;
import Service.DeviceManager;
import Service.SearchDevice;
import UI.DevicesListScreen;

public class DeleteDeviceCommand implements Command {
    private final String request;

    public DeleteDeviceCommand(String request) {
        this.request = request;
    }

    @Override
    public void execute() {
        Device device = SearchDevice.generalSearch(DataBaseStorage.getHouse(0), Integer.parseInt(request));

        if (device != null)
            DeviceManager.deleteDevice(DataBaseStorage.getHouseArrayList().get(0), device);
        else
            System.out.println("Device is no found!");
        new RedirectViewCommand(new DevicesListScreen()).execute();
    }
}
