package main.java.net.aeon.survival.listeners;

import main.java.net.aeon.survival.utils.ArmorWearEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class ArmorWearListeners implements Listener {
    @EventHandler
    public void OnArmorWearByInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        int[] ArmorSlots = {5, 6, 7, 8};
        if (e.getInventory() instanceof PlayerInventory) {
            if (e.getClick().equals(ClickType.DROP)) {

                // Checks to see if the Clicked slot is an armor slot
                for (int slot : ArmorSlots) {
                    if (e.getSlot() == slot) {
                        String Type = null;
                        ItemStack dropItem = e.getCurrentItem();
                        String dropItemType = dropItem.getType().toString().toLowerCase();
                        if (dropItemType.contains("helmet")) {
                            Type = "helmet";
                        }

                        if (dropItemType.contains("chestplate")) {
                            Type = "chestplate";
                        }

                        if (dropItemType.contains("leggings")) {
                            Type = "leggings";
                        }

                        if (dropItemType.contains("boots")) {
                            Type = "boots";
                        } else {
                            return;
                        }
                        ArmorWearEvent a = new ArmorWearEvent(p, dropItem, "drop", Type);
                        Bukkit.getPluginManager().callEvent(a);
                        if (a.isCancelled()) {
                            e.setCancelled(true);
                        }
                    }
                }
            }
            if (e.getClick().equals(ClickType.SHIFT_LEFT)) {

                if (e.getInventory().getItem(e.getSlot()) != null) {

                    // Checks to see if the Clicked slot is an armor slot
                    for (int slot : ArmorSlots) {
                        if (e.getSlot() == slot) {
                            ItemStack ClickItem = e.getInventory().getItem(e.getSlot());
                            String ClickItemType = ClickItem.getType().toString().toLowerCase();
                            String Type = null;
                            if (ClickItemType.contains("helmet")) {
                                Type = "helmet";
                            }

                            if (ClickItemType.contains("chestplate")) {
                                Type = "chestplate";
                            }

                            if (ClickItemType.contains("leggings")) {
                                Type = "leggings";
                            }

                            if (ClickItemType.contains("boots")) {
                                Type = "boots";
                            } else {
                                return;
                            }
                            ArmorWearEvent a = new ArmorWearEvent(p, ClickItem, "shift", Type);
                            Bukkit.getPluginManager().callEvent(a);
                            if (a.isCancelled()) {
                                e.setCancelled(true);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void OnArmorWearByRightClick(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player p = e.getPlayer();
            String click = "right_click";
            ItemStack Item = e.getPlayer().getItemInHand();
            String ItemType = Item.getType().toString().toLowerCase();
            String Type = null;
            if (ItemType.contains("helmet")) {
                Type = "helmet";
            }

            if (ItemType.contains("chestplate")) {
                Type = "chestplate";
            }

            if (ItemType.contains("leggings")) {
                Type = "leggings";
            }

            if (ItemType.contains("boots")) {
                Type = "boots";
            } else {
                return;
            }
            ArmorWearEvent a = new ArmorWearEvent(p, Item, click, Type);
            Bukkit.getPluginManager().callEvent(a);
            if (a.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }

}
