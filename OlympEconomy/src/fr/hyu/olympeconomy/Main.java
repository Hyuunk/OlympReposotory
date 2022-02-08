package fr.hyu.olympeconomy;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		System.out.println("OlympEconomy est activé");
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		System.out.println("OlympEconomy est désactivé");
		super.onDisable();
	}
}
