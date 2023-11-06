package me.wantsome.plugins.collect.configs;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class HeadConfig {

    private final File headFile;
    private YamlConfiguration headFileConfig;

    public HeadConfig(Plugin plugin){
        if(!plugin.getDataFolder().exists()){
            plugin.getDataFolder().mkdirs();
        }
        this.headFile = new File(plugin.getDataFolder(), "heads.yml");
        if(!this.headFile.exists()){
            plugin.saveResource("heads.yml", false);
            plugin.getLogger().info("Head Config has been Created!");
        }

        headFileConfig = new YamlConfiguration();
        headFileConfig.options().parseComments(true);

        try {
            headFileConfig.load(headFile);
        }catch (Exception exception){
            plugin.getLogger().info("Head Config did not Load! Plugin Shutting Down!");
            plugin.getServer().getPluginManager().disablePlugin(plugin);
            exception.printStackTrace();
        }
    }

    public FileConfiguration getHeadConfiguration(){
        return this.headFileConfig;
    }

    public void saveHeadConfig(){
        try{
            this.headFileConfig.save(this.headFile);
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    public void reloadHeadConfig(){
        this.headFileConfig = YamlConfiguration.loadConfiguration(this.headFile);
    }

}
