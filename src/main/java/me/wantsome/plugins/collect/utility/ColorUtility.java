package me.wantsome.plugins.collect.utility;

import me.wantsome.plugins.collect.CollectPlugin;
import org.bukkit.ChatColor;

public class ColorUtility {

    private final CollectPlugin plugin;

    public ColorUtility(CollectPlugin plugin){
        this.plugin = plugin;
    }

    public String color(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public String decolor(String message){
        return ChatColor.stripColor(message);
    }

}
