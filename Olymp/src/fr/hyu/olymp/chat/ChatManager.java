package fr.hyu.olymp.chat;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import fr.hyu.olympperms.players.PlayerProfileManager;
import fr.hyu.olympperms.players.PlayerRankProfile;


public class ChatManager implements Listener{
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
				
		String rankPlayer = PlayerProfileManager.profiles.get(event.getPlayer()).getRank().toString().toUpperCase();
		
		switch (rankPlayer) {
		
		case "GERANT":
			toFormat(ChatColor.DARK_PURPLE + "Gérant", event.getPlayer().getName(), event.getMessage(), event);
			break;
			
		case "RESPONSABLE":
			toFormat(ChatColor.RED + "Responsable", event.getPlayer().getName(), event.getMessage(), event);
			break;
			
		case "DEVELOPPEUR":
			toFormat(ChatColor.BLUE + "Développeur", event.getPlayer().getName(), event.getMessage(), event);
			break;
			
		case "MODERATEUR":
			toFormat(ChatColor.YELLOW + "Modérateur", event.getPlayer().getName(), event.getMessage(), event);
			break;
			
		case "BUILDER":
			toFormat(ChatColor.LIGHT_PURPLE + "Builder", event.getPlayer().getName(), event.getMessage(), event);
			break;
			
		case "HELPER":
			toFormat(ChatColor.GREEN + "Helper", event.getPlayer().getName(), event.getMessage(), event);
			break;
			
		case "AMI":
			toFormat(ChatColor.GOLD + "Ami", event.getPlayer().getName(), event.getMessage(), event);
			break;
			
		default:
			toFormat(ChatColor.GRAY + "Joueur", event.getPlayer().getName(), event.getMessage(), event);			
			break;		
				
		}
		
	}
	
public void toFormat(String type, String name, String message, AsyncPlayerChatEvent event) {
	if (PlayerRankProfile.hasPermission(event.getPlayer(), "chatcolor.use")) {
	event.setFormat(ChatColor.GRAY + "[" + PlayerProfileManager.profiles.get(event.getPlayer()).getLevel() + "/" + type + ChatColor.GRAY + "] " + name + ": " + colourise(message));
	} else {
		event.setFormat(ChatColor.GRAY + "[" + PlayerProfileManager.profiles.get(event.getPlayer()).getLevel() + "/" + type + ChatColor.GRAY + "] " + name + ": " + message);
	}
}

public enum MessageType {
		
	//OLYMPTYPE
	OLYMPCLASSIC(ChatColor.GRAY + "[" + ChatColor.GOLD + "Olymp" + ChatColor.GRAY + "]" + ChatColor.WHITE + " > " + ChatColor.GRAY),	
	OLYMPRIGHT(ChatColor.GRAY + "[" + ChatColor.GREEN + "Olymp" + ChatColor.GRAY + "]"	+ ChatColor.WHITE + " > " + ChatColor.GRAY),
	OLYMPERROR(ChatColor.GRAY + "[" + ChatColor.RED + "OlympError" + ChatColor.GRAY + "]" + ChatColor.WHITE + " > " + ChatColor.GRAY),

	//PARTYTYPE
	PARTYCLASSIC(ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + "Party" + ChatColor.GRAY + "]" + ChatColor.WHITE + " > " + ChatColor.GRAY),
	PARTYRIGHT(ChatColor.GRAY + "[" + ChatColor.GREEN + "Party" + ChatColor.GRAY + "]" + ChatColor.WHITE + " > " + ChatColor.GRAY),
	PARTYERROR(ChatColor.GRAY + "[" + ChatColor.RED + "PartyError" + ChatColor.GRAY + "]" + ChatColor.WHITE + " > " + ChatColor.GRAY),
	
	//UNKNOWCOMMAND
	UNKNOWCOMMAND("Unknown command. Type \"/help\" for help.");

	private String type;

	
	
	private MessageType(String type) {
	 this.type = type;
	}	

	public String getMessage( ) {
		return type;
	}	
 }
	
	private static String colourise(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

}