package Model;

public class Device {
    private final String name;
    private final int id;
    private final double electricPower;
    private boolean isActive;


    public Device(String name, int id, double electricPower) {
        this.name = name;
        this.id = id;
        this.electricPower = electricPower;
        isActive = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getElectricPower() {
        return (isActive) ? electricPower : 0;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        String toReturn = getName() + " - " + getId() + " - ";
        toReturn += (isActive) ? "Activated" : "Deactivated";

        return toReturn;
    }

    public String stingPower() {
        String toReturn = this.toString();

        return toReturn + " - " + ((isActive) ? electricPower : 0);
    }

}
