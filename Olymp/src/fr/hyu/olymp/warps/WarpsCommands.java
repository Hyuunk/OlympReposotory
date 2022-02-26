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
						
						if (createWarp(args[0], player.getName(), player.getLocation())) {
							
							player.sendMessage("Vous venez de créer un warp"); 
							
						} else {
							
						player.sendMessage("Le warp existe déjà");
						
						}
						
					} else {
						//si le warp existe déjà
						player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage()
								+ "Argument's Error. Try /setwarp " + ChatColor.RED + " <name>");
					}
					
				} else if (cmd.getLabel().equals("warp")) {

					player.teleport(toWarp(args[0].toString()));
					player.sendMessage("Vous venez de vous téléporter");
					
					
				}
			} 
		
		return false;
	}

	public static boolean createWarp(String nameWarp, String namePlayer, Location location) {
		
		File file = new File(Main.INSTANCE.getDataFolder(), "Olymp/warps.yml");		
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			if (config.getString("warps." + nameWarp + ".author") == null) {
				
			config.set("warps." + nameWarp + ".location.world", location.getWorld().getName());
			config.set("warps." + nameWarp + ".location.x", location.getX());
			config.set("warps." + nameWarp + ".location.y", location.getY());
			config.set("warps." + nameWarp + ".location.z", location.getZ());
			config.set("warps." + nameWarp + ".location.yaw", location.getYaw());
			config.set("warps." + nameWarp + ".location.pitch", location.getPitch());
			config.set("warps." + nameWarp + ".author", namePlayer);
					
			try {
				config.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}	
			
			return true;
			}
			
			System.out.println('e');
		return false;
	}
	
	
	public static Location toWarp(String name) {
				
		File file = new File(Main.INSTANCE.getDataFolder(), "Olymp/warps.yml");		
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);

		World world = Bukkit.getWorld(config.getString("warps." + name + ".location.world"));
		double x = config.getDouble("warps." + name + ".location.x");
		double y = config.getDouble("warps." + name + ".location.y");
		double z = config.getDouble("warps." + name + ".location.z");
		float yaw = (float) config.getDouble("warps." + name + ".location.yaw");
		float pitch = (float) config.getDouble("warps." + name + ".location.pitch");
		Location location = new Location(world, x, y, z, yaw, pitch);

      
		return location;
	}
}