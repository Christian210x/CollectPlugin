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
            plugin.saveResource("messages.yml", false);
            plugin.getLogger().info("Message Config has been Created!");
        }

        messageFileConfig = new YamlConfiguration();
        messageFileConfig.options().parseComments(true);

        try {
            this.messageFileConfig.load(messageFile);
        }catch (Exception exception){
            plugin.getLogger().info("Message Config did not Load! Plugin Shutting Down!");
            plugin.getServer().getPluginManager().disablePlugin(plugin);
            exception.printStackTrace();
        }
    }

    public FileConfiguration getMessageFileConfiguration(){
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
            this.messageFileConfig = YamlConfiguration.loadConfiguration(this.messageFile);
    }

}
