package fr.hyu.olympplayers.players;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class InteractPlayerOnMonster implements Listener {
	
	@EventHandler
	public void onAfterDeath(EntityDeathEvent event) {
		
		//definit les choses après la mort de l'entité donc drop 
			
		if (event.getEntity().getKiller() instanceof Player) {
			Player player = event.getEntity().getKiller();
			player.sendMessage("you killed " + event.getEntity().getName());			
		}
				
	}
		
}
