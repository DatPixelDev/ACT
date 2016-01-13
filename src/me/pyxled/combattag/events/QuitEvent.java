package me.pyxled.combattag.events;

import me.pyxled.combattag.Core;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Pyxled Development 2016 (c)
 * File created: 01/11/2016
 */
public class QuitEvent implements Listener {

    Core core = new Core();

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();
        if(core.combatTagTime.containsKey(p)){
            p.setHealth(0.0D);
            Bukkit.getServer().broadcastMessage(core.LoggedOutInCombat(p));
            core.combatTagTime.remove(p);
        }
    }
}
