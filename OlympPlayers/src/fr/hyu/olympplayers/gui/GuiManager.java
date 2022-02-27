package fr.hyu.olympplayers.gui;

import java.util.ArrayList;
import java.util.HashMap;
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
		Player player = (Player) event.getWhoClicked();
		
		if (getListInventory().contains(event.getInventory())) {			
			event.setCancelled(true);
			
			if (clickedItem == null || clickedItem.getType() == Material.AIR) {
				return;
				
			} else {				
				
				Material materialItem = clickedItem.getType();
				
				//Barrier Block -> on every inventory, leave
				if (materialItem == Material.BARRIER) {
					closeInventory(player);
					
				} else {		
					
				switch (event.getInventory().getName()) {
				
					case "Player Menu":
					
						MenuManager.onMenuItem(materialItem, player);
						
						player.sendMessage("player menu");
						break;
						
					case "Player Menu (devmod)":
						
						MenuManager.onMenuDevItem(materialItem, player);
						
						player.sendMessage("player menu (devmod)");
						break;
				}
						
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
		inventoryPlayerMenu(null, 36, "Player Menu"),
		inventoryPlayerMenuDevMod(null, 36, "Player Menu (devmod)"),
		inventoryProfile(null, 54, "Profile"),
		inventoryProfileDevMod(null, 54, "Profile (devmod)"),
		inventoryStats(null, 54, "Stats"),
		inventoryStatsDevMod(null, 54, "Stats (devmod)"),
		inventoryJobs(null, 54, "Jobs"),
		inventoryJobsDevMod(null, 54, "Jobs (devmod)"),
		inventoryQuests(null, 54, "Quests"),
		inventoryQuestsDevMod(null, 54, "Quests (devmod)"),
		inventorySettings(null, 54, "Settings"),
		inventorySettingsDevMod(null, 54, "Settings (devmod)");
		
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
	
	public static HashMap<Inventory, InventoryList> getHashMapInventory() {
		HashMap<Inventory, InventoryList> inventoryHashMap = new HashMap<Inventory, InventoryList>();
		for (InventoryList inventory : InventoryList.values()) {
			inventoryHashMap.put(inventory.getInventory(), inventory);
		}
		return inventoryHashMap;
	}
	
	public static HashMap<String, InventoryList> getHashMapNameInventory() {
		HashMap<String, InventoryList> inventoryHashMap = new HashMap<String, InventoryList>();
		for (InventoryList inventory : InventoryList.values()) {
			inventoryHashMap.put(inventory.getInventoryName(), inventory);
		}
		return inventoryHashMap;
	}
	
	public static void initialize(Player player, Inventory inventory) {
		
		if (getListInventory().contains(inventory)) {
			
		switch (getHashMapInventory().get(inventory)) {
					
			case inventoryJobs: MenuManager.initializeJobsMenuItems(player);				
				break;		
			case inventoryJobsDevMod: MenuManager.initializeJobsMenuDevItems(player);				
				break;				
			case inventoryPlayerMenu: MenuManager.initializePlayerMenuItems(player);				
				break;
			case inventoryPlayerMenuDevMod: MenuManager.initializePlayerMenuDevItems(player);				
				break;
			case inventoryProfile: MenuManager.initializeProfileMenuItems(player);	 			
				break;
			case inventoryProfileDevMod: MenuManager.initializeProfileMenuDevItems(player);				
				break;
			case inventoryQuests: MenuManager.initializeQuestsMenuItems(player);
				break;
			case inventoryQuestsDevMod: MenuManager.initializeQuestsMenuDevItems(player);
				break;
			case inventorySettings: MenuManager.initializeSettingsMenuItems(player);
				break;
			case inventorySettingsDevMod: MenuManager.initializeSettingsMenuDevItems(player);
				break;
			case inventoryStats: MenuManager.initializeStatsMenuItems(player);
				break;
			case inventoryStatsDevMod: MenuManager.initializeStatsMenuDevItems(player);
				break;
				// No return
			case inventoryNot: 		
				break;	
				// Error Return
			default: System.out.println("[OLYMPPLAYERS] (GuiManager.initialize) inventory initialize path not defined");
				break;

			}
			
		} else {
			System.out.println("[OLYMPPLAYERS] (GuiManager.initialize) inventory not recognized");
		}
		
		
	}
}
