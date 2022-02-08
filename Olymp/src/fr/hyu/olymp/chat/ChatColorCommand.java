package fr.hyu.olymp.chat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatColorCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		
		
		if (sender instanceof Player) {
			Player player = (Player) sender;
			String newLine = System.getProperty("line.separator");
		player.sendMessage(ChatColor.GRAY + ChatColor.STRIKETHROUGH.toString() + "----------" + ChatColor.RED + ChatColor.BOLD + " C" + ChatColor.GOLD + ChatColor.BOLD + "h" + ChatColor.YELLOW + ChatColor.BOLD + "a" + ChatColor.GREEN + ChatColor.BOLD + "t" + ChatColor.DARK_GREEN + ChatColor.BOLD + "C" + ChatColor.DARK_AQUA + ChatColor.BOLD + "o" + ChatColor.BLUE + ChatColor.BOLD + "l" + ChatColor.DARK_BLUE + ChatColor.BOLD + "o" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "r " + ChatColor.GRAY + ChatColor.STRIKETHROUGH + "----------" 
			+ newLine + "" );
		}
		
		return false;
	}

}
