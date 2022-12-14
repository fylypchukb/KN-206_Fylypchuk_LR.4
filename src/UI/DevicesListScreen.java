package UI;

import Command.*;
import DB.DataBaseStorage;
import Logger.LoggingClass;
import Model.Room;

import java.util.Scanner;
import java.util.logging.Level;

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

        if (list == null){
            LoggingClass.logger.log(Level.SEVERE, "Database is empty");
        }

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
                command = new SwitchCommand(words[1]);
            } else if (words[0].compareTo("/active") == 0) {
                command = new ActiveDeviceListCommand();
            } else if (words[0].compareTo("/add") == 0) {
                command = new AddDeviceCommand(words[1]);
            } else if (words[0].compareTo("/delete") == 0) {
                command = new DeleteDeviceCommand(words[1]);
            } else if (words[0].compareTo("/sort") == 0) {
                command = new SortDeviceListScreenCommand();
            } else if (words[0].compareTo("/help") == 0) {
                printHelp();
            } else if (words[0].compareTo("/main") == 0) {
                command = new RedirectViewCommand(new MainScreen());
            } else
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
