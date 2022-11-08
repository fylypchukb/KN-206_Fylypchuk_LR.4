package UI;

import Command.*;
import DB.DataBaseStorage;
import Model.Room;
import Service.SearchDevice;
import Service.SearchRoom;

import java.util.Scanner;

public class DevicesListScreen implements Screen {

    public DevicesListScreen() {
    }

    @Override
    public void showScreen() {
        showListDevices();
        actionMaker();
    }

    public static void showListDevices() {
        var list = DataBaseStorage.getHouseArrayList();

        for (int i = 0; i < list.get(0).roomCount(); i++) {
            Room room = list.get(0).getRoom(i);
            System.out.println("\n-----" + "Room: " + room.getName());
            for (int j = 0; j < room.devicesCount(); j++) {
                System.out.println(room.getDevice(j));
            }
        }
    }

    private void actionMaker() {
        Scanner scanner = new Scanner(System.in);
        Command command = null;

        while (command == null) {
            String input = scanner.nextLine();
            var words = input.split(" ");
            if (words[0].compareTo("/switch") == 0) {
                command = new SwitchCommand(SearchDevice.generalSearch(DataBaseStorage.getHouseArrayList().get(0),
                        Integer.parseInt(words[1])));
            } else if (words[0].compareTo("/active") == 0) {
                command = new ActiveDeviceListCommand();
            } else if (words[0].compareTo("/add") == 0) {
                command = new AddDeviceCommand(SearchRoom.searchRoom(DataBaseStorage.getHouseArrayList().get(0), words[1]));

            } else if (words[0].compareTo("/delete") == 0) {
                command = new DeleteDeviceCommand(SearchDevice.generalSearch(DataBaseStorage.getHouseArrayList().get(0),
                        Integer.parseInt(words[1])));
            } else if (words[0].compareTo("/sort") == 0) {
                command = new SortDeviceListScreenCommand();
            } else if (words[0].compareTo("/help") == 0) {
                printHelp();
            } else if (words[0].compareTo("/main") == 0) {
                command = new RedirectViewCommand(new MainScreen());
            }
            else
                System.out.println("Command not found! Type \"/help\"");
        }

        command.execute();
    }

    private void printHelp() {
        System.out.println("Activate/Deactivate - /switch {id}");
        System.out.println("Show only active - /active");
        System.out.println("Add device - /add {roomName}");
        System.out.println("Delete device - /delete {id}");
        System.out.println("Sort - /sort");
        System.out.println("Main screen - /main");
    }
}
