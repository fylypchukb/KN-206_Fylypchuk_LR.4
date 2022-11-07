package Command;

import DB.DataBaseStorage;
import Service.DeviceManager;
import UI.RoomListScreen;

public class AddRoomCommand implements Command{

    public AddRoomCommand() {
    }

    @Override
    public void execute() {
        DeviceManager.createRoom(DataBaseStorage.getHouse(0));
        new RedirectViewCommand(new RoomListScreen()).execute();
    }
}
