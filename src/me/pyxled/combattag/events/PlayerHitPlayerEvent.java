package me.pyxled.combattag.events;

import me.pyxled.combattag.Core;
import me.pyxled.combattag.SettingsManager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * Pyxled Development 2016 (c)
 * File created: 01/12/2016
 */
public class PlayerHitPlayerEvent implements Listener {
    Core core = new Core();

    @EventHandler
    public void onEntityHit(EntityDamageByEntityEvent e){
        Entity e1 = e.getEntity();
        Entity e2 = e.getDamager();

        if((e1 instanceof Player)){

            Player victim = (Player)e1;

            Player attacker = null;

            if((e2 instanceof Player)){
                attacker = (Player)e2;
            }
            else if((e2 instanceof Projectile)){
                Projectile projectile = (Projectile)e2;
                LivingEntity shooter = (LivingEntity) projectile.getShooter();
                if((shooter instanceof Player)){
                    attacker = (Player)shooter;
                }
            }
            if(attacker == null) return;
                if(!core.combatTagTime.containsKey(victim) || !core.combatTagTime.containsKey(attacker)){
                    if(SettingsManager.getInstance().getConfig().getBoolean("config.CombatTriggers.PvPDamage")){
                        if(e.getDamager() == attacker) {
                            core.inCombatVictim(victim);
                            core.inCombatAttacker(attacker, victim);
                    }
                }
            }
        }
    }
}
