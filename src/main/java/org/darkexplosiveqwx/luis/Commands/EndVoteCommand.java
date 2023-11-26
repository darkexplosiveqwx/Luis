package org.darkexplosiveqwx.luis.Commands;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.persistence.*;
import org.darkexplosiveqwx.luis.Luis;

import java.util.*;

public class EndVoteCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Server server = sender.getServer();
        NamespacedKey key = new NamespacedKey(Luis.getPlugin(),"Votes");
        NamespacedKey factionKey = new NamespacedKey(Luis.getPlugin(), "Faction");
        Collection<? extends Player> onlinePlayers = server.getOnlinePlayers();
        String[] players = new String[onlinePlayers.size()];
        Integer[] votes = new Integer[onlinePlayers.size()];
        String[] factions = new String[onlinePlayers.size()];
        int count = 0;

        for (Player player : onlinePlayers) {
            players[count] = player.getName();
            PersistentDataContainer data = player.getPersistentDataContainer();
            votes[count] = data.get(key, PersistentDataType.INTEGER);
            factions[count] = data.get(factionKey, PersistentDataType.STRING);

            server.broadcastMessage(ChatColor.GREEN + players[count] +" from " + factions[count] + " has " + votes[count] +" Votes.");
            count++;

        }

        return true;
    }
}
