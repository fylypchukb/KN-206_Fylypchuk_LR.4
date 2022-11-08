package Model;

import java.util.ArrayList;

public class VirtualHouse {
    private final ArrayList<Room> rooms;

    public VirtualHouse() {
        rooms = new ArrayList<>();
    }

    public void addRoom(Room toAdd) {
        rooms.add(toAdd);
    }

    public void removeRoom(int index) {
        rooms.remove(index);
    }

    public int roomCount() {
        return rooms.size();
    }

    public Room getRoom(int index) {
        return rooms.get(index);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
}
