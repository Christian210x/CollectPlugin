package me.wantsome.plugins.collect.utility;

import me.wantsome.plugins.collect.CollectPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.ConfigurationSection;

public class LocationUtility {

    private CollectPlugin plugin;

    public LocationUtility(CollectPlugin plugin){
        this.plugin = plugin;
    }

    public void writeLocation(Location location, ConfigurationSection section){
        section.set("worldName", location.getWorld().getName());
        section.set("x", location.getX());
        section.set("y", location.getY());
        section.set("z", location.getZ());
        section.set("yaw", location.getYaw());
        section.set("pitch", location.getPitch());
    }

    public Location readLocation(ConfigurationSection section){
        World world = Bukkit.createWorld(new WorldCreator(section.getString("worldName")));
        return new Location(world,
                section.getDouble("x"),
                section.getDouble("y"),
                section.getDouble("z"),
                (float) section.getDouble("yaw"),
                (float) section.getDouble("pitch"));
    }

    public boolean blockCoordinatesMatch(Location loc1, Location loc2){
        if(loc1 == null || loc2 == null) return false;
        return loc1.getBlockX() == loc2.getBlockX() &&
                loc1.getBlockY() == loc2.getBlockY() &&
                loc1.getBlockZ() == loc2.getBlockZ();
    }

    public String locationToString(Location location){
        return "X: " + location.getX() + " Y: " + location.getY() + " Z: " + location.getZ();
    }
}
