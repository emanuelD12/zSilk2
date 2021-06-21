package com.zsilk2;


import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

public class Main extends JavaPlugin {
    private Logger logger = getLogger();
    public Material silk2;
    public ItemStack silk2_item;
    public List<String> blocks;
    @Override
    public void onEnable() {
        super.onEnable();
        saveDefaultConfig();
        silk2 = Material.getMaterial(getConfig().getString("itemsilk2").toUpperCase(Locale.ROOT));
        if((getConfig().getInt("leveldosilk") < 2)){
            logger.warning("O level da silk touch deve ser maior do que 1! Parando plugin.");
            getServer().getPluginManager().disablePlugin(this);
        }else {
            logger.info("\n-----------------\nAutor: emanuel VINI\nVersão: 1.2\nSuporte: emanuel VINI#8000");
            logger.info("Carregando itens...");
            logger.info("Item da silk 2: " + silk2.name());
            logger.info("Criando item da silk...");
            silk2_item = new ItemStack(silk2);
            silk2_item.addUnsafeEnchantment(Enchantment.SILK_TOUCH, getConfig().getInt("leveldosilk"));
            logger.info("Silk touch level " + String.valueOf(getConfig().getInt("leveldosilk")) + " carregado!");
            blocks = getConfig().getStringList("blocos");
            blocks.replaceAll(String::toUpperCase);
            getCommand("silk2").setExecutor(new GiveSilk2());
            getCommand("silk2reload").setExecutor(new SilkReload());
            getServer().getPluginManager().registerEvents(new SilkListener(), this);
            logger.info("Plugin carregado com sucesso! Use /silk2 para givar e /silk2reload para recarregar.");
        }
    }
}
