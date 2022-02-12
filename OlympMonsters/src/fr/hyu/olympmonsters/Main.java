package fr.hyu.olympmonsters;

import org.bukkit.plugin.java.JavaPlugin;

import fr.hyu.olymp.party.PartyCommands;


public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		System.out.println("OlympMonsters est activé");
		
		//commandes
		getCommand("monster").setExecutor(new MonsterCommands());	
		
		//TabCompleters
		getCommand("monster").setTabCompleter(new MonsterCommands());
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		System.out.println("OlympMonsters est désactivé");
		super.onDisable();
	}
}
