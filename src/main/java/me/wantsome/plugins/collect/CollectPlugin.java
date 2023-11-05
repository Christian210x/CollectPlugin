package me.wantsome.plugins.collect;

import me.wantsome.plugins.collect.configs.MessageConfig;
import me.wantsome.plugins.collect.utility.ColorUtility;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CollectPlugin extends JavaPlugin {

    private CollectPlugin plugin;

    private MessageConfig messageConfig;
    private ColorUtility colorUtility;

    @Override
    public void onEnable() {
        this.plugin = this;

        initConfigs();

        this.colorUtility = new ColorUtility(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void initConfigs(){
        long start = System.currentTimeMillis();

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        this.messageConfig = new MessageConfig(this);

        Bukkit.getServer().getLogger().info("Successfully initialized Configs! [" + getTimeDifference(start, System.currentTimeMillis()) + "]");
    }

    public String getTimeDifference(long start, long end) {
        return (end - start) + "ms";
    }

    public MessageConfig getMessageConfig() {
        return this.messageConfig;
    }

    public ColorUtility getColorUtility(){
        return this.colorUtility;
    }

    public CollectPlugin getCollect() {
        return this.plugin;
    }
}
