package org.darkexplosiveqwx.luis.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.persistence.*;
import org.darkexplosiveqwx.luis.Luis;

import java.util.Objects;

public class JoinQuitListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();
        PersistentDataContainer data = p.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(Luis.getPlugin(),"Faction");
        boolean hasFaction = data.has(key, PersistentDataType.STRING);
        if (hasFaction){
            if (Objects.equals(data.get(key, PersistentDataType.STRING), "Diamond")){
                event.setJoinMessage(ChatColor.BLUE + p.getName() + ChatColor.YELLOW + " is here!");
            }else if (Objects.equals(data.get(key, PersistentDataType.STRING),"Emerald")){
                event.setJoinMessage(ChatColor.GREEN + p.getName() + ChatColor.YELLOW + " is here!");
            }else if (Objects.equals(data.get(key, PersistentDataType.STRING),"Netherite")){
                event.setJoinMessage(ChatColor.BLACK + p.getName() + ChatColor.YELLOW + " is here!");
            }else {
                event.setJoinMessage(ChatColor.YELLOW + p.getName() + ChatColor.YELLOW + " is here!");
                p.sendMessage("Invalid Faction choose again with /faction .");
            }
        }else {
            event.setJoinMessage(ChatColor.YELLOW + p.getName() + ChatColor.YELLOW + " is here!");
            p.chat(ChatColor.YELLOW  + "Choose a Faction by doing /faction ." );
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        event.setQuitMessage(ChatColor.YELLOW + event.getPlayer().getName() + ChatColor.YELLOW + " is gone now!");
    }
}
