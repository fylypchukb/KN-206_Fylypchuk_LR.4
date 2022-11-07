package Command;

import DB.DataBaseStorage;
import Model.Device;
import Model.Room;
import Service.SearchDevice;
import Service.SearchRoom;
import UI.MainScreen;

import java.io.IOException;

public class SearchHouseScreenCommand implements Command {

    String request;

    public SearchHouseScreenCommand(String request) {
        this.request = request;
    }

    @Override
    public void execute() {
        var words = request.split(" ");
        int id;
        String name;

        Device result;
        try {
            id = Integer.parseInt(words[1]);
            result = SearchDevice.generalSearch(DataBaseStorage.getHouse(0), id);
        } catch (Exception e) {
            name = words[1];

            if (words.length > 2)
                for (int i = 2; i < words.length; i++) {
                    name += " " + words[i];
                }
            result = SearchDevice.generalSearch(DataBaseStorage.getHouse(0), name);
        }

        Room room = SearchRoom.searchRoomByDevice(DataBaseStorage.getHouse(0), result);
        System.out.println("Result: " + room.getName() + ": " + result);
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        new RedirectViewCommand(new MainScreen()).execute();

    }
}
