package me.wantsome.plugins.collect.commands;

import me.wantsome.plugins.collect.CollectPlugin;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.List;

public class CollectCommand implements CommandExecutor, TabCompleter {

    private final CollectPlugin plugin;

    public CollectCommand(CollectPlugin plugin){
        this.plugin = plugin;
        PluginCommand command = plugin.getCommand("c");
        command.setExecutor(this);
        command.setTabCompleter(this);
    }

    /*  TODO LIST
        should i separate add and list commands with two classes
        need to add cancel command to this class or add another class
    */

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("You are not a player");
            return false;
        }

        Player player = (Player) sender;
        if(!player.hasPermission("collect.admin")){
            player.sendMessage(plugin.getColorUtility().color("&4You do not have permission to use this command!"));
            return true;
        }

        if(args.length == 0){
            player.sendMessage(plugin.getColorUtility().color("&7/c &7[&4add&7|&4list&7]"));
            return true;
        }

        if(args.length == 1){
            if(args[0].equalsIgnoreCase("list")){
                player.sendMessage("test!");
            }
            if(args[0].equalsIgnoreCase("add")){
                player.sendMessage(plugin.getColorUtility().color("&7/c &7[&4add&7] &7[&4name&7] &7[&4texture&7|&4null&7]"));
            }
            return true;
        }

        switch (args.length){
            case 2:
                if(args[0].equalsIgnoreCase("add")){
                    String headName = args[1];
                    player.sendMessage("[debug] Head: " + headName);
                }
                break;
            case 3:
                if(args[0].equalsIgnoreCase("add")){
                    String headName = args[1];
                    String texture = args[2];
                    player.sendMessage("[debug] Head: " + headName + " " + "Texture: " + texture);
                }
                break;
            default:
                player.sendMessage(plugin.getColorUtility().color("&7/c &7[&4add&7|&4list&7]"));
                break;
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) return null;
        Player player = (Player) sender;
        if(!player.hasPermission("collect.admin")) return null;
        if(args.length == 1) return List.of("add", "list");
        if(args.length == 2) return List.of("name");
        if(args.length == 3) return List.of("texture");
        return null;
    }
}
