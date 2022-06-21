package net.aeon.survival.utils;

import net.minecraft.server.v1_5_R3.ItemArmor;
import org.bukkit.craftbukkit.v1_5_R3.inventory.CraftItemStack;

public class ItemStackUtils {
    public static boolean IsEquipable_(org.bukkit.inventory.ItemStack i)
    {
        net.minecraft.server.v1_5_R3.ItemStack r = CraftItemStack.asNMSCopy(i);

        return r.getItem() instanceof ItemArmor;
    }
}
