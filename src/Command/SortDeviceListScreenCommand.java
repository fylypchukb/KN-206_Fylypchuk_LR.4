package Command;

import DB.DataBaseStorage;
import Service.SortDevices;
import UI.DevicesListScreen;

import java.io.IOException;

public class SortDeviceListScreenCommand implements Command {

    @Override
    public void execute() {
        var sort = SortDevices.sortHouse(DataBaseStorage.getHouseArrayList().get(0));
        for (var device : sort) {
            System.out.println(device.stingPower());
        }

        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        new RedirectViewCommand(new DevicesListScreen()).execute();
    }
}
