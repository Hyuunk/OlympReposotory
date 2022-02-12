package fr.hyu.olympplayers;

import org.bukkit.plugin.java.JavaPlugin;

import fr.hyu.olympplayers.gui.MenuManager;
import fr.hyu.olympplayers.stats.strength.PlayerStrengthApplicator;


public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		System.out.println("OlympPlayers est activ�");
		
		
		//Listeners
		getServer().getPluginManager().registerEvents(new PlayerStrengthApplicator(), this);
		getServer().getPluginManager().registerEvents(new JoinAndLeave(), this);
		getServer().getPluginManager().registerEvents(new MenuManager(), this);
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		System.out.println("OlympPlayers est d�sactiv�");
		
		super.onDisable();
	}
	
	
}
