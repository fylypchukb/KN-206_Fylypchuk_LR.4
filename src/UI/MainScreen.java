package UI;

import Command.RedirectViewCommand;
import DB.DataBaseStorage;

import java.util.Scanner;

public class MainScreen extends Screen {
    private DataBaseStorage dataBaseStorage = null;

    public MainScreen(){
        dataBaseStorage = new DataBaseStorage();
    }

    @Override
    public void showScreen(){
        System.out.println("\n1. Show devices");
        System.out.println("2. Show rooms");
        System.out.println("3. Calculate power consumption");

        actionChoose();
    }

    public void actionChoose(){
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        switch (input){
            case 1:
                RedirectViewCommand redirectView = new RedirectViewCommand( new DevicesListScreen());
                redirectView.execute();
            case 0:
                return;
        }
    }

}
