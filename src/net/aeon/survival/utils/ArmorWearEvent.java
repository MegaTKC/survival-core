package net.aeon.survival.utils;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;


public class ArmorWearEvent extends Event implements Cancellable {
    private final Player player;
    private final String slot;

    private final ItemStack Item;

    private final String ClickType;
    private boolean isCancelled = false;

    public ArmorWearEvent(Player p, ItemStack item, String ClickType, String Type) {
        this.player = p;
        this.Item = item;
        this.ClickType = ClickType;
        this.slot = Type;

    }
    // Sets the getters
    public Player getPlayer() {
        return this.player;
    }

    public ItemStack getItem() {
        return this.Item;
    }


    public String getSlot() {
        return this.slot;
    }

    public String getClickType() {
        return this.ClickType;
    }


    @Override
    public boolean isCancelled() {
        return this.isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.isCancelled = b;
    }

    private static final HandlerList handlers = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
