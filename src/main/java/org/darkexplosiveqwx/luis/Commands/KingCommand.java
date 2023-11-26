package org.darkexplosiveqwx.luis.Commands;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Server;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.darkexplosiveqwx.luis.Luis;

public class KingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Server server = sender.getServer();
        if (sender instanceof Player){
            Player p = (Player) sender;

            if (args.length != 1){
                p.sendMessage(ChatColor.RED + "Provide a Player From your Faction that is currently online.");
            }else {
                if (server.getOnlinePlayers().contains(server.getPlayer(args[0]))){
                    Player tP = server.getPlayer(args[0]);
                    assert tP != null;
                    PersistentDataContainer data = tP.getPersistentDataContainer();
                    NamespacedKey key = new NamespacedKey(Luis.getPlugin(),"King");
                    NamespacedKey factionKey = new NamespacedKey(Luis.getPlugin(), "Faction");
                    if (Boolean.TRUE.equals(data.get(key, PersistentDataType.BOOLEAN))){
                        p.sendMessage(ChatColor.RED + "This PLayer is already the King");
                    }else {
                        data.set(key,PersistentDataType.BOOLEAN,true);
                        p.sendMessage(ChatColor.GREEN + tP.getName() +" is now the King" + data.get(factionKey,PersistentDataType.STRING));
                    }
                }else {
                    p.sendMessage(ChatColor.RED + "This Player is not online.");
                }

            }


        }





        return true;
    }
}
