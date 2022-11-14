package UI;

import Command.RedirectViewCommand;

import java.util.Scanner;

public class MainScreen implements Screen {

    public MainScreen() {

    }

    @Override
    public void showScreen() {
        System.out.println("\n1. Show devices");
        System.out.println("2. Show rooms");
        System.out.println("3. Calculate power consumption");
        System.out.println("4. Search for device");

        actionChoose();
    }

    public void actionChoose() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        RedirectViewCommand command;

        switch (input) {
            case 1:
                command = new RedirectViewCommand(new DevicesListScreen());
                command.execute();
                break;
            case 2:
                command = new RedirectViewCommand(new RoomListScreen());
                command.execute();
                break;
            case 3:
                command = new RedirectViewCommand(new ElectricalPowerScreen());
                command.execute();
                break;
            case 4:
                command = new RedirectViewCommand(new SearchScreen());
                command.execute();
                break;
            case 0:
        }


    }

}
