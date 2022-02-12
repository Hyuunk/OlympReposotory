package fr.hyu.olymp;

import org.bukkit.plugin.java.JavaPlugin;

import fr.hyu.olymp.chat.ChatColorCommand;
import fr.hyu.olymp.chat.ChatManager;
import fr.hyu.olymp.party.PartyCommands;
import fr.hyu.olympperms.players.PlayerRankProfile;

public class Main extends JavaPlugin {
	
	public static Main INSTANCE = null;
	@Override
	public void onEnable() {
		
		// permet d'appeler la fonction main 
		INSTANCE = this;
		
		System.out.println("Olymp est activé");
		
		//Commandes
		getCommand("olymp").setExecutor(new OlympCommands());
		getCommand("party").setExecutor(new PartyCommands());	
		getCommand("chatcolor").setExecutor(new ChatColorCommand());
		
		//TabCompleters
		getCommand("olymp").setTabCompleter(new OlympCommands());
		getCommand("party").setTabCompleter(new PartyCommands());
		
		//Listeners
		getServer().getPluginManager().registerEvents(new ChatManager(), this);
		PlayerRankProfile.initRank();
		
		super.onEnable();
	}
	
	@Override 
	public void onDisable() {
		
		System.out.println("Olymp est désactivé");

		super.onDisable();
	}

}