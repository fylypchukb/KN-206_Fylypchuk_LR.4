package Command;

import DB.DataBaseStorage;
import Logger.LoggingClass;
import Model.Device;
import Model.Room;
import Service.SearchDevice;
import Service.SearchRoom;
import UI.MainScreen;

import java.io.IOException;
import java.util.logging.Level;

public class SearchHouseScreenCommand implements Command {

    String request;

    public SearchHouseScreenCommand(String request) {
        this.request = request;
    }

    @Override
    public void execute() {
        var words = request.split(" ");
        int id;
        StringBuilder name;

        Device result;
        try {
            id = Integer.parseInt(words[1]);
            result = SearchDevice.generalSearch(DataBaseStorage.getHouse(0), id);

        } catch (Exception e) {
            LoggingClass.logger.log(Level.WARNING, "Int parsing threw an exception");

            name = new StringBuilder(words[1]);

            if (words.length > 2)
                for (int i = 2; i < words.length; i++) {
                    name.append(" ").append(words[i]);
                }
            result = SearchDevice.generalSearch(DataBaseStorage.getHouse(0), name.toString());
        }

        if (result != null) {
            Room room = SearchRoom.searchRoomByDevice(DataBaseStorage.getHouse(0), result);
            assert room != null;
            System.out.println("Result: " + room.getName() + ": " + result);
            LoggingClass.logger.log(Level.INFO, "Device was found in " + room.getName() + " - "
                    + result.getName() + "\n\tRequest - " + request);
            try {
                System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Device is not found!");
            LoggingClass.logger.log(Level.WARNING, "Device wasn't found in house. Request - " + request);
        }

        new RedirectViewCommand(new MainScreen()).execute();

    }
}
