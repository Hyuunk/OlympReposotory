package fr.hyu.olympplayers.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


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

					MenuGuiSummoner();
					openInventory(event.getPlayer());
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
					System.out.println(" error inventory ");
				}
		}
	}

	// INVENTORY CREATOR
	private Inventory inv;

	public void MenuGuiSummoner() {

		inv = Bukkit.createInventory(null, 9, "MENU");

		initializeMenuItems();
	}

	public void initializeMenuItems() {

		inv.setItem(1, GuiItem.createGuiItem(Material.DIAMOND_SWORD, "Example Sword", "§aFirst line of the lore",
				"§bSecond line of the lore"));
		inv.setItem(3, GuiItem.createGuiItem(Material.IRON_HELMET, "§bExample Helmet", "§aFirst line of the lore",
				"§bSecond line of the lore"));
	}

	public void openInventory(final HumanEntity entity) {
		entity.openInventory(inv);
	}

	@EventHandler
	public void onInventoryClick(final InventoryClickEvent event) {
		if (!event.getInventory().equals(inv))
			return;

		event.setCancelled(true);

		final ItemStack clickedItem = event.getCurrentItem();

		if (clickedItem == null || clickedItem.getType() == Material.AIR)
			return;

		final Player player = (Player) event.getWhoClicked();

		player.sendMessage("You clicked at slot " + event.getRawSlot());
	}

	@EventHandler
	public void onInventoryClick(final InventoryDragEvent event) {
		if (event.getInventory().equals(inv)) {
			event.setCancelled(true);
		}
	}

}
