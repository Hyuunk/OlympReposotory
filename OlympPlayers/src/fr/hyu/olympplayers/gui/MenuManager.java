package fr.hyu.olympplayers.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import fr.hyu.olympplayers.Main;
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
	public static void onMenuItem(ItemStack itemStack, Player player, InventoryAction action) {

		Material material = itemStack.getType();
		
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

	public static void onJobsItem(ItemStack itemStack, Player player, InventoryAction action) {

		Material material = itemStack.getType();
		
		switch (material) {

		case ARROW:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryPlayerMenu));
			break;
		}
	}

	public static void onProfileItem(ItemStack itemStack, Player player, InventoryAction action) {

		Material material = itemStack.getType();
		
		switch (material) {

		case ARROW:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryPlayerMenu));
			break;
		}
	}

	public static void onQuestsItem(ItemStack itemStack, Player player, InventoryAction action) {

		Material material = itemStack.getType();
		
		switch (material) {

		case ARROW:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryPlayerMenu));
			break;
		}
	}

	public static void onSettingsItem(ItemStack itemStack, Player player, InventoryAction action) {

		Material material = itemStack.getType();
		
		switch (material) {

		case ARROW:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryPlayerMenu));
			break;
		}
	}

	public static void onMenuStatsItem(ItemStack itemStack, Player player, InventoryAction action) {

		Material material = itemStack.getType();
		
		switch (material) {

		case STAINED_CLAY:
			 
			switch (itemStack.getDurability()) {
			
			case 14:
				
				onActionItem(player, Stat.VITALITYNATIVE, action, 19);
				break;
				
			case 5:
					
				onActionItem(player, Stat.STRENGTHNATIVE, action, 21);
				break;
				
			case 4:
				
				onActionItem(player, Stat.DEXTIRITYNATIVE, action, 23);
				break;
				
			case 0:
				
				onActionItem(player, Stat.AGILITYNATIVE, action, 25);
				break;
				
			case 3:
				
				onActionItem(player, Stat.INTELLIGENCENATIVE, action, 30);
				break;
				
			case 2:
				
				onActionItem(player, Stat.FAITHNATIVE, action, 32);
				break;
			
			}
			
			break;
			
		case ARROW:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryPlayerMenu));
			break;
			
		}
	}

	public static void onMenuDevItem(ItemStack itemStack, Player player, InventoryAction action) {

		Material material = itemStack.getType();
		
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

	public static void onJobsDevItem(ItemStack itemStack, Player player, InventoryAction action) {

		Material material = itemStack.getType();
		
		switch (material) {

		case ARROW:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryPlayerMenuDevMod));
			break;
		}
	}

	public static void onProfileDevItem(ItemStack itemStack, Player player, InventoryAction action) {

		Material material = itemStack.getType();
		
		switch (material) {

		case ARROW:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryPlayerMenuDevMod));
			break;
		}
	}

	public static void onQuestsDevItem(ItemStack itemStack, Player player, InventoryAction action) {

		Material material = itemStack.getType();
		
		switch (material) {

		case ARROW:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryPlayerMenuDevMod));
			break;
		}
	}

	public static void onSettingsDevItem(ItemStack itemStack, Player player, InventoryAction action) {

		Material material = itemStack.getType();
		
		switch (material) {

		case ARROW:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryPlayerMenuDevMod));
			break;
		}
	}

	public static void onMenuStatsDevItem(ItemStack itemStack, Player player, InventoryAction action) {

		Material material = itemStack.getType();
		
		switch (material) {
		
		case STAINED_CLAY:
					
			switch (itemStack.getDurability()) {
			
			case 14:
				
				onActionDevItem(player, Stat.VITALITYNATIVE, action);
				break;
				
			case 5:
					
				onActionDevItem(player, Stat.STRENGTHNATIVE, action);
				break;
				
			case 4:
				
				onActionDevItem(player, Stat.DEXTIRITYNATIVE, action);
				break;
				
			case 0:
				
				onActionDevItem(player, Stat.AGILITYNATIVE, action);
				break;
				
			case 3:
				
				onActionDevItem(player, Stat.INTELLIGENCENATIVE, action);
				break;
				
			case 2:
				
				onActionDevItem(player, Stat.FAITHNATIVE, action);
				break;
			
			}
			
			break;
			
		case ARROW:
			GuiManager.toOpen(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
					.get(InventoryTypeList.inventoryPlayerMenuDevMod));
			break;
		}
	}
	
