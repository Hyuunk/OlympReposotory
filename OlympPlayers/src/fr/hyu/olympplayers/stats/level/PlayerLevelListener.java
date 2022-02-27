package fr.hyu.olympplayers.stats.level;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

import fr.hyu.olymp.chat.ChatManager;
import fr.hyu.olympperms.players.PlayerProfileManager;

public class PlayerLevelListener implements Listener {

	@EventHandler
	public void onPlayerLevelChange(PlayerLevelChangeEvent event) {
		
		Player player = event.getPlayer();
		int oldLevel = event.getOldLevel();
		int newLevel = event.getNewLevel();
		
		PlayerProfileManager.profiles.get(player).setLevel(newLevel);		
		
		player.sendMessage(ChatManager.MessageType.OLYMPRIGHT.getMessage() + "Niveau " + oldLevel + " > " + "Niveau " + newLevel);
		player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 100, 100);
	}
}
