package Command;

import DB.DataBaseStorage;
import Model.Device;
import Service.SearchDevice;
import UI.DevicesListScreen;

public class SwitchCommand implements Command {

    private final String request;

    public SwitchCommand(String request) {
        this.request = request;
    }

    @Override
    public void execute() {

        Device device = SearchDevice.generalSearch(DataBaseStorage.getHouse(0), request);

        if (device != null)
            device.setActive(!device.getIsActive());
        else
            System.out.println("Device is not found!");
        var forAction = new RedirectViewCommand(new DevicesListScreen());
        forAction.execute();
    }
}
