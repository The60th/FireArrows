package main;

import main.events.ArrowLandEvent;
import main.old.MemeEvent;
import main.old.SpearEvent;
import main.old.blockPlace;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public class Main extends JavaPlugin {

    public static Plugin plugin;
    public static JavaPlugin javaPlugin;
    public static Logger logger;

    @Override
    public void onEnable(){
        logger = Logger.getLogger("Minecraft");
        plugin = this;
        javaPlugin = this;

        //Create config file.
        plugin.saveDefaultConfig();

        registerEvents();


    }

    public void onDisable() {
        PluginDescriptionFile pdfFile = getDescription();
        Logger logger = Logger.getLogger("Minecraft");
        logger.info(pdfFile.getName() + "has successfully disabled.");
    }



    public void registerCommands(){
        //getCommand("toggle").setExecutor(new ToggleCommand());

    }

    public void registerEvents(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ArrowLandEvent(), this);
    }

    public static Plugin getPlugin() {
        return plugin;
    }

}
