package net.aeon.survival.listeners;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class MobListener implements Listener {
	//Listen for sheep eating the grass, and when he eats it, the event gets cancelled.
	@EventHandler
	public void onSheepEatGrass(EntityChangeBlockEvent e) {
		EntityType sheep = EntityType.SHEEP;
		if (e.getEntity().getType() == sheep) {
			if (e.getTo() == Material.DIRT) {
				e.getBlock().setType(Material.GRASS);
			}
		}
	}
}
