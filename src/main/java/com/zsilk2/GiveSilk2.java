package com.zsilk2;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class GiveSilk2 implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            String permissao = Main.getPlugin(Main.class).getConfig().getString("permissao");
            if(((Player) commandSender).getPlayer().hasPermission(permissao)){
                ItemStack item = Main.getPlugin(Main.class).silk2_item;
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(Main.getPlugin(Main.class).getConfig().getString("nomedoitem").replace("&","§"));
                List<String> as = Main.getPlugin(Main.class).getConfig().getStringList("loredasilk2");
                for (int i = 0; i < as.size(); ++i) {
                    as.set(i, as.get(i).replaceAll("&", "§"));
                }
                meta.setLore(as);
                item.setItemMeta(meta);
                ((Player) commandSender).getPlayer().getInventory().addItem(item);
                commandSender.sendMessage("§aPicareta enviada com sucesso!");
            }else{
                commandSender.sendMessage(Main.getPlugin(Main.class).getConfig().getString("noperm").replace("&","§"));
            }
        }else{
            commandSender.sendMessage("§cO console não pode fazer isso!");
        }
        return false;
    }
}
