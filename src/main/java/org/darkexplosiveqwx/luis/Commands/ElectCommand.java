package org.darkexplosiveqwx.luis.Commands;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Server;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.persistence.*;
import org.darkexplosiveqwx.luis.Luis;

import java.util.Collection;
import java.util.Objects;

public class ElectCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            PersistentDataContainer data = p.getPersistentDataContainer();
            NamespacedKey key = new NamespacedKey(Luis.getPlugin(),"Faction");
            Server server = p.getServer();
            boolean hasFaction = data.has(key, PersistentDataType.STRING);
            String senderFaction = data.get(key,PersistentDataType.STRING);
            if (hasFaction){
                if (Objects.equals(data.get(key, PersistentDataType.STRING), "Diamond") || Objects.equals(data.get(key, PersistentDataType.STRING),"Emerald")||
                        Objects.equals(data.get(key, PersistentDataType.STRING),"Netherite")){
                    if (args.length != 1){
                        p.sendMessage("Provide a Player From your Faction that is currently online.");
                        p.sendMessage("Example: /elect UrMom");
                    } else {
                        String targetPlayerName = args[0];
                        Player targetedPlayer = server.getPlayerExact(targetPlayerName);
                        Collection<? extends Player> onlinePlayers = server.getOnlinePlayers();
                        if (onlinePlayers.contains(targetedPlayer)){
                            assert targetedPlayer != null;
                            PersistentDataContainer targetedPlayerData = targetedPlayer.getPersistentDataContainer();
                            String targetedPlayerFaction = targetedPlayerData.get(key,PersistentDataType.STRING);
                            NamespacedKey votesKey = new NamespacedKey(Luis.getPlugin(),"Votes");

                            if (Objects.equals(targetedPlayerFaction, senderFaction)){


                                NamespacedKey hasVotedKey = new NamespacedKey(Luis.getPlugin(),"HasVoted");
                                if (Boolean.TRUE.equals(data.get(hasVotedKey, PersistentDataType.BOOLEAN))){
                                    p.sendMessage(ChatColor.RED + "You have already voted");
                                }else {
                                    if (!targetedPlayerData.has(votesKey, PersistentDataType.INTEGER)){
                                        targetedPlayerData.set(votesKey,PersistentDataType.INTEGER,1);
                                    } else {
                                        targetedPlayerData.set(votesKey,PersistentDataType.INTEGER,targetedPlayerData.get(votesKey,PersistentDataType.INTEGER) + 1);
                                    }
                                    data.set(hasVotedKey,PersistentDataType.BOOLEAN,true);
                                }
                            }else {
                                p.sendMessage(ChatColor.RED + "This Player is not from your Faction.");
                                p.sendMessage(ChatColor.RED + "Provide a Player From your Faction that is currently online.");
                                p.sendMessage(ChatColor.RED + "Example: /elect UrMom");
                            }
                        }else {
                            p.sendMessage(ChatColor.RED + "This Player is not online.");
                            p.sendMessage(ChatColor.RED + "Provide a Player From your Faction that is currently online.");
                            p.sendMessage(ChatColor.RED + "You might have misspelled the name. DarkexPlosIveQwX IS NOT darkexplosiveqwx.");
                            p.sendMessage(ChatColor.RED + "Example: /elect UrMom");
                        }

                    }
                }else {
                    p.sendMessage(ChatColor.RED + "Invalid Faction choose again with /faction .");
                }

            }else {
                p.sendMessage(ChatColor.RED + "You are not in a Faction, do /faction to join one.");
            }
        }

        return true;
    }
}
