package net.aeon.survival;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import net.aeon.survival.custom.boots.BoltBoots;
import net.aeon.survival.listeners.MobListener;

public class Main extends JavaPlugin implements Listener {
	public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        //Listeners
        getServer().getPluginManager().registerEvents(new MobListener(), this);
        // Custom Items
        getServer().getPluginManager().registerEvents(new BoltBoots(), this);
	}
	
}
