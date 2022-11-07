package Command;

import DB.DataBaseStorage;
import Model.Room;
import Service.SearchRoom;
import UI.RoomListScreen;

import java.io.IOException;

public class ShowDevicesInRoomCommand implements Command{

    private Room room;

    public ShowDevicesInRoomCommand(String name) {
        this.room = SearchRoom.searchRoom(DataBaseStorage.getHouseArrayList().get(0), name);
    }

    @Override
    public void execute() {
        System.out.println("--Room: " + room.getName());
        for (int i = 0; i < room.devicesCount(); i++){
            System.out.println(room.getDevice(i));
        }

        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        new RedirectViewCommand(new RoomListScreen()).execute();
    }
}
