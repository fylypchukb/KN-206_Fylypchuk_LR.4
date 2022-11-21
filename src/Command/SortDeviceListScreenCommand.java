package Command;

import DB.DataBaseStorage;
import Logger.LoggingClass;
import Service.SortDevices;
import UI.DevicesListScreen;

import java.io.IOException;
import java.util.logging.Level;

public class SortDeviceListScreenCommand implements Command {

    @Override
    public void execute() {
        var sort = SortDevices.sortHouse(DataBaseStorage.getHouseArrayList().get(0));

        if (sort == null) {
            LoggingClass.logger.log(Level.SEVERE, "Sorting was unsuccessful");
        } else {
            for (var device : sort) {
                System.out.println(device.stingPower());
            }
            LoggingClass.logger.log(Level.INFO, "Sorting completed");


            try {
                System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        new RedirectViewCommand(new DevicesListScreen()).execute();
    }
}
