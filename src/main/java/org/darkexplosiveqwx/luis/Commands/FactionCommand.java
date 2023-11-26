package org.darkexplosiveqwx.luis.Commands;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.persistence.*;
import org.darkexplosiveqwx.luis.Luis;

import javax.annotation.*;
import java.util.Objects;

public class FactionCommand implements CommandExecutor {
    @Override
    public boolean onCommand( CommandSender sender, Command command, String label, String[] args) {
            if (sender instanceof Player){
                Player p = (Player) sender;
                PersistentDataContainer data = p.getPersistentDataContainer();
                NamespacedKey key = new NamespacedKey(Luis.getPlugin(),"Faction");
                boolean hasFaction = data.has(key, PersistentDataType.STRING);
                if (args.length != 1){
                    p.sendMessage(ChatColor.RED + "Choose a Faction between Diamond, Emerald and Netherite");
                    p.sendMessage(ChatColor.RED + "Example: /faction Diamond");
                } else if (Objects.equals(args[0], "Diamond") || Objects.equals(args[0], "diamond")) {
                        data.set(key,PersistentDataType.STRING,"Diamond");
                        p.sendMessage(ChatColor.RED + "You already had a Faction and you changed it to: Diamond" );
                } else if (Objects.equals(args[0], "Emerald") || Objects.equals(args[0], "emerald")) {
                    data.set(key,PersistentDataType.STRING,"Emerald");
                    p.sendMessage(ChatColor.GREEN + "You changed your Faction to: Emerald");
                } else if (Objects.equals(args[0], "Netherite") || Objects.equals(args[0], "netherite")) {
                    data.set(key,PersistentDataType.STRING,"Netherite");
                    p.sendMessage(ChatColor.GREEN + "You changed your Faction to: Netherite");
                }else {
                    p.sendMessage(ChatColor.RED + "Choose a Faction between Diamond, Emerald and Netherite");
                    p.sendMessage(ChatColor.RED + "Example: /faction Diamond");
                }
            }

        return true;
    }
}
