package me.wantsome.plugins.collect.commands;

import me.wantsome.plugins.collect.CollectPlugin;
import org.bukkit.command.*;

import java.util.List;

public class CollectCommand implements CommandExecutor, TabCompleter {

    private CollectPlugin plugin;

    public CollectCommand(CollectPlugin plugin){
        this.plugin = plugin;
        PluginCommand command = plugin.getCommand("c");
        command.setExecutor(this);
        command.setTabCompleter(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String s, String[] args) {
        return null;
    }
}
