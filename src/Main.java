import DB.DataBaseStorage;
import Logger.LoggingClass;
import UI.MainScreen;

public class Main {
    public static void main(String[] args) {
        DataBaseStorage dataBaseStorage = new DataBaseStorage();

        LoggingClass loggingClass = new LoggingClass();

        MainScreen mainScreen = new MainScreen();
        mainScreen.showScreen();
    }
}