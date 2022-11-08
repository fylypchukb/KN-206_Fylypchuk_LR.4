package UI;

import Command.Command;
import Command.RedirectViewCommand;
import Command.SearchHouseScreenCommand;
import Command.SearchRoomScreenCommand;

import java.util.Scanner;

public class SearchScreen implements Screen {

    @Override
    public void showScreen() {
        screenContext();
    }

    private void screenContext() {

        System.out.println("\n1. Search in the house");
        System.out.println("2. Search in the room");
        System.out.println("0. Main screen");

        Scanner scanner = new Scanner(System.in);
        int inputInt = scanner.nextInt();

        while (inputInt != 1 && inputInt != 2 && inputInt != 0) {
            System.out.println("Choice is incorrect. Try again");
            inputInt = scanner.nextInt();
        }

        String inputString;
        Command command = null;
        if (inputInt == 1) {
            System.out.println("Help: \"/search {id}\" or \n\"/search {name}\"");
            scanner.nextLine();
            inputString = scanner.nextLine();
            command = new SearchHouseScreenCommand(inputString);
        } else if (inputInt == 2) {
            System.out.println("Help: \"/search {roomName} {id}\" or \"/search {roomName} {name}\"");
            scanner.nextLine();
            inputString = scanner.nextLine();
            command = new SearchRoomScreenCommand(inputString);

        } else {
            command = new RedirectViewCommand(new MainScreen());
        }

        command.execute();
    }
}
