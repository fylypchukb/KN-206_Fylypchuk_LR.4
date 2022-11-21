package UI;

import Command.Command;
import Command.RedirectViewCommand;
import DB.DataBaseStorage;
import Logger.LoggingClass;
import Model.Room;
import Model.VirtualHouse;
import Service.ElectricPower;

import java.util.Scanner;
import java.util.logging.Level;

public class ElectricalPowerScreen implements Screen {

    @Override
    public void showScreen() {
        showContext();
        actionMaker();
    }

    private void showContext() {
        VirtualHouse house = DataBaseStorage.getHouse(0);

        if (house == null){
            LoggingClass.logger.log(Level.SEVERE, "Database is empty");
        }

        System.out.println("\nTotal in the house - "
                + ElectricPower.calculateGeneralInHome(house) + "\n");

        for (int i = 0; i < house.roomCount(); i++) {
            Room room = house.getRoom(i);
            double power = ElectricPower.calculateGeneralInRoom(room);
            System.out.println(i + 1 + ". " + room.getName() + " - " + power + " W");
        }
    }

    private void actionMaker() {
        Scanner scanner = new Scanner(System.in);
        Command command = null;
        while (command == null) {
            String input = scanner.nextLine();
            var words = input.split(" ");

            if (words[0].compareTo("/main") == 0) {
                command = new RedirectViewCommand(new MainScreen());
            } else if (words[0].compareTo("/help") == 0)
                System.out.println("/main - return to main menu");
            else
                System.out.println("Command not found! Type \"/help\"");
        }

        command.execute();
    }
}
