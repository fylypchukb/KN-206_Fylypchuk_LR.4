package Command;

import DB.DataBaseStorage;
import Model.Device;
import Model.Room;
import Service.SearchDevice;
import Service.SearchRoom;
import UI.MainScreen;

import java.io.IOException;

public class SearchRoomScreenCommand implements Command {

    String request;

    public SearchRoomScreenCommand(String request) {
        this.request = request;
    }

    Device result;

    @Override
    public void execute() {
        var words = request.split(" ");
        Room room = SearchRoom.searchRoom(DataBaseStorage.getHouse(0), words[1]);

        if (room != null) {
            int id;
            StringBuilder name;
            try {
                id = Integer.parseInt(words[2]);
                result = SearchDevice.generalSearch(DataBaseStorage.getHouse(0), id);
            } catch (Exception e) {
                name = new StringBuilder(words[2]);

                for (int i = 2; i < words.length; i++) {
                    name.append(" ").append(words[i]);
                }
                result = SearchDevice.generalSearch(DataBaseStorage.getHouse(0), name.toString());
            }
        } else
            System.out.println("Room is not found!");

        if (result != null) {
            System.out.println("Result: " + result);
            try {
                System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else
            System.out.println("Device is not found");

        new RedirectViewCommand(new MainScreen()).execute();
    }
}
