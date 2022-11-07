package Model;

import java.util.ArrayList;
import java.util.List;

public class VirtualHouse {
    private List<Room> rooms;

    public VirtualHouse(){
        rooms = new ArrayList<Room>();
    }

    public void addRoom(Room toAdd){
        rooms.add(toAdd);
    }

    public void removeRoom(int index){
        rooms.remove(index);
    }

    public int roomCount(){
        return rooms.size();
    }

    public Room getRoom(int index){
        return rooms.get(index);
    }
}
