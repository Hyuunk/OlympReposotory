package fr.hyu.olympperms;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.hyu.olympperms.players.PlayerRankProfile;

public class PermsCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		
		if (sender instanceof Player) {
		Player player = (Player) sender;

		if (args.length > 0) {
			
			switch (args[0].toUpperCase()) {
			case "SETRANK":
				break;
			case "RELOADPERMS":
				break;
			case "ADDPERMS":
				break;
			case "DELPERMS":
				break;
			default:
			}
		}
		
		return false;
	}
		return false;
	}

}