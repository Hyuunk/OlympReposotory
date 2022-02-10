package fr.hyu.olympeconomy;

import org.bukkit.plugin.java.JavaPlugin;

import fr.hyu.olymp.OlympCommands;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		System.out.println("OlympEconomy est activ�");
		
		getCommand("gold").setExecutor(new EconomyCommands());
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		System.out.println("OlympEconomy est d�sactiv�");
		super.onDisable();
	}
}
