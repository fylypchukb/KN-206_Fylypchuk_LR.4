package Command;

import DB.DataBaseStorage;
import Service.ActiveDevices;
import UI.DevicesListScreen;

import java.io.IOException;

public class ActiveDeviceListCommand implements Command {
    @Override
    public void execute() {
        ActiveDevices.showActiveHouse(DataBaseStorage.getHouseArrayList().get(0));
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        new RedirectView(new DevicesListScreen()).execute();
    }
}
