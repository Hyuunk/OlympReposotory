package fr.hyu.olympmonsters.files;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import fr.hyu.olymp.Main;
import fr.hyu.olympperms.players.PlayerProfile.Stat;

public class MonsterFinishFile{

public static boolean monsterFinish(File file, String monster) {
		
		try {
						
			File newfile = new File(Main.INSTANCE.getDataFolder(), "OlympMonsters/monsters/" + monster + ".yml");
		
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			FileConfiguration newConfig = YamlConfiguration.loadConfiguration(newfile);
			
			newConfig.set("monsterName", config.getString("monsterName"));
			newConfig.set("entityType", config.getString("entityType"));
			//description
			if (!config.getString("description").equals("to fill")) {
				newConfig.set("description", config.getString("description"));
			}
			
			//stat
			for (Stat stat : Stat.values()) {
				if (stat.getStat() != "experiencePoints" | stat.getStat() != "gold" | stat.getStat() != "karma") {
					if (config.getInt("stats." + stat.getStat()) != 0) {
						newConfig.set("stats." + stat.getStat(), config.getInt("stats." + stat.getStat()));						
					}
				}
			}
			
			//faire un arraylist des sorts utilisables a refaire en gros 
			
			//spells utilisables
			if (!config.getString("spells.utilisables").equals("to fill")) {
				newConfig.set("spells.utilisables", config.getString("spells.utilisables"));
			}
			
			//equippedItems
			for (EquippedItemsPlace equippedItemsPlace : EquippedItemsPlace.values()) {				
					if (!config.getString("equippedItems." + equippedItemsPlace.getEquippedItemsPlace()).equals("to fill")) {
						newConfig.set("equippedItems." + equippedItemsPlace.getEquippedItemsPlace(), config.getString("equippedItems." + equippedItemsPlace.getEquippedItemsPlace()));						
						}
					}
			
			//droppables
			//golds
			if (config.getInt("droppables.golds") != 0) {
				newConfig.set("droppables.golds", config.getInt("droppables.golds"));
			}
			//experciences
			if (config.getInt("droppables.experciences") != 0) {
				newConfig.set("droppables.experciences", config.getInt("droppables.experciences"));
			}
			//items 
			if (!config.getString("droppables.items").equals("to fill")) {
				newConfig.set("droppables.items", config.getString("droppables.items"));
			}
			
			
			try {
				newConfig.save(newfile);
				file.delete();
				return true;
			} catch (IOException e) {

				return false;
			}
			
			
		} catch (Exception e) {			
			return false;
		}
		
	}

private enum EquippedItemsPlace{
	MAINHAND("mainhand"),
	OFFHAND("offhand"),
	HEAD("head"),
	CHEST("chest"),
	LEGS("legs"),
	FEET("feet");

	private String name;		
		
		private EquippedItemsPlace(String name) {
		 this.name = name;
		}	

		public String getEquippedItemsPlace() {
			return name;
		}	
	 }
	
}