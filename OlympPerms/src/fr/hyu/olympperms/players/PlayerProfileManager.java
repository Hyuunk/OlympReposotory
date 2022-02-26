package fr.hyu.olympperms.players;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.hyu.olympperms.Main;


public class PlayerProfileManager implements Listener{

	public static HashMap<Player, PlayerProfile> profiles = new HashMap<Player, PlayerProfile>();
	public static HashMap<Player, PlayerRankProfile> hasPermissions = new HashMap<Player, PlayerRankProfile>();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		PlayerProfile getProfile = new PlayerProfile(player);
		profiles.put(player, getProfile);
		player.addAttachment(Main.INSTANCE, "olymp.basics", false);
		player.recalculatePermissions();
		}
}	