package Command;

import DB.DataBaseStorage;
import Logger.LoggingClass;
import Model.Room;
import Service.SearchRoom;
import UI.RoomListScreen;

import java.io.IOException;
import java.util.logging.Level;

public class ShowDevicesInRoomCommand implements Command {

    private String request;

    public ShowDevicesInRoomCommand(String name) {
        request = name;
    }

    @Override
    public void execute() {
        Room room = SearchRoom.searchRoom(DataBaseStorage.getHouseArrayList().get(0), request);

        if (room == null) {
            LoggingClass.logger.log(Level.WARNING, "Room was not found. Request - " + request);
            System.out.println("Room wasn't found");
        } else {
            System.out.println("--Room: " + room.getName());
            for (int i = 0; i < room.devicesCount(); i++) {
                System.out.println(room.getDevice(i));
            }

            try {
                System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            LoggingClass.logger.log(Level.INFO, "Showed devices in room. Request - " + room.getName());
        }

        new RedirectViewCommand(new RoomListScreen()).execute();
    }
}
