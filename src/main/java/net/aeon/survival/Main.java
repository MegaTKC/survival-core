package net.aeon.survival;

import net.aeon.survival.listeners.ArmorWearListeners;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import main.java.net.aeon.survival.custom.boots.BoltBoots;
import main.java.net.aeon.survival.listeners.MobListener;

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
