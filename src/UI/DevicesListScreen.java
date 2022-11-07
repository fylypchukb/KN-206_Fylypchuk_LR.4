package UI;

import Command.ActiveDeviceListCommand;
import Command.SwitchCommand;
import DB.DataBaseStorage;
import Model.Room;
import Service.SearchDevice;

import java.util.Scanner;

public class DevicesListScreen extends Screen {

    public DevicesListScreen() {
    }

    @Override
    public void showScreen() {
        showListDevices();
        actionMaker();
    }

    private void showListDevices() {
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
        String input = scanner.nextLine();
        var words = input.split(" ");
        if (words[0].compareTo("/switch") == 0) {
            SwitchCommand command =
                    new SwitchCommand(SearchDevice.generalSearch(DataBaseStorage.getHouseArrayList().get(0),
                            Integer.parseInt(words[1])));
            command.execute();
        } else if (words[0].compareTo("/active") == 0) {
            ActiveDeviceListCommand command = new ActiveDeviceListCommand();
            command.execute();
        } else if (words[0].compareTo("/add") == 0) {
            // todo: add device action
        } else if (words[0].compareTo("/delete") == 0) {
            // todo: delete device action
        } else if (words[0].compareTo("/sort") == 0) {
            // todo: sort action
        } else if(words[0].compareTo("/help") == 0){
            printHelp();
        }
    }

    private void printHelp() {
        System.out.println("Activate/Deactivate - /switch {id}");
        System.out.println("Show only active - /active");
        System.out.println("Add device - /add");
        System.out.println("Delete device - /delete");
        System.out.println("Sort - /sort");
    }
}
