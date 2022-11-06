package Command;

import UI.Screen;

public class RedirectView implements Command{

    private Screen screen = null;

    public RedirectView(Screen screen){
        this.screen = screen;
    }


    @Override
    public void execute() {
        screen.showScreen();
    }
}
