package fr.hyu.olympeconomy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.hyu.olymp.chat.ChatManager;
import fr.hyu.olympperms.players.PlayerProfileManager;

public class EconomyCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {

		if (sender instanceof Player) {
		Player player = (Player) sender;
		
		player.sendMessage(ChatManager.MessageType.OLYMPCLASSIC.getMessage() + ChatColor.GRAY + "Votre nombre de gold est : " + ChatColor.GOLD + PlayerProfileManager.profiles.get(player).getGold() + " ⛁"
);
		}
		return false;
	}

}
