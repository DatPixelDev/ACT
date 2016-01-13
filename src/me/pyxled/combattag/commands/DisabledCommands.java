package me.pyxled.combattag.commands;

import me.pyxled.combattag.Core;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Pyxled Development 2016 (c)
 * File created: 01/11/2016
 */
public class DisabledCommands {

    Core core = new Core();

    List<String> commands = core.commands;

    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(s instanceof Player){
            Player p = (Player)s;
            if(commands != null && !commands.isEmpty() && l.contentEquals(commands.toString()) && core.combatTagTime.containsKey(p)){
                p.sendMessage(core.translate("&6[&eACT&6] &cYou cannot use this command while in combat!"));
                return true;
            }
        }
        return true;
    }
}
