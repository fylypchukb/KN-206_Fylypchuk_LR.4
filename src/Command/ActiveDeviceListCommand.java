package Command;

import DB.DataBaseStorage;
import Service.ActiveDevices;
import UI.DevicesListScreen;

import java.io.IOException;

public class ActiveDeviceListCommand implements Command {
    @Override
    public void execute() {
        var show = ActiveDevices.showActiveHouse(DataBaseStorage.getHouseArrayList().get(0));

        for (var item : show) {
            System.out.println("\n--" + item.getName());
            for (int i = 0; i < item.devicesCount(); i++) {
                System.out.println(item.getDevice(i));
            }
        }

        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        new RedirectViewCommand(new DevicesListScreen()).execute();
    }
}
