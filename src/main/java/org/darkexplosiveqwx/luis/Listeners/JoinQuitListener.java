package org.darkexplosiveqwx.luis.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

public class JoinQuitListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.setJoinMessage(ChatColor.YELLOW + event.getPlayer().getName() + ChatColor.YELLOW + "is here!");
        event.getPlayer().chat("Plugin by darkexplosiveqwx." + "Welcome " + event.getPlayer().getName() + ".");
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        event.setQuitMessage(ChatColor.YELLOW + event.getPlayer().getName() + ChatColor.YELLOW + "is gone now!");
    }
}
