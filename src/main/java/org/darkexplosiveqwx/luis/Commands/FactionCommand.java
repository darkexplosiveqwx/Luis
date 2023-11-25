package org.darkexplosiveqwx.luis.Commands;

import org.bukkit.NamespacedKey;
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
                    p.sendMessage("Choose a Faction between Diamond, Emerald and Netherite");
                    p.sendMessage("Example: /faction Diamond");
                } else if (Objects.equals(args[0], "Diamond") || Objects.equals(args[0], "diamond")) {
                        data.set(key,PersistentDataType.STRING,"Diamond");
                        if (hasFaction){
                            p.sendMessage("You already had a Faction and you changed it to: Diamond" );
                        }
                } else if (Objects.equals(args[0], "Emerald") || Objects.equals(args[0], "emerald")) {
                    data.set(key,PersistentDataType.STRING,"Emerald");
                    if (hasFaction){
                        p.sendMessage("You already had a Faction and you changed it to: Emerald" );
                    }
                } else if (Objects.equals(args[0], "Netherite") || Objects.equals(args[0], "netherite")) {
                    data.set(key,PersistentDataType.STRING,"Netherite");
                    if (hasFaction){
                        p.sendMessage("You already had a Faction and you changed it to: Netherite" );
                    }
                }else {
                    p.sendMessage("Choose a Faction between Diamond, Emerald and Netherite");
                    p.sendMessage("Example: /faction Diamond");
                }
            }

        return true;
    }
}
