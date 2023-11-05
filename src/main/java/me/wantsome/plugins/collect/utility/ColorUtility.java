package me.wantsome.plugins.collect.utility;

import org.bukkit.ChatColor;

public class ColorUtility {

    public static String color(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
