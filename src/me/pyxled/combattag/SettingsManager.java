package me.pyxled.combattag;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;

/**
 * Pyxled Development 2016 (c)
 * File created: 01/11/2016
 */
public class SettingsManager {

    Core core = new Core();

    private SettingsManager() { }

    static SettingsManager instance = new SettingsManager();

    public static SettingsManager getInstance() { return instance; }

    Plugin p;

    FileConfiguration config;
    File cfile;

    public void setup(Plugin p){
        cfile = new File(p.getDataFolder(), "config.yml");
        config = p.getConfig();

        if(!p.getDataFolder().exists()){
            p.getDataFolder().mkdir();
            try{
                cfile.createNewFile();
            }
            catch (IOException e){
                Bukkit.getLogger().log(Level.SEVERE, "Configuration Exception! [Could not Generate Configuration File.]");
            }
        }
        config = YamlConfiguration.loadConfiguration(cfile);
        loadDefaults();
    }
    public void loadDefaults(){
        config.options().header("Advanced Combat Tag version" + core.getDescription().getVersion() + " Main Configuration "+
                "\n");
        config.addDefault("config.inCombat.DisabledCommands", Arrays.asList(new String[] {
                "spawn"
        }));
        config.addDefault("config.CombatTriggers.BlockDamage", true);
        config.options().copyDefaults(true);
        saveData();
        reloadData();
    }
    public int loadDisabledCommands(){
        if(!config.contains("config.inCombat.DisabledCommands")){
            return 0;
        }

        core.commands = config.getStringList("config.inCombat.DisabledCommands");

        return core.commands.size();
    }
    public void saveData(){
        try{
            config.save(cfile);
        }
        catch (IOException e){
            Bukkit.getLogger().log(Level.SEVERE, "Configuration Exception! [Could not Save Configuration File.]");
        }
    }
    public FileConfiguration getConfig(){ return config; }
    public void reloadData(){
        config = YamlConfiguration.loadConfiguration(cfile);
    }
}
