package fr.hyu.olympplayers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.hyu.olympplayers.gui.GuiManager;

public class testCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
	
		if (sender instanceof Player) {
			Player player = (Player) sender;
			player.sendMessage(GuiManager.getListNameInventory().toString());
		}
		
		return false;
	}

}
