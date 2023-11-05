package me.wantsome.plugins.collect.configs;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class MessageConfig {

    private final File messageFile;
    private YamlConfiguration messageFileConfig;

    public MessageConfig(Plugin plugin){
        if(!plugin.getDataFolder().exists()){
            plugin.getDataFolder().mkdirs();
        }
        this.messageFile = new File(plugin.getDataFolder(), "messages.yml");
        if(!this.messageFile.exists()){
            try {
                this.messageFile.createNewFile();
                this.messageFileConfig = YamlConfiguration.loadConfiguration(messageFile);
                this.messageFileConfig.set("collect-head", "You have collected a head!");
                this.messageFileConfig.set("obtained-head", "You already have this head! Go find a different one!");
                this.messageFileConfig.save(messageFile);
                plugin.getLogger().info("Message Config has been Created!");
            }catch (IOException exception){
                plugin.getLogger().info("Message Config was not Created! Plugin Shutting Down!");
                plugin.getServer().getPluginManager().disablePlugin(plugin);
                exception.printStackTrace();
            }
        }
        if(messageFileConfig == null){
            plugin.getLogger().info("Message Config can not Load! Plugin Shutting Down!");
            plugin.getServer().getPluginManager().disablePlugin(plugin);
        }else{
            plugin.getLogger().info("Message Config has Been Loaded!");
            messageFileConfig = YamlConfiguration.loadConfiguration(messageFile);
        }
    }

    public FileConfiguration getMessageFileConfig(){
        return this.messageFileConfig;
    }

    public void saveMessageConfig(){
        try{
            this.messageFileConfig.save(this.messageFile);
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    public void reloadMessageConfig(){
            this.messageFileConfig = YamlConfiguration.loadConfiguration(messageFile);
    }

}
