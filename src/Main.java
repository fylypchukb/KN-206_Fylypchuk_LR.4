import DB.DataBaseStorage;
import UI.MainScreen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataBaseStorage dataBaseStorage = new DataBaseStorage();
        MainScreen mainScreen = new MainScreen();
        mainScreen.showScreen();
    }
}