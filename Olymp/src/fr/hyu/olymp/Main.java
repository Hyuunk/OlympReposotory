package fr.hyu.olymp;

import org.bukkit.plugin.java.JavaPlugin;

import fr.hyu.olymp.chat.ChatColorCommand;
import fr.hyu.olymp.chat.ChatManager;
import fr.hyu.olymp.party.PartyCommands;
import fr.hyu.olymp.warps.WarpsCommands;
import fr.hyu.olympperms.players.PlayerRankProfile;

public class Main extends JavaPlugin {
	
	public static Main INSTANCE = null;
	@Override
	public void onEnable() {
		
		// permet d'appeler la fonction main 
		INSTANCE = this;
		
		System.out.println("Olymp est activ?");
		
		//Commandes
		getCommand("olymp").setExecutor(new OlympCommands());
		getCommand("party").setExecutor(new PartyCommands());	
		getCommand("chatcolor").setExecutor(new ChatColorCommand());
		getCommand("setwarp").setExecutor(new WarpsCommands());
		getCommand("warp").setExecutor(new WarpsCommands());
		getCommand("gms").setExecutor(new OlympCommands());
		getCommand("gmc").setExecutor(new OlympCommands());
		getCommand("gma").setExecutor(new OlympCommands());
		getCommand("gmsp").setExecutor(new OlympCommands());
		
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
		
		System.out.println("Olymp est d?sactiv?");

		super.onDisable();
	}

}