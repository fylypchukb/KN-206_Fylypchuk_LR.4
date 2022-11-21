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

public class SearchRoomScreenCommand implements Command {

    String request;

    public SearchRoomScreenCommand(String request) {
        this.request = request;
    }

    Device result;

    @Override
    public void execute() {
        var words = request.split(" ");
        Room room = SearchRoom.searchRoom(DataBaseStorage.getHouse(0), words[1]);

        if (room != null) {
            int id;
            StringBuilder name;
            try {
                id = Integer.parseInt(words[2]);
                result = SearchDevice.roomSearch(room, id);
            } catch (Exception e) {

                LoggingClass.logger.log(Level.WARNING, "Int parsing threw an exception. Request - " + request);

                name = new StringBuilder(words[2]);

                for (int i = 3; i < words.length; i++) {
                    name.append(" ").append(words[i]);
                }
                result = SearchDevice.roomSearch(room, name.toString());
            }
        } else {
            System.out.println("Room is not found!");
            LoggingClass.logger.log(Level.WARNING, "Room was not found. Request - " + request);
        }

        if (result != null) {
            System.out.println("Result: " + result);
            LoggingClass.logger.log(Level.INFO, "Device wa found. Result - " + result.toString()
                    + "\n\tRequest - " + request);
            try {
                System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Device is not found");
            LoggingClass.logger.log(Level.WARNING, "Device was not found. Request - " + request);
        }

        new RedirectViewCommand(new MainScreen()).execute();
    }
}
