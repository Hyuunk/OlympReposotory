package fr.hyu.olympplayers.stats.vitality;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import fr.hyu.olympperms.players.PlayerProfileManager;
import fr.hyu.olympperms.players.PlayerRankProfile;

public class PlayerStrengthApplicator implements Listener {
	@EventHandler
	public void onHit(EntityDamageByEntityEvent event) {
		
		if (event.getDamager() instanceof Player) {
Player player = (Player) event.getDamager();
		
			if (PlayerRankProfile.hasPermission(player, "olymp.reportMessage")) {
				player.sendMessage(ChatColor.GRAY + "dealBeforeCalculating: " + event.getDamage());
			}
			
			// Damage calculator
		event.setDamage(event.getDamage() + PlayerProfileManager.profiles.get(player).getStrengthNative());
		
		
		if (PlayerRankProfile.hasPermission(player, "olymp.reportMessage"))
			player.sendMessage(ChatColor.GRAY + "dealAfterCalculating: " + event.getDamage());
		}
		}
	}

