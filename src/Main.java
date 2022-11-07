import DB.DataBaseStorage;
import UI.MainScreen;

public class Main {
    public static void main(String[] args) {
        DataBaseStorage dataBaseStorage = new DataBaseStorage();
        MainScreen mainScreen = new MainScreen();
        mainScreen.showScreen();
    }
}