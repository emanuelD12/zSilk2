package com.zsilk2;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SilkReload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.hasPermission(Main.getPlugin(Main.class).getConfig().getString("permissao"))) {
            commandSender.sendMessage("§aPlugin recarregado com sucesso!");
            Main.getPlugin(Main.class).reloadConfig();
            Main p = Main.getPlugin(Main.class);
            p.blocks = p.getConfig().getStringList("blocos");
            p.blocks.replaceAll(String::toUpperCase);
        }else{
            commandSender.sendMessage(Main.getPlugin(Main.class).getConfig().getString("noperm"));
        }
        return false;
    }
}
