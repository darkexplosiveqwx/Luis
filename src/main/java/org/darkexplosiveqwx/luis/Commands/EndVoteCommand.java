package org.darkexplosiveqwx.luis.Commands;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Server;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.persistence.*;
import org.darkexplosiveqwx.luis.Luis;

import java.util.*;

public class EndVoteCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            Server server = p.getServer();
            NamespacedKey key = new NamespacedKey(Luis.getPlugin(),"Votes");
            Collection<? extends Player> onlinePlayers = server.getOnlinePlayers();
            List<String> players = new ArrayList<String>();
            List<Integer> votes = new ArrayList<Integer>();

            for (Player player : onlinePlayers) {
                if (player.getName().equalsIgnoreCase(p.getName())){
                    players.add(player.getName());
                    PersistentDataContainer data = player.getPersistentDataContainer();
                    votes.add(data.get(key,PersistentDataType.INTEGER));
                    p.sendMessage(ChatColor.GREEN + player.getName() + " has " + votes.size() +" Votes.");

                }
            }

        }

        return true;
    }
}
