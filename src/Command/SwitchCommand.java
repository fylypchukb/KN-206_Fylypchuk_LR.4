package Command;

import Model.Device;
import UI.DevicesListScreen;

public class SwitchCommand implements Command {

    private Device device;

    public SwitchCommand(Device device){
        this.device = device;
    }

    @Override
    public void execute() {
        device.setActive(!device.getIsActive());
        var forAction= new RedirectView(new DevicesListScreen());
        forAction.execute();
    }
}