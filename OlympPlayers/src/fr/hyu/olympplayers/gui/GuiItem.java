package fr.hyu.olympplayers.gui;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class GuiItem {

	public static ItemStack createGuiItem(final ItemStack item, final String name, final String... lore) {
		
		final ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(Arrays.asList(lore));
		item.setItemMeta(meta);
		return item;		

	}
	
	public static ItemStack createHeadItem(final Material material, Player playername, final String name, final String... lore) {
		
		final ItemStack item = new ItemStack(material, 1,(byte) 3);
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		meta.setDisplayName(name);
		meta.setOwningPlayer(playername);
		meta.setLore(Arrays.asList(lore));
		item.setItemMeta(meta);
		return item;
		
	}
	
}
