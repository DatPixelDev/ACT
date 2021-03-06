package me.pyxled.combattag.commands;

import me.pyxled.combattag.Core;
import me.pyxled.combattag.SettingsManager;
import mkremins.fanciful.FancyMessage;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Pyxled Development 2016 (c)
 * File created: 01/11/2016
 */
public class ctCMD implements CommandExecutor {
    Core plugin;

    public ctCMD (Core i) {
        plugin = i;
    }
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if (s instanceof Player) {
            Player p = (Player) s;
            if (p.hasPermission("act.info")) {
                if (args.length == 0) {
                    sms(p, "&6&lAdvancedCombatTag &6by: &ePyxled");
                    sms(p, "&6Spigot Page: " + Core.link);
                }
            } else {
                Core.translate(SettingsManager.getInstance().getConfig().getString("config.Messages.NoPermission"));
                return true;
            }
            if (p.hasPermission("act.help")) {
                if (args.length == 1 && args[0].equalsIgnoreCase("help")) {
                    sms(p, "&6&lCommands:");
                    new FancyMessage("§e/ct")
                            .tooltip("§7Usage: §e/ct", "§7Description: §eShows plugin information.", "", "§7§oClick to execute command.")
                            .command("/ct")
                            .send(p);
                    new FancyMessage("§e/ct help")
                            .tooltip("§7Usage: §e/ct help", "§7Description: §eShows this text again.", "", "§7§oClick to execute command.")
                            .command("/ct help")
                            .send(p);
                    new FancyMessage("§e/ct check")
                            .tooltip("§7Usage: §e/ct check", "§7Description: §eShows your CombatTime", "", "§7§oClick to execute command.")
                            .command("/ct check")
                            .send(p);
                    sms(p, "");
                    sms(p, "&7&oTip: Hover over text for info.");
                }
            } else {
                sms(p, Core.translate(SettingsManager.getInstance().getConfig().getString("config.Messages.NoPermission")));
                return true;
            }
            if (p.hasPermission("act.check")) {
                if (args.length == 1 && args[0].equalsIgnoreCase("check")) {
                    if (Core.combatTagTime.containsKey(p)) {
                        sms(p, Core.translate(SettingsManager.getInstance().getConfig().getString("config.Messages.TimeLeft").replace("%time", String.valueOf(Core.combatTagTime.get(p)))));
                        return true;
                    } else {
                        sms(p, Core.translate(SettingsManager.getInstance().getConfig().getString("config.Messages.NotInCombat")));
                    }
                }
            } else {
                sms(p, Core.translate(SettingsManager.getInstance().getConfig().getString("config.Messages.NoPermission")));
            }
        } else {
            sms(s, "&6[&aACT&6] &4Command Exception! &c[You must be a player to use this command.]");
            return true;
        }
        return true;
    }
    private void sms(CommandSender s, String msg){
        s.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
    }
}
