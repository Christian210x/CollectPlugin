package me.wantsome.plugins.collect.listeners;

import me.wantsome.plugins.collect.CollectPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class CollectListener implements Listener {

    private CollectPlugin plugin;

    public CollectListener(CollectPlugin plugin){
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void interact(PlayerInteractEvent event){

    }



}
