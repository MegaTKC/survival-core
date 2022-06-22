package main.java.net.aeon.survival;

import org.bukkit.plugin.java.JavaPlugin;

import main.java.net.aeon.survival.custom.boots.BoltBoots;
import main.java.net.aeon.survival.listeners.ArmorWearListeners;
import main.java.net.aeon.survival.listeners.MobListener;
import main.java.net.aeon.survival.mobs.Zombie;

public class Main extends JavaPlugin {
	public void onEnable() {
        //Listeners
        getServer().getPluginManager().registerEvents(new MobListener(), this);
        // Custom Items
        getServer().getPluginManager().registerEvents(new BoltBoots(), this);
        getServer().getPluginManager().registerEvents(new ArmorWearListeners(), this);
	}
	
}
