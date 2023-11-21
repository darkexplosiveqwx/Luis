package org.darkexplosiveqwx.luis.Commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.Objects;

public class FactionCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (sender instanceof Player){
                Player p = (Player) sender;
                if (args.length != 1){
                    p.sendMessage("Choose a Faction between Diamond, Emerald and Netherite");
                    p.sendMessage("Example: /faction Diamond");
                } else if (Objects.equals(args[0], "Diamond") || Objects.equals(args[0], "diamond")) {

                } else if (Objects.equals(args[0], "Emerald") || Objects.equals(args[0], "emerald")) {

                } else if (Objects.equals(args[0], "Netherite") || Objects.equals(args[0], "netherite")) {

                }else {
                    p.sendMessage("Choose a Faction between Diamond, Emerald and Netherite");
                    p.sendMessage("Example: /faction Diamond");
                }
            }

        return true;
    }
}
