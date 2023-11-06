package me.wantsome.plugins.collect.manager;

import me.wantsome.plugins.collect.CollectPlugin;
import me.wantsome.plugins.collect.objects.Collect;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectManager {

    private final CollectPlugin plugin;

    public CollectManager(CollectPlugin plugin){
        this.plugin = plugin;
    }

    private final Set<Collect> heads = new HashSet<>();

    public void read(){
        Set<String> config = plugin.getHeadConfig().getHeadConfiguration().getKeys(true);
        if(config.size() == 0){
            plugin.getLogger().severe("heads.yml is empty! to add a collect head use command /c");
            return;
        }
        for(String names : plugin.getHeadConfig().getHeadConfiguration().getKeys(false)){
            ConfigurationSection section = plugin.getHeadConfig().getHeadConfiguration();

            String name = section.getString(names + ".name");
            String texture = section.getString(names + ".texture");
            Location location = plugin.getLocationUtility().readLocation(section.getConfigurationSection(names + ".location"));

            Collect head = new Collect(name, texture, location);

            List<String> players = section.getStringList(names + ".players");
            for(String key : players){
                head.addPlayer(key);
            }

            heads.add(head);
        }
    }

    //write collect object when command is set up, we then right-click the player head on the ground
    public void write(Collect collect){
        ConfigurationSection section = plugin.getHeadConfig().getHeadConfiguration();
        section.set(collect.getName(), null);
        section.set(collect.getName() + ".name", collect.getName());
        section.set(collect.getName() + ".texture", collect.getTexture());
        section.set(collect.getName() + ".location", collect.getLocation());
        section.set(collect.getName() + ".players", new ArrayList<>());

        plugin.getHeadConfig().saveHeadConfig();
    }

    public Set<Collect> getHeads() {
        return heads;
    }
}
