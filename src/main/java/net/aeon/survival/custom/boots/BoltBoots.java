package main.java.net.aeon.survival.custom.boots;

import net.aeon.survival.Main;
import net.aeon.survival.utils.ArmorWearEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import main.java.net.aeon.survival.Main;
import main.java.net.aeon.survival.utils.ArmorWearEvent;

import java.util.List;

public class BoltBoots implements Listener {
	
    @EventHandler
    public void onBoltWear(ArmorWearEvent e) {
        if (e.getSlot().equals("boots")) {
        	System.out.println("Check x passed");
            if (e.getItem().getItemMeta().getLore() != null) {
            	System.out.println("Check y passed");
                List<String> Lore = e.getItem().getItemMeta().getLore();
                if (Lore.contains(ChatColor.GRAY + "Flash II")) {
                	System.out.println("Check z passed");
                    Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                        	e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 , 2));
                        }
                    }, 0L, 200L);
                }
            }
        }
    }
    @EventHandler
    public void OnBoltRemove(InventoryClickEvent e) {
        if (e.getSlot() == 8) {
        	System.out.println("Check a passed");
            if ((e.getClick().equals(ClickType.SHIFT_LEFT) || e.getClick().equals(ClickType.LEFT) && !(e.getClick().equals(ClickType.DROP)))) {
            	System.out.println("Check d passed");
                if (e.getInventory().getItem(e.getSlot()) != null) {
                	System.out.println("Check b passed");
                    ItemStack removedItem = e.getInventory().getItem(e.getSlot());
                    if (removedItem.getItemMeta().getLore() != null) {
                    	System.out.println("Check e passed");
                        if (removedItem.getItemMeta().getLore().contains(ChatColor.GRAY + "Flash II")) {
                            System.out.println("Check c passed");
                            e.getWhoClicked().removePotionEffect(PotionEffectType.SPEED);
                        }
                    }
                }
            }
        }
    }
}