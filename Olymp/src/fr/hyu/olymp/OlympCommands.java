package fr.hyu.olymp;

import java.lang.Character.UnicodeBlock;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import com.google.common.collect.Lists;

import fr.hyu.olymp.chat.ChatManager;
import fr.hyu.olympperms.players.PlayerProfile;
import fr.hyu.olympperms.players.PlayerProfile.Stat;
import fr.hyu.olympperms.players.PlayerProfileManager;
import fr.hyu.olympperms.players.PlayerRankProfile;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class OlympCommands implements CommandExecutor, TabCompleter {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;

			// PERMISSION
			if (PlayerRankProfile.hasPermission(player, "olymp.useAdmin")) {
				
				switch (cmd.getLabel().toUpperCase()) {
				case "OLYMP":
					
					if (args.length > 0) {
						
						//ARGS[0] CHECK
						switch (args[0].toUpperCase()) {
						
						
						case "HELP":
							String newLine = System.getProperty("line.separator");
							player.sendMessage(ChatManager.MessageType.OLYMPCLASSIC.getMessage() + ChatColor.GRAY.toString() + "Voici la liste des commandes " + ChatColor.GOLD + ChatColor.BOLD + "Olymp" + ChatColor.GRAY + " :"
							+ newLine + ChatColor.GOLD + "/olymp setstat:" + ChatColor.GRAY + " pour définir les statistiques d'un joueur." 
							+ newLine + ChatColor.GOLD + "/olymp getstat:" + ChatColor.GRAY + " pour afficher les caractéristiques d'un joueur.");
							break;

						case "TEST":
							Player targetPlayer = Bukkit.getPlayer(args[1]);
							String message = ChatColor.GOLD + "Endurance " + PlayerProfileManager.profiles.get(targetPlayer).getEnduranceOnLeave() + "/" + PlayerProfileManager.profiles.get(targetPlayer).getEnduranceNative() + "          " + ChatColor.AQUA + "Mana " + PlayerProfileManager.profiles.get(targetPlayer).getManaOnLeave() + "/" + PlayerProfileManager.profiles.get(targetPlayer).getManaCapacityNative();
							targetPlayer.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
							break;
						case "UNICODE":
							UnicodeBlock a = UnicodeBlock.forName(args[1]);
							System.out.println(a);
							break;

						case "SETSTAT":
							
							if (args.length == 3 | args.length == 4) {
								if (args.length == 3) {
									if (isNumeric(args[2].toString())) {
										if (PlayerProfile.isStat(args[1])) {
										PlayerProfile.setStat(player, Stat.valueOf(args[1].toUpperCase()),
												Integer.valueOf(args[2])); 
											player.sendMessage(ChatManager.MessageType.OLYMPRIGHT.getMessage()
													+ args[0].toLowerCase() + " " + player.getName() + " "
													+ args[1].toUpperCase() + " to "
													+ PlayerProfile.getStat(player, Stat.valueOf(args[1].toUpperCase())));

											break;									
										
										} else {
											player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage()
													+ "Argument's Error. Try /olymp setstat [<targetPlayer>] "
													+ ChatColor.RED + "<stat> " + ChatColor.GRAY + "<number>.");
											break;
										}
									} else {
										player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage()
												+ "Argument's Error. Try /olymp setstat [<targetPlayer>] <stat>"
												+ ChatColor.RED + " <number>" + ChatColor.GRAY + ".");
										break;
									}
								} else {
									Player targetPlayerSetStat = Bukkit.getPlayer(args[1]);
									if (targetPlayerSetStat != null) {
										if (isNumeric(args[3])) {
											if (PlayerProfile.isStat(args[2])) {
											PlayerProfile.setStat(targetPlayerSetStat,
													Stat.valueOf(args[2].toUpperCase()), Integer.valueOf(args[3].toUpperCase()));

												player.sendMessage(ChatManager.MessageType.OLYMPRIGHT.getMessage()
														+ args[0].toLowerCase() + " " + targetPlayerSetStat.getName() + " "
														+ args[2].toUpperCase() + " to "
														+ PlayerProfile.getStat(targetPlayerSetStat, Stat.valueOf(args[2].toUpperCase())));
												break;
											
											} else {
												player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage()
														+ "Argument's Error. Try /olymp setstat [<targetPlayer>]"
														+ ChatColor.RED + " <stat>" + ChatColor.GRAY + " <number>.");
												break;
											}
										} else {
											player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage()
													+ "Argument's Error. Try /olymp setstat [<targetPlayer>] <stat>"
													+ ChatColor.RED + " <number>.");
											break;
										}
									} else {
										player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage()
												+ "Invalid Player. Try /olymp setstat" + ChatColor.RED
												+ " [<targetPlayer>]" + ChatColor.GRAY + " <stat> <number>.");
										break;
									}
								}
							} else {
								player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage()
										+ "Argument's Error. Try /olymp setstat [<targetPlayer>] <stat> <number>.");
								break;

							} 
							
						

						case "GETSTAT":

							if (args.length == 2 | args.length == 3) {
								if (args.length == 2) {
									if (PlayerProfile.isStat(args[1])) {
									if (PlayerProfile.getStat(player, Stat.valueOf(args[1].toUpperCase())) != -0) {
										player.sendMessage(ChatManager.MessageType.OLYMPRIGHT.getMessage()
												+ args[0].toLowerCase() + " " + player.getName() + " "
												+ args[1].toUpperCase() + " is "
												+ PlayerProfile.getStat(player, Stat.valueOf(args[1].toUpperCase())));
										break;
									}
									
									} else {
										player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage()
												+ "Argument's Error. Try /olymp getstat [<targetPlayer>]" + ChatColor.RED
												+ " <stat>" + ChatColor.GRAY + ".");
										break;
									}
								} else {
									Player targetPlayerGetStat = Bukkit.getPlayer(args[1]);
									if (targetPlayerGetStat != null) {
										if (PlayerProfile.isStat(args[2])) {
										if (PlayerProfile.getStat(player,
												Stat.valueOf(args[2].toUpperCase())) != -0) {
											player.sendMessage(ChatManager.MessageType.OLYMPRIGHT.getMessage()
													+ args[0].toLowerCase() + " " + targetPlayerGetStat.getName() + " "
													+ args[2].toUpperCase() + " is "
													+ PlayerProfile.getStat(targetPlayerGetStat, Stat.valueOf(args[2].toUpperCase())));
											break;
										}
										} else {
											player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage()
													+ "Argument's Error. Try /olymp getstat [<targetPlayer>]"
													+ ChatColor.RED + " <stat>" + ChatColor.GRAY + ".");
											break;
										}
									} else {
										player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage()
												+ "Argument's Error. Try /olymp getstat" + ChatColor.RED
												+ " [<targetPlayer>]" + ChatColor.GRAY + " <stat>.");
										break;
									}
								}

							} else {
								player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage()
										+ "Argument's Error. Try /olymp getstat [<targetPlayer>] <stat>.");
								break;
							}
							
							break; 
							
						default:
							
							player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage() + "Not valid argument. Try /olymp help");
							break;
						
							
						}	
					} else {
						player.sendMessage(ChatManager.MessageType.OLYMPCLASSIC.getMessage() + "Add an argument. Try /olymp help.");
					}
					
					break;
					
				case "GMS":
					setGameMode(GameMode.SURVIVAL, args, player);
					break;
				case "GMC":
					setGameMode(GameMode.CREATIVE, args, player);
					break;
				case "GMA":
					setGameMode(GameMode.ADVENTURE, args, player);
					break;
				case "GMSP":
					setGameMode(GameMode.SPECTATOR, args, player);
					break;
			

				}
				
			} else {
				player.sendMessage(ChatManager.MessageType.UNKNOWCOMMAND.getMessage());
			}
		}
		return false;
		
		
		
		
	}

	public boolean isNumeric(String args) {
		try {
			Integer.parseInt(args);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {

		List<String> argumentsNumber = Arrays.asList("0");
		List<String> noArgument = Arrays.asList("");
		List<String> fList = Lists.newArrayList();	
		
			//PERMISSION
			if (PlayerRankProfile.hasPermission((Player) sender, "olymp.useAdmin")) {
				
				if (args.length == 1) {
					for (OlympCommandsName cmdName : OlympCommandsName.values()) {
						if (cmdName.getName().toLowerCase().startsWith(args[0]))
							fList.add(cmdName.getName());
					} return fList;
					
				} else 		
					
				switch (args[0].toUpperCase()) {
				
				case "HELP":
					return noArgument;
				case "TEST":
					if (args.length == 2) {
						
						for (Player player : Bukkit.getOnlinePlayers()) 
							fList.add(player.getName());	
						return fList;
					} else return noArgument;
					
				case "SETSTAT":
					if (args.length == 2) {
						
						for (Player player : Bukkit.getOnlinePlayers()) 
							fList.add(player.getName());	
						return fList;
						
					} else if (args.length == 3) {
						
						for (Stat stat : Stat.values()) 
							if (stat.getName().toLowerCase().startsWith(args[2]))
								fList.add(stat.getName());
						return fList;
						
					} else if (args.length == 4) {
						
						return argumentsNumber;
						
					} return noArgument;
					
				case "GETSTAT":
					if (args.length == 2) {
						
						for (Player player : Bukkit.getOnlinePlayers()) 
							fList.add(player.getName());	
						return fList;
						
					} else if (args.length == 3) {
						
						for (Stat stat : Stat.values()) 
							if (stat.getName().toLowerCase().startsWith(args[2]))
								fList.add(stat.getName());
						return fList;
						
					} return noArgument;
					
				default:
					return noArgument;
				}
			}
			
			return null;		
			
	}
	
	public enum OlympCommandsName {
		
		HELP("help"),
		TEST("test"),
		UNICODE("unicode"),
		GETSTAT("getstat"),
		SETSTAT("setstat");
		
		private String name;		
		
		private OlympCommandsName(String name) {
		 this.name = name;
		}	

		public String getName( ) {
			return name;
		}
	}
	public void setGameMode(GameMode gamemode, String[] args, Player player) {
		
		
		if (args.length == 0) {
			
			player.setGameMode(gamemode);
			player.sendMessage(ChatManager.MessageType.OLYMPCLASSIC.getMessage() + "Tu viens de passer en mode " + ChatColor.GREEN + gamemode.name().toLowerCase() + ChatColor.GRAY + ".");
			
		} else if (args.length == 1) {
			
			Player targetPlayer = Bukkit.getPlayer(args[0]);
			
			if (targetPlayer != null) {
				
				if (targetPlayer == player) {
					
					player.setGameMode(gamemode);
					player.sendMessage(ChatManager.MessageType.OLYMPCLASSIC.getMessage() + "Tu viens de passer en mode " + ChatColor.GREEN + gamemode.name().toLowerCase() + ChatColor.GRAY + ".");
					
				} else {
					
					targetPlayer.setGameMode(gamemode);
					player.sendMessage(ChatManager.MessageType.OLYMPCLASSIC.getMessage() + "Tu viens de passer en mode " + ChatColor.GREEN + gamemode.name().toLowerCase() + " " + ChatColor.GRAY + targetPlayer.getName() + ".");
					targetPlayer.sendMessage(ChatManager.MessageType.OLYMPCLASSIC.getMessage() + "Ton gamemode a été changé en " + ChatColor.GREEN + gamemode.name().toLowerCase() + ChatColor.GRAY + ".");
				}
				
			} else {
				
				player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage()
						+ "Invalid Player. Try /gm(a,c,s,sp)" + ChatColor.RED
						+ " [<targetPlayer>]" + ChatColor.GRAY + ".");
			}
			
		} else {
			
		player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage()
				+ "Argument's Error. Try /gm(a,c,s,sp) [<targetPlayer>].");
	}
	
	}
}

	
	
