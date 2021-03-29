package Ping;

import java.util.ArrayList;

public class Day {
    public String Name;
    private final ArrayList<String> Events;

    public Day(){
        this.Name = "Day";
        this.Events = new ArrayList<>();
    }

    public Day(String name){
        this.Name = name;
        this.Events = new ArrayList<>();
    }

    public void addEvent(String event){
        this.Events.add(event);
    }

    public void removeEvent(int index){
        this.Events.remove(index);
    }

    public void editEvent(int index, String event){
        this.Events.remove(index);
        this.Events.add(event);
    }

    public String getDay(){
        return this.Name;
    }

    public ArrayList getEvents(){
        return this.Events;
    }
}

