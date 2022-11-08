package UI;

import Command.AddTimeDeviceCommand;
import Command.Command;
import Command.RedirectViewCommand;
import Service.TimeControlled;

import java.util.Scanner;

public class TimeControlledScreen implements Screen {

    @Override
    public void showScreen() {
        showContext();
        actionMaker();
    }

    private void showContext() {
        if (TimeControlled.getTimeControlledDevices().size() > 0)
            for (var device : TimeControlled.getTimeControlledDevices()) {
                System.out.println(device.stringTime());
            }
        else
            System.out.println("There is no time-controlled devices");
    }

    private void actionMaker() {
        Scanner scanner = new Scanner(System.in);
        Command command = null;

        while (command == null) {
            String input = scanner.nextLine();
            var words = input.split(" ");
            if (words[0].compareTo("/addTime") == 0) {
                command = new AddTimeDeviceCommand();
            } else if (words[0].compareTo("/reload") == 0) {
                command = new RedirectViewCommand(new TimeControlledScreen());
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
        System.out.println("Reload - /reload");
        System.out.println("Add time to device - /addTime");
        System.out.println("Delete time - /deleteTime");
        System.out.println("Main screen - /main");
    }
}
