package Command;

import DB.DataBaseStorage;
import Logger.LoggingClass;
import Model.Room;
import Service.ElectricPower;
import Service.SortRooms;
import UI.RoomListScreen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;

public class SortRoomListScreenCommand implements Command {


    @Override
    public void execute() {
        ArrayList<Room> sort = SortRooms.sortRooms(DataBaseStorage.getHouse(0));

        if (sort == null) {
            LoggingClass.logger.log(Level.SEVERE, "Sorting was unsuccessful");
        } else {

            for (Room room : sort) {
                System.out.println(room.getName() + " - " + ElectricPower.calculateGeneralInRoom(room));
            }

            LoggingClass.logger.log(Level.INFO, "Sorting completed");

            try {
                System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        new RedirectViewCommand(new RoomListScreen()).execute();
    }
}
