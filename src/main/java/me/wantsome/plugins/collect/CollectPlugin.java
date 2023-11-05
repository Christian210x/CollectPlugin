package me.wantsome.plugins.collect;

import me.wantsome.plugins.collect.configs.MessageConfig;
import org.bukkit.plugin.java.JavaPlugin;

public final class CollectPlugin extends JavaPlugin {

    private CollectPlugin plugin;

    private MessageConfig messageConfig;

    @Override
    public void onEnable() {
        this.plugin = this;

        initConfigs();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    private void initConfigs(){
        this.messageConfig = new MessageConfig(this);
    }

    public String getTimeDifference(long start, long end) {
        return (end - start) + "ms";
    }

    public CollectPlugin getPlugin() {
        return plugin;
    }
}
