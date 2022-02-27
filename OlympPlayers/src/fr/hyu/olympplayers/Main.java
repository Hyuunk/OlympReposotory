package fr.hyu.olympplayers;

import org.bukkit.plugin.java.JavaPlugin;

import fr.hyu.olympplayers.gui.GuiManager;
import fr.hyu.olympplayers.gui.MenuManager;
import fr.hyu.olympplayers.players.InteractPlayerOnMonster;
import fr.hyu.olympplayers.stats.level.PlayerLevelApplicator;
import fr.hyu.olympplayers.stats.level.PlayerLevelListener;
import fr.hyu.olympplayers.stats.strength.PlayerStrengthApplicator;


public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		System.out.println("OlympPlayers est activé");
		
		getCommand("inventory").setExecutor(new InventoryCommands());
		
		//Listeners
		getServer().getPluginManager().registerEvents(new InteractPlayerOnMonster(), this);
		getServer().getPluginManager().registerEvents(new PlayerStrengthApplicator(), this);
		getServer().getPluginManager().registerEvents(new PlayerLevelApplicator(), this);
		getServer().getPluginManager().registerEvents(new PlayerLevelListener(), this);
		getServer().getPluginManager().registerEvents(new JoinAndLeave(), this);
		getServer().getPluginManager().registerEvents(new MenuManager(), this);
		getServer().getPluginManager().registerEvents(new GuiManager(), this);
		
		//TabCompleters
		getCommand("inventory").setTabCompleter(new InventoryCommands());
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		System.out.println("OlympPlayers est désactivé");
		
		super.onDisable();
	}
	
	
}
