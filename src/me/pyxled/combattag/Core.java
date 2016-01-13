package me.pyxled.combattag;

import me.pyxled.combattag.events.DamageEvent;
import me.pyxled.combattag.events.PlayerHitPlayerEvent;
import me.pyxled.combattag.events.QuitEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.List;

/**
 * Pyxled Development 2016 (c)
 * File created: 01/11/2016
 */
public class Core extends JavaPlugin {

    public PluginManager pm;
    public String link = "&e&n[INSERT LINK HERE]";
    public List<String> commands;
    public HashMap<Player, Integer> combatTagTime;
    public HashMap<Player, BukkitRunnable> combatTagTask;
    SettingsManager settings = SettingsManager.getInstance();

    @Override
    public void onEnable(){
        //
        SettingsManager.getInstance().setup(this);
        settings.loadDisabledCommands();
        combatTagTime = new HashMap<>();
        combatTagTask = new HashMap<>();
        //
        StartupMSG();
        RegisterListeners();
    }
    public void RegisterListeners(){
        pm.registerEvents(new DamageEvent(), this);
        pm.registerEvents(new PlayerHitPlayerEvent(), this);
        pm.registerEvents(new QuitEvent(), this);
    }
    public String translate(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
    public void StartupMSG(){
        getServer().getConsoleSender()
                .sendMessage(translate("&6[&eACT&6] &eVersion: &6"
                        + pm.getPlugin(this.getName()).getDescription().getVersion())
                        + " &eby &6Pyxled");
    }
    public String LoggedOutInCombat(Player p){
       return translate("&6[&eACT&6] &e" + p.getName() + " " + "&7has logged out in &ccombat!");
    }
    public void inCombatVictim(final Player p){
        p.sendMessage(translate("&6[&eACT&6] &7You are now combat tagged"));
        combatTagTime.put(p, 5);
        combatTagTask.put(p, new BukkitRunnable() {
            @Override
            public void run() {
            combatTagTime.put(p, combatTagTime.get(p) - 1);
                if(combatTagTime.get(p) == 0){
                    combatTagTime.remove(p);
                    combatTagTask.remove(p);
                    p.sendMessage(translate("&6[&eACT&6] &7You are no longer in Combat!"));
                    cancel();
                }
            }
        });
        combatTagTask.get(p).runTaskTimer(this, 20, 20);
    }
    public void inCombatAttacker(final Player p, Player t){
        p.sendMessage(translate("&6[&eACT&6] &7You are in combat with &e" + t.getName()));
        combatTagTime.put(p, 5);
        combatTagTask.put(p, new BukkitRunnable() {
            @Override
            public void run() {
            combatTagTime.put(p, combatTagTime.get(p) - 1);
                if(combatTagTime.get(p) == 0){
                    combatTagTime.remove(p);
                    combatTagTask.remove(p);
                    p.sendMessage(translate("&6[&eACT&6] &7You are no longer in Combat!"));
                    cancel();
                }
            }
        });
        combatTagTask.get(p).runTaskTimer(this, 20, 20);
    }
}
