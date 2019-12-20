package main;

import main.events.ArrowLandEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Main instance;
    @Override
    public void onEnable(){
        instance = this;
        registerEvents();
    }
    public void registerCommands(){
        //getCommand("toggle").setExecutor(new ToggleCommand());

    }

    public void registerEvents(){
        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new ArrowLandEvent(), this);
    }

}
