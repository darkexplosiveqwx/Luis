package org.darkexplosiveqwx.luis.Listeners;

import org.bukkit.*;
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
                p.sendMessage(ChatColor.RED + "Invalid Faction choose again with /faction .");
            }
        }else {
            event.setJoinMessage(ChatColor.YELLOW + p.getName() + ChatColor.YELLOW + " is here!");
            p.sendMessage(ChatColor.GREEN  + "Choose a Faction by doing /faction ." );
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        event.setQuitMessage(ChatColor.YELLOW + event.getPlayer().getName() + ChatColor.YELLOW + " is gone now!");
        Player p = event.getPlayer();
        PersistentDataContainer data = p.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(Luis.getPlugin(),"Faction");
        boolean hasFaction = data.has(key, PersistentDataType.STRING);
        if (hasFaction){
            if (Objects.equals(data.get(key, PersistentDataType.STRING), "Diamond")){
                event.setQuitMessage(ChatColor.BLUE + p.getName() + ChatColor.YELLOW + " is gone now!");
            }else if (Objects.equals(data.get(key, PersistentDataType.STRING),"Emerald")){
                event.setQuitMessage(ChatColor.GREEN + p.getName() + ChatColor.YELLOW + " is gone now!");
            }else if (Objects.equals(data.get(key, PersistentDataType.STRING),"Netherite")){
                event.setQuitMessage(ChatColor.BLACK + p.getName() + ChatColor.YELLOW + " is gone now!");
            }else {
                event.setQuitMessage(ChatColor.YELLOW + p.getName() + ChatColor.YELLOW + " is gone now!");
            }
        }else {
            event.setQuitMessage(ChatColor.YELLOW + p.getName() + ChatColor.YELLOW + " is gone now!");
        }
    }
}
