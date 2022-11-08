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
        StringBuilder name;

        Device result;
        try {
            id = Integer.parseInt(words[1]);
            result = SearchDevice.generalSearch(DataBaseStorage.getHouse(0), id);
        } catch (Exception e) {
            name = new StringBuilder(words[1]);

            if (words.length > 2)
                for (int i = 2; i < words.length; i++) {
                    name.append(" ").append(words[i]);
                }
            result = SearchDevice.generalSearch(DataBaseStorage.getHouse(0), name.toString());
        }

        if (result != null) {
            Room room = SearchRoom.searchRoomByDevice(DataBaseStorage.getHouse(0), result);
            assert room != null;
            System.out.println("Result: " + room.getName() + ": " + result);
            try {
                System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else
            System.out.println("Device is not found!");

        new RedirectViewCommand(new MainScreen()).execute();

    }
}
