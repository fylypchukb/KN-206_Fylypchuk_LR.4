package Command;

import DB.DataBaseStorage;
import Model.Device;
import Model.Room;
import Service.SearchDevice;
import Service.SearchRoom;
import UI.MainScreen;

import java.io.IOException;

public class SearchRoomScreenCommand implements Command{

    String request;

    public SearchRoomScreenCommand(String request) {
        this.request = request;
    }

    @Override
    public void execute() {
        var words = request.split(" ");
        Room room = SearchRoom.searchRoom(DataBaseStorage.getHouse(0), words[1]);

        int id;
        StringBuilder name;
        Device result;
        try {
            id = Integer.parseInt(words[2]);
            result = SearchDevice.generalSearch(DataBaseStorage.getHouse(0), id);
        } catch (Exception e) {
            name = new StringBuilder(words[2]);

            if (words.length > 2)
                for (int i = 2; i < words.length; i++) {
                    name.append(" ").append(words[i]);
                }
            result = SearchDevice.generalSearch(DataBaseStorage.getHouse(0), name.toString());
        }

        System.out.println("Result: " + result);
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        new RedirectViewCommand(new MainScreen()).execute();
    }
}
