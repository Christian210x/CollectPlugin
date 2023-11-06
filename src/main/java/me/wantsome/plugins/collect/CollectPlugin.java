package me.wantsome.plugins.collect;

import me.wantsome.plugins.collect.configs.HeadConfig;
import me.wantsome.plugins.collect.configs.MessageConfig;
import me.wantsome.plugins.collect.listeners.CollectListener;
import me.wantsome.plugins.collect.manager.CollectManager;
import me.wantsome.plugins.collect.utility.ColorUtility;
import me.wantsome.plugins.collect.utility.LocationUtility;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class CollectPlugin extends JavaPlugin {

    private CollectPlugin plugin;

    private HeadConfig headConfig;
    private MessageConfig messageConfig;

    private ColorUtility colorUtility;
    private LocationUtility locationUtility;

    private CollectListener collectListener;
    private CollectManager collectManager;

    @Override
    public void onEnable() {
        this.plugin = this;

        initConfigs();
        initCommands();
        initEvents();

        this.colorUtility = new ColorUtility(this);
        this.locationUtility = new LocationUtility(this);
        this.collectManager = new CollectManager(this);

        collectManager.read();
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(collectListener);
    }

    private void initConfigs(){
        long start = System.currentTimeMillis();

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        this.headConfig = new HeadConfig(this);
        this.messageConfig = new MessageConfig(this);

        Bukkit.getServer().getLogger().info("Successfully initialized configs! [" + getTimeDifference(start, System.currentTimeMillis()) + "]");
    }

    private void initCommands(){
        long start = System.currentTimeMillis();

        this.collectListener = new CollectListener(this);

        Bukkit.getServer().getLogger().info("Successfully initialized commands! [" + getTimeDifference(start, System.currentTimeMillis()) + "]");
    }

    private void initEvents(){
        long start = System.currentTimeMillis();

        new CollectListener(this);

        Bukkit.getServer().getLogger().info("Successfully initialized events! [" + getTimeDifference(start, System.currentTimeMillis()) + "]");
    }

    public String getTimeDifference(long start, long end) {
        return (end - start) + "ms";
    }

    public HeadConfig getHeadConfig() {
        return headConfig;
    }

    public MessageConfig getMessageConfig() {
        return this.messageConfig;
    }

    public ColorUtility getColorUtility(){
        return this.colorUtility;
    }

    public LocationUtility getLocationUtility(){
        return this.locationUtility;
    }

    public CollectManager getCollectManager() {
        return collectManager;
    }

    public CollectPlugin getPlugin() {
        return this.plugin;
    }
}
