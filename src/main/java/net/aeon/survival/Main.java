package main.java.net.aeon.survival;

import main.java.net.aeon.survival.custom.boots.BoltBoots;
import main.java.net.aeon.survival.listeners.ArmorWearListeners;
import main.java.net.aeon.survival.listeners.MobListener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Plugin instance;

    public static Plugin getInstance() {
        return instance;
    }
	public void onEnable() {
        instance = this;
        //Listeners
        getServer().getPluginManager().registerEvents(new MobListener(), this);
        // Custom Items
        getServer().getPluginManager().registerEvents(new BoltBoots(), this);
        getServer().getPluginManager().registerEvents(new ArmorWearListeners(), this);
	}
	
}
