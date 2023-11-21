package org.darkexplosiveqwx.luis;




import org.bukkit.plugin.java.JavaPlugin;
import org.darkexplosiveqwx.luis.Commands.*;
import org.darkexplosiveqwx.luis.Listeners.JoinQuitListener;

public final class Luis extends JavaPlugin  {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Plugin Started!");
        getServer().getPluginManager().registerEvents(new JoinQuitListener(),this);
        getCommand("faction").setExecutor(new FactionCommand());
        getCommand("faction").setExecutor(new ElectCommand());
    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
