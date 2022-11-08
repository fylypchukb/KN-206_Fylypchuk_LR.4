package Command;

import DB.DataBaseStorage;
import Model.Device;
import Service.SearchDevice;
import Service.TimeControlled;
import UI.DevicesListScreen;
import UI.Screen;
import UI.TimeControlledScreen;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AddTimeDeviceCommand implements Command{

    @Override
    public void execute() {
        DevicesListScreen.showListDevices();

        System.out.print("\nSelect device (id): ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        Device device = SearchDevice.generalSearch(DataBaseStorage.getHouse(0), id);

        System.out.print("Enter the Date (dd-MM-yyyy HH:mm:ss): ");
        scanner.nextLine();
        String inputDate = scanner.nextLine();

        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime dateTime = null;
        try {
            dateTime = LocalDateTime.parse(inputDate, myFormatObj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        TimeControlled.switchOnTime(device, dateTime);
        new RedirectViewCommand(new TimeControlledScreen()).execute();
    }
}
