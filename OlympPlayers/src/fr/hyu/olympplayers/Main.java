package fr.hyu.olympplayers;

import org.bukkit.plugin.java.JavaPlugin;

import fr.hyu.olympplayers.stats.strength.PlayerStrengthApplicator;


public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		System.out.println("OlympPlayers est activ�");
		
		getServer().getPluginManager().registerEvents(new PlayerStrengthApplicator(), this);
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		System.out.println("OlympPlayers est d�sactiv�");
		
		super.onDisable();
	}
	
	
}
