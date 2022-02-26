package fr.hyu.olympplayers.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class GuiManager implements Listener {
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		
		ItemStack clickedItem = event.getCurrentItem();
		Material materialItem = clickedItem.getType();
		String nameItem = clickedItem.getItemMeta().getDisplayName();
		Player player = (Player) event.getWhoClicked();
		
		if (getListInventory().contains(event.getInventory())) {
			
			event.setCancelled(true);
			
			if (clickedItem == null || clickedItem.getType() == Material.AIR) {
				return;
			} else {
				switch (event.getInventory().getName().toUpperCase()) {
					case "PLAYER MENU":
						if (materialItem == Material.BARRIER && nameItem.equals(ChatColor.DARK_RED + "Quitter")) {
							closeInventory(player);
						}
						break;
					case "Player Menu (devmod)":
						
						break;
				}
						
			}			


		player.sendMessage("You clicked at slot " + event.getRawSlot());
	}
}

	@EventHandler
	public void onInventoryDrag(InventoryDragEvent event) {
		if (getListInventory().contains(event.getInventory())) {
			event.setCancelled(true);
		}
	}			
	
	public static void openInventory(HumanEntity entity, Inventory inventory) {
		entity.openInventory(inventory);
	}
	
	public static void closeInventory(HumanEntity entity) {
		entity.closeInventory();
	}
	
	public enum InventoryList {
		
		inventoryNot(null, 0, "null"),
		inventoryMenu(null, 27, "Player Menu"),
		inventoryMenuDevMod(null, 27, "Player Menu (devmod)");
	
		private Inventory inventory;
		private InventoryHolder inventoryHolder;
		private int slotNumber;
		private String inventoryName;
		
		InventoryList(InventoryHolder inventoryHolder, int slotNumber, String inventoryName) {
			this.inventory = Bukkit.createInventory(inventoryHolder, slotNumber, inventoryName);
			this.inventoryHolder = inventoryHolder;
			this.slotNumber = slotNumber;
			this.inventoryName = inventoryName;
		}
		
		public Inventory getInventory() {
			return inventory;
		}
		
		public InventoryHolder getInventoryHolder() {
			return inventoryHolder;
		}

		public int getSlotNumber() {
			return slotNumber;
		}

		public String getInventoryName() {
			return inventoryName;
		}
	}
	
	public static List<Inventory> getListInventory() {
		List<Inventory> inventoryList = new ArrayList<Inventory>();
		for (InventoryList inventory : InventoryList.values()) {
			inventoryList.add(inventory.getInventory());			
		}
		return inventoryList;
	}	
	
	public static List<String> getListNameInventory() {
		List<String> inventoryList = new ArrayList<String>();
		for (InventoryList inventory : InventoryList.values()) {
			inventoryList.add(inventory.getInventoryName());			
		}
		return inventoryList;
	}
	
}
