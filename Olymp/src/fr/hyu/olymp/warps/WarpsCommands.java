package fr.hyu.olymp.warps;

import java.io.File;
import java.io.IOException;


import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import fr.hyu.olymp.Main;
import fr.hyu.olymp.chat.ChatManager;

public class WarpsCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		
			if (sender instanceof Player) {
				
				Player player = (Player) sender;
				
				if (cmd.getLabel().equals("setwarp")) {
					
					if (args.length > 0) {
						
						createWarp(args[0], player.getLocation());
						player.sendMessage("Vous venez de créer un warp");
						
					} else {
						//si le warp existe déjà
						player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage()
								+ "Argument's Error. Try /setwarp " + ChatColor.RED + " <name>");
					}
					
				} else if (cmd.getLabel().equals("warp")) {
					
					player.teleport(toWarp(args[0]));
					player.sendMessage("Vous venez de vous téléporter");
					
					
				}
			} 
		
		return false;
	}

	public static void createWarp(String name, Location location) {
		
		File file = new File(Main.INSTANCE.getDataFolder(), "Olymp/warps.yml");
				
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			
			config.set("warps." + name + ".location", location);
			
			try {
				config.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
		return;
	}
	
	public static Location toWarp(String name) {
		
		
		
		File file = new File(Main.INSTANCE.getDataFolder(), "Olymp/warps.yml");
		
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);

		Location location;
		location = new Location(Bukkit.getWorld(
			config.getString("warps" + name + ".location.world")),
			config.getDouble("warps" + name + ".location.x"), 
			config.getDouble("warps" + name + ".location.y"), 
			config.getDouble("warps" + name + ".location.z"), 
			config.getInt("warps" + name + ".location.pitch"), 
			config.getInt("warps" + name + ".location.yaw"));

      
		return location;
	}
}