package fr.hyu.olympplayers.stats.ondamage;

import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import fr.hyu.olympperms.players.PlayerProfile;
import fr.hyu.olympperms.players.PlayerProfile.Stat;
import fr.hyu.olympperms.players.PlayerRankProfile;

public class PlayerStrengthApplicator implements Listener {
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		
	if (event.getDamager() instanceof Player) {
		
		Player playerDamager = (Player) event.getDamager();
		
		if(event.getEntity() instanceof Player) {
			
			Player playerSuffer = (Player) event.getEntity();
			
			if (isHit(playerSuffer)) {
			
				if (PlayerRankProfile.hasPermission(playerDamager, "olymp.reportMessage")) {
					playerDamager.sendMessage(ChatColor.GRAY + "dealBeforeCalculating: " + event.getDamage());
				}
				// Damage calculator
			event.setDamage((event.getDamage() + PlayerProfile.getStat(playerDamager, Stat.STRENGTHNATIVE))/(PlayerProfile.getStat(playerSuffer, Stat.DEFENCENATIVE)));
			
			}
			
		}	

			
	if (PlayerRankProfile.hasPermission(playerDamager, "olymp.reportMessage"))
			playerDamager.sendMessage(ChatColor.GRAY + "dealAfterCalculating: " + event.getDamage());
		}
	}
	
	public static boolean isHit(Player player) {
		
		if (ThreadLocalRandom.current().nextInt(0, 101) > PlayerProfile.getStat(player, Stat.AGILITYNATIVE)) {
			//HIT
			return true;
	}
		//NOT HIT
	return false;
	}
}

