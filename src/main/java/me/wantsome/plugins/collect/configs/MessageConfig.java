package me.wantsome.plugins.collect.configs;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class MessageConfig {

    private final File messageFile;
    private final YamlConfiguration messageFileConfig;

    public MessageConfig(Plugin plugin){
        if(!plugin.getDataFolder().exists()){
            plugin.getDataFolder().mkdirs();
        }
        this.messageFile = new File(plugin.getDataFolder(), "messages.yml");
        if(!messageFile.exists()){
            try {
                this.messageFile.createNewFile();

                //this is where we will populate config messages for collect!

            }catch (IOException exception){
                exception.printStackTrace();
            }
        }
        this.messageFileConfig = new YamlConfiguration();
        try{
            this.messageFileConfig.load(this.messageFile);
        }catch (IOException | InvalidConfigurationException exception){
            exception.printStackTrace();
        }
    }

    public YamlConfiguration getMessageFileConfig(){
        return this.messageFileConfig;
    }

    public void saveMessageConfig(){
        try{
            this.messageFileConfig.save(messageFile);
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

}
