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
			+ newLine + ChatColor.RESET + "&4: " + ChatColor.DARK_RED + " dark_red " + ChatColor.RESET + "&c: " + ChatColor.RED + " red " + ChatColor.RESET +"&6: " + ChatColor.GOLD + " gold " + ChatColor.RESET + "&e " + ChatColor.YELLOW + " yellow " 
			+ newLine + ChatColor.RESET + "&2" + ChatColor.DARK_GREEN + " dark_green " + ChatColor.RESET + "&a: " + ChatColor.GREEN + " green " + ChatColor.RESET + "&b " + ChatColor.AQUA + " aqua " + ChatColor.RESET + "&3" + ChatColor.DARK_AQUA + " dark_aqua " 
			+ newLine + ChatColor.RESET + "&1: " + ChatColor.DARK_BLUE + " dark_blue " + ChatColor.RESET + "&9 " + ChatColor.BLUE + " blue "  + ChatColor.RESET + "&d" + ChatColor.LIGHT_PURPLE + " light_purple " + ChatColor.RESET + "&5: " + ChatColor.DARK_PURPLE + " dark_purple "
			+ newLine + ChatColor.RESET + "&f " + ChatColor.WHITE + " white "  + ChatColor.RESET + "&7" + ChatColor.GRAY + " gray " + ChatColor.RESET + "&8: " + ChatColor.DARK_GRAY + " dark_gray "+ ChatColor.RESET + "&0 " + ChatColor.BLACK + " black " 
			+ newLine + ChatColor.RESET + "&k " + ChatColor.MAGIC + " magic "  + ChatColor.RESET + "&l" + ChatColor.BOLD + " bold " + ChatColor.RESET + "&m: " + ChatColor.STRIKETHROUGH + " strikethrough "
			+ newLine + ChatColor.RESET + "&n " + ChatColor.UNDERLINE + " underline "  + ChatColor.RESET + "&o" + ChatColor.ITALIC + " italic " + ChatColor.RESET + "&r: " + ChatColor.RESET + " reset ");
		}
		
		return false;
	}

}

