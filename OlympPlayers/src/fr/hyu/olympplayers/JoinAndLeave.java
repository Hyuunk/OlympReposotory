package fr.hyu.olympplayers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinAndLeave implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		event.setJoinMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + player.getName());
		
		ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD.toString() + ChatColor.BOLD + "MENU");
		item.setItemMeta(meta);
		player.getInventory().setItem(7, item);
		
		List<String> loresList = new ArrayList<String>();
		loresList.add("Cliquez sur l'étoile du nether pour ouvrir votre menu de joueur.");
		meta.setLore(loresList);
		item.setItemMeta(meta);
		player.getInventory().setItem(8, item);
		
		//METTRE TOUT LES INIT ICI POUR PERFS
		
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent event) {
		
		event.setQuitMessage(ChatColor.GRAY + "[" + ChatColor.RED + "-" + ChatColor.GRAY + "] " + event.getPlayer().getName());
	}
}
