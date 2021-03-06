package net.aeon.survival.custom.boots;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.aeon.survival.utils.ArmorWearEvent;

import java.util.List;

public class BoltBoots implements Listener {
    @EventHandler
    public void onBoltWear(ArmorWearEvent e) {
        if (e.getSlot().equals("boots")) {
        	System.out.println("Check x passed");
            if (e.getItem().getItemMeta().getLore() != null) {
            	System.out.println("Check y passed");
                List<String> Lore = e.getItem().getItemMeta().getLore();
                if (Lore.contains("Flash II")) {
                	System.out.println("Check z passed");
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 , 2));
                }
            }
        }
    }
    @EventHandler
    public void OnBoltRemove(InventoryClickEvent e) {
        if (e.getSlot() == 8) {
        	System.out.println("Check a passed");
            if (e.getClick().equals(ClickType.SHIFT_LEFT) || e.getClick().equals(ClickType.LEFT)) {
            	System.out.println("Check d passed");
                if (e.getInventory().getItem(e.getSlot()).getItemMeta().getLore() != null) {
                	System.out.println("Check b passed");
                    ItemStack removedItem = e.getInventory().getItem(e.getSlot());
                    if (removedItem.getItemMeta().getLore().contains("Flash II")) {
                    	System.out.println("Check c passed");
                        e.getWhoClicked().removePotionEffect(PotionEffectType.SPEED);
                    }
                }
            }
        }
    }
}