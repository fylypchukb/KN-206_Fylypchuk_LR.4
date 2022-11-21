package Command;

import Logger.LoggingClass;
import UI.Screen;

import java.util.logging.Level;

public class RedirectViewCommand implements Command {

    private final Screen screen;

    public RedirectViewCommand(Screen screen) {
        this.screen = screen;
    }


    @Override
    public void execute() {
        LoggingClass.logger.log(Level.INFO, "Redirected to " + screen.getClass().getName());

        screen.showScreen();
    }
}
