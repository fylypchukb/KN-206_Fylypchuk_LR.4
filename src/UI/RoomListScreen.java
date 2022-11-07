package UI;

import Command.*;
import DB.DataBaseStorage;
import Model.Room;

import java.util.Scanner;

public class RoomListScreen implements Screen {

    @Override
    public void showScreen() {
        showListRooms();
        actionMaker();
    }

    private void showListRooms() {
        var list = DataBaseStorage.getHouseArrayList();

        System.out.println();
        for (int i = 0; i < list.get(0).roomCount(); i++) {
            Room room = list.get(0).getRoom(i);
            System.out.println(i + 1 + ". " + room.getName() + " - " + room.devicesCount() + " devices");
        }
    }

    private void actionMaker() {
        Scanner scanner = new Scanner(System.in);
        Command command = null;
        while (command == null) {
            String input = scanner.nextLine();
            var words = input.split(" ");

            if (words[0].compareTo("/show") == 0) {
                command = new ShowDevicesInRoomCommand(words[1]);
            } else if (words[0].compareTo("/add") == 0) {
                command = new AddRoomCommand();
            } else if (words[0].compareTo("/delete") == 0) {
                command = new DeleteRoomCommand(words[1]);
            } else if (words[0].compareTo("/main") == 0) {
                command = new RedirectViewCommand(new MainScreen());
            } else
                System.out.println("Command not found!");
        }

        command.execute();
    }

    private void printHelp() {
        System.out.println("Show devices in room - /show {roomName}");
        System.out.println("Add room - /add");
        System.out.println("Delete room - /delete {roomName}");
        System.out.println("Sort by power consumption - /sort");
        System.out.println("Main screen - /main");
    }
}

