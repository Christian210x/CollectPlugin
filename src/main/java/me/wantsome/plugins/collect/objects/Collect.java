package me.wantsome.plugins.collect.objects;

import org.bukkit.Location;

import java.util.*;

public class Collect {

    //we could not do player files, we could actually use a list of uuids and then add that to the object and yeah...

    private String name;
    private String texture;
    private Location location;

    private List<String> players;

    public Collect(String name, String texture, Location location){
        this.name = name;
        this.texture = texture;
        this.location = location;

        players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public Location getLocation() {
        return location;
    }

    //we might have to modify this location
    public void setLocation(Location location) {
        this.location = location;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void addPlayer(String player) {
        List<String> list = this.players;
        list.add(player);
        this.players = list;
    }

    public void removePlayer(String player) {
        List<String> list = this.players;
        if(list.contains(player)){
            list.remove(player);
            this.players = list;
        }
    }

}
