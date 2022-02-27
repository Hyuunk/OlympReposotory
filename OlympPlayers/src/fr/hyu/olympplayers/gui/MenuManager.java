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

import fr.hyu.olympperms.players.PlayerProfileManager;
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
					GuiSummoner(event.getPlayer(), InventoryList.inventoryPlayerMenu.getInventory());
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
	public void onPlayerDropMenu(PlayerDropItemEvent event) {

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


	
	public static void onMenuItem(Material material, Player player) {
		
		switch (material) {
		
		case SKULL_ITEM:
			GuiSummoner(player, InventoryList.inventoryProfile.getInventory());
			break;
			
		case EXP_BOTTLE:
			GuiSummoner(player, InventoryList.inventoryStats.getInventory());
			break;
			
		case BREWING_STAND_ITEM:
			GuiSummoner(player, InventoryList.inventoryJobs.getInventory());
			break;
			
		case BOOK_AND_QUILL:
			GuiSummoner(player, InventoryList.inventoryQuests.getInventory());
			break;
			
		case EMPTY_MAP:
			break;
			
		case REDSTONE_COMPARATOR:
			GuiSummoner(player, InventoryList.inventorySettings.getInventory());
			break;
			
		case COMMAND:
			GuiSummoner(player, InventoryList.inventoryPlayerMenuDevMod.getInventory());
			break;
		}
		
	}
	
	public static void onMenuDevItem(Material material, Player player) {
		
		switch (material) {
		
		case SKULL_ITEM:
			GuiSummoner(player, InventoryList.inventoryProfileDevMod.getInventory());
			break;
			
		case EXP_BOTTLE:
			GuiSummoner(player, InventoryList.inventoryStatsDevMod.getInventory());
			break;
			
		case BREWING_STAND_ITEM:
			GuiSummoner(player, InventoryList.inventoryJobsDevMod.getInventory());
			break;
			
		case BOOK_AND_QUILL:
			GuiSummoner(player, InventoryList.inventoryQuestsDevMod.getInventory());
			break;
			
		case EMPTY_MAP:
			break;
			
		case REDSTONE_COMPARATOR:
			GuiSummoner(player, InventoryList.inventorySettingsDevMod.getInventory());
			break;

		case GRASS:
			GuiSummoner(player, InventoryList.inventoryPlayerMenu.getInventory());
			break;
		}
	}
	
	// INVENTORY CREATOR

	public static void GuiSummoner(Player player, Inventory inventory) {
		
		GuiManager.initialize(player, inventory);
		GuiManager.openInventory(player, inventory);

	}
	

	public static void initializePlayerMenuItems(Player player) {

		Inventory inventory = InventoryList.inventoryPlayerMenu.getInventory();
		
		inventory.setItem(4, GuiItem.createHeadItem(Material.SKULL_ITEM, player, ChatColor.GREEN + "Profile",
				ChatColor.BLUE.toString() + "note: mettre les dégats (et ce pour tout)",
				ChatColor.BLUE.toString() +"et non les stats pure, degats sur un monstre de meme niv que le joueur ",
				ChatColor.GRAY.toString() + "Rank: " + PlayerProfileManager.profiles.get(player).getRank(),
				ChatColor.GRAY.toString() + "Level: " + PlayerProfileManager.profiles.get(player).getLevel(),
				ChatColor.RED.toString() + "Health: " + PlayerProfileManager.profiles.get(player).getVitalityNative(),
				ChatColor.BLUE.toString() + "Defence: " + PlayerProfileManager.profiles.get(player).getDefenceNative(),
				ChatColor.RED.toString() + "Strength: " + PlayerProfileManager.profiles.get(player).getStrengthNative(),
				ChatColor.GOLD.toString() + "Endurance: " + PlayerProfileManager.profiles.get(player).getEnduranceNative(),
				ChatColor.DARK_AQUA.toString() + "Intelligence: " + PlayerProfileManager.profiles.get(player).getIntelligenceNative(),
				ChatColor.AQUA.toString() + "Mana: " + PlayerProfileManager.profiles.get(player).getManaCapacityNative(),
				ChatColor.GREEN.toString() + "Luck WIP: ",
				ChatColor.LIGHT_PURPLE.toString() + "Karma: " + PlayerProfileManager.profiles.get(player).getKarma(),
				ChatColor.GOLD.toString() + "Gold: " + PlayerProfileManager.profiles.get(player).getGold()
				));
		
		
		inventory.setItem(10, GuiItem.createGuiItem(Material.EXP_BOTTLE, ChatColor.BLUE + "Statistiques", ""));
		
		inventory.setItem(11, GuiItem.createGuiItem(Material.BREWING_STAND_ITEM, ChatColor.GREEN + "Métiers", ""));
		
		inventory.setItem(15, GuiItem.createGuiItem(Material.BOOK_AND_QUILL, ChatColor.LIGHT_PURPLE + "Quêtes",""));
		
		inventory.setItem(16, GuiItem.createGuiItem(Material.EMPTY_MAP, ChatColor.YELLOW + "Map", ""));		
		
		inventory.setItem(31, GuiItem.createGuiItem(Material.BARRIER, ChatColor.DARK_RED + "Quitter", ""));
		
		inventory.setItem(32, GuiItem.createGuiItem(Material.REDSTONE_COMPARATOR, ChatColor.RED + "Paramètres", ""));
	
		
		if (player.isOp()) {
			inventory.setItem(30, GuiItem.createGuiItem(Material.COMMAND, ChatColor.GOLD + "DevMod", ""));
		}
	}	
	public static void initializePlayerMenuDevItems(Player player) {

			Inventory inventory = InventoryList.inventoryPlayerMenuDevMod.getInventory();
			
			inventory.setItem(4, GuiItem.createHeadItem(Material.SKULL_ITEM, player, ChatColor.GREEN + "Profile",
					ChatColor.BLUE.toString() + "note: mettre les dégats (et ce pour tout)",
					ChatColor.BLUE.toString() +"et non les stats pure, degats sur un monstre de meme niv que le joueur ",
					ChatColor.GRAY.toString() + "Rank: " + PlayerProfileManager.profiles.get(player).getRank(),
					ChatColor.GRAY.toString() + "Level: " + PlayerProfileManager.profiles.get(player).getLevel(),
					ChatColor.RED.toString() + "Health: " + PlayerProfileManager.profiles.get(player).getVitalityNative(),
					ChatColor.BLUE.toString() + "Defence: " + PlayerProfileManager.profiles.get(player).getDefenceNative(),
					ChatColor.RED.toString() + "Strength: " + PlayerProfileManager.profiles.get(player).getStrengthNative(),
					ChatColor.GOLD.toString() + "Endurance: " + PlayerProfileManager.profiles.get(player).getEnduranceNative(),
					ChatColor.DARK_AQUA.toString() + "Intelligence: " + PlayerProfileManager.profiles.get(player).getIntelligenceNative(),
					ChatColor.AQUA.toString() + "Mana: " + PlayerProfileManager.profiles.get(player).getManaCapacityNative(),
					ChatColor.GREEN.toString() + "Luck WIP: ",
					ChatColor.LIGHT_PURPLE.toString() + "Karma: " + PlayerProfileManager.profiles.get(player).getKarma(),
					ChatColor.GOLD.toString() + "Gold: " + PlayerProfileManager.profiles.get(player).getGold()
					));
			
			inventory.setItem(10, GuiItem.createGuiItem(Material.EXP_BOTTLE, ChatColor.BLUE + "Statistiques", ""));
			
			inventory.setItem(11, GuiItem.createGuiItem(Material.BREWING_STAND_ITEM, ChatColor.GREEN + "Métiers", ""));
			
			inventory.setItem(15, GuiItem.createGuiItem(Material.BOOK_AND_QUILL, ChatColor.LIGHT_PURPLE + "Quêtes",""));
			
			inventory.setItem(16, GuiItem.createGuiItem(Material.EMPTY_MAP, ChatColor.YELLOW + "Map", ""));		
			
			inventory.setItem(31, GuiItem.createGuiItem(Material.BARRIER, ChatColor.DARK_RED + "Quitter", ""));
			
			inventory.setItem(32, GuiItem.createGuiItem(Material.REDSTONE_COMPARATOR, ChatColor.RED + "Paramètres", ""));
			
			if (player.isOp()) {
				inventory.setItem(30, GuiItem.createGuiItem(Material.GRASS, ChatColor.GREEN + "NormalMod", ""));
		}			
	}
	
	public static void initializeProfileMenuItems(Player player) {
		
		Inventory inventory = InventoryList.inventoryProfile.getInventory();
		
		inventory.setItem(49, GuiItem.createGuiItem(Material.BARRIER, ChatColor.DARK_RED + "Quitter", ""));
		
	}
	
	public static void initializeProfileMenuDevItems(Player player) {
		
		Inventory inventory = InventoryList.inventoryProfileDevMod.getInventory();
		
		inventory.setItem(49, GuiItem.createGuiItem(Material.BARRIER, ChatColor.DARK_RED + "Quitter", ""));
	}	
	
	public static void initializeStatsMenuItems(Player player) {
		
		Inventory inventory = InventoryList.inventoryStats.getInventory();
		
		inventory.setItem(49, GuiItem.createGuiItem(Material.BARRIER, ChatColor.DARK_RED + "Quitter", ""));
	}
	
	public static void initializeStatsMenuDevItems(Player player) {
		
		Inventory inventory = InventoryList.inventoryStatsDevMod.getInventory();
		
		inventory.setItem(49, GuiItem.createGuiItem(Material.BARRIER, ChatColor.DARK_RED + "Quitter", ""));
	}	
	
	public static void initializeJobsMenuItems(Player player) {
	
		Inventory inventory = InventoryList.inventoryJobs.getInventory();
		
		inventory.setItem(49, GuiItem.createGuiItem(Material.BARRIER, ChatColor.DARK_RED + "Quitter", ""));
	}
	
	public static void initializeJobsMenuDevItems(Player player) {
		
		Inventory inventory = InventoryList.inventoryJobsDevMod.getInventory();
		
		inventory.setItem(49, GuiItem.createGuiItem(Material.BARRIER, ChatColor.DARK_RED + "Quitter", ""));
	}	
		
	public static void initializeQuestsMenuItems(Player player) {
		
		Inventory inventory = InventoryList.inventoryQuests.getInventory();
		
		inventory.setItem(49, GuiItem.createGuiItem(Material.BARRIER, ChatColor.DARK_RED + "Quitter", ""));
	}
	
	public static void initializeQuestsMenuDevItems(Player player) {
		
		Inventory inventory = InventoryList.inventoryQuestsDevMod.getInventory();
		
		inventory.setItem(49, GuiItem.createGuiItem(Material.BARRIER, ChatColor.DARK_RED + "Quitter", ""));
	}		
	
	public static void initializeSettingsMenuItems(Player player) {
		
		Inventory inventory = InventoryList.inventorySettings.getInventory();
		
		inventory.setItem(49, GuiItem.createGuiItem(Material.BARRIER, ChatColor.DARK_RED + "Quitter", ""));
	}
	
	public static void initializeSettingsMenuDevItems(Player player) {
		
		Inventory inventory = InventoryList.inventorySettingsDevMod.getInventory();		
		
		inventory.setItem(49, GuiItem.createGuiItem(Material.BARRIER, ChatColor.DARK_RED + "Quitter", ""));
	}	
	
}
