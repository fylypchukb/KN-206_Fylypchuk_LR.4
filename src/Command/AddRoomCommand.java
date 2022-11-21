package Command;

import DB.DataBaseStorage;
import Logger.LoggingClass;
import Service.RoomManager;
import UI.RoomListScreen;

import java.util.logging.Level;

public class AddRoomCommand implements Command{

    public AddRoomCommand() {
    }

    @Override
    public void execute() {
        RoomManager.createRoom(DataBaseStorage.getHouse(0));

        LoggingClass.logger.log(Level.INFO, "Added new room");
        new RedirectViewCommand(new RoomListScreen()).execute();
    }
}
