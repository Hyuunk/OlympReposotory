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
				
		String rankPlayer = PlayerProfileManager.profiles.get(event.getPlayer()).getRank().toString().toLowerCase();
		
		if (rankPlayer.equals("gerant")) {			
			toFormat(ChatColor.GOLD + "Gérant", event.getPlayer().getName(), event.getMessage(), event);
		} else if (rankPlayer.equals("responsable")) {
			toFormat(ChatColor.RED + "Responsable", event.getPlayer().getName(), event.getMessage(), event);
		} else if (rankPlayer.equals("developpeur")) {
			toFormat(ChatColor.BLUE + "Developpeur", event.getPlayer().getName(), event.getMessage(), event);
		} else if (rankPlayer.equals("moderateur")) {
			toFormat(ChatColor.YELLOW + "Modérateur", event.getPlayer().getName(), event.getMessage(), event);
		} else if (rankPlayer.equals("builder")) {
			toFormat(ChatColor.LIGHT_PURPLE + "Builder", event.getPlayer().getName(), event.getMessage(), event);
		} else if (rankPlayer.equals("helper")) {
			toFormat(ChatColor.GREEN + "Helper", event.getPlayer().getName(), event.getMessage(), event);
		} else {
			toFormat(ChatColor.GRAY.toString() + "wip", event.getPlayer().getName(), event.getMessage(), event);
			
			
				
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