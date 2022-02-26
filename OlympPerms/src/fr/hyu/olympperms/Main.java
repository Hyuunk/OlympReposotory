package fr.hyu.olympperms;

import org.bukkit.plugin.java.JavaPlugin;

import fr.hyu.olympperms.players.PlayerProfileManager;

public class Main extends JavaPlugin {

	public static Main INSTANCE = null;
	
	@Override
	public void onEnable() {
		
		INSTANCE = this;
		System.out.println("OlympPerms est activé");
		
		
		//Commands
		getCommand("olympperms").setExecutor(new PermsCommands());
		
		////Listeners
		getServer().getPluginManager().registerEvents(new PlayerProfileManager(), this);
		
	//	player.addAttachment(Main.INSTANCE, "minecraft.command.help", false);
		//player.recalculatePermissions();
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {		
		System.out.println("OlympPerms est désactivé");
		
		super.onDisable();
	}
}