package fr.hyu.olympperms;

import org.bukkit.plugin.java.JavaPlugin;

import fr.hyu.olympperms.players.PlayerProfileManager;

public class Main extends JavaPlugin {

	
	@Override
	public void onEnable() {
		
		System.out.println("OlympPerms est activé");
		
		
		//Commands
		getCommand("perms").setExecutor(new PermsCommands());
		
		////Listeners
		getServer().getPluginManager().registerEvents(new PlayerProfileManager(), this);
		
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {		
		System.out.println("OlympPerms est désactivé");
		
		super.onDisable();
	}
}