package fr.hyu.olymp.chat;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import fr.hyu.olympperms.players.PlayerProfileManager;


public class ChatManager implements Listener{
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
				
		String rankPlayer = PlayerProfileManager.profiles.get(event.getPlayer()).getRank().toString().toLowerCase();
		
		if (rankPlayer.equals("gerant")) {			
			toFormat(ChatColor.GOLD + "GérantBG", event.getPlayer().getName(), event.getMessage(), event);
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
			
			event.setMessage(ChatColor.translateAlternateColorCodes('&', event.getMessage()));
				
		}
		
	}
	
public void toFormat(String type, String name, String message, AsyncPlayerChatEvent event) {	
	event.setFormat(ChatColor.GRAY + "[" + PlayerProfileManager.profiles.get(event.getPlayer()).getLevel() + "/" + type + ChatColor.GRAY + "] " + name + " : " + buildText(message));
		
}

public enum MessageType {
		
	//OLYMPTYPE
	OLYMPCLASSIC(ChatColor.GRAY + "[" + ChatColor.GOLD + "Olymp" + ChatColor.GRAY + "]" + ChatColor.WHITE + " > " + ChatColor.GRAY),
	OLYMPRIGHT(ChatColor.GRAY + "[" + ChatColor.GREEN + "Olymp" + ChatColor.GRAY + "]"	+ ChatColor.WHITE + " > " + ChatColor.GRAY),
	OLYMPERROR(ChatColor.GRAY + "[" + ChatColor.RED + "OlympError" + ChatColor.GRAY + "]" + ChatColor.WHITE + " > " + ChatColor.GRAY),

	//PARTYTYPE
	PARTYCLASSIC(ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + "Party" + ChatColor.GRAY + "]" + ChatColor.WHITE + " > " + ChatColor.GRAY),
	PARTYRIGHT(ChatColor.GRAY + "[" + ChatColor.GREEN + "Party" + ChatColor.GRAY + "]" + ChatColor.WHITE + " > " + ChatColor.GRAY),
	PARTYERROR(ChatColor.GRAY + "[" + ChatColor.RED + "PartyError" + ChatColor.GRAY + "]" + ChatColor.WHITE + " > " + ChatColor.GRAY);

	private String type;

	
	
	private MessageType(String type) {
	 this.type = type;
	}	

	public String getMessage( ) {
		return type;
	}	
 }
	
	
private String buildText(String text) {
    StringBuilder sb = new StringBuilder();
    String[] textArray = text.split(" ");
    for (String chunk : textArray) {
        if (chunk.contains("&")) {
            if (chunk.equalsIgnoreCase("&black"))
                sb.append(ChatColor.BLACK);
            else if (chunk.equalsIgnoreCase("&blue"))
                sb.append(ChatColor.DARK_BLUE);
            else if (chunk.equalsIgnoreCase("&green"))
                sb.append(ChatColor.DARK_GREEN);
            else if (chunk.equalsIgnoreCase("&white"))
                sb.append(ChatColor.WHITE);
            
            return sb.toString();
            }
        }
	return null;
     	
}
}