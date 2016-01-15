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

    private SettingsManager() { }

    static SettingsManager instance = new SettingsManager();

    public static SettingsManager getInstance() { return instance; }

    Plugin p;

    FileConfiguration config;
    File cfile;
    @SuppressWarnings("static-access")
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
        config.options().header("Advanced Combat Tag version" + Bukkit.getPluginManager().getPlugin("ACT").getDescription().getVersion() + " Main Configuration "+
                "\n");
        config.addDefault("config.inCombat.DisabledCommands", Arrays.asList(new String[] {
                "spawn"
        }));
        config.addDefault("config.Settings.CombatTime", "10");
        config.addDefault("config.Messages.NoPermission", "&cNo permission");
        config.addDefault("config.Messages.TimeLeft", "&7You are in combat for &e%time &7seconds!");
        config.addDefault("config.Messages.NotInCombat", "&cYou are not in combat!");
        config.addDefault("config.CombatTriggers.PvPDamage", true);
        config.addDefault("config.CombatTriggers.BlockDamage", true);
        config.addDefault("config.CombatTriggers.DrowningDamage", true);
        config.addDefault("config.CombatTriggers.MobDamage", true);
        config.addDefault("config.CombatTriggers.CreeperDamage", true);
        config.addDefault("config.CombatTriggers.FallDamage", true);
        config.addDefault("config.CombatTriggers.FallingBlockDamage", true);
        config.addDefault("config.CombatTriggers.FireDamage", true);
        config.addDefault("config.CombatTriggers.LavaDamage", true);
        config.addDefault("config.CombatTriggers.LightningDamage", true);
        config.addDefault("config.CombatTriggers.MagicDamage", true);
        config.addDefault("config.CombatTriggers.MeltingDamage", true);
        config.addDefault("config.CombatTriggers.PoisonDamage", true);
        config.addDefault("config.CombatTriggers.ProjectileDamage", true);
        config.addDefault("config.CombatTriggers.HungerDamage", true);
        config.addDefault("config.CombatTriggers.SuffocationDamage", true);
        config.addDefault("config.CombatTriggers.ThornsDamage", true);
        config.addDefault("config.CombatTriggers.WitherDamage", true);
        config.options().copyDefaults(true);
        saveData();
        reloadData();
    }
    public int loadDisabledCommands(){
        if(!config.contains("config.inCombat.DisabledCommands")){
            return 0;
        }

        Core.commands = config.getStringList("config.inCombat.DisabledCommands");

        return Core.commands.size();
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
