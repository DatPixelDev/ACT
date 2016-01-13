package me.pyxled.combattag.events;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Pyxled Development 2016 (c)
 * File created: 01/11/2016
 */
public class DamageEvent implements Listener {
    @EventHandler
    public void onDamage(EntityDamageEvent e){
        EntityDamageEvent.DamageCause c = e.getCause();
        if(e.getEntity().getType() == EntityType.PLAYER){
            if(c == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION){

            }
        }
    }
}
