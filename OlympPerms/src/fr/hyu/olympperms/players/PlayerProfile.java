package fr.hyu.olympperms.players;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import fr.hyu.olymp.Main;
import fr.hyu.olympperms.players.PlayerRankProfile.Rank;


public class PlayerProfile {

	// Definition des variables joueurs utilis�
	private String name;
	private UUID uuid;
	private Rank rank;
	private int level;
	private int experiencesPoints;
	private int gold;
	private int karma;
	private int vitalityNative;
	private int defenceNative;
	private int strengthNative;
	private int enduranceNative;
	private int intelligenceNative;
	private int manaCapacityNative;

	// private UUID faction;

	public PlayerProfile(Player player) {

		this.uuid = player.getUniqueId();
		init();
		File file = new File(Main.INSTANCE.getDataFolder(), "players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		this.rank = Rank.valueOf(config.getString("rank").toUpperCase());
		this.level = config.getInt("level.level");
		this.experiencesPoints = config.getInt("level.experiencsPoints");
		this.gold = config.getInt("gold");
		this.karma = config.getInt("stats.karmaPoint");
		this.vitalityNative = config.getInt("stats.vitalityNative");
		this.defenceNative = config.getInt("stats.defenceNative");
		this.strengthNative = config.getInt("stats.strengthNative");
		this.enduranceNative = config.getInt("stats.enduranceNative");
		this.intelligenceNative = config.getInt("stats.intelligenceNative");
		this.manaCapacityNative = config.getInt("stats.manaCapacityNative");

	}

	private void init() {

		File file = new File(Main.INSTANCE.getDataFolder(), "players/" + uuid + ".yml");
		if (!file.exists()) {
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			config.set("rank", "default");
			config.set("level.level", 0);
			config.set("level.experiencesPoints", 0);
			config.set("gold", 0);
			config.set("stats.karmaPoint", 0);
			config.set("stats.vitalityNative", 0);
			config.set("stats.defenceNative", 0);
			config.set("stats.strengthNative", 0);
			config.set("stats.enduranceNative", 0);
			config.set("stats.intelligenceNative", 0);
			config.set("stats.manaCapacityNative", 100);

			try {
				config.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// Constructeur des variables joueurs
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
		File file = new File(Main.INSTANCE.getDataFolder(), "players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("rank", rank);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
		File file = new File(Main.INSTANCE.getDataFolder(), "players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("level.level", level);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getExperiencesPoints() {
		return experiencesPoints;
	}

	public void setExperiencesPoints(int experiencesPoints) {
		this.experiencesPoints = experiencesPoints;
		File file = new File(Main.INSTANCE.getDataFolder(), "players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("level.experiencesPoints", experiencesPoints);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
		File file = new File(Main.INSTANCE.getDataFolder(), "players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("gold", gold);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getKarma() {
		return karma;
	}

	public void setKarma(int karma) {
		this.karma = karma;
		File file = new File(Main.INSTANCE.getDataFolder(), "players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("stats.karmaPoint", karma);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// -----------------------------------------------------------------------------------------------------//
	//                                                                                                      //
	//                                          STATS PLAYER                                                //
	//                                                                                                      //
	// -----------------------------------------------------------------------------------------------------//

	public int getVitalityNative() {
		return vitalityNative;
	}

	public void setVitalityNative(int vitalityNative) {
		this.vitalityNative = vitalityNative;
		File file = new File(Main.INSTANCE.getDataFolder(), "players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("stats.vitalityNative", vitalityNative);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int getDefenceNative() {
		return defenceNative;
	}

	public void setDefenceNative(int defenceNative) {
		this.defenceNative = defenceNative;
		File file = new File(Main.INSTANCE.getDataFolder(), "players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("stats.defenceNative", defenceNative);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getStrengthNative() {
		return strengthNative;
	}

	public void setStrengthNative(int strengthNative) {
		this.strengthNative = strengthNative;
		File file = new File(Main.INSTANCE.getDataFolder(), "players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("stats.strengthNative", strengthNative);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getEnduranceNative() {
		return enduranceNative;
	}

	public void setEnduranceNative(int enduranceNative) {
		this.enduranceNative = enduranceNative;
		File file = new File(Main.INSTANCE.getDataFolder(), "players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("stats.enduranceNative", enduranceNative);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getIntelligenceNative() {
		return intelligenceNative;
	}

	public void setIntelligenceNative(int intelligenceNative) {
		this.intelligenceNative = intelligenceNative;
		File file = new File(Main.INSTANCE.getDataFolder(), "players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("stats.intelligenceNative", intelligenceNative);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getManaCapacityNative() {
		return manaCapacityNative;
	}

	public void setManaCapacityNative(int manaCapacityNative) {
		this.manaCapacityNative = manaCapacityNative;
		File file = new File(Main.INSTANCE.getDataFolder(), "players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("stats.manaCapacityNative", manaCapacityNative);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getStat(Player player, String stat) {

		switch (stat.toUpperCase()) {
		case "LEVEL":
			return PlayerProfileManager.profiles.get(player).getLevel();
		case "EXPERIENCEPOINTS":
			return PlayerProfileManager.profiles.get(player).getExperiencesPoints();
		case "GOLD":
			return PlayerProfileManager.profiles.get(player).getGold();
		case "KARMA":
			return PlayerProfileManager.profiles.get(player).getKarma();
		case "VITALITYNATIVE":
			return PlayerProfileManager.profiles.get(player).getVitalityNative();
		case "DEFENCENATIVE":
			return PlayerProfileManager.profiles.get(player).getDefenceNative();
		case "STRENGTHNATIVE":
			return PlayerProfileManager.profiles.get(player).getStrengthNative();
		case "ENDURANCENATIVE":
			return PlayerProfileManager.profiles.get(player).getEnduranceNative();
		case "INTELLIGENCENATIVE":
			return PlayerProfileManager.profiles.get(player).getIntelligenceNative();
		case "MANACAPACITYNATIVE":
			return PlayerProfileManager.profiles.get(player).getManaCapacityNative();

		}
		return -123456789;
	}

	public boolean setStat(Player player, String stat, int toSet) {

		switch (stat.toUpperCase()) {
		case "LEVEL":
			PlayerProfileManager.profiles.get(player).setLevel(toSet);
			return true;
		case "EXPERIENCEPOINTS":
			PlayerProfileManager.profiles.get(player).setExperiencesPoints(toSet);
			return true;
		case "GOLD":
			PlayerProfileManager.profiles.get(player).setGold(toSet);
			return true;
		case "KARMA":
			PlayerProfileManager.profiles.get(player).setKarma(toSet);
			return true;
		case "VITALITYNATIVE":
			PlayerProfileManager.profiles.get(player).setVitalityNative(toSet);
			return true;
		case "DEFENCENATIVE":
			PlayerProfileManager.profiles.get(player).setDefenceNative(toSet);
			return true;
		case "STRENGTHNATIVE":
			PlayerProfileManager.profiles.get(player).setStrengthNative(toSet);
			return true;
		case "ENDURANCENATIVE":
			PlayerProfileManager.profiles.get(player).setEnduranceNative(toSet);
			return true;
		case "INTELLIGENCENATIVE":
			PlayerProfileManager.profiles.get(player).setIntelligenceNative(toSet);
			return true;
		case "MANACAPACITYNATIVE":
			PlayerProfileManager.profiles.get(player).setManaCapacityNative(toSet);
			return true;
		}
		return false;

	}
	
	public enum Stat {

		LEVEL("level"),
		EXPERIENCEPOINTS("experiencePoints"),
		GOLD("gold"),
		KARMA("karma"),
		VITALITYNATIVE("vitalityNative"),
		DEFENCENATIVE("defenceNative"),
		STRENGTHNATIVE("strengthNative"),
		ENDURENCENATIVE("enduranceNative"),
		INTELLIGENCENATIVE("intelligenceNative"),
		MANACAPACITYNATIVE("manaCapacityNative");

		private String name;		
		
		private Stat(String name) {
		 this.name = name;
		}	

		public String getStat( ) {
			return name;
		}	
	 }			
}