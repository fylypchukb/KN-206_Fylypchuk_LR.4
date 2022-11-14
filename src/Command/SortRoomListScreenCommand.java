package Command;

import DB.DataBaseStorage;
import Model.Room;
import Service.ElectricPower;
import Service.SortRooms;
import UI.RoomListScreen;

import java.io.IOException;
import java.util.ArrayList;

public class SortRoomListScreenCommand implements Command {


    @Override
    public void execute() {
        ArrayList<Room> sort = SortRooms.sortRooms(DataBaseStorage.getHouse(0));

        for (Room room : sort) {
            System.out.println(room.getName() + " - " + ElectricPower.calculateGeneralInRoom(room));
        }

        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        new RedirectViewCommand(new RoomListScreen()).execute();
    }
}
