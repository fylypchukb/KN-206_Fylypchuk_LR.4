package Command;

import DB.DataBaseStorage;
import Service.RoomManager;
import UI.RoomListScreen;

public class DeleteRoomCommand implements Command{
    private final String roomName;

    public DeleteRoomCommand(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public void execute() {
        RoomManager.deleteRoom(DataBaseStorage.getHouse(0), roomName);
        new RedirectViewCommand(new RoomListScreen()).execute();
    }
}
