package org.darkexplosiveqwx.luis.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class ElectCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (args.length != 1){
                p.sendMessage("Provide a Player From your Faction that is currently online.");
                p.sendMessage("Example: /elect UrMom");
            } else{
                String playerName = args[0];
                String[] onlinePlayers = (String[]) Bukkit.getOnlinePlayers().toArray();

                if (Arrays.asList(onlinePlayers).contains(playerName)){
                    p.sendMessage("You have voted for" + playerName);

                }else {
                    p.sendMessage("Provide a Player From your Faction that is currently online.");
                    p.sendMessage("Example: /elect UrMom");
                }

            }
        }

        return true;
    }
}
