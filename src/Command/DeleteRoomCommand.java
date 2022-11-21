package Command;

import DB.DataBaseStorage;
import Logger.LoggingClass;
import Service.RoomManager;
import UI.RoomListScreen;

import java.util.logging.Level;

public class DeleteRoomCommand implements Command {
    private final String roomName;

    public DeleteRoomCommand(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public void execute() {
        RoomManager.deleteRoom(DataBaseStorage.getHouse(0), roomName);

        LoggingClass.logger.log(Level.INFO, "Room \"" + roomName + "\" is deleted");

        new RedirectViewCommand(new RoomListScreen()).execute();
    }
}
