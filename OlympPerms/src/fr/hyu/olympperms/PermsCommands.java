package fr.hyu.olympperms;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.hyu.olympperms.players.PlayerRankProfile;

public class PermsCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		
		Player player = (Player) sender;

		if (cmd.getLabel().equalsIgnoreCase("perms")) {
			PlayerRankProfile.initRank();
			player.sendMessage(PlayerRankProfile.getPermissions(player).toString());
		}
			
		return false;
	}

}