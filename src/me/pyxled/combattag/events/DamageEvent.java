package me.pyxled.combattag.events;

import me.pyxled.combattag.Core;
import me.pyxled.combattag.SettingsManager;
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

    @SuppressWarnings("static-access")
    @EventHandler
    public void onDamage(EntityDamageEvent e){
        EntityDamageEvent.DamageCause c = e.getCause();
        if(e.getEntity().getType() == EntityType.PLAYER){
            Player p = (Player)e.getEntity();
            if(p.hasPermission("act.bypass")){
                return;
            }
            if(!Core.combatTagTime.containsKey(p)) {
                if (c == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
                    if (s.getConfig().getBoolean("config.CombatTriggers.BlockDamage")) {
                        Core.inCombatVictim(p);
                    }
                }
            }
            if(!Core.combatTagTime.containsKey(p)) {
                if (c == EntityDamageEvent.DamageCause.DROWNING) {
                    if (s.getConfig().getBoolean("config.CombatTriggers.DrowningDamage")) {
                        Core.inCombatVictim(p);
                    }
                }
            }
            if(!Core.combatTagTime.containsKey(p)) {
                if (c == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
                    if (s.getConfig().getBoolean("config.CombatTriggers.MobDamage")) {
                        Core.inCombatVictim(p);
                    }
                }
            }
            if(!Core.combatTagTime.containsKey(p)) {
                if (c == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) {
                    if (s.getConfig().getBoolean("config.CombatTriggers.CreeperDamage")) {
                        Core.inCombatVictim(p);
                    }
                }
            }
            if(!Core.combatTagTime.containsKey(p)) {
                if (c == EntityDamageEvent.DamageCause.FALL) {
                    if (s.getConfig().getBoolean("config.CombatTriggers.FallDamage")) {
                        Core.inCombatVictim(p);
                    }
                }
            }
            if(!Core.combatTagTime.containsKey(p)) {
                if (c == EntityDamageEvent.DamageCause.FALLING_BLOCK) {
                    if (s.getConfig().getBoolean("config.CombatTriggers.FallingBlockDamage")) {
                        Core.inCombatVictim(p);
                    }
                }
            }
            if(!Core.combatTagTime.containsKey(p)) {
                if (c == EntityDamageEvent.DamageCause.FIRE) {
                    if (s.getConfig().getBoolean("config.CombatTriggers.FireDamage")) {
                        Core.inCombatVictim(p);
                    }
                }
            }
            if(!Core.combatTagTime.containsKey(p)) {
                if (c == EntityDamageEvent.DamageCause.FIRE_TICK) {
                    if (s.getConfig().getBoolean("config.CombatTriggers.FireDamage")) {
                        Core.inCombatVictim(p);
                    }
                }
            }
            if(!Core.combatTagTime.containsKey(p)) {
                if (c == EntityDamageEvent.DamageCause.LAVA) {
                    if(s.getConfig().getBoolean("config.CombatTriggers.LavaDamage")) {
                        Core.inCombatVictim(p);
                    }
                }
            }
            if(!Core.combatTagTime.containsKey(p)) {
                if(c == EntityDamageEvent.DamageCause.LIGHTNING){
                    if(s.getConfig().getBoolean("config.CombatTriggers.LightningDamage")){
                        Core.inCombatVictim(p);
                    }
                }
            }
            if(!Core.combatTagTime.containsKey(p)) {
                if(c == EntityDamageEvent.DamageCause.MAGIC){
                    if(s.getConfig().getBoolean("config.CombatTriggers.MagicDamage")){
                        Core.inCombatVictim(p);
                    }
                }
            }
            if(!Core.combatTagTime.containsKey(p)) {
                if(c == EntityDamageEvent.DamageCause.MELTING){
                    if(s.getConfig().getBoolean("config.CombatTriggers.MeltingDamage")){
                        Core.inCombatVictim(p);
                    }
                }
            }
            if(!Core.combatTagTime.containsKey(p)) {
                if(c == EntityDamageEvent.DamageCause.POISON){
                    if(s.getConfig().getBoolean("config.CombatTriggers.PoisonDamage")){
                        Core.inCombatVictim(p);
                    }
                }
            }
            if(!Core.combatTagTime.containsKey(p)) {
                if(c == EntityDamageEvent.DamageCause.PROJECTILE){
                    if(s.getConfig().getBoolean("config.CombatTriggers.ProjectileDamage")){
                        Core.inCombatVictim(p);
                    }
                }
            }
            if(!Core.combatTagTime.containsKey(p)) {
                if(c == EntityDamageEvent.DamageCause.STARVATION){
                    if(s.getConfig().getBoolean("config.CombatTriggers.HungerDamage")){
                        Core.inCombatVictim(p);
                    }
                }
            }
            if(!Core.combatTagTime.containsKey(p)) {
                if(c == EntityDamageEvent.DamageCause.SUFFOCATION){
                    if(s.getConfig().getBoolean("config.CombatTriggers.SuffocationDamage")){
                        Core.inCombatVictim(p);
                    }
                }
            }
            if(!Core.combatTagTime.containsKey(p)) {
                if(c == EntityDamageEvent.DamageCause.THORNS){
                    if(s.getConfig().getBoolean("config.CombatTriggers.ThornsDamage")){
                        Core.inCombatVictim(p);
                    }
                }
                Core.inCombatVictim(p);
            }
            if(!Core.combatTagTime.containsKey(p)) {
                if(c == EntityDamageEvent.DamageCause.WITHER){
                    if(s.getConfig().getBoolean("config.CombatTriggers.WitherDamage")){
                        Core.inCombatVictim(p);
                    }
                }
            }
        }
    }
}
