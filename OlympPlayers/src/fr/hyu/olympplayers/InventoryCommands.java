package fr.hyu.olympplayers;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import com.google.common.collect.Lists;

import fr.hyu.olympperms.players.PlayerProfileManager;
import fr.hyu.olympplayers.gui.GuiManager;

public class InventoryCommands implements CommandExecutor, TabCompleter {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {

		if (sender instanceof Player) {

			Player player = (Player) sender;

			if (args.length > 0) {
				switch (args[0].toString().toUpperCase()) {
				case "MISSINGINIT":

			//		GuiManager.toOpen(player, InventoryTypeList.inventoryNot.getInventory());
					break;

				case "INVENTORYNOTFOUND":

					Inventory inv = Bukkit.createInventory(null, 9, "title");
					
					GuiManager.toOpen(player, inv);
					break;

				case "INVENTORYHOLDER": 
					player.sendMessage(player.getInventory().getHolder().toString());
					
				case "OH": 
					player.sendMessage(PlayerProfileManager.profiles.get(player).getHashMapInventoryTypeToInventory().toString());
					
				case "GOTINVNAME":
					
					player.sendMessage(GuiManager.getListNameInventory(player).toString());
					
				case "NEWINV":
					
					PlayerProfileManager.profiles.get(player).setInventories(Bukkit.createInventory(player, 9, "prout"));
					
				default:
					break;
				}
			}
		}
		return false;

	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {

		List<String> argumentsNumber = Arrays.asList("0");
		List<String> noArgument = Arrays.asList("");
		List<String> fList = Lists.newArrayList();	
		
		
			//PERMISSION
		if (sender.isOp()) {
				if (args.length == 1) {
					for (InventoryCommandsName cmdName : InventoryCommandsName.values()) {
						if (cmdName.getName().toLowerCase().startsWith(args[0]))
							fList.add(cmdName.getName());
					} return fList;
					
				}					
			}
			
			return null;				
	}
	
	public enum InventoryCommandsName{
		
		MISSINGINIT("missingInit"),
		INVENTORYNOTFOUND("inventoryNotFound"),
		INVENTORYHOLDER("inventoryHolder"),
		OH("oh"),
		GOTINVNAME("gotInvName"),
		NEWINV("newInv");
		
		private String name;		
		
		private InventoryCommandsName(String name) {
		 this.name = name;
		}	

		public String getName( ) {
			return name;
		}
	}
}

