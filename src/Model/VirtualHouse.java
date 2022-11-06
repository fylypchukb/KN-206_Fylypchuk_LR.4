package Model.Rooms.Devices;

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

    public void removeRoom(String name){
        for (int i = 0; i < rooms.size(); i++){
            if (rooms.get(i).getName().compareToIgnoreCase(name) == 0){
                rooms.remove(i);
                break;
            }
        }
    }

    public int roomCount(){
        return rooms.size();
    }

    public Room getRoom(int index){
        return rooms.get(index);
    }
}
