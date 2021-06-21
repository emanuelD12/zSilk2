package com.zsilk2;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.inventory.ItemStack;


public class SilkListener implements Listener {
    @EventHandler
    public void onBlockDamage(BlockDamageEvent e) throws InterruptedException {
        Block b = e.getBlock();
        int enchant_level = e.getItemInHand().getEnchantmentLevel(Enchantment.SILK_TOUCH);
        Main.getPlugin(Main.class).getLogger().info(b.getType().name());
        int delay = Main.getPlugin(Main.class).getConfig().getInt("breaktimedelay");
        for(String name : Main.getPlugin(Main.class).blocks){
            if(enchant_level == Main.getPlugin(Main.class).getConfig().getInt("leveldosilk")){
                if(b.getType().name().equalsIgnoreCase(name)) {
                    if(b.getType().name().equalsIgnoreCase("BARRIER")) {
                        Thread.sleep(delay);
                        b.breakNaturally();
                        ItemStack barrier = new ItemStack(Material.BARRIER);
                        barrier.setAmount(1);
                        b.getWorld().dropItem(b.getLocation(), barrier);
                    }else if(b.getType().name().equalsIgnoreCase("ENDER_PORTAL_FRAME")){
                            Thread.sleep(delay);
                            b.breakNaturally();
                            ItemStack barrier = new ItemStack(Material.ENDER_PORTAL_FRAME);
                            barrier.setAmount(1);
                            b.getWorld().dropItem(b.getLocation(),barrier);
                    }else{
                        Thread.sleep(delay);
                        b.breakNaturally();
                    }

                }
            }
        }
    }
}