private static void onActionItem(Player player, Stat stat, InventoryAction action, int slot) {	
			
		switch (action) {
		
		//left click
		case PICKUP_ALL:		
			
			if (PlayerProfile.getStat(player, Stat.POINTSAVAILABLES) > 0) { 
			PlayerProfile.addStat(player, stat, 1);		
			PlayerProfile.addStat(player, Stat.POINTSAVAILABLES, -1);
			
			} else {		
				
				PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory().get(InventoryTypeList.inventoryStats).setItem(slot, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 14), ChatColor.RED + "Point insuffisant !"));
			
		    }		
			
			break;
			 
		case PICKUP_HALF:
			
			if (PlayerProfile.getStat(player, Stat.POINTSAVAILABLES) > 4) { 
			PlayerProfile.addStat(player, stat, 5);
			PlayerProfile.addStat(player, Stat.POINTSAVAILABLES, -5);
			
			} else {	
				
				PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory().get(InventoryTypeList.inventoryStats).setItem(slot, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 14), ChatColor.RED + "Points insuffisants !"));				
		    }	
			
			break;	
		}
		
		GuiManager.toActualize(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
				.get(InventoryTypeList.inventoryStats));
		
	}
	
	private static void onActionDevItem(Player player, Stat stat, InventoryAction action) {
		
		switch (action) {
		
		//left click
		case PICKUP_ALL:
			
			PlayerProfile.addStat(player, stat, 1);		
			break;
			
		//right click
		case PICKUP_HALF:
			
			PlayerProfile.addStat(player, stat, 5);
			break;
		
		//drop
		case DROP_ONE_SLOT:
			PlayerProfile.addStat(player, stat, -1);
			
			break;
			
		//ctrl + drop
		case DROP_ALL_SLOT:
			PlayerProfile.addStat(player, stat, -5);
			break;
		}
		
		GuiManager.toActualize(player, PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory()
				.get(InventoryTypeList.inventoryStatsDevMod));
	}

	// INVENTORY CREATOR

	public static void initializePlayerMenuItems(Player player, Inventory inventory) {

		inventory.setItem(4, GuiItem.createHeadItem(Material.SKULL_ITEM, player, ChatColor.GREEN + "Profile",
				ChatColor.BLUE.toString() + "note: mettre les dégats (et ce pour tout)",
				ChatColor.BLUE.toString() + "et non les stats pure, degats sur un monstre de meme niv que le joueur ",
				ChatColor.GRAY.toString() + "Rank " + PlayerProfileManager.profiles.get(player).getRank(),
				ChatColor.GRAY.toString() + "Niveau " + PlayerProfile.getStat(player, Stat.LEVEL),
				ChatColor.RED.toString() + "\u2764 Vitalité " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.VITALITYNATIVE),
				ChatColor.BLUE.toString() + "\u2748 Defence " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.DEFENCENATIVE),
				ChatColor.GREEN.toString() + "\u03A8 Force " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.STRENGTHNATIVE),
				ChatColor.YELLOW.toString() + "\u27B6 Dexterité " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.DEXTIRITYNATIVE),
				ChatColor.GOLD.toString() + "\u26A1 Endurance " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.ENDURENCENATIVE),
				ChatColor.BLUE.toString() + "\u2745 Intelligence " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.INTELLIGENCENATIVE),
				ChatColor.DARK_PURPLE.toString() + "\u29FE Foi " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.FAITHNATIVE),
				ChatColor.AQUA.toString() + "\u224B Mana " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.MANACAPACITYNATIVE),
				ChatColor.WHITE.toString() + "\u2727 Agilité " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.AGILITYNATIVE),
				ChatColor.GREEN.toString() + "\u2618 Luck WIP ",
				ChatColor.LIGHT_PURPLE.toString() + "\u2756 Karma " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.KARMA)));

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
		inventory.setItem(19, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 14), ChatColor.RED + "\u2764 Vitalité " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.VITALITYNATIVE),
				ChatColor.GRAY + "La vitalité vous permet d'augmenter votre vie maximale et votre défense.",
				"",
				ChatColor.GREEN + "Clic gauche + Ajouter 1 point",
				ChatColor.GREEN + "Clic droit + Ajouter 5 points"));
		
		inventory.setItem(21, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 5), ChatColor.GREEN + "\u03A8 Force " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.STRENGTHNATIVE),
				ChatColor.GRAY + "La force vous permet d'augmenter vos dégats physiques et vos dégats physiques critiques.",
				"",
				ChatColor.GREEN + "Clic gauche + Ajouter 1 point",
				ChatColor.GREEN + "Clic droit + Ajouter 5 points"));	
		
		inventory.setItem(23, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 4), ChatColor.YELLOW + "\u27B6 Dexterité " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.DEXTIRITYNATIVE),
				ChatColor.GRAY + "La dexterité vous permet d'augmenter vos chances de coup critique physique.",
				"",
				ChatColor.GREEN + "Clic gauche + Ajouter 1 point",
				ChatColor.GREEN + "Clic droit + Ajouter 5 points"));
		
		inventory.setItem(25, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 0), ChatColor.WHITE + "\u2727 Agilité " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.AGILITYNATIVE),
				ChatColor.GRAY + "L'agilité vous permet d'augmenter vos chances d'esquives et votre vitesse de déplacement.",
				"",
				ChatColor.GREEN + "Clic gauche + Ajouter 1 point",
				ChatColor.GREEN + "Clic droit + Ajouter 5 points"));
		
		inventory.setItem(30, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 3), ChatColor.BLUE + "\u2745 Intelligence " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.INTELLIGENCENATIVE),
				ChatColor.GRAY + "L'intelligence vous permet d'augmenter vos dégats magiques et vos dégats magiques critiques.",
				"",
				ChatColor.GREEN + "Clic gauche + Ajouter 1 point",
				ChatColor.GREEN + "Clic droit + Ajouter 5 points"));
		
		inventory.setItem(32, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 2), ChatColor.DARK_PURPLE + "\u29FE Foi " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.FAITHNATIVE),
				ChatColor.GRAY + "La foi vous permet d'augmenter vos chances de coup critique magiques.",
				"",
				ChatColor.GREEN + "Clic gauche + Ajouter 1 point",
				ChatColor.GREEN + "Clic droit + Ajouter 5 points"));
		
		
		//OTHERS ITEMS
		if (PlayerProfileManager.profiles.get(player).getPointsAvailables() == 0) {			
		inventory.setItem(4, GuiItem.createGuiItem(new ItemStack(Material.BOOK), ChatColor.GOLD + "Point disponible " + ChatColor.GRAY + PlayerProfileManager.profiles.get(player).getPointsAvailables(), ""));
		} else if (PlayerProfileManager.profiles.get(player).getPointsAvailables() == 1) {
		inventory.setItem(4, GuiItem.createGuiItem(new ItemStack(Material.ENCHANTED_BOOK), ChatColor.GOLD + "Point disponible " + ChatColor.GRAY + PlayerProfileManager.profiles.get(player).getPointsAvailables(), ""));
		} else {
		inventory.setItem(4, GuiItem.createGuiItem(new ItemStack(Material.ENCHANTED_BOOK), ChatColor.GOLD + "Points disponibles " + ChatColor.GRAY + PlayerProfileManager.profiles.get(player).getPointsAvailables(), ""));	
		}
		
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
				ChatColor.GRAY.toString() + "Rank : " + PlayerProfileManager.profiles.get(player).getRank(),
				ChatColor.GRAY.toString() + "Niveau : " + PlayerProfile.getStat(player, Stat.LEVEL),
				ChatColor.RED.toString() + "\u2756 Vitalité : " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.VITALITYNATIVE),
				ChatColor.BLUE.toString() + "Defence : " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.DEFENCENATIVE),
				ChatColor.GREEN.toString() + " \u03A8 Force : " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.STRENGTHNATIVE),
				ChatColor.YELLOW.toString() + "\u2727 Dexterité : " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.DEXTIRITYNATIVE),
				ChatColor.GOLD.toString() + "Endurance : " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.ENDURENCENATIVE),
				ChatColor.BLUE.toString() + "Intelligence : " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.INTELLIGENCENATIVE),
				ChatColor.DARK_PURPLE.toString() + "\u29FE Foi : " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.FAITHNATIVE),
				ChatColor.AQUA.toString() + "Mana : " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.MANACAPACITYNATIVE),
				ChatColor.WHITE.toString() + "Agilité : " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.AGILITYNATIVE),
				ChatColor.GREEN.toString() + "Luck WIP: ",
				ChatColor.LIGHT_PURPLE.toString() + "Karma: " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.KARMA),
				ChatColor.GOLD.toString() + "Gold: " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.GOLD)));

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
		inventory.setItem(19, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 14), ChatColor.RED + "\u2764 Vitalité " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.VITALITYNATIVE),
				ChatColor.GRAY + "La vitalité vous permet d'augmenter votre vie maximale et votre défense.",
				"",
				ChatColor.GREEN + "Clic gauche + Ajouter 1 point",
				ChatColor.GREEN + "Clic droit + Ajouter 5 points",
				"",
				ChatColor.RED + "Jeter - Retirer 1 point",
				ChatColor.RED + "Ctrl + Jeter - Retirer 5 points"));
		
		inventory.setItem(21, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 5), ChatColor.GREEN + "\u03A8 Force " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.STRENGTHNATIVE),
				ChatColor.GRAY + "La force vous permet d'augmenter vos dégats physiques et vos dégats physiques critiques.",
				"",
				ChatColor.GREEN + "Clic gauche + Ajouter 1 point",
				ChatColor.GREEN + "Clic droit + Ajouter 5 points",
				"",
				ChatColor.RED + "Jeter - Retirer 1 point",
				ChatColor.RED + "Ctrl + Jeter - Retirer 5 points"));
		
		inventory.setItem(23, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 4), ChatColor.YELLOW + "\u27B6 Dexterité " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.DEXTIRITYNATIVE),
				ChatColor.GRAY + "La dexterité vous permet d'augmenter vos chances de coup critique physique.",
				"",
				ChatColor.GREEN + "Clic gauche + Ajouter 1 point",
				ChatColor.GREEN + "Clic droit + Ajouter 5 points",
				"",
				ChatColor.RED + "Jeter - Retirer 1 point",
				ChatColor.RED + "Ctrl + Jeter - Retirer 5 points"));
		
		inventory.setItem(25, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 0), ChatColor.WHITE + "\u2727 Agilité " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.AGILITYNATIVE),
				ChatColor.GRAY + "L'agilité vous permet d'augmenter vos chances d'esquives et votre vitesse de déplacement.",
				"",
				ChatColor.GREEN + "Clic gauche + Ajouter 1 point",
				ChatColor.GREEN + "Clic droit + Ajouter 5 points",
				"",
				ChatColor.RED + "Jeter - Retirer 1 point",
				ChatColor.RED + "Ctrl + Jeter - Retirer 5 points"));

		inventory.setItem(30, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 3), ChatColor.BLUE + "\u2745 Intelligence " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.INTELLIGENCENATIVE),
				ChatColor.GRAY + "L'intelligence vous permet d'augmenter vos dégats magiques et vos dégats magiques critiques.",
				"",
				ChatColor.GREEN + "Clic gauche + Ajouter 1 point",
				ChatColor.GREEN + "Clic droit + Ajouter 5 points",
				"",
				ChatColor.RED + "Jeter - Retirer 1 point",
				ChatColor.RED + "Ctrl + Jeter - Retirer 5 points"));

		inventory.setItem(32, GuiItem.createGuiItem(new ItemStack(Material.STAINED_CLAY, 1, (short) 2), ChatColor.DARK_PURPLE + "\u29FE Foi " + ChatColor.GRAY + PlayerProfile.getStat(player, Stat.FAITHNATIVE),
				ChatColor.GRAY + "La foi vous permet d'augmenter vos chances de coup critique magiques.",
				"",
				ChatColor.GREEN + "Clic gauche + Ajouter 1 point",
				ChatColor.GREEN + "Clic droit + Ajouter 5 points",
				"",
				ChatColor.RED + "Jeter - Retirer 1 point",
				ChatColor.RED + "Ctrl + Jeter - Retirer 5 points"));
		
				
		//OTHERS ITEMS
		if (PlayerProfileManager.profiles.get(player).getPointsAvailables() == 0) {			
		inventory.setItem(4, GuiItem.createGuiItem(new ItemStack(Material.BOOK), ChatColor.GOLD + "Point disponible " + ChatColor.GRAY + PlayerProfileManager.profiles.get(player).getPointsAvailables(), ""));
		} else if (PlayerProfileManager.profiles.get(player).getPointsAvailables() == 1) {
		inventory.setItem(4, GuiItem.createGuiItem(new ItemStack(Material.ENCHANTED_BOOK), ChatColor.GOLD + "Point disponible " + ChatColor.GRAY + PlayerProfileManager.profiles.get(player).getPointsAvailables(), ""));
		} else {
		inventory.setItem(4, GuiItem.createGuiItem(new ItemStack(Material.ENCHANTED_BOOK), ChatColor.GOLD + "Points disponibles " + ChatColor.GRAY + PlayerProfileManager.profiles.get(player).getPointsAvailables(), ""));	
		}
		
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
