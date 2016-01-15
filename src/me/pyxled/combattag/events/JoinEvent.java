package me.pyxled.combattag.events;

import me.pyxled.combattag.Core;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Pyxled Development 2016 (c)
 * File created: 01/13/2016
 */
public class JoinEvent implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        p.sendMessage(Core.translate("&6[&eACT&6] &eThis server is monitored by Advanced Combat Tagging."));
    }
}
