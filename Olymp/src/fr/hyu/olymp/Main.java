package fr.hyu.olymp;

import org.bukkit.plugin.java.JavaPlugin;

import fr.hyu.olymp.chat.ChatManager;
import fr.hyu.olymp.party.PartyCommands;
import fr.hyu.olympperms.players.PlayerRankProfile;

public class Main extends JavaPlugin {
	
	public static Main INSTANCE = null;
	@Override
	public void onEnable() {
		
		// permet d'appeler la fonction main 
		INSTANCE = this;
		
		System.out.println("Olymp est activ�");
		
		//Commandes
		getCommand("olymp").setExecutor(new OlympCommands());
		getCommand("party").setExecutor(new PartyCommands());			
		
		//TabCompleters
		getCommand("olymp").setTabCompleter(new OlympCommands());
		
		//Listeners
		getServer().getPluginManager().registerEvents(new ChatManager(), this);
		PlayerRankProfile.initRank();
		
		super.onEnable();
	}
	
	@Override 
	public void onDisable() {
		
		System.out.println("Olymp est d�sactiv�");

		super.onDisable();
	}

}