package me.pyxled.combattag.events;

import me.pyxled.combattag.Core;
import me.pyxled.combattag.SettingsManager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Pyxled Development 2016 (c)
 * File created: 01/11/2016
 */
public class DamageEvent implements Listener {

    SettingsManager s = SettingsManager.getInstance();
    Core core = new Core();

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        EntityDamageEvent.DamageCause c = e.getCause();
        if(e.getEntity().getType() == EntityType.PLAYER){
            Player p = (Player)e.getEntity();
            if(!core.combatTagTime.containsKey(p)) {
                if (c == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
                    if (s.getConfig().getBoolean("config.CombatTriggers.BlockDamage")) {
                        core.inCombatVictim(p);
                    }
                }
            }
            if(!core.combatTagTime.containsKey(p)) {
                if (c == EntityDamageEvent.DamageCause.DROWNING) {
                    if (s.getConfig().getBoolean("config.CombatTriggers.DrowningDamage")) {
                        core.inCombatVictim(p);
                    }
                }
            }
            if(!core.combatTagTime.containsKey(p)) {
                if (c == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
                    if (s.getConfig().getBoolean("config.CombatTriggers.MobDamage")) {
                        core.inCombatVictim(p);
                    }
                }
            }
            if(!core.combatTagTime.containsKey(p)) {
                if (c == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) {
                    if (s.getConfig().getBoolean("config.CombatTriggers.CreeperDamage")) {
                        core.inCombatVictim(p);
                    }
                }
            }
            if(!core.combatTagTime.containsKey(p)) {
                if (c == EntityDamageEvent.DamageCause.FALL) {
                    if (s.getConfig().getBoolean("config.CombatTriggers.FallDamage")) {
                        core.inCombatVictim(p);
                    }
                }
            }
            if(!core.combatTagTime.containsKey(p)) {
                if (c == EntityDamageEvent.DamageCause.FALLING_BLOCK) {
                    if (s.getConfig().getBoolean("config.CombatTriggers.FallingBlockDamage")) {
                        core.inCombatVictim(p);
                    }
                }
            }
            if(!core.combatTagTime.containsKey(p)) {
                if (c == EntityDamageEvent.DamageCause.FIRE) {
                    if (s.getConfig().getBoolean("config.CombatTriggers.FireDamage")) {
                        core.inCombatVictim(p);
                    }
                }
            }
            if(!core.combatTagTime.containsKey(p)) {
                if (c == EntityDamageEvent.DamageCause.FIRE_TICK) {
                    if (s.getConfig().getBoolean("config.CombatTriggers.FireDamage")) {
                        core.inCombatVictim(p);
                    }
                }
            }
            if(!core.combatTagTime.containsKey(p)) {
                if (c == EntityDamageEvent.DamageCause.LAVA) {
                    if(s.getConfig().getBoolean("config.CombatTriggers.LavaDamage")) {
                        core.inCombatVictim(p);
                    }
                }
            }
            if(!core.combatTagTime.containsKey(p)) {
                if(c == EntityDamageEvent.DamageCause.LIGHTNING){
                    if(s.getConfig().getBoolean("config.CombatTriggers.LightningDamage")){
                        core.inCombatVictim(p);
                    }
                }
            }
            if(!core.combatTagTime.containsKey(p)) {
                if(c == EntityDamageEvent.DamageCause.MAGIC){
                    if(s.getConfig().getBoolean("config.CombatTriggers.MagicDamage")){
                        core.inCombatVictim(p);
                    }
                }
            }
            if(!core.combatTagTime.containsKey(p)) {
                if(c == EntityDamageEvent.DamageCause.MELTING){
                    if(s.getConfig().getBoolean("config.CombatTriggers.MeltingDamage")){
                        core.inCombatVictim(p);
                    }
                }
            }
            if(!core.combatTagTime.containsKey(p)) {
                if(c == EntityDamageEvent.DamageCause.POISON){
                    if(s.getConfig().getBoolean("config.CombatTriggers.PoisonDamage")){
                        core.inCombatVictim(p);
                    }
                }
            }
            if(!core.combatTagTime.containsKey(p)) {
                if(c == EntityDamageEvent.DamageCause.PROJECTILE){
                    if(s.getConfig().getBoolean("config.CombatTriggers.ProjectileDamage")){
                        core.inCombatVictim(p);
                    }
                }
            }
            if(!core.combatTagTime.containsKey(p)) {
                if(c == EntityDamageEvent.DamageCause.STARVATION){
                    if(s.getConfig().getBoolean("config.CombatTriggers.HungerDamage")){
                        core.inCombatVictim(p);
                    }
                }
            }
            if(!core.combatTagTime.containsKey(p)) {
                if(c == EntityDamageEvent.DamageCause.SUFFOCATION){
                    if(s.getConfig().getBoolean("config.CombatTriggers.Suffocation")){
                        core.inCombatVictim(p);
                    }
                }
            }
            if(!core.combatTagTime.containsKey(p)) {
                if(c == EntityDamageEvent.DamageCause.THORNS){
                    if(s.getConfig().getBoolean("config.CombatTriggers.ThornsDamage")){
                        core.inCombatVictim(p);
                    }
                }
            }
            if(!core.combatTagTime.containsKey(p)) {
                if(c == EntityDamageEvent.DamageCause.WITHER){
                    if(s.getConfig().getBoolean("config.CombatTriggers.WitherDamage")){
                        core.inCombatVictim(p);
                    }
                }
            }
        }
    }
}

