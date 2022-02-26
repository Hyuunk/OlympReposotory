package fr.hyu.olympplayers.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import fr.hyu.olympplayers.gui.GuiManager.InventoryList;


public class MenuManager implements Listener {

	@EventHandler
	public void onClickMenu(PlayerInteractEvent event) {

		if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& event.getItem() != null && event.getItem().getType() == Material.NETHER_STAR && event.getItem()
						.getItemMeta().getDisplayName().equals(ChatColor.GOLD.toString() + ChatColor.BOLD + "MENU")) {

			try {

				List<String> loresList = new ArrayList<String>();
				loresList.add("Cliquez sur l'étoile du nether pour ouvrir votre menu de joueur.");

				if (event.getItem().getItemMeta().getLore().equals(loresList)) {
					MenuGuiSummoner(event.getPlayer());
					GuiManager.openInventory(event.getPlayer(), InventoryList.inventoryMenu.getInventory());
				}

			} catch (NullPointerException e) {
			}

		}
	}

	@EventHandler
	public void onInventoryInteractMenu(InventoryClickEvent event) {

		if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.NETHER_STAR
				&& event.getCurrentItem().getItemMeta().getDisplayName() != null && event.getCurrentItem().getItemMeta()
						.getDisplayName().equals(ChatColor.GOLD.toString() + ChatColor.BOLD + "MENU")) {

			try {

				List<String> loresList = new ArrayList<String>();
				loresList.add("Cliquez sur l'étoile du nether pour ouvrir votre menu de joueur.");

				if (event.getCurrentItem().getItemMeta().getLore().equals(loresList))
					event.setCancelled(true);

			} catch (NullPointerException e) {
			}
		}
	}

	@EventHandler
	public void onDropMenu(PlayerDropItemEvent event) {

		if (event.getItemDrop() != null && event.getItemDrop().getType() == EntityType.DROPPED_ITEM) {

			Item dropped = (Item) event.getItemDrop();

			if (dropped.getItemStack().getType().equals(Material.NETHER_STAR) && dropped.getItemStack().getItemMeta()
					.getDisplayName().equals(ChatColor.GOLD.toString() + ChatColor.BOLD + "MENU"))

				try {

					List<String> loresList = new ArrayList<String>();
					loresList.add("Cliquez sur l'étoile du nether pour ouvrir votre menu de joueur.");

					if (dropped.getItemStack().getItemMeta().getLore().equals(loresList))
						event.setCancelled(true);

				} catch (NullPointerException e) {
					
				}
		}
	}

	// INVENTORY CREATOR

	public void MenuGuiSummoner(Player player) {
		
		initializeMenuItems(player);
	}

	public void initializeMenuItems(Player player) {

		InventoryList.inventoryMenu.getInventory().setItem(4, GuiItem.createHeadItem(Material.SKULL_ITEM, player, ChatColor.GREEN + "Profile", ChatColor.WHITE + "Description " + player.getName()));
		
		InventoryList.inventoryMenu.getInventory().setItem(10, GuiItem.createGuiItem(Material.EXP_BOTTLE, ChatColor.BLUE + "Statistiques", ""));
		
		InventoryList.inventoryMenu.getInventory().setItem(11, GuiItem.createGuiItem(Material.BREWING_STAND_ITEM, ChatColor.GREEN + "Métiers", ""));
		
		InventoryList.inventoryMenu.getInventory().setItem(15, GuiItem.createGuiItem(Material.BOOK_AND_QUILL, ChatColor.LIGHT_PURPLE + "Quêtes",""));
		
		InventoryList.inventoryMenu.getInventory().setItem(16, GuiItem.createGuiItem(Material.EMPTY_MAP, ChatColor.WHITE + "Map", ""));		
		
		InventoryList.inventoryMenu.getInventory().setItem(22, GuiItem.createGuiItem(Material.BARRIER, ChatColor.DARK_RED + "Quitter", ""));
		
		InventoryList.inventoryMenu.getInventory().setItem(23, GuiItem.createGuiItem(Material.REDSTONE_COMPARATOR, ChatColor.RED + "Paramètres", ""));
		
		if (player.isOp()) {
			InventoryList.inventoryMenu.getInventory().setItem(21, GuiItem.createGuiItem(Material.COMMAND, ChatColor.GOLD + "DevMod", ""));
		}
		
	}


}
