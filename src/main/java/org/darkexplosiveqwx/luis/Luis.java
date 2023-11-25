package org.darkexplosiveqwx.luis;




import org.bukkit.plugin.java.JavaPlugin;
import org.darkexplosiveqwx.luis.Commands.*;
import org.darkexplosiveqwx.luis.Listeners.*;

import java.util.Objects;

public final class Luis extends JavaPlugin  {

    private static Luis plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getServer().getPluginManager().registerEvents(new JoinQuitListener(),this);
        getServer().getPluginManager().registerEvents(new ChatListener(),this);
        Objects.requireNonNull(getCommand("faction")).setExecutor(new FactionCommand());
        Objects.requireNonNull(getCommand("elect")).setExecutor(new ElectCommand());
        Objects.requireNonNull(getCommand("endvote")).setExecutor(new EndVoteCommand());


        System.out.println("Plugin Started!");
    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Luis getPlugin() {
        return plugin;
    }

}
