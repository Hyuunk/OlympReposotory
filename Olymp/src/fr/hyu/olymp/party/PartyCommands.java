package fr.hyu.olymp.party;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import com.google.common.collect.Lists;

import fr.hyu.olymp.OlympCommands.OlympCommandsName;
import fr.hyu.olymp.chat.ChatManager;
import fr.hyu.olympperms.players.PlayerRankProfile;
import fr.hyu.olympperms.players.PlayerProfile.Stat;

public class PartyCommands implements CommandExecutor, TabCompleter {

	private HashMap<Player, Party> partyMember = new HashMap<Player, Party>(); // party chief et party member
	private HashMap<Player, ArrayList<Player>> partyRequest = new HashMap<Player, ArrayList<Player>>(); // recoit en 1
																										// arg le joueur
																										// recevant

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {

		String newLine = System.getProperty("line.separator");
		Player player = (Player) sender;

		if (args.length == 0) {
			player.sendMessage(ChatColor.DARK_GREEN + "Fait " + ChatColor.GREEN + "/party help " + ChatColor.DARK_GREEN
					+ "pour connaître la liste des commandes");

		} else if (args.length >= 1) {
			switch (args[0].toUpperCase()) {

			case "HELP":
				player.sendMessage(ChatManager.MessageType.PARTYCLASSIC.getMessage() + ChatColor.GRAY.toString() + "Voici la liste des commandes " + ChatColor.DARK_GREEN + ChatColor.BOLD + "Party" + ChatColor.GRAY + " :" 
			+ newLine + ChatColor.GREEN + "/party invite" + ChatColor.GRAY + " pour inviter un joueur dans la partie." 
			+ newLine + ChatColor.GREEN + "/party members" + ChatColor.GRAY + " pour afficher les membres de votre partie."
			+ newLine+ ChatColor.GREEN + "/party disband" + ChatColor.GRAY + " pour supprimer/démenteler la partie."
			+ newLine + ChatColor.GREEN + "/party accept [pseudo]" + ChatColor.GRAY + " pour rejoindre la partie d'un joueur.");
				break;

			case "INVITE":
				if (args.length == 2 && Bukkit.getPlayer(args[1]) != null) {
					Player invitedPlayer = Bukkit.getPlayer(args[1]);
					// Player player = (Player) sender;

					if (!partyMember.containsKey(invitedPlayer)) {

						ArrayList<Player> requestingPlayer = partyRequest.get(invitedPlayer);

						if (requestingPlayer == null) {
							
							requestingPlayer = new ArrayList<Player>();
							requestingPlayer.add(player);
							partyRequest.put(invitedPlayer, requestingPlayer);

							player.sendMessage(ChatColor.DARK_GREEN + "Vous avez invité " + ChatColor.GREEN
									+ invitedPlayer.getName());
							invitedPlayer.sendMessage(ChatColor.GREEN.toString() + player.getName() + ChatColor.DARK_GREEN
									+ " vous a invité a rejoindre sa partie");
							
							
						} else if (!requestingPlayer.contains(player)) {
								requestingPlayer.add(player);								

								player.sendMessage(ChatColor.DARK_GREEN + "Vous avez invité " + ChatColor.GREEN
										+ invitedPlayer.getName());
								invitedPlayer.sendMessage(ChatColor.GREEN.toString() + player.getName() + ChatColor.DARK_GREEN
										+ " vous a invité a rejoindre sa partie");						
								
							} else {
								player.sendMessage(ChatColor.DARK_GREEN + "Vous avez déjà invité le joueur "
										+ ChatColor.GREEN + invitedPlayer.getName());
							}
						}

					} else {
						
						player.sendMessage(
								ChatColor.DARK_GREEN + "Le joueur que vous essayez d'inviter est déjà dans une partie");

					}
					break;
				
 

			case "ACCEPT":
				if (partyRequest.containsKey(player)) {

					
					
					// partyMember.put(partyRequest.values()., player); Il faut mettre le joueur
					// ayant fait la requete en tant que clé et le joueur en tant que valeur

					// soit mettre une limite de demande en meme temps sur un joueur soit mettre un
					// argument a accepte pour qu'il accepte le joueur qu'il met en arguement au cas
					// ou il recoit 2 invite en meme temps

					// faire en sorte qu'on puisse cliquer sur accept et check un vrai plugin party
					// pour voir les optis a faire
					partyRequest.clear();

				} else {
					player.sendMessage(ChatColor.DARK_GREEN + "Aucun joueur ne vous a fait d'invation a sa partie");
					break;
				}
			case "MEMBERS":
				// if (partyMember.containsValue(player);

			}
		}
		return false;
	}
	
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {

		List<String> noArgument = Arrays.asList("");
		List<String> fList = Lists.newArrayList();			

				
				if (args.length == 1) {
					for (PartyCommandsName cmdName : PartyCommandsName.values()) {
						if (cmdName.getName().toLowerCase().startsWith(args[0]))
							fList.add(cmdName.getName());
					} return fList;
					
				} else 		
					
				switch (args[0].toUpperCase()) {
				
				case "HELP":
					return noArgument;
					
				case "INVITE":
					if (args.length == 2) {
						
						for (Player player : Bukkit.getOnlinePlayers()) 
							fList.add(player.getName());	
						return fList;
					} else return noArgument;
					
				case "ACCEPT":
					if (args.length == 2) {
						
						for (Player player : Bukkit.getOnlinePlayers()) {
							fList.add(player.getName());	
						 return fList;}
					} return noArgument;				
				default:
					return noArgument;				
		}				
	}
	
public enum PartyCommandsName {
		
		HELP("help"),
		INVITE("invite"),
		ACCEPT("accept"),
		LEAVE("leave"),
		MEMBERS("members"),
		DISBAND("disband");
		
		private String name;		
		
		private PartyCommandsName(String name) {
		 this.name = name;
		}	

		public String getName( ) {
			return name;
		}
	}

}