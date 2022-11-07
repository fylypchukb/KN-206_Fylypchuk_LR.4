package Command;

import DB.DataBaseStorage;
import Service.RoomManager;
import UI.RoomListScreen;

public class AddRoomCommand implements Command{

    public AddRoomCommand() {
    }

    @Override
    public void execute() {
        RoomManager.createRoom(DataBaseStorage.getHouse(0));
        new RedirectViewCommand(new RoomListScreen()).execute();
    }
}
