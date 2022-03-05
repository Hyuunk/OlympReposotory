package fr.hyu.olympplayers.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
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
import org.bukkit.inventory.ItemStack;

import fr.hyu.olympperms.players.PlayerProfile;
import fr.hyu.olympperms.players.PlayerProfile.Stat;
import fr.hyu.olympperms.players.PlayerProfileManager;
import fr.hyu.olympplayers.gui.GuiManager.InventoryTypeList;

public class MenuManager implements Listener {

	//TO PREVENT MENU STARS AND TO OPEN
	
	@EventHandler
	public void onClickMenu(PlayerInteractEvent event) {

		Player player = (Player) event.getPlayer();

		if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& event.getItem() != null && event.getItem().getType() == Material.NETHER_STAR && event.getItem()
						.getItemMeta().getDisplayName().equals(ChatColor.GOLD.toString() + ChatColor.BOLD + "MENU")) {

			try {

				List<String> loresList = new ArrayList<String>();
				loresList.add("Cliquez sur l'étoile du nether pour ouvrir votre menu de joueur.");

				if (event.getItem().getItemMeta().getLore().equals(loresList)) {
					GuiManager.toOpen(event.getPlayer(), PlayerProfileManager.profiles.get(player)
							.getHashMapInventoryTypeToInventory().get(InventoryTypeList.inventoryPlayerMenu));
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

		//MENU ITEM FUNCTION
	public static void onMenuItem(Material material, Player player) {

		switch (material) {

		case SKULL_ITEM:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryProfile));
			break;

		case EXP_BOTTLE:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryStats));
			break;

		case BREWING_STAND_ITEM:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryJobs));
			break;

		case BOOK_AND_QUILL:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryQuests));
			break;

		case EMPTY_MAP:
			break;

		case REDSTONE_COMPARATOR:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventorySettings));
			break;

		case COMMAND:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryPlayerMenuDevMod));
			break;

		}
	}

	public static void onJobsItem(Material material, Player player) {

		switch (material) {

		case ARROW:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryPlayerMenu));
			break;
		}
	}

	public static void onProfileItem(Material material, Player player) {

		switch (material) {

		case ARROW:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryPlayerMenu));
			break;
		}
	}

	public static void onQuestsItem(Material material, Player player) {

		switch (material) {

		case ARROW:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryPlayerMenu));
			break;
		}
	}

	public static void onSettingsItem(Material material, Player player) {

		switch (material) {

		case ARROW:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryPlayerMenu));
			break;
		}
	}

	public static void onMenuStatsItem(Material material, Player player) {

		switch (material) {

		case ARROW:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryPlayerMenu));
			break;
		}
	}

	public static void onMenuDevItem(Material material, Player player) {

		switch (material) {

		case SKULL_ITEM:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryProfileDevMod));
			break;

		case EXP_BOTTLE:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryStatsDevMod));
			break;

		case BREWING_STAND_ITEM:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryJobsDevMod));
			break;

		case BOOK_AND_QUILL:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryQuestsDevMod));
			break;

		case EMPTY_MAP:
			break;

		case REDSTONE_COMPARATOR:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventorySettingsDevMod));
			break;

		case GRASS:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryPlayerMenu));
			break;
		}

	}

	public static void onJobsDevItem(Material material, Player player) {

		switch (material) {

		case ARROW:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryPlayerMenuDevMod));
			break;
		}
	}

	public static void onProfileDevItem(Material material, Player player) {

		switch (material) {

		case ARROW:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryPlayerMenuDevMod));
			break;
		}
	}

	public static void onQuestsDevItem(Material material, Player player) {

		switch (material) {

		case ARROW:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryPlayerMenuDevMod));
			break;
		}
	}

	public static void onSettingsDevItem(Material material, Player player) {

		switch (material) {

		case ARROW:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryPlayerMenuDevMod));
			break;
		}
	}

	public static void onMenuStatsDevItem(Material material, Player player) {

		switch (material) {

		case ARROW:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryPlayerMenuDevMod));
			break;
		}
	}

	// INVENTORY CREATOR

	public static void initializePlayerMenuItems(Player player, Inventory inventory) {

		inventory.setItem(4, GuiItem.createHeadItem(Material.SKULL_ITEM, player, ChatColor.GREEN + "Profile",
				ChatColor.BLUE.toString() + "note: mettre les dégats (et ce pour tout)",
				ChatColor.BLUE.toString() + "et non les stats pure, degats sur un monstre de meme niv que le joueur ",
				ChatColor.GRAY.toString() + "Rank: " + PlayerProfileManager.profiles.get(player).getRank(),
				ChatColor.GRAY.toString() + "Level: " + PlayerProfileManager.profiles.get(player).getLevel(),
				ChatColor.RED.toString() + "Health: " + PlayerProfileManager.profiles.get(player).getVitalityNative(),
				ChatColor.BLUE.toString() + "Defence: " + PlayerProfileManager.profiles.get(player).getDefenceNative(),
				ChatColor.RED.toString() + "Strength: " + PlayerProfileManager.profiles.get(player).getStrengthNative(),
				ChatColor.GOLD.toString() + "Endurance: "
						+ PlayerProfileManager.profiles.get(player).getEnduranceNative(),
				ChatColor.DARK_AQUA.toString() + "Intelligence: "
						+ PlayerProfileManager.profiles.get(player).getIntelligenceNative(),
				ChatColor.AQUA.toString() + "Mana: "
						+ PlayerProfileManager.profiles.get(player).getManaCapacityNative(),
				ChatColor.GREEN.toString() + "Luck WIP: ",
				ChatColor.LIGHT_PURPLE.toString() + "Karma: " + PlayerProfileManager.profiles.get(player).getKarma(),
				ChatColor.GOLD.toString() + "Gold: " + PlayerProfileManager.profiles.get(player).getGold()));

		inventory.setItem(10, GuiItem.createGuiItem(new ItemStack(Material.EXP_BOTTLE), ChatColor.BLUE + "Statistiques", ""));

		inventory.setItem(11, GuiItem.createGuiItem(new ItemStack(Material.BREWING_STAND_ITEM), ChatColor.GREEN + "Métiers", ""));

		inventory.setItem(15, GuiItem.createGuiItem(new ItemStack(Material.BOOK_AND_QUILL), ChatColor.LIGHT_PURPLE + "Quêtes", ""));

		inventory.setItem(16, GuiItem.createGuiItem(new ItemStack(Material.EMPTY_MAP), ChatColor.YELLOW + "Map", ""));

		inventory.setItem(31, GuiItem.createGuiItem(new ItemStack(Material.BARRIER), ChatColor.DARK_RED + "Quitter", ""));

		inventory.setItem(32, GuiItem.createGuiItem(new ItemStack(Material.REDSTONE_COMPARATOR), ChatColor.RED + "Paramètres", ""));

		if (player.isOp()) {
			inventory.setItem(30, GuiItem.createGuiItem(new ItemStack(Material.COMMAND), ChatColor.GOLD + "DevMod", ""));
		}

	}

	public static void initializeProfileMenuItems(Player player, Inventory inventory) {

		inventory.setItem(45, GuiItem.createGuiItem(new ItemStack(Material.ARROW), ChatColor.YELLOW + "Retour", ""));

		inventory.setItem(49, GuiItem.createGuiItem(new ItemStack(Material.BARRIER), ChatColor.DARK_RED + "Quitter", ""));

	}

	public static void initializeStatsMenuItems(Player player, Inventory inventory) {

		//STATS ITEMS
		inventory.setItem(10, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 14), ChatColor.RED + "\u2756 Vitalité : " + PlayerProfile.getStat(player, Stat.VITALITYNATIVE), ChatColor.GRAY + "La vitalité vous permet d'augmenter votre vie maximale et votre défense"));
		
		inventory.setItem(12, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 5), ChatColor.GREEN + "\u03A8 Force : " + PlayerProfile.getStat(player, Stat.STRENGTHNATIVE), ""));
		
		inventory.setItem(14, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 4), ChatColor.YELLOW + "\u2727 Dexterité : " + PlayerProfile.getStat(player, Stat.DEXTIRITYNATIVE), ""));
		
		inventory.setItem(16, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 0), ChatColor.WHITE + "Agilité : " + PlayerProfile.getStat(player, Stat.AGILITYNATIVE), ""));
		
		inventory.setItem(21, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 3), ChatColor.BLUE + "Intelligence : " + PlayerProfile.getStat(player, Stat.INTELLIGENCENATIVE), ""));
		
		inventory.setItem(23, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 2), ChatColor.DARK_PURPLE + "\u29FE Foi : " + PlayerProfile.getStat(player, Stat.FAITHNATIVE), ""));
		
		//MENU ITEMS
		inventory.setItem(45, GuiItem.createGuiItem(new ItemStack(Material.ARROW), ChatColor.YELLOW + "Retour", ""));

		inventory.setItem(49, GuiItem.createGuiItem(new ItemStack(Material.BARRIER), ChatColor.DARK_RED + "Quitter", ""));
	}

	public static void initializeJobsMenuItems(Player player, Inventory inventory) {

		inventory.setItem(45, GuiItem.createGuiItem(new ItemStack(Material.ARROW), ChatColor.YELLOW + "Retour", ""));

		inventory.setItem(49, GuiItem.createGuiItem(new ItemStack(Material.BARRIER), ChatColor.DARK_RED + "Quitter", ""));
	}

	public static void initializeQuestsMenuItems(Player player, Inventory inventory) {

		inventory.setItem(45, GuiItem.createGuiItem(new ItemStack(Material.ARROW), ChatColor.YELLOW + "Retour", ""));

		inventory.setItem(49, GuiItem.createGuiItem(new ItemStack(Material.BARRIER), ChatColor.DARK_RED + "Quitter", ""));
	}

	public static void initializeSettingsMenuItems(Player player, Inventory inventory) {

		inventory.setItem(45, GuiItem.createGuiItem(new ItemStack(Material.ARROW), ChatColor.YELLOW + "Retour", ""));

		inventory.setItem(49, GuiItem.createGuiItem(new ItemStack(Material.BARRIER), ChatColor.DARK_RED + "Quitter", ""));
	}

	// INVENTORY DEV CREATOR

	public static void initializePlayerMenuDevItems(Player player, Inventory inventory) {

		inventory.setItem(4, GuiItem.createHeadItem(Material.SKULL_ITEM, player, ChatColor.GREEN + "Profile",
				ChatColor.BLUE.toString() + "note: mettre les dégats (et ce pour tout)",
				ChatColor.BLUE.toString() + "et non les stats pure, degats sur un monstre de meme niv que le joueur ",
				ChatColor.GRAY.toString() + "Rank: " + PlayerProfileManager.profiles.get(player).getRank(),
				ChatColor.GRAY.toString() + "Level: " + PlayerProfileManager.profiles.get(player).getLevel(),
				ChatColor.RED.toString() + "Health: " + PlayerProfileManager.profiles.get(player).getVitalityNative(),
				ChatColor.BLUE.toString() + "Defence: " + PlayerProfileManager.profiles.get(player).getDefenceNative(),
				ChatColor.RED.toString() + "Strength: " + PlayerProfileManager.profiles.get(player).getStrengthNative(),
				ChatColor.GOLD.toString() + "Endurance: "
						+ PlayerProfileManager.profiles.get(player).getEnduranceNative(),
				ChatColor.DARK_AQUA.toString() + "Intelligence: "
						+ PlayerProfileManager.profiles.get(player).getIntelligenceNative(),
				ChatColor.AQUA.toString() + "Mana: "
						+ PlayerProfileManager.profiles.get(player).getManaCapacityNative(),
				ChatColor.GREEN.toString() + "Luck WIP: ",
				ChatColor.LIGHT_PURPLE.toString() + "Karma: " + PlayerProfileManager.profiles.get(player).getKarma(),
				ChatColor.GOLD.toString() + "Gold: " + PlayerProfileManager.profiles.get(player).getGold()));

		inventory.setItem(10, GuiItem.createGuiItem(new ItemStack(Material.EXP_BOTTLE), ChatColor.BLUE + "Statistiques", ""));

		inventory.setItem(11, GuiItem.createGuiItem(new ItemStack(Material.BREWING_STAND_ITEM), ChatColor.GREEN + "Métiers", ""));

		inventory.setItem(15, GuiItem.createGuiItem(new ItemStack(Material.BOOK_AND_QUILL), ChatColor.LIGHT_PURPLE + "Quêtes", ""));

		inventory.setItem(16, GuiItem.createGuiItem(new ItemStack(Material.EMPTY_MAP), ChatColor.YELLOW + "Map", ""));

		inventory.setItem(31, GuiItem.createGuiItem(new ItemStack(Material.BARRIER), ChatColor.DARK_RED + "Quitter", ""));

		inventory.setItem(32, GuiItem.createGuiItem(new ItemStack(Material.REDSTONE_COMPARATOR), ChatColor.RED + "Paramètres", ""));

		if (player.isOp()) {
			inventory.setItem(30, GuiItem.createGuiItem(new ItemStack(Material.GRASS), ChatColor.GREEN + "NormalMod", ""));
		}
	}

	public static void initializeProfileMenuDevItems(Player player, Inventory inventory) {

		inventory.setItem(45, GuiItem.createGuiItem(new ItemStack(Material.ARROW), ChatColor.YELLOW + "Retour", ""));

		inventory.setItem(49, GuiItem.createGuiItem(new ItemStack(Material.BARRIER), ChatColor.DARK_RED + "Quitter", ""));
	}

	public static void initializeStatsMenuDevItems(Player player, Inventory inventory) {
		
		//STATS ITEMS
		inventory.setItem(10, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 14), ChatColor.RED + "Vitalité", ""));
		
		inventory.setItem(12, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 5), ChatColor.GREEN + "Force", ""));
		
		inventory.setItem(14, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 4), ChatColor.YELLOW + "Dexterité", ""));
		
		inventory.setItem(16, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 0), ChatColor.WHITE + "Agilité", ""));
		
		inventory.setItem(21, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 3), ChatColor.BLUE + "Intelligence", ""));
		
		inventory.setItem(23, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 2), ChatColor.DARK_PURPLE + "Foi", ""));
		
		//MENU ITEMS
		inventory.setItem(45, GuiItem.createGuiItem(new ItemStack(Material.ARROW), ChatColor.YELLOW + "Retour", ""));

		inventory.setItem(49, GuiItem.createGuiItem(new ItemStack(Material.BARRIER), ChatColor.DARK_RED + "Quitter", ""));
	}

	public static void initializeJobsMenuDevItems(Player player, Inventory inventory) {

		inventory.setItem(45, GuiItem.createGuiItem(new ItemStack(Material.ARROW), ChatColor.YELLOW + "Retour", ""));

		inventory.setItem(49, GuiItem.createGuiItem(new ItemStack(Material.BARRIER), ChatColor.DARK_RED + "Quitter", ""));
	}

	public static void initializeQuestsMenuDevItems(Player player, Inventory inventory) {

		inventory.setItem(45, GuiItem.createGuiItem(new ItemStack(Material.ARROW), ChatColor.YELLOW + "Retour", ""));

		inventory.setItem(49, GuiItem.createGuiItem(new ItemStack(Material.BARRIER), ChatColor.DARK_RED + "Quitter", ""));
	}

	public static void initializeSettingsMenuDevItems(Player player, Inventory inventory) {

		inventory.setItem(45, GuiItem.createGuiItem(new ItemStack(Material.ARROW), ChatColor.YELLOW + "Retour", ""));

		inventory.setItem(49, GuiItem.createGuiItem(new ItemStack(Material.BARRIER), ChatColor.DARK_RED + "Quitter", ""));
	}
}
