package fr.hyu.olympplayers;

import org.bukkit.plugin.java.JavaPlugin;

import fr.hyu.olympplayers.gui.GuiManager;
import fr.hyu.olympplayers.gui.MenuManager;
import fr.hyu.olympplayers.stats.strength.PlayerStrengthApplicator;


public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		System.out.println("OlympPlayers est activé");
		
		getCommand("test").setExecutor(new testCommands());
		
		//Listeners
		getServer().getPluginManager().registerEvents(new PlayerStrengthApplicator(), this);
		getServer().getPluginManager().registerEvents(new JoinAndLeave(), this);
		getServer().getPluginManager().registerEvents(new MenuManager(), this);
		getServer().getPluginManager().registerEvents(new GuiManager(), this);
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		System.out.println("OlympPlayers est désactivé");
		
		super.onDisable();
	}
	
	
}
