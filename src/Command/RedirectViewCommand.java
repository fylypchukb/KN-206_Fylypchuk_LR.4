package Command;

import Service.TimeControlled;
import UI.Screen;

public class RedirectViewCommand implements Command {

    private Screen screen = null;

    public RedirectViewCommand(Screen screen) {
        this.screen = screen;
    }


    @Override
    public void execute() {
        screen.showScreen();
    }
}
