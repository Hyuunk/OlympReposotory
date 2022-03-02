package fr.hyu.olympplayers.gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
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

import fr.hyu.olympperms.players.PlayerProfileManager;
import fr.hyu.olympplayers.gui.GuiManager.InventoryTypeList;

public class GuiManager implements Listener {
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		
		ItemStack clickedItem = event.getCurrentItem();
		Player player = (Player) event.getWhoClicked();
		
		if (PlayerProfileManager.profiles.get(player).getInventories().contains(event.getInventory())) {			
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
		Player player = (Player) event.getWhoClicked();
		if (PlayerProfileManager.profiles.get(player).getInventories().contains(event.getInventory())) {
			event.setCancelled(true);
		}
	}			
	
	public static void openInventory(HumanEntity entity, Inventory inventory) {
		entity.openInventory(inventory);
	}
	
	public static void closeInventory(HumanEntity entity) {
		entity.closeInventory();
	}
	
	public enum InventoryTypeList { //PRIVATE INV
		
		inventoryNot(0, "null"),
		inventoryPlayerMenu(36, "Player Menu"),
		inventoryPlayerMenuDevMod(36, "Player Menu (devmod)"),
		inventoryProfile(54, "Profile"),
		inventoryProfileDevMod(54, "Profile (devmod)"),
		inventoryStats(54, "Stats"),
		inventoryStatsDevMod(54, "Stats (devmod)"),
		inventoryJobs(54, "Jobs"),
		inventoryJobsDevMod(54, "Jobs (devmod)"),
		inventoryQuests(54, "Quests"),
		inventoryQuestsDevMod(54, "Quests (devmod)"),
		inventorySettings(54, "Settings"),
		inventorySettingsDevMod(54, "Settings (devmod)");
		
		private int slotNumber;
		private String inventoryName;
		
		InventoryTypeList(int slotNumber, String inventoryName) {
			this.slotNumber = slotNumber;
			this.inventoryName = inventoryName;
		}	
			
		public Inventory createInventory(Player player) {
			return Bukkit.createInventory(player, slotNumber, inventoryName);
		}
			
		public int getSlotNumber() {
			return slotNumber;
		}

		public String getInventoryName() {
			return inventoryName;
		}		
	}

	

	public static List<String> getListNameInventory(Player player) {
		
		List<String> inventoryList = new ArrayList<String>();
		
		for (int i = 0; i < PlayerProfileManager.profiles.get(player).getInventories().size(); i++) {
			inventoryList.add(PlayerProfileManager.profiles.get(player).getInventories().get(i).getName());
		}
		
		return inventoryList;
	}

	public static boolean isInventoryType(Inventory inventory) {
		
		String inventoryName = inventory.getName();
		int inventorySize = inventory.getSize();
		
		for (InventoryTypeList inv : InventoryTypeList.values()) {
			if(inv.getSlotNumber() == inventorySize && inv.getInventoryName() == inventoryName) {
				return true;
			}
		}
		return false;
	}
	
	public static InventoryTypeList getInventoryType(Inventory inventory) {
		
		String inventoryName = inventory.getName();
		int inventorySize = inventory.getSize();
		
		for (InventoryTypeList inv : InventoryTypeList.values()) {
			if(inv.getSlotNumber() == inventorySize && inv.getInventoryName() == inventoryName) {
				return inv;
			}
		}
		return InventoryTypeList.inventoryNot;
	}
	
	
	public static void toOpen(Player player, Inventory inventory) {

		if (isInventoryType(inventory)) {
									
		switch (getInventoryType(inventory)) {
				
			case inventoryJobs: MenuManager.initializeJobsMenuItems(player, inventory);
				break;		
			case inventoryJobsDevMod: MenuManager.initializeJobsMenuDevItems(player, inventory);				
				break;				
			case inventoryPlayerMenu: MenuManager.initializePlayerMenuItems(player, inventory);				
				break;
			case inventoryPlayerMenuDevMod: MenuManager.initializePlayerMenuDevItems(player, inventory);				
				break;
			case inventoryProfile: MenuManager.initializeProfileMenuItems(player, inventory);	 			
				break;
			case inventoryProfileDevMod: MenuManager.initializeProfileMenuDevItems(player, inventory);				
				break;
			case inventoryQuests: MenuManager.initializeQuestsMenuItems(player, inventory);
				break;
			case inventoryQuestsDevMod: MenuManager.initializeQuestsMenuDevItems(player, inventory);
				break;
			case inventorySettings: MenuManager.initializeSettingsMenuItems(player, inventory);
				break;
			case inventorySettingsDevMod: MenuManager.initializeSettingsMenuDevItems(player, inventory);
				break;
			case inventoryStats: MenuManager.initializeStatsMenuItems(player, inventory);
				break;
			case inventoryStatsDevMod: MenuManager.initializeStatsMenuDevItems(player, inventory);
				break;
				// Error Return
			default: System.out.println("[OLYMPPLAYERS] (GuiManager.initialize) inventory initialize path not defined");
				break;
				
			}	
		
		player.openInventory(inventory);
		
		} else {
			
			System.out.println("[OLYMPPLAYERS] (GuiManager.initialize) inventoryType not recognized");
		}
	}	
}
